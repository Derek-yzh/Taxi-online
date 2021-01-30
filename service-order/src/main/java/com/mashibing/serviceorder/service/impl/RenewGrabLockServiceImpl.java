package com.mashibing.serviceorder.service.impl;

import com.mashibing.serviceorder.service.RenewGrabLockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.scheduling.annotation.Async;

import java.util.concurrent.TimeUnit;

/**
 * @Author: Derek
 * @DateTime: 2020/11/17 11:30
 * @Description: TODO
 */
public class RenewGrabLockServiceImpl implements RenewGrabLockService {

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @Override
    @Async
    public void renewLock(String key, String value, int time) {
        String v = redisTemplate.opsForValue().get(key);
        if (v.equals(value)){
            int sleepTime = time / 3;
            try {
                Thread.sleep(sleepTime * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            redisTemplate.expire(key,time, TimeUnit.SECONDS);
            renewLock(key,value,time);
        }
    }

}
