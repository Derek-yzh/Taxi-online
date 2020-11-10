package com.mashibing.apipassenger.service;

import com.mashibing.internalcommon.dto.ResponseResult;
import org.springframework.stereotype.Service;

/**
 * @Author: Derek
 * @DateTime: 2020/11/1 14:34
 * @Description: TODO
 */
@Service
public interface VerificationCodeService {
    ResponseResult send(String phoneNumber);
}
