package org.example.rest_cinema.controller;

import org.example.rest_cinema.dto.filmDto.FilmDtoReceive;
import org.example.rest_cinema.dto.filmDto.FilmDtoSend;
import org.example.rest_cinema.dto.realisateurDto.RealisateurDtoSend;
import org.example.rest_cinema.entity.Film;
import org.example.rest_cinema.entity.Realisateur;
import org.example.rest_cinema.service.FilmService;
import org.example.rest_cinema.service.RealisateurService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("catalogue/films")
public class FilmController {

    private final FilmService filmService;
    private final RealisateurService realisateurService;

    public FilmController(FilmService filmService, RealisateurService realisateurService) {
        this.filmService = filmService;
        this.realisateurService = realisateurService;
    }

    @GetMapping
    public ResponseEntity<List<FilmDtoSend>> getAll() {
        List<Film> films = filmService.getAll();
        List<FilmDtoSend> filmDtoSends = new ArrayList<>();
        for (Film film : films) {
            Realisateur realisateur = film.getRealisateur();
            RealisateurDtoSend realisateurDtoSend = new RealisateurDtoSend(
                    realisateur.getNom(),
                    realisateur.getPrenom(),
                    realisateur.getDateNaissance(),
                    realisateur.getNationalite()
            );

            filmDtoSends.add(new FilmDtoSend(
                    film.getNom(),
                    film.getDescription(),
                    film.getDateDeSortie(),
                    film.getDuree(),
                    film.getGenre(),
                    realisateurDtoSend
            ));
        }

        return ResponseEntity.ok(filmDtoSends);
    }

    @GetMapping("{id}")
    public ResponseEntity<FilmDtoSend> getFilm(@PathVariable("id") int id) {
        Film film = filmService.getById(id);
        Realisateur realisateur = film.getRealisateur();
        RealisateurDtoSend realisateurDtoSend = new RealisateurDtoSend(
                realisateur.getNom(),
                realisateur.getPrenom(),
                realisateur.getDateNaissance(),
                realisateur.getNationalite()
        );

        FilmDtoSend filmDtoSend = new FilmDtoSend(
                film.getNom(),
                film.getDescription(),
                film.getDateDeSortie(),
                film.getDuree(),
                film.getGenre(),
                realisateurDtoSend
        );

        return ResponseEntity.ok(filmDtoSend);
    }

    @PostMapping
    public ResponseEntity<FilmDtoSend> register(@RequestBody FilmDtoReceive filmDtoReceive) {
        Film film = filmService.create(filmDtoReceive);

        Realisateur realisateur = film.getRealisateur();
        RealisateurDtoSend realisateurDtoSend = new RealisateurDtoSend(
                realisateur.getNom(),
                realisateur.getPrenom(),
                realisateur.getDateNaissance(),
                realisateur.getNationalite()
        );

        FilmDtoSend filmDtoSend = new FilmDtoSend(
                film.getNom(),
                film.getDescription(),
                film.getDateDeSortie(),
                film.getDuree(),
                film.getGenre(),
                realisateurDtoSend
        );

        return new ResponseEntity<>(filmDtoSend, HttpStatus.CREATED);
    }

    @GetMapping("realisateur/{nom_realisateur}")
    public ResponseEntity<List<FilmDtoSend>> getByRealisateur(@PathVariable("nom_realisateur") String nomRealisateur) {
        Realisateur realisateur = realisateurService.getByNom(nomRealisateur);

        List<Film> films = filmService.getByRealisateur(realisateur);
        List<FilmDtoSend> filmDtoSends = new ArrayList<>();
        for (Film film : films) {
            RealisateurDtoSend realisateurDtoSend = new RealisateurDtoSend(
                    film.getRealisateur().getNom(),
                    film.getRealisateur().getPrenom(),
                    film.getRealisateur().getDateNaissance(),
                    film.getRealisateur().getNationalite()
            );

            filmDtoSends.add(new FilmDtoSend(
                    film.getNom(),
                    film.getDescription(),
                    film.getDateDeSortie(),
                    film.getDuree(),
                    film.getGenre(),
                    realisateurDtoSend
            ));
        }

        return ResponseEntity.ok(filmDtoSends);
    }
}
