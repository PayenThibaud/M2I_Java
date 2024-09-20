package org.example.rest_annotation_biblio.controller;

import org.example.rest_annotation_biblio.DTO.BiblioDTO.BibliothequeDtoReceive;
import org.example.rest_annotation_biblio.DTO.BiblioDTO.BibliothequeDtoSend;
import org.example.rest_annotation_biblio.DTO.livreDTO.LivreDtoReceive;
import org.example.rest_annotation_biblio.DTO.livreDTO.LivreDtoSend;
import org.example.rest_annotation_biblio.entity.Bibliotheque;
import org.example.rest_annotation_biblio.entity.Livre;
import org.example.rest_annotation_biblio.service.BibliothequeService;
import org.example.rest_annotation_biblio.service.LivreService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("livre/")
public class LivreController {

    private LivreService livreService;

    public LivreController(LivreService livreService) {
        this.livreService = livreService;
    }

    @GetMapping
    public ResponseEntity<List<LivreDtoSend>> getAll() {
        List<Livre> livres = livreService.getAll();
        List<LivreDtoSend> livreDtoSends = livreService.listLivretoListLivreDtoSend(livres);
        return ResponseEntity.ok(livreDtoSends);
    }

    @GetMapping("{id}")
    public ResponseEntity<LivreDtoSend> getBibliothequeById(@PathVariable("id") Integer id) {
        Livre livre = livreService.getLivreById(id);
        LivreDtoSend livreDtoSend = livreService.livreToLivreDto(livre);
        return ResponseEntity.ok(livreDtoSend);
    }

    @PostMapping
    public ResponseEntity<LivreDtoSend> register(@RequestBody LivreDtoReceive livreDtoReceive) {
        Livre livre = livreService.saveLivre(livreDtoReceive);
        LivreDtoSend livreDtoSend = livreService.livreToLivreDto(livre);

        return new ResponseEntity<>(livreDtoSend, HttpStatus.CREATED);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> delete(@PathVariable("id") Integer id) {
        livreService.delete(id);
        return ResponseEntity.noContent().build();
    }
}