package com.mashibing.serviceverificationcode.service;

import com.mashibing.internalcommon.dto.ResponseResult;
import com.mashibing.internalcommon.dto.serviceVerificationCode.response.VerifyCodeResponse;

/**
 * @Author: Derek
 * @DateTime: 2020/10/31 20:50
 * @Description: TODO
 */
public interface VerifyCodeService {
    /**
     * 根据身份和手机号生成验证码
     * @param identity
     * @param phoneNumber
     * @return
     */
    public ResponseResult<VerifyCodeResponse> generate(int identity, String phoneNumber);

    ResponseResult verify(int identity, String phoneNumber, String code);
}
