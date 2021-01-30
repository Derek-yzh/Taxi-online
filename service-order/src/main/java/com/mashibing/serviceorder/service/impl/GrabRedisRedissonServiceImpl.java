package com.mashibing.serviceorder.service.impl;

import com.mashibing.serviceorder.service.GrabService;
import com.mashibing.serviceorder.service.OrderService;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @Author: Derek
 * @DateTime: 2020/11/16 16:50
 * @Description: TODO
 */
@Service("grabRedisRedissonService")
@SuppressWarnings("all")
public class GrabRedisRedissonServiceImpl implements GrabService {

    @Autowired
    private OrderService orderService;

    @Autowired
    RedissonClient redissonClient;

    @Override
    public String grabOrder(int orderId, int driverId) {
        //神生成key
        String lock = "order_"+(orderId+"");

        RLock rLock = redissonClient.getLock(lock.intern());

        try {
            //此代码默认 设置key 超时时间为30s 过十秒再延时
            rLock.lock();

            try {
                TimeUnit.SECONDS.sleep(3);} catch (InterruptedException e) {e.printStackTrace();}

            System.out.println("司机:"+driverId+" 执行抢单逻辑");

            boolean b = orderService.grab(orderId, driverId);
            if(b) {
                System.out.println("司机:"+driverId+" 抢单成功");
            }else {
                System.out.println("司机:"+driverId+" 抢单失败");
            }


        }finally {
            rLock.unlock();
        }

        return null;
    }
}
