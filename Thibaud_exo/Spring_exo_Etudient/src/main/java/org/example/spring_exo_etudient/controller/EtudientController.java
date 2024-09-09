package org.example.spring_exo_etudient.controller;

import org.example.spring_exo_etudient.service.EtudientService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class EtudientController {

    private final EtudientService etudientService;

    public EtudientController(EtudientService etudientService) {
        this.etudientService = etudientService;
    }

    @RequestMapping("/")
    public String index(Model model) {
        model.addAttribute("EtudientsName",etudientService.getEtudients());
        return "index";
    }

    @RequestMapping ("/list-etudient")
    public String list(Model model){
        model.addAttribute("Etudients", etudientService.getEtudients());
        return "list-etudient";
    }

    @RequestMapping("/etudient/{name}")
    public String etudient(@PathVariable String name, Model model){
        model.addAttribute("Name",name);
        model.addAttribute("Etudients", etudientService.getEtudientsByName(name));
        return "etudient";
    }
}
