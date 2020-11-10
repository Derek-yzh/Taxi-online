package com.mashibing.apipassenger.service;

import com.mashibing.internalcommon.dto.ResponseResult;

/**
 * @Author: Derek
 * @DateTime: 2020/11/1 15:02
 * @Description: TODO
 */
public interface ServiceSmsRestTemplateService {
    ResponseResult sendSms(String phoneNumber, String code);
}
