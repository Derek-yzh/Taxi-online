package com.mashibing.serviceorder.service;

/**
 * @Author: Derek
 * @DateTime: 2020/11/15 20:24
 * @Description: 抢单服务
 */
public interface GrabService {

    /**
     * 司机抢单
     * @param orderId
     * @param driverId
     */
    String grabOrder(int orderId, int driverId);

}
