package com.demo.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("/api")
public class demoAPI {
    @GetMapping("/greet/{name}")
    public String greet(@PathVariable String name){
        return "Hello v2 hsfgdsdgfskldfgd"+name;
    }
}
