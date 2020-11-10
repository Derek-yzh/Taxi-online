package com.mashibing.apipassenger.gray;

import com.netflix.loadbalancer.IRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: Derek
 * @DateTime: 2020/11/4 13:23
 * @Description: TODO
 */
public class GrayRibbonConfiguration {

    @Bean
    public IRule ribbonRule(){
        return new GrayRule();
    }

}
