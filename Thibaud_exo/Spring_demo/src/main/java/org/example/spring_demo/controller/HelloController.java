package org.example.spring_demo.controller;

import org.example.spring_demo.service.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.w3c.dom.ls.LSOutput;

import java.util.List;

@Controller
public class HelloController {

    private final GreetingService greetingsService;

//    @Autowired
    public HelloController(@Qualifier("Greetings") GreetingService greetingService) {
        this.greetingsService = greetingService;
    }

    @RequestMapping("/")
    public String index() {
        return "index";
    }

    @RequestMapping("/hello")
    public String getGreeting() {
        System.out.println(greetingsService.greet());
        return "hello";
    }

    @RequestMapping("/json")
    @ResponseBody
    public List<String> getPersons() {
        return List.of("Toto","Tata","Titi");

    }

    @RequestMapping("/person/details")
    public String getPerson(Model model) {
        model.addAttribute("FirstName", "Toto");
        model.addAttribute("LastName", "Tata");

        List<String> persons = List.of("Toto", "Titi", "Tata");

        model.addAttribute("Persons", persons);

        return "person/details";
    }
}
