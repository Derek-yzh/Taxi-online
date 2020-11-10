package com.mashibing.cloudzuul.yml;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @Author: Derek
 * @DateTime: 2020/11/5 12:43
 * @Description: 了解使用yml
 */
@Component
@PropertySource(value = {"classpath:my.yml"})
@ConfigurationProperties(prefix = "my")
@Data
public class MyYml {

    @Value("${address}")
    private String address;


}
