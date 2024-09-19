package org.example.rest_cinema.service;

import org.example.rest_cinema.Repository.FilmRepository;
import org.example.rest_cinema.Repository.RealisateurRepository;
import org.example.rest_cinema.dto.filmDto.FilmDtoReceive;
import org.example.rest_cinema.dto.filmDto.FilmDtoSend;
import org.example.rest_cinema.dto.realisateurDto.RealisateurDtoSend;
import org.example.rest_cinema.entity.Film;
import org.example.rest_cinema.entity.Realisateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

    public FilmDtoSend filmToFilmDtoSend(Film film) {
        Realisateur realisateur = film.getRealisateur();
        RealisateurDtoSend realisateurDtoSend =
                new RealisateurDtoSend(
                        realisateur.getNom(),
                        realisateur.getPrenom(),
                        realisateur.getDateNaissance(),
                        realisateur.getNationalite()
                );

        return new FilmDtoSend(
                film.getNom(),
                film.getDescription(),
                film.getDateDeSortie(),
                film.getDuree(),
                film.getGenre(),
                realisateurDtoSend
        );
    }

    public List<FilmDtoSend> filmsToFilmDtoSendList(List<Film> films) {
        List<FilmDtoSend> filmDtoSends = new ArrayList<>();
        for (Film film : films) {
            RealisateurDtoSend realisateurDtoSend = new RealisateurDtoSend(
                    film.getRealisateur().getNom(),
                    film.getRealisateur().getPrenom(),
                    film.getRealisateur().getDateNaissance(),
                    film.getRealisateur().getNationalite()
            );

            FilmDtoSend filmDtoSend = new FilmDtoSend(
                    film.getNom(),
                    film.getDescription(),
                    film.getDateDeSortie(),
                    film.getDuree(),
                    film.getGenre(),
                    realisateurDtoSend
            );
            filmDtoSends.add(filmDtoSend);
        }
        return filmDtoSends;
    }

}
