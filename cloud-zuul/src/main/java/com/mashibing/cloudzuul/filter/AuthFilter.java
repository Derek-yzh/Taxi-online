package com.mashibing.cloudzuul.filter;

import com.mashibing.internalcommon.constant.RedisKeyPrefixConstant;
import com.mashibing.internalcommon.util.JwtInfo;
import com.mashibing.internalcommon.util.JwtUtil;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.apache.commons.lang.StringUtils;
import org.apache.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.data.redis.core.BoundValueOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author: Derek
 * @DateTime: 2020/11/2 11:56
 * @Description: 鉴权filter
 */
@Component
public class AuthFilter extends ZuulFilter {

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    /**
     * 过滤器是否生效
     * @return
     */
    @Override
    public boolean shouldFilter() {
        //获取上下文 贯穿所有Filter 包含所有参数
        /*Object limit = RequestContext.getCurrentContext().get("limit");
        return "true".equals(limit);*/

        return false;//TODO 关闭鉴权
    }

    /**
     * 拦截后的具体业务逻辑
     * @return
     * @throws ZuulException
     */
    @Override
    public Object run() throws ZuulException {
        System.out.println("鉴权...");

        //获取上下文（重要！ 贯穿所有filter，包含所有参数）
        RequestContext requestContext = RequestContext.getCurrentContext();
        HttpServletRequest request = requestContext.getRequest();

        String token = request.getHeader("Authorization");
        if(StringUtils.isNotBlank(token)){
            JwtInfo tokenJwtInfo = JwtUtil.parseToken(token);

            if (null != tokenJwtInfo){
                String tokenUser = tokenJwtInfo.getSubject();
                Long tokenIssueDate = tokenJwtInfo.getIssueDate();

                BoundValueOperations<String, String> stringStringBoundValueOperations = redisTemplate.boundValueOps(tokenUser);
                String redisToken = stringStringBoundValueOperations.get();
                if (StringUtils.isNotBlank(redisToken) && redisToken.equals(token)){
                    return null;
                }

            }

        }

        requestContext.setSendZuulResponse(false); //设置为false 可以在后面filter的shouldFilter做判断走不走
        requestContext.setResponseStatusCode(HttpStatus.SC_UNAUTHORIZED);
        requestContext.setResponseBody("auth fail");

        //requestContext.set("ifContinue",false);

        return null;
    }

    /**
     * 拦截类型，4种类型
     * @return filter类型
     */
    @Override
    public String filterType() {
        return FilterConstants.PRE_TYPE; //在所有过滤器之前
    }

    /**
     * filter执行的顺序：值越小越在前
     * @return 顺序值
     */
    @Override
    public int filterOrder() {
        return -1;
    }

}
