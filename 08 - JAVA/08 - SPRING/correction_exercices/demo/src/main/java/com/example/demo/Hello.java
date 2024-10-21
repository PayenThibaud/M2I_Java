package com.example.demo;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class Hello {

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/hello")
    public String sayHello() {
        return "Hello world";
    }
}
