package com.tbd.lab1.services;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestService {
    @GetMapping("/hello")
    public String hello() {
        return "Hello World!";
    }
}