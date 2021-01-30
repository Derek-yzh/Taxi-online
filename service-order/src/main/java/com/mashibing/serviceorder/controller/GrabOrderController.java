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
 * @Description: TODO
 */
@RestController
@RequestMapping("/grab")
@SuppressWarnings("all")
public class GrabOrderController {

    @Autowired
    //@Qualifier("grabNoLockService")//无锁
    //@Qualifier("grabJvmLockService")//jvm锁
    //@Qualifier("grabMysqlLockService")//mysql锁
    //@Qualifier("grabRedisLockService")//手写redis
    //单个redisson
    //@Qualifier("grabRedisRedissonService")
    //红锁
    @Qualifier("grabRedisRedissonRedLockLockService")
    private GrabService grabService;

    @GetMapping("/do/{orderId}")
    public String grab(@PathVariable("orderId") int orderId, int driverId){
        System.out.println("order:"+orderId+",driverId:"+driverId);
        grabService.grabOrder(orderId,driverId);
        return "";
    }
}
