package com.mashibing.serviceverificationcode.service;

import com.mashibing.internalcommon.dto.ResponseResult;
import com.mashibing.internalcommon.dto.serviceVerificationCode.response.VerifyCodeResponse;

/**
 * @Author: Derek
 * @DateTime: 2020/10/31 20:50
 * @Description: 验证码服务
 */
public interface VerifyCodeService {
    /**
     * 根据身份和手机号生成验证码 (注意通过redis设置验证码过期时间)
     * @param identity
     * @param phoneNumber
     * @return
     */
    public ResponseResult<VerifyCodeResponse> generate(int identity, String phoneNumber);

    ResponseResult verify(int identity, String phoneNumber, String code);

    ResponseResult get(int identity, String phoneNumber);

}
