package org.example.exo_spring_forum.controller;

import jakarta.servlet.http.HttpSession;
import org.example.exo_spring_forum.entity.Forum;
import org.example.exo_spring_forum.service.ForumService;
import org.example.exo_spring_forum.service.LoginService;
import org.example.exo_spring_forum.service.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ForumController {
    private final ForumService forumService;
    private final UtilisateurService utilisateurService;
    private final LoginService loginService;

    private HttpSession httpSession;

    @Autowired
    public ForumController(ForumService forumService, UtilisateurService utilisateurService, HttpSession httpSession, LoginService loginService) {
        this.forumService = forumService;
        this.utilisateurService = utilisateurService;
        this.httpSession = httpSession;
        this.loginService = loginService;
    }

    @RequestMapping("/forum")
    public String forum(Model model) {
        if (!loginService.isLogged()) {
            return "redirect:/login";
        }
        model.addAttribute("forums", forumService.getAllForums());
        model.addAttribute("utilisateur", utilisateurService.findByNom((String) httpSession.getAttribute("utilisateurNom")));
        model.addAttribute("forum", new Forum());
        return "forum";
    }

    @PostMapping("/forum")
    public String forum(@ModelAttribute("forum") Forum forum) {
        if (!loginService.isLogged()) {
            return "redirect:/login";
        }

        forum.setUtilisateur(utilisateurService.findByNom((String) httpSession.getAttribute("utilisateurNom")));
        forumService.save(forum);

        return "redirect:/forum";
    }
}
