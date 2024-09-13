package org.example.exo_spring_forum.service;

import org.example.exo_spring_forum.entity.Utilisateur;
import org.example.exo_spring_forum.repository.UtilisateurRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UtilisateurService {
    private UtilisateurRepository utilisateurRepository;

    public UtilisateurService(UtilisateurRepository utilisateurRepository) {
        this.utilisateurRepository = utilisateurRepository;
    }

    public Utilisateur findById(int id){
        return utilisateurRepository.findById(id).orElse(null);
    }

    public List<Utilisateur> findAll(){
        return utilisateurRepository.findAll();
    }

    public Utilisateur save(Utilisateur utilisateur){
        return utilisateurRepository.save(utilisateur);
    }

    public void delete(Utilisateur utilisateur){
        utilisateurRepository.delete(utilisateur);
    }
}
