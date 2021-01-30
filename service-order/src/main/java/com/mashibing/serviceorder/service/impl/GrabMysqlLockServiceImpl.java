package com.mashibing.serviceorder.service.impl;

import com.mashibing.serviceorder.entity.TblOrderLock;
import com.mashibing.serviceorder.lock.MysqlLock;
import com.mashibing.serviceorder.service.GrabService;
import com.mashibing.serviceorder.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: Derek
 * @DateTime: 2020/11/16 14:11
 * @Description: TODO
 */
@Service("grabMysqlLockService")
public class GrabMysqlLockServiceImpl implements GrabService {

    @Autowired
    private MysqlLock lock;


    @Autowired
    OrderService orderService;

    ThreadLocal<TblOrderLock> orderLock = new ThreadLocal<>();

    @Override
    public String grabOrder(int orderId, int driverId) {
        //生成锁
        TblOrderLock tblOrderLock = new TblOrderLock();
        tblOrderLock.setOrderId(orderId);
        tblOrderLock.setDriverId(driverId);

        orderLock.set(tblOrderLock);
        lock.setOrderLockThreadLocal(orderLock);

        //lock
        lock.lock();

        // 执行业务
        try {
            System.out.println("司机:"+driverId+" 执行抢单逻辑");

            boolean b = orderService.grab(orderId, driverId);
            if(b) {
                System.out.println("司机:"+driverId+" 抢单成功");
            }else {
                System.out.println("司机:"+driverId+" 抢单失败");
            }
        }finally {
            // 释放锁
            lock.unlock();
        }


        return null;
    }
}
