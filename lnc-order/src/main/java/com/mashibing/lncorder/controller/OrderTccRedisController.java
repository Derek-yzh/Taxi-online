package com.mashibing.lncorder.controller;

import com.codingapi.txlcn.tc.annotation.TccTransaction;
import com.mashibing.lncorder.dao.LcnOrderDao;
import com.mashibing.lncorder.entity.LcnOrder;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.BoundValueOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: Derek
 * @DateTime: 2020/11/10 19:22
 * @Description: TODO
 */
@RestController
@RequestMapping
@SuppressWarnings("all")
public class OrderTccRedisController {

    @Autowired
    private LcnOrderDao lcnOrderDao;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private RedisTemplate<String,String> redisTemplate;

    @PostMapping("/add-order-tcc-redis")
    @Transactional(rollbackFor = Exception.class)
    @TccTransaction
    public String add(@RequestBody LcnOrder bean){

        JSONObject data = new JSONObject();
        data.put("payName",bean.getOrderName()+"pay");

        restTemplate.postForEntity("http://lcn-pay/add-pay-tcc-redis",data,String.class);

        LcnOrder lcnOrder = new LcnOrder();
        lcnOrder.setId(1);
        lcnOrder.setOrderName("新");

        lcnOrderDao.updateByPrimaryKey(lcnOrder);

        BoundValueOperations<String, String> order = redisTemplate.boundValueOps("order");
        order.set("order-value");

        //int i = 1/0;
        return "新增订单成功";

    }

    public String confirmAdd(LcnOrder bean){
        System.out.println("order confirm");
        return "新增订单成功";
    }

    private static Map<String,Integer> maps = new HashMap<>();
    public String cancelAdd(LcnOrder bean){
        LcnOrder lcnOrder = new LcnOrder();
        lcnOrder.setId(1);
        lcnOrder.setOrderName("旧");

        lcnOrderDao.updateByPrimaryKey(lcnOrder);

        redisTemplate.delete("order");

        System.out.println("order cancel");
        return "新增订单成功";
    }

}
