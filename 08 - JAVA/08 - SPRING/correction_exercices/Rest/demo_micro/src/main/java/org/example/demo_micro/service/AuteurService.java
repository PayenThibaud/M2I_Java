package org.example.demo_micro.service;

import org.example.demo_micro.dto.AuteurdtoReceive;
import org.example.demo_micro.entity.Auteur;
import org.example.demo_micro.repository.AuteurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuteurService {

    @Autowired
    private AuteurRepository auteurRepository;

    public Auteur save(AuteurdtoReceive auteurdtoReceive) {
        Auteur auteur = Auteur.builder()
                .nom(auteurdtoReceive.getNom())
                .prenom(auteurdtoReceive.getPrenom())
                .build();

        return auteurRepository.save(auteur);
    }

    public Auteur getById(int id) {
        return auteurRepository.findById(id).orElse(null);
    }
}
