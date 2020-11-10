package com.mashibing.apipassenger.service;

import com.mashibing.internalcommon.dto.ResponseResult;

/**
 * @Author: Derek
 * @DateTime: 2020/11/1 20:08
 * @Description: TODO
 */
public interface AuthService {
    ResponseResult auth(String passengerPhone, String code);
}
