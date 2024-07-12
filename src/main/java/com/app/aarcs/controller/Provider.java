package com.app.aarcs.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Provider {

    @GetMapping("/greet")
    public String greet() {
        return "Hello";
    }
}
