package com.mashibing.apipassenger.service;

import com.mashibing.internalcommon.dto.ResponseResult;

/**
 * @Author: Derek
 * @DateTime: 2020/11/1 20:20
 * @Description: TODO
 */
public interface ServicePassengerUserService {
    ResponseResult login(String passengerPhone);
}
