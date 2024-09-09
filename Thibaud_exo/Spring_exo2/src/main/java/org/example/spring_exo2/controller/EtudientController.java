package org.example.spring_exo2.controller;

import org.example.spring_exo2.service.EtudientService;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class EtudientController {

    private final EtudientService etudientService;

    public EtudientController(EtudientService etudientService) {
        this.etudientService = etudientService;
    }

    @RequestMapping("/")
    public String index() {
        return "index";
    }

    RequestMapping("/list-etudient")
        public String listEtudient() {
        }
}
