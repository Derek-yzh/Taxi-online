package com.mashibing.serviceorder.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @Author: Derek
 * @DateTime: 2020/11/16 18:05
 * @Description: TODO
 */
@Component
@ConfigurationProperties(prefix = "sentinel")
@Order(0)
@Data
public class RedisSentinelProperties {

    private String[] address;

    private String masterName;

}
