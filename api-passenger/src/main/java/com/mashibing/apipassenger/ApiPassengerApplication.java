package com.mashibing.apipassenger;

import com.mashibing.apipassenger.annotation.ExcudeRibbonConfig;
import com.mashibing.apipassenger.gray.GrayRibbonConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@RestController
@ComponentScan(
        excludeFilters = {
                @ComponentScan.Filter(type = FilterType.ANNOTATION,value = ExcudeRibbonConfig.class)
})
//@RibbonClient(name = "service-sms",configuration = GrayRibbonConfiguration.class) //服务之间灰度发布
public class ApiPassengerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiPassengerApplication.class, args);
    }

    @LoadBalanced
    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

    @GetMapping
    public String test(){
        return "api-passenger";
    }

}
