package org.example.micro_exo_1.service;

import org.example.micro_exo_1.dto.UtilisateurDtoReceive;
import org.example.micro_exo_1.dto.UtilisateurDtoSend;
import org.example.micro_exo_1.entity.Utilisateur;
import org.example.micro_exo_1.repository.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UtilisateurService {

    @Autowired
    private UtilisateurRepository utilisateurRepository;

    public UtilisateurService(UtilisateurRepository utilisateurRepository) {
        this.utilisateurRepository = utilisateurRepository;
    }

    private UtilisateurDtoSend utilisateurToUtilisateurDtoSend(Utilisateur utilisateur) {
        return UtilisateurDtoSend.builder()
                .id(utilisateur.getId())
                .nom(utilisateur.getNom())
                .email(utilisateur.getEmail())
                .build();
    }

    private List<UtilisateurDtoSend> listUtilisateurToUtilisateurDtoSends(List<Utilisateur> utilisateurs) {
        return utilisateurs.stream().map(this::utilisateurToUtilisateurDtoSend).toList();
    }

    private Utilisateur findById(int id) {
        return utilisateurRepository.findById(id).orElse(null);
    }


    public List<UtilisateurDtoSend> getAll() {
        return listUtilisateurToUtilisateurDtoSends((List<Utilisateur>) utilisateurRepository.findAll());
    }

    public UtilisateurDtoSend getById(int id) {
        return utilisateurToUtilisateurDtoSend(utilisateurRepository.findById(id).orElseThrow());
    }

    public UtilisateurDtoSend save(UtilisateurDtoReceive utilisateurDtoReceive) {

        Utilisateur utilisateur = Utilisateur.builder()
                .nom(utilisateurDtoReceive.getNom())
                .email(utilisateurDtoReceive.getEmail())
                .build();

        return utilisateurToUtilisateurDtoSend(utilisateurRepository.save(utilisateur));
    }

    public UtilisateurDtoSend update(int id, UtilisateurDtoReceive utilisateurDtoReceive) {
        Utilisateur utilisateur = findById(id);

        utilisateur.setNom(utilisateurDtoReceive.getNom());
        utilisateur.setEmail(utilisateurDtoReceive.getEmail());

        return utilisateurToUtilisateurDtoSend(utilisateurRepository.save(utilisateur));
    }

    public void delete(int id) {
        utilisateurRepository.delete(findById(id));
    }

}
