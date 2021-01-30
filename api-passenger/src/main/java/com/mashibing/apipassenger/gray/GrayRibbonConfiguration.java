package com.mashibing.apipassenger.gray;

import com.mashibing.apipassenger.annotation.ExcudeRibbonConfig;
import com.netflix.loadbalancer.IRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: Derek
 * @DateTime: 2020/11/4 13:23
 * @Description: GrayRibbonConfiguration 灰度Ribbon配置
 */
@ExcudeRibbonConfig
public class GrayRibbonConfiguration {

    @Bean
    public IRule ribbonRule(){
        return new GrayRule();
    }

}
