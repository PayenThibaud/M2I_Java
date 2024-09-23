package org.example.demo_micro.controller;

import org.example.demo_micro.dto.AuteurdtoReceive;
import org.example.demo_micro.entity.Auteur;
import org.example.demo_micro.service.AuteurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auteur")
public class AuteurController {

    @Autowired
    private AuteurService auteurService;

    @GetMapping("/{id}")
    public ResponseEntity<Auteur> getById(@PathVariable int id) {
        return ResponseEntity.ok(auteurService.getById(id));
    }

    @PostMapping
    public ResponseEntity<Auteur> save(@RequestBody AuteurdtoReceive auteurdtoReceive) {
        return ResponseEntity.status(HttpStatus.CREATED).body(auteurService.save(auteurdtoReceive));
    }
}
