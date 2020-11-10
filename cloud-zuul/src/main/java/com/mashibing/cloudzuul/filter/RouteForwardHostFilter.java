package com.mashibing.cloudzuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import lombok.SneakyThrows;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.net.URI;

/**
 * @Author: Derek
 * @DateTime: 2020/11/5 11:08
 * @Description: 动态路由问题_路由转发
 */
@Component
public class RouteForwardHostFilter extends ZuulFilter {


    @SneakyThrows
    @Override
    public Object run() throws ZuulException {
        RequestContext currentContext = RequestContext.getCurrentContext();
        HttpServletRequest request = currentContext.getRequest();

        //获取原来的请求url
        String requestURI = request.getRequestURI();

        //目的地映射
        if (requestURI.contains("/zuul-api-driver")){

            currentContext.setRouteHost(new URI("http://localhost:8003/test/sms-test-routeFilter1").toURL());
        }


        return null;
    }

    @Override
    public String filterType() {
        return FilterConstants.ROUTE_TYPE;
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

}
