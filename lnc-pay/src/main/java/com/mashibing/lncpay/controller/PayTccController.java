package com.mashibing.lncpay.controller;

import com.codingapi.txlcn.tc.annotation.TccTransaction;
import com.mashibing.lncpay.dao.LcnPayDao;
import com.mashibing.lncpay.entity.LcnPay;
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
 * @Description: 分布式事务 TCC
 */
@RestController
@RequestMapping
public class PayTccController {

    @Autowired
    private LcnPayDao lcnPayDao;

    @PostMapping("/add-pay-tcc")
    @Transactional(rollbackFor = Exception.class)
    @TccTransaction
    public String addPay(@RequestBody LcnPay lcnPay){
        lcnPayDao.insert(lcnPay);
        maps.put("a",lcnPay.getId());
        //int i = 1/0;
        return "新增支付成功";
    }

    public String confirmAddPay(LcnPay lcnPay){
        System.out.println("pay confirm");
        return "新增支付成功";
    }

    private static Map<String,Integer> maps = new HashMap<>();
    public String cancelAddPay(LcnPay lcnPay){
        Integer a = maps.get("a");
        System.out.println("a:"+a);
        lcnPayDao.deleteByPrimaryKey(a);
        System.out.println("pay cancel");
        return "新增支付成功";
    }
}
