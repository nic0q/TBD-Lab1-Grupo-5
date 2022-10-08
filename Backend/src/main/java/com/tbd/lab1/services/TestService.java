package com.tbd.lab1.services;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

// NO COPIAR ESTO QUE ES UN CONTROLADOR TA MALO
@RestController
public class TestService {
    @GetMapping("/hello")
    public String hello() {
        return "Hello World!";
    }
}