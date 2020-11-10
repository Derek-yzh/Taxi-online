package com.mashibing.servicepassengeruser.controller;

import com.mashibing.internalcommon.dto.ResponseResult;
import com.mashibing.internalcommon.dto.servicePassengerUser.request.LoginRequest;
import com.mashibing.servicepassengeruser.service.PassengerUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: Derek
 * @DateTime: 2020/11/1 20:47
 * @Description: TODO
 */
@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private PassengerUserService passengerUserService;

    @PostMapping("/login")
    public ResponseResult login(@RequestBody LoginRequest request){
        String passengerPhone = request.getPassengerPhone();
        return passengerUserService.login(passengerPhone);
    }

}
