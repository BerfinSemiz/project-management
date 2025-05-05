package com.gruntech.project_management.controllers;

import org.springframework.web.bind.annotation.GetMapping;

public class test {
    @GetMapping("/hello")
    public String hello() {
        return "Hello, Swagger!";
    }
}
