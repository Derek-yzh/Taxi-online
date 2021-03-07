package com.mashibing.serviceorder.service.impl;

import com.mashibing.serviceorder.service.GrabService;
import com.mashibing.serviceorder.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @Author: Derek
 * @DateTime: 2020/11/16 16:24
 * @Description: 注意：这个不怎么用 我也没测试哈哈哈
 */
@Service("grabRedisLockService")
public class GrabRedisLockServiceImpl implements GrabService {

    @Autowired
    OrderService orderService;

    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @Override
    public String grabOrder(int orderId, int driverId) {
        //生成key
        String lock = "order_"+(orderId+"");

        //注意点：1.加超时时间 setnx 2.超时时间一次性加如下行所示 否则会有加不上的情况·
        Boolean lockStatus = stringRedisTemplate.opsForValue().setIfAbsent(lock.intern(), driverId + "", 30L, TimeUnit.SECONDS);
        // 开个子线程，原来时间N，每个n/3，去续上n

        if (!lockStatus){
            return null;
        }

        try {
            System.out.println("司机:"+driverId+" 执行抢单逻辑");

            boolean b = orderService.grab(orderId, driverId);
            if(b) {
                System.out.println("司机:"+driverId+" 抢单成功");
            }else {
                System.out.println("司机:"+driverId+" 抢单失败");
            }

        } finally{

            //这种释放锁有，可能释放了别人的锁。
            //stringRedisTemplate.delete(lock.intern());

            //下面代码避免释放别人的锁
            if((driverId+"").equals(stringRedisTemplate.opsForValue().get(lock.intern()))) {
                stringRedisTemplate.delete(lock.intern());
            }
        }

        return null;
    }
}
