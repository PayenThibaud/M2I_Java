package org.example.spring_demo.service;

import org.springframework.stereotype.Service;

@Service("Greetings")
public class GreetingServiceEnglish implements GreetingService {

    @Override
    public String greet() {
        return "Hello !";
    }
}
