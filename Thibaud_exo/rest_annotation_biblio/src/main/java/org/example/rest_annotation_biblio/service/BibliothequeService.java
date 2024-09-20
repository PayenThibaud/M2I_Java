package org.example.rest_annotation_biblio.service;

import jakarta.persistence.PersistenceContext;
import org.example.rest_annotation_biblio.DTO.BiblioDTO.BibliothequeDtoReceive;
import org.example.rest_annotation_biblio.DTO.BiblioDTO.BibliothequeDtoSend;
import org.example.rest_annotation_biblio.DTO.livreDTO.LivreDtoSend;
import org.example.rest_annotation_biblio.annotation.LogginAspect;
import org.example.rest_annotation_biblio.annotation.PerformanceAspect;
import org.example.rest_annotation_biblio.entity.Bibliotheque;
import org.example.rest_annotation_biblio.entity.Livre;
import org.example.rest_annotation_biblio.repository.BibliothequeRepository;
import org.example.rest_annotation_biblio.repository.LivreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BibliothequeService {

    @Autowired
    private BibliothequeRepository bibliothequeRepository;
    @Autowired
    private LivreRepository livreRepository;

    @LogginAspect
    @PerformanceAspect
    public List<Bibliotheque> getAll() {
        return (List<Bibliotheque>) bibliothequeRepository.findAll();
    }

    @LogginAspect
    @PerformanceAspect
    public Bibliotheque getById(int id) {
        return bibliothequeRepository.findById(id).orElseThrow();
    }

    @LogginAspect
    @PerformanceAspect
    public Bibliotheque save(BibliothequeDtoReceive bibliothequeDtoReceive) {
        Bibliotheque bibliotheque = Bibliotheque.builder()
                .nom(bibliothequeDtoReceive.getNom())
                .lieu(bibliothequeDtoReceive.getLieu())
                .build();

        return bibliothequeRepository.save(bibliotheque);
    }

    public Bibliotheque getByNom(String nom) {
        return bibliothequeRepository.findByNom(nom);
    }

    @LogginAspect
    @PerformanceAspect
    public boolean deleteById(int id) {
        Bibliotheque bibliotheque = bibliothequeRepository.findById(id).orElseThrow();

        for (Livre livre : bibliotheque.getLivres()) {
            livre.setBibliotheque(null);
        }

        for (Livre livre : bibliotheque.getLivres()) {
            livreRepository.save(livre);
        }

        bibliothequeRepository.delete(bibliotheque);
        return true;
    }


    public BibliothequeDtoSend biblioToBiblioDtoSend(Bibliotheque bibliotheque) {
        return new BibliothequeDtoSend(
                bibliotheque.getNom(),
                bibliotheque.getLieu());
    }


    public List<BibliothequeDtoSend> listBiblioToListBiblioDTOSend(List<Bibliotheque> bibliotheques) {
        List<BibliothequeDtoSend> bibliothequeDtoSendList = new ArrayList<>();
        for (Bibliotheque bibliotheque : bibliotheques) {
            BibliothequeDtoSend bibliothequeDtoSend = new BibliothequeDtoSend(
                    bibliotheque.getNom(),
                    bibliotheque.getLieu()
            );
            bibliothequeDtoSendList.add(bibliothequeDtoSend);
        }
        return bibliothequeDtoSendList;
    }
}
