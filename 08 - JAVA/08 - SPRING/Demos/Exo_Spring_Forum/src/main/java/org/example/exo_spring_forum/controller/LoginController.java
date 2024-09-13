package org.example.exo_spring_forum.controller;

import jakarta.servlet.http.HttpSession;
import org.example.exo_spring_forum.service.LoginService;
import org.example.exo_spring_forum.service.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    private final LoginService loginService;
    private final UtilisateurService utilisateurService;
    private final HttpSession httpSession;

    @Autowired
    public LoginController(HttpSession httpSession, LoginService loginService, UtilisateurService utilisateurService) {
        this.loginService = loginService;
        this.utilisateurService = utilisateurService;
        this.httpSession = httpSession;
    }

    @RequestMapping("/login")
    public String login(Model model) {
        if (loginService.isLogged()) {
            model.addAttribute("utilisateur", utilisateurService.findByNom((String) httpSession.getAttribute("utilisateurNom")));
            return "index";
        }
        return "login";
    }


    @PostMapping("/login")
    public String login(@RequestParam("nom") String nom, @RequestParam("password") String password, Model model) {
        if (loginService.login(nom, password)) {
            model.addAttribute("utilisateur", utilisateurService.findByNom(nom));
            return "index";
        }
        return "redirect:/login";
    }

    @RequestMapping("/logout")
    public String logout() {
        loginService.logout();
        return "redirect:/login";
    }
}
