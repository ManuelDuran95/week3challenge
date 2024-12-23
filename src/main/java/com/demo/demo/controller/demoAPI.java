package com.demo.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Value;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@RestController("/api")
public class demoAPI {
    @Value("${test.variable}")
    private String demoVar;

   @GetMapping("/greet/{name}")
    public Map<String, String> greet(@PathVariable String name) {
        System.out.println("Variable from properties: " + demoVar);

        // Mock user information
        Map<String, String> userInfo = new HashMap<>();
        userInfo.put("name", name);
        userInfo.put("greeting", "Hello " + name + " APIv5.5 " + demoVar);
        userInfo.put("email", name.toLowerCase() + "@example.com");
        userInfo.put("id", String.valueOf(generateRandomNumber()));

        return userInfo;
    }

     public int generateRandomNumber() {
        Random random = new Random();
        return random.nextInt(100); // Generates a random number between 0 and 99
    }
}
