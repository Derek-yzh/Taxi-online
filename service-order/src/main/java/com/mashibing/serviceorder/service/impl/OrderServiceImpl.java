package com.mashibing.serviceorder.service.impl;

import com.mashibing.serviceorder.dao.TblOrderDao;
import com.mashibing.serviceorder.entity.TblOrder;
import com.mashibing.serviceorder.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @Author: Derek
 * @DateTime: 2020/11/16 11:53
 * @Description: OrderServiceImpl
 */
@Service
@SuppressWarnings("all")
public class OrderServiceImpl implements OrderService {

    @Autowired
    private TblOrderDao tblOrderDao;

    @Override
    public boolean grab(int orderId, int driverId) {
        TblOrder order = tblOrderDao.selectByPrimaryKey(orderId);
        try {
            TimeUnit.MILLISECONDS.sleep(200);
        } catch (InterruptedException e) {e.printStackTrace();}

        // 还有填写其他很多业务信息。包括哪个司机啥的。起点，终点。
        if (order.getOrderStatus().intValue() == 0){
            order.setOrderStatus(1);
            tblOrderDao.updateByPrimaryKeySelective(order);
            return true;
        }
        return false;
    }
}
