package com.mashibing.servicesms.service;

import com.mashibing.internalcommon.dto.ResponseResult;
import com.mashibing.internalcommon.dto.serviceSms.request.SmsSendRequest;
import org.springframework.stereotype.Service;

/**
 * @Author: Derek
 * @DateTime: 2020/11/1 18:58
 * @Description: TODO
 */
public interface SmsService {
    ResponseResult sendSms(SmsSendRequest smsSendRequest);
}
