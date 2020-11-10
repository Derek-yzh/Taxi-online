package com.mashibing.serviceorder.config;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.jms.Queue;

/**
 * @Author: Derek
 * @DateTime: 2020/11/9 13:21
 * @Description: activeMQ配置
 */
@Configuration
public class ActiveMQConfig {

    @Value("${spring.activemq.broker-url}")
    private String brokerUrl;

    @Bean
    public Queue queue(){
        return new ActiveMQQueue("ActiveMQQueue");
    }

    @Bean
    public ActiveMQConnectionFactory connectionFactory(){
        return new ActiveMQConnectionFactory(brokerUrl);
    }

}
