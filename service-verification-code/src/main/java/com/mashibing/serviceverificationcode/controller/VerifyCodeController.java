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
 * @Description: 验证码
 */
@RestController
@RequestMapping("/verify-code")
@Slf4j
public class VerifyCodeController {

    @Autowired
    VerifyCodeService verifyCodeService;

    /**
     * 根据身份，手机号，生成验证码
     * @param identity 身份
     * @param phoneNumber 手机号
     * @return 返回验证码
     */
    @GetMapping("/generate/{identity}/{phoneNumber}")
    public ResponseResult generate(@PathVariable("identity") int identity, @PathVariable("phoneNumber") String phoneNumber){
        log.info("/generate/{identity}/{phoneNumber} ： 身份类型："+identity+",手机号："+phoneNumber);
        return verifyCodeService.generate(identity,phoneNumber);
    }

    /**
     * 校验验证码
     * @param request 请求
     * @return
     */
    @PostMapping("/verify")
    public ResponseResult verify(@RequestBody VerifyCodeRequest request){
        log.info("/verify-code/verify  request:"+ JSONObject.fromObject(request));
        //获取手机号和验证码
        String phoneNumber = request.getPhoneNumber();
        int identity = request.getIdentity();
        String code = request.getCode();

        return verifyCodeService.verify(identity,phoneNumber,code);
    }

    @GetMapping("/get/{identity}/{phoneNumber}")
    public ResponseResult get(@PathVariable("identity") int identity, @PathVariable("phoneNumber") String phoneNumber){
        log.info("/get/{identity}/{phoneNumber} ： 身份类型："+identity+",手机号："+phoneNumber);
        return verifyCodeService.get(identity,phoneNumber);
    }


}
