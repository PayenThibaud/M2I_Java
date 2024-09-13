package org.example.exo_spring_forum.service;

import jakarta.servlet.http.HttpSession;
import org.example.exo_spring_forum.entity.Utilisateur;
import org.example.exo_spring_forum.repository.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {
    @Autowired
    private HttpSession httpSession;
    private final UtilisateurRepository utilisateurRepository;
    ;

    public LoginService(UtilisateurRepository utilisateurRepository) {
        this.utilisateurRepository = utilisateurRepository;
    }

    public boolean login(String nom, String password) {
        Utilisateur utilisateur = utilisateurRepository.findByNom(nom);
        if (utilisateur != null) {
            if (utilisateur.getPassword().equals(password)) {
                httpSession.setAttribute("login", "OK");
                httpSession.setAttribute("utilisateurNom", utilisateur.getNom());
                return true;
            }
        }
        return false;
    }


    public void logout() {
        httpSession.removeAttribute("login");
        httpSession.removeAttribute("utilisateurNom");
    }

    public boolean isLogged() {
        try {
            String verif = (String) httpSession.getAttribute("login");
            return verif.equals("OK");
        } catch (Exception e) {
            return false;
        }
    }
}


