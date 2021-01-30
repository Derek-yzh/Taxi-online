package com.mashibing.apipassenger.gray;

import io.jmnarloch.spring.cloud.ribbon.support.RibbonFilterContextHolder;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: Derek
 * @DateTime: 2020/11/4 13:12
 * @Description: TODO
 */
@Aspect
@Component
public class RequestAspect {

    @Pointcut("execution(* com.mashibing.apipassenger.controller..*Controller*.*(..))")
    private void anyMethod(){

    }

    @Before(value = "anyMethod()")
    public void before(JoinPoint joinPoint){

        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        String version = request.getHeader("version");

        //灰度规则匹配的地方 查db redis ...
        if (version.trim().equals("v1")){
            RibbonFilterContextHolder.getCurrentContext().add("version","v1");
        }
        else {
            RibbonFilterContextHolder.getCurrentContext().add("version",version);
        }

        //此处为自定义灰度
        /*Map<String,String> map = new HashMap<>();
        map.put("version",version);
        RibbonParameters.set(map);*/
    }

}
