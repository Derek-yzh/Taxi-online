package com.mashibing.apipassenger.controller;

import com.google.common.collect.Maps;
import com.mashibing.apipassenger.request.UserAuthRequest;
import com.mashibing.apipassenger.service.AuthService;
import com.mashibing.internalcommon.dto.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: Derek
 * @DateTime: 2020/11/1 20:08
 * @Description:
 */
@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @RequestMapping("login")
    public ResponseResult login(@RequestBody @Validated UserAuthRequest userAuthRequest){

        String passengerPhone = userAuthRequest.getPassengerPhone();
        String code = userAuthRequest.getCode();
        return authService.auth(passengerPhone,code);
    }

}
