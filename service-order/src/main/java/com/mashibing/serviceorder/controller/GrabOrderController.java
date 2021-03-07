package com.mashibing.serviceorder.controller;

import com.mashibing.serviceorder.service.GrabService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: Derek
 * @DateTime: 2020/11/15 20:22
 * @Description: 抢单 测试分布式锁
 */
@RestController
@RequestMapping("/grab")
@SuppressWarnings("all")
public class GrabOrderController {

    @Autowired
    @Qualifier("grabNoLockService")//无锁
    private GrabService grabNoLockService;

    @Autowired
    @Qualifier("grabJvmLockService")//jvm锁
    private GrabService grabJvmLockService;

    @Autowired
    @Qualifier("grabMysqlLockService")//mysql锁
    private GrabService grabMysqlLockService;

    //@Autowired
    //@Qualifier("grabRedisLockService")//手写redis
    private GrabService grabRedisLockService;

    //@Autowired
    //@Qualifier("grabRedisRedissonService") //单个redisson
    private GrabService grabRedisRedissonService;

    //@Autowired
    //@Qualifier("grabRedisRedissonRedLockLockService")//红锁
    private GrabService grabService;

    @GetMapping("/do/{orderId}")
    public String grab(@PathVariable("orderId") int orderId, int driverId){
        System.out.println("order:"+orderId+",driverId:"+driverId);
        grabMysqlLockService.grabOrder(orderId,driverId);
        return "";
    }

}
