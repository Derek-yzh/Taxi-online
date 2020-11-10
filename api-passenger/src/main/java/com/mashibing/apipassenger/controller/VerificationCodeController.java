package com.mashibing.apipassenger.controller;

import com.mashibing.apipassenger.request.ShortMsgRequest;
import com.mashibing.apipassenger.service.VerificationCodeService;
import com.mashibing.internalcommon.dto.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: Derek
 * @DateTime: 2020/11/1 14:32
 * @Description: TODO
 */
@RestController
@RequestMapping("/verify-code")
public class VerificationCodeController {

    @Autowired
    VerificationCodeService verificationCodeService;

    @PostMapping("/send")
    public ResponseResult send(@RequestBody @Validated ShortMsgRequest request){

        return verificationCodeService.send(request.getPhoneNumber());
    }

}
