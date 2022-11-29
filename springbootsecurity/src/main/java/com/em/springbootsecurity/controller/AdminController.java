package com.em.springbootsecurity.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class AdminController {
    @GetMapping("/index")
    public String adminPage(){
        return "Admin Index Page";
    }
    @GetMapping("/dashboard")
    public String adminDashboard(){
        return " Admin Dashboard";
    }
}
