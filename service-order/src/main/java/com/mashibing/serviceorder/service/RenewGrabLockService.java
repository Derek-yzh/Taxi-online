package com.mashibing.serviceorder.service;

/**
 * @Author: Derek
 * @DateTime: 2020/11/17 11:30
 * @Description: TODO
 */
public interface RenewGrabLockService {

    /**
     * 续约
     * @param key
     * @param value
     * @param time
     */
    public void renewLock(String key , String value , int time);

}
