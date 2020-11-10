package com.mashibing.servicesms.filter;

import com.google.common.util.concurrent.RateLimiter;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @Author: Derek
 * @DateTime: 2020/11/6 9:37
 * @Description: sms服务限流
 */
@Component
public class LimitFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    //令牌桶  每秒2个
    private static final RateLimiter RATE_LIMITER = RateLimiter.create(2);
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        if (RATE_LIMITER.tryAcquire()){
            filterChain.doFilter(servletRequest,servletResponse);
        }else {

            servletResponse.setCharacterEncoding("utf-8");
            servletResponse.setContentType("text/html;charset=utf-8");

            PrintWriter printWriter = null;

            printWriter = servletResponse.getWriter();
            printWriter.write("限流了");

            printWriter.close();
        }

    }

    @Override
    public void destroy() {

    }

}
