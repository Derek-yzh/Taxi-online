package com.mashibing.apipassenger.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @Author: Derek
 * @DateTime: 2020/11/4 12:36
 * @Description: TODO
 */
@RestController
@RequestMapping("/test")
public class TestCallServiceSmsController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/call")
    public String testCall(){

        return restTemplate.getForObject("http://service-sms/test/sms-test",String.class);
    }

}


