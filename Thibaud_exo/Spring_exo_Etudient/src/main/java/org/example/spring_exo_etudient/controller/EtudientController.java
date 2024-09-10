package org.example.spring_exo_etudient.controller;

import org.example.spring_exo_etudient.model.Etudient;
import org.example.spring_exo_etudient.service.EtudientService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class EtudientController {

    private final EtudientService etudientService;

    public EtudientController(EtudientService etudientService) {
        this.etudientService = etudientService;
    }

    @RequestMapping("/")
    public String index(Model model) {
        model.addAttribute("EtudientsNom",etudientService.getEtudients());
        return "index";
    }

    @RequestMapping("/recherche")
    public String search(@RequestParam("nom") String nom, Model model) {
        List<Etudient> resultatsRecherche = etudientService.getEtudientsByName(nom);
        model.addAttribute("EtudientsNom", resultatsRecherche);
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

    @RequestMapping( "/inscription")
    public String inscription(Model model) {
        Etudient etudientVide = new Etudient("Entrez le nom", "Entrez le prénom", "Entrez l'email", 0);
        model.addAttribute("Etudient", etudientVide);
        return "inscription";
    }

    @RequestMapping(value = "/inscription", method = RequestMethod.POST)
    public String inscription(
            @RequestParam String prenom,
            @RequestParam String nom,
            @RequestParam String email,
            @RequestParam int age,
            Model model) {

        Etudient etudient = new Etudient(nom, prenom, email, age);
        etudientService.setEtudients(etudient);
        return "redirect:/";
    }


}
