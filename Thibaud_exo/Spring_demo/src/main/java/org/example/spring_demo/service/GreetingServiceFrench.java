package org.example.spring_demo.service;

import org.springframework.stereotype.Service;

@Service("Salutations")
public class GreetingServiceFrench implements GreetingService {

    @Override
    public String greet() {
        return "Bonjour !";
    }
}
