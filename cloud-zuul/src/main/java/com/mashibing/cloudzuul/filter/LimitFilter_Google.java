package com.mashibing.cloudzuul.filter;

import com.google.common.util.concurrent.RateLimiter;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

/**
 * @Author: Derek
 * @DateTime: 2020/11/5 20:53
 * @Description: 限流
 */
@Component
public class LimitFilter_Google extends ZuulFilter {

    //令牌桶  每秒2个
    private static final RateLimiter RATE_LIMITER = RateLimiter.create(3);
    @Override
    public Object run() throws ZuulException {
        RequestContext currentContext = RequestContext.getCurrentContext();

        if (RATE_LIMITER.tryAcquire()){
            currentContext.set("limit","true");
        }else {
            currentContext.set("limit","false");//设置为false  其他过滤器在shouldFilter中做判断
            currentContext.setSendZuulResponse(false);
            currentContext.setResponseStatusCode(HttpStatus.TOO_MANY_REQUESTS.value());
        }

        return null;
    }

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
        return false;
    }

}
