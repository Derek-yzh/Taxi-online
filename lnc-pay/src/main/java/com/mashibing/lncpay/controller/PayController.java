package com.mashibing.lncpay.controller;

import com.codingapi.txlcn.tc.annotation.LcnTransaction;
import com.mashibing.lncpay.dao.LcnPayDao;
import com.mashibing.lncpay.entity.LcnPay;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: Derek
 * @DateTime: 2020/11/10 19:58
 * @Description: TODO
 */
@RestController
public class PayController {

    @Autowired
    private LcnPayDao lcnPayDao;

    @PostMapping("/add-pay")
    @Transactional(rollbackFor = Exception.class)
    @LcnTransaction
    public String addPay(@RequestBody LcnPay lcnPay){
        lcnPayDao.insert(lcnPay);
        return "新增支付成功";
    }


}
