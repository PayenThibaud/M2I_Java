package org.example.rest_cinema.service;

import org.example.rest_cinema.Repository.RealisateurRepository;
import org.example.rest_cinema.dto.realisateurDto.RealisateurDtoReceive;
import org.example.rest_cinema.entity.Realisateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RealisateurService {

    @Autowired
    private RealisateurRepository realisateurRepository;

    public List<Realisateur> getAll() {
        return (List<Realisateur>) realisateurRepository.findAll();
    }

    public Realisateur getById(int id) {
        return realisateurRepository.findById(id).orElseThrow();
    }

    public Realisateur create (RealisateurDtoReceive realisateurDtoReceive){
        Realisateur realisateurCreated = Realisateur.builder()
                .nom(realisateurDtoReceive.getNom())
                .prenom(realisateurDtoReceive.getPrenom())
                .dateNaissance(realisateurDtoReceive.getDateNaissance())
                .nationalite(realisateurDtoReceive.getNationalite())
                .build();

        return realisateurRepository.save(realisateurCreated);
    }
}
