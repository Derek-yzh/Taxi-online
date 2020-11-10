package com.mashibing.servicesms.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author: Derek
 * @DateTime: 2020/11/4 10:40
 * @Description: TODO
 */
@RestController
@RequestMapping("/test")
public class ServiceSmsTestController {

    @Value("${server.port}")
    private String port;

    @GetMapping("/sms-test")
    public String test(){

        return "sms-test:"+port;
    }

    //获取Cookie并返回到页面
    @GetMapping("/sms-test-token")
    public String test2(HttpServletRequest request){
        String token = request.getHeader("Cookie");
        return "sms-test-token:"+port+":"+token;
    }

    //动态路由问题测试及解决
    @GetMapping("/sms-test-routeFilter1")
    public String test3_1(){

        return "sms-test-route-test3_1";
    }
    @GetMapping("/sms-test-routeFilter2")
    public String test3_2(){

        return "sms-test-route-test3_2";
    }

}
