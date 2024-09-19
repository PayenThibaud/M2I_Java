package org.example.rest_cinema.service;

import org.example.rest_cinema.Repository.FilmRepository;
import org.example.rest_cinema.Repository.RealisateurRepository;
import org.example.rest_cinema.dto.filmDto.FilmDtoReceive;
import org.example.rest_cinema.entity.Film;
import org.example.rest_cinema.entity.Realisateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FilmService {

    @Autowired
    private FilmRepository filmRepository;
    @Autowired
    private RealisateurRepository realisateurRepository;

    public List<Film> getAll() {
        return (List<Film>) filmRepository.findAll();
    }

    public Film getById(int id) {
        return filmRepository.findById(id).orElseThrow();
    }

    public Film create (FilmDtoReceive filmDtoReceive){
        Film filmCreated = Film.builder()
                .nom(filmDtoReceive.getNom())
                .dateDeSortie(filmDtoReceive.getDateDeSortie())
                .description(filmDtoReceive.getDescription())
                .duree(filmDtoReceive.getDuree())
                .genre(filmDtoReceive.getGenre())
                .realisateur(realisateurRepository.findByNom(filmDtoReceive.getNom_realisateur()))
                .build();

        return filmRepository.save(filmCreated);
    }

    public List<Film> getByRealisateur(Realisateur realisateur) {
        return filmRepository.findByRealisateur(realisateur);
    }
}
