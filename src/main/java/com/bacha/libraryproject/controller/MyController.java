package com.bacha.libraryproject.controller;

import com.bacha.libraryproject.security.SecurityUser;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MyController {

    @GetMapping("/hello")
    public String sayHello(){
        return "/hello";
    }

    @GetMapping("/showUserInfo")
    public String showUserInfo(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        SecurityUser securityUser = (SecurityUser) authentication.getPrincipal();
        System.out.println(securityUser.getUser());

        return "hello";
    }

    @GetMapping("/admin")
    public String adminPage(){
        return "admin";
    }
}
