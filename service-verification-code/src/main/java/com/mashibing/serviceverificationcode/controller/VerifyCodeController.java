package com.mashibing.serviceverificationcode.controller;

import com.mashibing.internalcommon.dto.ResponseResult;
import com.mashibing.internalcommon.dto.serviceVerificationCode.request.VerifyCodeRequest;
import com.mashibing.serviceverificationcode.service.VerifyCodeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import net.sf.json.JSONObject;


/**
 * @Author: Derek
 * @DateTime: 2020/10/31 20:10
 * @Description: 短信验证
 */
@RestController
@RequestMapping("/verify-code")
@Slf4j
public class VerifyCodeController {

    @Autowired
    VerifyCodeService verifyCodeService;

    /**
     * 根据身份，手机号，生成验证码
     * @param identity
     * @param phoneNumber
     * @return
     */
    @GetMapping("/generate/{identity}/{phoneNumber}")
    public ResponseResult generate(@PathVariable("identity") int identity,@PathVariable("phoneNumber") String phoneNumber){
        log.info("/generate/{identity}/{phoneNumber} ： 身份类型："+identity+",手机号："+phoneNumber);
        return verifyCodeService.generate(identity,phoneNumber);
    }

    @PostMapping("/verify")
    public ResponseResult verify(@RequestBody VerifyCodeRequest request){
        log.info("/verify-code/verify  request:"+ JSONObject.fromObject(request));
        //获取手机号和验证码
        String phoneNumber = request.getPhoneNumber();
        int identity = request.getIdentity();
        String code = request.getCode();

        return verifyCodeService.verify(identity,phoneNumber,code);
    }



}
