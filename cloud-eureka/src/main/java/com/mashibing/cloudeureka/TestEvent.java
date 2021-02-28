package com.mashibing.cloudeureka;

import org.springframework.cloud.netflix.eureka.server.event.EurekaInstanceCanceledEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.Timer;

/**
 * @Author: Derek
 * @DateTime: 2020/12/29 23:53
 * @Description: Eureka对服务下线进行监听
 */
@Component
public class TestEvent {

    @EventListener
    public void listen(EurekaInstanceCanceledEvent event){
        //TODO 服务下线: 发邮件 短信
        System.out.println("下线:"+event.getServerId());
    }

}
