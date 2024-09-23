package org.example.micro_exo_1.controller;

import org.example.micro_exo_1.dto.UtilisateurDtoReceive;
import org.example.micro_exo_1.dto.UtilisateurDtoSend;
import org.example.micro_exo_1.service.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/utilisateur")
public class UtilisateurController {

    @Autowired
    private UtilisateurService utilisateurService;

    @GetMapping("/{id}")
    public ResponseEntity<UtilisateurDtoSend> getById(@PathVariable int id) {
        return ResponseEntity.ok(utilisateurService.getById(id));
    }

    @GetMapping
    public ResponseEntity<List<UtilisateurDtoSend>> getAll() {
        return ResponseEntity.ok(utilisateurService.getAlL());
    }

    @PostMapping
    public ResponseEntity<UtilisateurDtoSend> create(@RequestBody UtilisateurDtoReceive utilisateurDtoReceive) {
        return ResponseEntity.status(HttpStatus.CREATED).body(utilisateurService.save(utilisateurDtoReceive));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable int id) {
        utilisateurService.delete(id);
        return ResponseEntity.ok("Utilisateur supprimer");
    }

    @PutMapping("/{id}")
    public ResponseEntity<UtilisateurDtoSend> update(@PathVariable int id, @RequestBody UtilisateurDtoReceive utilisateurDtoReceive) {
        return ResponseEntity.ok(utilisateurService.update(id, utilisateurDtoReceive));
    }


}
