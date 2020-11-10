package com.mashibing.servicepay;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
@EnableJms
@EnableScheduling
public class ServicePayApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServicePayApplication.class, args);
    }

    @GetMapping
    public String test(){
        return "service-pay";
    }

}
