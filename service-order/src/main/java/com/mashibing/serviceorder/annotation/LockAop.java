package com.mashibing.serviceorder.annotation;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.integration.redis.util.RedisLockRegistry;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;

/**
 * @Author: Derek
 * @DateTime: 2020/11/17 12:02
 * @Description: TODO
 */
@Component
@Aspect
@Slf4j
public class LockAop {

    private WebApplicationContext webApplicationContext;

    public LockAop(WebApplicationContext webApplicationContext){
        this.webApplicationContext = webApplicationContext;
    }

    @Pointcut("@annotation(com.mashibing.serviceorder.annotation.DistributedLock)")
    private void apiAop(){

    }

    @Around("apiAop()")
    public Object aroundApi(ProceedingJoinPoint point) throws Throwable {
        MethodSignature signature = (MethodSignature) point.getSignature();
        Method method = signature.getMethod();
        Object[] args = point.getArgs();
        System.out.println(args[0]);
        DistributedLock lockDistributed = method.getAnnotation(DistributedLock.class);

        RedisLockRegistry redisLockRegistry = (RedisLockRegistry) webApplicationContext.getBean(lockDistributed.value());

        Lock lock = redisLockRegistry.obtain(signature.getName() + "_" + args[0]);
        boolean b = false;
        for (int i = 0; i < 3; i++) {
            b = lock.tryLock(lockDistributed.time(), TimeUnit.SECONDS);
            if (b){
                break;
            }else {
                //continue;
            }
            log.info("获取锁"+b);
            Object proceed = null;
            try {
                proceed = point.proceed();
            } catch (Exception e) {
                throw e;
            }finally {
                try {
                    lock.unlock();
                }catch (Exception e){
                    System.out.println("没锁");
                }
            }
        }

        return null;
    }


}
