package com.mashibing.serviceverificationcode;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class ServiceVerificationCodeApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceVerificationCodeApplication.class, args);
    }

    @GetMapping
    public String test(){
        return "service-verification-code";
    }

}
