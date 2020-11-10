package com.mashibing.internalcommon.dto.serviceVerificationCode.request;

import lombok.Data;

/**
 * @Author: Derek
 * @DateTime: 2020/11/1 17:56
 * @Description: TODO
 */
@Data
public class VerifyCodeRequest {

    private int identity;

    private  String phoneNumber;

    private String code;

}

