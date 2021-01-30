package com.example.oauth1.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: Derek
 * @DateTime: 2021/1/9 11:02
 * @Description: TODO
 */
@RestController
public class MainController {

    @GetMapping("/oauth2/api/me")
    public Authentication me(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication;
    }

    @GetMapping("/oauth2/api/read/xxoo")
    public Authentication read(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        System.out.println("read");
        return authentication;
    }

    @GetMapping("/oauth2/api/write/xxoo")
    public Authentication write(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        System.out.println("write");
        return authentication;
    }

}
