package com.mashibing.lncorder.controller;

import com.codingapi.txlcn.tc.annotation.LcnTransaction;
import com.mashibing.lncorder.dao.LcnOrderDao;
import com.mashibing.lncorder.entity.LcnOrder;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @Author: Derek
 * @DateTime: 2020/11/10 19:22
 * @Description: TODO
 */
@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private LcnOrderDao lcnOrderDao;

    @Autowired
    private RestTemplate restTemplate;

    @PostMapping("/add-order")
    @Transactional(rollbackFor = Exception.class)
    @LcnTransaction
    public String add(@RequestBody LcnOrder bean){

        JSONObject data = new JSONObject();
        data.put("payName",bean.getOrderName()+"pay");

        restTemplate.postForEntity("http://lcn-pay/add-pay",data,String.class);
        int i = 1/0;
        lcnOrderDao.insert(bean);
        return "新增订单成功";

    }

}
