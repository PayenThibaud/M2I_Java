package org.example.exo_spring_forum.controller;

import jakarta.servlet.http.HttpSession;
import org.example.exo_spring_forum.entity.Message;
import org.example.exo_spring_forum.repository.UtilisateurRepository;
import org.example.exo_spring_forum.service.ForumService;
import org.example.exo_spring_forum.service.LoginService;
import org.example.exo_spring_forum.service.MessageService;
import org.example.exo_spring_forum.service.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDateTime;

@Controller
public class MessageController {
    private final MessageService messageService;
    private final LoginService loginService;
    private final UtilisateurService utilisateurService;
    private final ForumService forumService;

    private HttpSession httpSession;

    @Autowired
    public MessageController(MessageService messageService, LoginService loginService, UtilisateurService utilisateurService, HttpSession httpSession, ForumService forumService) {
        this.messageService = messageService;
        this.loginService = loginService;
        this.utilisateurService = utilisateurService;
        this.httpSession = httpSession;
        this.forumService = forumService;
    }

    @RequestMapping("/message/{id_forum}")
    public String message(@PathVariable("id_forum") int id_Forum, Model model) {
        if (!loginService.isLogged()) {
            return "redirect:/login";
        }
        model.addAttribute("utilisateur", utilisateurService.findByNom((String) httpSession.getAttribute("utilisateurNom")));
        model.addAttribute("messages", messageService.getMessagesByForumId(id_Forum));
        model.addAttribute("message", new Message());
        model.addAttribute("forum", forumService.getForumById(id_Forum));
        return "message";
    }

    @PostMapping("/message/{id_forum}")
    public String postMessage(@ModelAttribute("message") Message message, @PathVariable("id_forum") int id_Forum) {
        if (!loginService.isLogged()) {
            return "redirect:/login";
        }
        message.setDate(LocalDateTime.now());
        message.setForum(forumService.getForumById(id_Forum));
        message.setUtilisateur(utilisateurService.findByNom((String) httpSession.getAttribute("utilisateurNom")));
        messageService.save(message);

        return "redirect:/message/" + id_Forum;
    }
}
