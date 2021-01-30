package com.mashibing.serviceorder.service.impl;

import com.mashibing.serviceorder.service.GrabService;
import com.mashibing.serviceorder.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: Derek
 * @DateTime: 2020/11/16 12:13
 * @Description: TODO
 */
@Service("grabNoLockService")
public class GrabNoLockServiceImpl implements GrabService {

    @Autowired
    private OrderService orderService;

    @Override
    public String grabOrder(int orderId, int driverId) {

        try {
            System.out.println("司机:"+driverId+" 执行抢单逻辑");

            boolean b = orderService.grab(orderId, driverId);
            if(b) {
                System.out.println("司机:"+driverId+" 抢单成功");
            }else {
                System.out.println("司机:"+driverId+" 抢单失败");
            }
        }finally {

        }


        return null;
    }
}
