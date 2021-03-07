package com.mashibing.apipassenger.gray;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.Server;
import com.netflix.niws.loadbalancer.DiscoveryEnabledServer;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * @Author: Derek
 * @DateTime: 2020/11/4 12:47
 * @Description: 服务_灰度
 */
public class GrayRule extends AbstractLoadBalancerRule {

    @Override
    public void initWithNiwsConfig(IClientConfig iClientConfig) {

    }

    @Override
    public Server choose(Object key) {
        return choose(getLoadBalancer(),key);
    }

    /**
     * 根据用户选出一个服务
     * @param lb
     * @param key
     * @return
     */
    public Server choose(ILoadBalancer lb, Object key){

        System.out.println("灰度 rule");
        Server server = null;
        while (server == null){
            //获取所有可达的服务
            List<Server> reachableServers = lb.getReachableServers();

            //获取当前线程的参数 用户id version=v1
            Map<String,String> map = RibbonParameters.get();
            String version = "";
            if (map != null && map.containsKey("version")){
                version = map.get("version");
            }
            System.out.println("当前version：" + version);

            //根据用户选服务
            for (int i = 0; i < reachableServers.size(); i++) {
                server = reachableServers.get(i);
                //Server.MetaInfo metaInfo = server.getMetaInfo();
                Map<String, String> metadata = ((DiscoveryEnabledServer) server).getInstanceInfo().getMetadata();
                String version1 = metadata.get("version");

                //服务的meta也有了，用户的version也有了
                if (version.trim().equals(version1)){
                    return server;
                }
            }

        }
        return server;
    }

}
