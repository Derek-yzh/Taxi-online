package com.mashibing.cloudzuul.controller;

import com.mashibing.cloudzuul.yml.MyYml;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: Derek
 * @DateTime: 2020/11/5 12:47
 * @Description: 了解使用yml
 */
@RestController
@RequestMapping("/myYml")
public class YmlController {

    @Autowired
    private MyYml myYml;

    @GetMapping
    public String myYml(){
        return myYml.getAddress();
    }

}
