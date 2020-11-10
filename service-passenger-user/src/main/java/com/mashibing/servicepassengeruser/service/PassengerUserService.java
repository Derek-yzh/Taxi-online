package com.mashibing.servicepassengeruser.service;

import com.mashibing.internalcommon.dto.ResponseResult;

/**
 * @Author: Derek
 * @DateTime: 2020/11/1 20:47
 * @Description: TODO
 */
public interface PassengerUserService {
    ResponseResult login(String passengerPhone);

    ResponseResult logout(String passengerId);
}
