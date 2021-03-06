package com.mashibing.apipassenger.service;

import com.mashibing.internalcommon.dto.ResponseResult;

/**
 * @Author: Derek
 * @DateTime: 2020/11/1 15:03
 * @Description:
 */
public interface ServiceVerificationCodeRestTemplateService {
    ResponseResult generatorCode(int passenger, String phoneNumber);

    ResponseResult verifyCode(int passenger, String passengerPhone, String code);

    ResponseResult get(int passenger, String phoneNumber);

}
