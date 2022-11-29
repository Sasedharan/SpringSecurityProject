package com.em.springbootsecurity.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    @GetMapping("/home")
    public String homePage(){
        return "Welcome to The Home Page";
    }
    @GetMapping("/context")
    public String contextPage(){
        return " You are in Abstract Page";
    }

}
