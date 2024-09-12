package org.example.demo_spring_jpa.controller;

import org.example.demo_spring_jpa.entity.Person;
import org.example.demo_spring_jpa.service.PersonService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PersonController {
    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @RequestMapping("/")
    public String home(Model model){
        model.addAttribute("personnes", personService.findAll());
        return "home";
    }

    @RequestMapping("/form")
    public String formulaire(Model model){
        model.addAttribute("personne", new Person());
        return "form";
    }

    @PostMapping("/add")
    public String addPerson(@ModelAttribute("personne") Person person){
        personService.save(person);
        return "redirect:/";
    }
}
