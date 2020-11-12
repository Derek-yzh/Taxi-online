package com.mashibing.lncpay.controller;

import com.codingapi.txlcn.tc.annotation.TccTransaction;
import com.mashibing.lncpay.dao.LcnPayDao;
import com.mashibing.lncpay.entity.LcnPay;
import com.mashibing.lncpay.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: Derek
 * @DateTime: 2020/11/10 19:58
 * @Description: TODO
 */
@RestController
@RequestMapping
@SuppressWarnings("all")
public class PayTccRedisController {

    @Autowired
    private LcnPayDao lcnPayDao;

    @Autowired
    private RedisService redisService;

    @PostMapping("/add-pay-tcc-redis")
    @Transactional(rollbackFor = Exception.class)
    public String addPay(@RequestBody LcnPay lcnPay){
        redisService.addPay(null);
        return "新增支付成功";
    }

}
