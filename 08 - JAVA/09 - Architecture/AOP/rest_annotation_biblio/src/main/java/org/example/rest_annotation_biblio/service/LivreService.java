package org.example.rest_annotation_biblio.service;

import org.example.rest_annotation_biblio.DTO.BiblioDTO.BibliothequeDtoSend;
import org.example.rest_annotation_biblio.DTO.livreDTO.LivreDtoReceive;
import org.example.rest_annotation_biblio.DTO.livreDTO.LivreDtoSend;
import org.example.rest_annotation_biblio.entity.Bibliotheque;
import org.example.rest_annotation_biblio.entity.Livre;
import org.example.rest_annotation_biblio.repository.BibliothequeRepository;
import org.example.rest_annotation_biblio.repository.LivreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LivreService {

    @Autowired
    private LivreRepository livreRepository;

    @Autowired
    private BibliothequeRepository bibliothequeRepository;

    public List<Livre> getAll() {
        return (List<Livre>) livreRepository.findAll();
    }

    public Livre getLivreById(int id) {
        return livreRepository.findById(id).orElseThrow();
    }

    public Livre saveLivre(LivreDtoReceive livreDtoReceive) {
        Livre livre = Livre.builder()
                .auteur(livreDtoReceive.getAuteur())
                .titre(livreDtoReceive.getTitre())
                .bibliotheque(bibliothequeRepository.findByNom(livreDtoReceive.getNom_bibliotheque()))
                .build();

        return livreRepository.save(livre);
    }

    public LivreDtoSend livreToLivreDto(Livre livre) {
        Bibliotheque bibliotheque = livre.getBibliotheque();
        BibliothequeDtoSend bibliothequeDtoSend = new BibliothequeDtoSend(
                bibliotheque.getNom(),
                bibliotheque.getLieu()
        );
        return new LivreDtoSend(
                livre.getTitre(),
                livre.getAuteur(),
                bibliothequeDtoSend
        );
    }

    public List<LivreDtoSend> listLivretoListLivreDtoSend(List<Livre> livres) {
        List<LivreDtoSend> livreDtoSends = new ArrayList<>();
        for (Livre livre : livres) {
            BibliothequeDtoSend bibliothequeDtoSend = new BibliothequeDtoSend(
                    livre.getBibliotheque().getNom(),
                    livre.getBibliotheque().getLieu()
            );
            LivreDtoSend livreDtoSend = new LivreDtoSend(
                    livre.getTitre(),
                    livre.getAuteur(),
                    bibliothequeDtoSend
            );
            livreDtoSends.add(livreDtoSend);
        }
        return livreDtoSends;
    }

}
