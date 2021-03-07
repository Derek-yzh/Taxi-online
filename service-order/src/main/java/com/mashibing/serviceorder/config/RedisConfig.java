package com.mashibing.serviceorder.config;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

/**
 * @Author: Derek
 * @DateTime: 2020/11/16 18:03
 * @Description: TODO
 */
//@Component
public class RedisConfig {

    @Autowired
    RedisSentinelProperties properties;


    //以下为红锁
    @Bean(name = "redissonRed1")
    @Primary
    public RedissonClient redissonRed1(){
        Config config = new Config();
        config.useSingleServer().setAddress("127.0.0.1:6379").setDatabase(0);
        return Redisson.create(config);
    }
    @Bean(name = "redissonRed2")
    public RedissonClient redissonRed2(){
        Config config = new Config();
        config.useSingleServer().setAddress("127.0.0.1:6380").setDatabase(0);
        return Redisson.create(config);
    }
    @Bean(name = "redissonRed3")
    public RedissonClient redissonRed3(){
        Config config = new Config();
        config.useSingleServer().setAddress("127.0.0.1:6381").setDatabase(0);
        return Redisson.create(config);
    }
    //以上为红锁


    /**
     * 单个redisson
     */
    /*@Bean
    public RedissonClient redissonClient() {
    	Config config = new Config();
    	config.useSingleServer().setAddress("127.0.0.1:6379").setDatabase(0);

    	return Redisson.create(config);
    }*/

}
