package com.mashibing.cloudzuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@SpringBootApplication
@RestController
@EnableZuulProxy
public class CloudZuulApplication {

    public static void main(String[] args) {
        SpringApplication.run(CloudZuulApplication.class, args);
    }

    @GetMapping
    public String test(){
        return "online-taxi-zuul";
    }

    private static void init(){
        //所有限流规则的合集
        //ArrayList<FlowRule> rules = new ArrayList<>();
    }

}
