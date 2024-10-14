package com.demo.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Value;

@RestController("/api")
public class demoAPI {
    @Value("${test.variable}")
    private String demoVar;

    @GetMapping("/greet/{name}")
    public String greet(@PathVariable String name){
      

        System.out.println("Variable from properties" + demoVar); 
        return "Hello "+name + "APIv3" +demoVar;
    }
}
