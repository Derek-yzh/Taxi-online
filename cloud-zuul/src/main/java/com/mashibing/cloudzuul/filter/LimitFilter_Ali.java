package com.mashibing.cloudzuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;

/**
 * @Author: Derek
 * @DateTime: 2020/11/7 11:54
 * @Description: 限流
 */
public class LimitFilter_Ali extends ZuulFilter {
    @Override
    public String filterType() {
        return FilterConstants.PRE_TYPE;
    }

    @Override
    public int filterOrder() {
        return -10;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        //限流的业务逻辑

        return null;
    }

}
