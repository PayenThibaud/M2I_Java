package org.example.rest_annotation_biblio.controller;

import org.example.rest_annotation_biblio.DTO.BiblioDTO.BibliothequeDtoReceive;
import org.example.rest_annotation_biblio.DTO.BiblioDTO.BibliothequeDtoSend;
import org.example.rest_annotation_biblio.entity.Bibliotheque;
import org.example.rest_annotation_biblio.service.BibliothequeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("biblio/")
public class BibliothequeController {

    private BibliothequeService bibliothequeService;

    public BibliothequeController(BibliothequeService bibliothequeService) {
        this.bibliothequeService = bibliothequeService;
    }

    @GetMapping
    public ResponseEntity<List<BibliothequeDtoSend>> getAll() {
        List<Bibliotheque> bibliotheques = bibliothequeService.getAll();
        List<BibliothequeDtoSend> bibliothequeDtoSends = bibliothequeService.listBiblioToListBiblioDTOSend(bibliotheques);
        return ResponseEntity.ok(bibliothequeDtoSends);
    }

    @GetMapping("{id}")
    public ResponseEntity<BibliothequeDtoSend> getBibliothequeById(@PathVariable("id") Integer id) {
        Bibliotheque bibliotheque = bibliothequeService.getById(id);
        BibliothequeDtoSend bibliothequeDtoSend = bibliothequeService.biblioToBiblioDtoSend(bibliotheque);
        return ResponseEntity.ok(bibliothequeDtoSend);
    }

    @PostMapping
    public ResponseEntity<BibliothequeDtoSend> registerBibliotheque(@RequestBody BibliothequeDtoReceive bibliothequeDtoReceive) {
        Bibliotheque bibliotheque = bibliothequeService.save(bibliothequeDtoReceive);
        BibliothequeDtoSend bibliothequeDtoSend = bibliothequeService.biblioToBiblioDtoSend(bibliotheque);

        return new ResponseEntity<>(bibliothequeDtoSend, HttpStatus.CREATED);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteBibliotheque(@PathVariable("id") Integer id) {
        bibliothequeService.deleteById(id);
        return ResponseEntity.ok("Deleted bibliotheque with id " + id);
    }
}
