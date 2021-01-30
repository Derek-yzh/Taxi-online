package com.mashibing.cloudzuul.filter;

import com.mashibing.cloudzuul.dao.CommonGrayRuleDaoCustomer;
import com.mashibing.cloudzuul.entity.CommonGrayRule;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import io.jmnarloch.spring.cloud.ribbon.api.RibbonFilterContext;
import io.jmnarloch.spring.cloud.ribbon.support.RibbonFilterContextHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author: Derek
 * @DateTime: 2020/11/4 9:58
 * @Description: 网关灰度
 */
@Component
@SuppressWarnings("all")
public class GrayFilter extends ZuulFilter {
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
        //Object limit = RequestContext.getCurrentContext().get("limit");
        //return "true".equals(limit);
    }

    @Autowired
    private CommonGrayRuleDaoCustomer commonGrayRuleDaoCustomer;

    @Override
    public Object run() throws ZuulException {

        RequestContext currentContext = RequestContext.getCurrentContext();
        HttpServletRequest request = currentContext.getRequest();

        int userId = Integer.parseInt(request.getHeader("userId"));
        //查库
        CommonGrayRule commonGrayRule = commonGrayRuleDaoCustomer.selectByUserId(userId);
        if (commonGrayRule == null){
            return null;
        }
        String version = commonGrayRule.getMetaVersion();
        RibbonFilterContextHolder.getCurrentContext().add("version", version);

        return null;
    }


}
