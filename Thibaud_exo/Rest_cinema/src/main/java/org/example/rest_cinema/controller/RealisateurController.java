package org.example.rest_cinema.controller;

import org.example.rest_cinema.dto.realisateurDto.RealisateurDtoReceive;
import org.example.rest_cinema.dto.realisateurDto.RealisateurDtoSend;
import org.example.rest_cinema.entity.Realisateur;
import org.example.rest_cinema.service.RealisateurService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("catalogue/realisateur")
public class RealisateurController {

    private RealisateurService realisateurService;

    public RealisateurController(RealisateurService realisateurService) {
        this.realisateurService = realisateurService;
    }

    @GetMapping
    public ResponseEntity<List<RealisateurDtoSend>> getAll() {
        List<Realisateur> realisateurs = realisateurService.getAll();
        List<RealisateurDtoSend> realisateurDtoSends = new ArrayList<>();
        for (Realisateur realisateur : realisateurs) {
            realisateurDtoSends.add(new RealisateurDtoSend(
                    realisateur.getNom(),
                    realisateur.getPrenom(),
                    realisateur.getDateNaissance(),
                    realisateur.getNationalite()));
        }

        return ResponseEntity.ok(realisateurDtoSends);
    }

    @GetMapping("{id}")
    public ResponseEntity<RealisateurDtoSend> getRealisateur(@PathVariable("id") int id) {
        Realisateur realisateur = realisateurService.getById(id);
        return ResponseEntity.ok(new RealisateurDtoSend(
                realisateur.getNom(),
                realisateur.getPrenom(),
                realisateur.getDateNaissance(),
                realisateur.getNationalite()));
    }

    @PostMapping
    public ResponseEntity<RealisateurDtoSend> register(@RequestBody RealisateurDtoReceive realisateurDtoReceive) {
        Realisateur realisateur = realisateurService.create(realisateurDtoReceive);
        RealisateurDtoSend realisateurDtoSend = new RealisateurDtoSend(
                realisateur.getNom(),
                realisateur.getPrenom(),
                realisateur.getDateNaissance(),
                realisateur.getNationalite());

        return new ResponseEntity<>(realisateurDtoSend, HttpStatus.CREATED);
    }
}
