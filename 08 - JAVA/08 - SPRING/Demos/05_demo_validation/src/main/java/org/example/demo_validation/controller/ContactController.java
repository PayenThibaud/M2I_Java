package org.example.demo_validation.controller;

import jakarta.validation.Valid;
import org.example.demo_validation.model.Contact;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.server.ResponseStatusException;

@Controller
public class ContactController {
    @RequestMapping(value = "/form")
    public String form(Model model){
        model.addAttribute("contact", new Contact());
        return "form";
    }

    @PostMapping("/add")
    public String addContact(@Valid @ModelAttribute("contact") Contact contact, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "form";
        } else {
            return "form-confirm";
        }
    }

    @RequestMapping("/pb")
    public String pb(){
        if(true){
            throw new ResponseStatusException(HttpStatus.I_AM_A_TEAPOT);
        }
        return "form-confirm";
    }
}
