package com.example.SpringBootLearningProject.controller;


import com.example.SpringBootLearningProject.actuatorService.Greeting;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicLong;

@Controller
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();


    @GetMapping("/greeting")
    @ResponseBody
    public Greeting sayHello (@RequestParam(name = "name", required = false, defaultValue = "Stranger") String name) {
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }
}

