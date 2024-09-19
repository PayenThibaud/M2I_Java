package org.example.rest_cinema.service;

import org.example.rest_cinema.Repository.FilmRepository;
import org.example.rest_cinema.dto.filmDto.FilmDtoReceive;
import org.example.rest_cinema.entity.Film;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FilmService {

    @Autowired
    private FilmRepository filmRepository;

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
                .realisateur(filmDtoReceive.getRealisateur())
                .build();

        return filmRepository.save(filmCreated);
    }
}
