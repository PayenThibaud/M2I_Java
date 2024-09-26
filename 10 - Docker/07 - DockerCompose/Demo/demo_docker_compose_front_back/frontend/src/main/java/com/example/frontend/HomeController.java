package com.example.frontend;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home(Model model) {
        RestTemplate restTemplate = new RestTemplate();
        // Communication avec un container du même réseau -> communique avec le conteneur backend
        String result = restTemplate.getForObject("http://backend:8080/api/message", String.class);
        model.addAttribute("message", result);
        return "home";
    }
}
