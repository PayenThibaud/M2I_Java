package org.example.exo_spring_forum.controller;

import org.example.exo_spring_forum.entity.Utilisateur;
import org.example.exo_spring_forum.service.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UtilisateurController {
    private final UtilisateurService utilisateurService;

    @Autowired
    public UtilisateurController(UtilisateurService utilisateurService) {
        this.utilisateurService = utilisateurService;
    }

    @RequestMapping("/")
    public String index() {
        return "index";
    }

    @RequestMapping("/inscription")
    public String inscription(Model model) {
        model.addAttribute("utilisateur", new Utilisateur());
        return "inscription";
    }

    @PostMapping("/inscription")
    public String inscriptionPost(@ModelAttribute("utilisateur") Utilisateur utilisateur) {
        utilisateurService.save(utilisateur);
        return "redirect:/";
    }


}
