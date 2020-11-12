package com.mashibing.lncpay.service;

import com.codingapi.txlcn.tc.annotation.TccTransaction;
import com.mashibing.lncpay.entity.LcnPay;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.BoundValueOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: Derek
 * @DateTime: 2020/11/11 15:09
 * @Description: TODO
 */
@Service
public class RedisService {

    @Autowired
    private RedisTemplate<String,String> redisTemplate;

    @TccTransaction
    public String addPay(@RequestBody LcnPay lcnPay){
        BoundValueOperations<String, String> pay = redisTemplate.boundValueOps("pay");
        pay.set("pay-value");
        //int i = 1/0;
        return "新增支付成功";
    }

    public String confirmAddPay(LcnPay lcnPay){
        System.out.println("pay confirm");
        return "新增支付成功";
    }

    private static Map<String,Integer> maps = new HashMap<>();
    public String cancelAddPay(LcnPay lcnPay){
        redisTemplate.delete("pay");
        System.out.println("pay cancel");
        return "新增支付成功";
    }


}
