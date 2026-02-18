package com.demo.demo.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class demoAPI {
    @Value("${test.variable}")
    private String demoVar;

   @GetMapping("/greet/{name}")
    public Map<String, String> greet(@PathVariable String name) {
        System.out.println("Variable from properties: " + demoVar);

        // Mock user information
        Map<String, String> userInfo = new HashMap<>();
        userInfo.put("name", name);
        userInfo.put("greeting", "Hello " + name + " APIv6.5 " + demoVar);
        userInfo.put("email", name.toLowerCase() + "@example1.com");
        userInfo.put("id", String.valueOf(generateRandomNumber()));

        return userInfo;
    }
    @PostMapping("/test/{name}")
    public Map<String, String> test411(@PathVariable String name) {
         Map<String, String> userInfo = new HashMap<>();
        userInfo.put("name", name);
        userInfo.put("greeting", "Hello " + name + " APIv7.5 " + demoVar);
        userInfo.put("email", name.toLowerCase() + "@example.com");
        userInfo.put("id", String.valueOf(generateRandomNumber()));
        return userInfo;

    }
    
    @GetMapping("/check/ready")
    public Map<String, String> checkReady() {
        Map<String, String> response = new HashMap<>();
        response.put("status", "UP");
        response.put("message", "Application is ready to handle requests");
        return response;
    }
    

     public int generateRandomNumber() {
        Random random = new Random();
        return random.nextInt(100); // Generates a random number between 0 and 99
    }
}
