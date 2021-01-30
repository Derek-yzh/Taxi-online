package com.mashibing.apipassenger.gray;

import org.springframework.stereotype.Component;

/**
 * @Author: Derek
 * @DateTime: 2020/11/4 12:54
 * @Description: RibbonParameters
 */
@Component
public class RibbonParameters {

    private static final ThreadLocal local = new ThreadLocal();

    public static <T> T get(){
        return (T)local.get();
    }

    public static <T> void set(T t){
        local.set(t);
    }

}
