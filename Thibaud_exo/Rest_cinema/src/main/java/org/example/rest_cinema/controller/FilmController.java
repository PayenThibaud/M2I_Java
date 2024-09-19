package org.example.rest_cinema.controller;

import org.example.rest_cinema.dto.filmDto.FilmDtoReceive;
import org.example.rest_cinema.dto.filmDto.FilmDtoSend;
import org.example.rest_cinema.dto.realisateurDto.RealisateurDtoReceive;
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

    private FilmService filmService;

    public FilmController(FilmService filmService) {
        this.filmService = filmService;
    }

    @GetMapping
    public ResponseEntity<List<FilmDtoSend>> getAll() {
        List<Film> films = filmService.getAll();
        List<FilmDtoSend> filmDtoSends = new ArrayList<>();
        for (Film film : films) {
            filmDtoSends.add(new FilmDtoSend(
                    film.getNom(),
                    film.getDescription(),
                    film.getDateDeSortie(),
                    film.getDuree(),
                    film.getGenre(),
                    film.getRealisateur()));
        }

        return ResponseEntity.ok(filmDtoSends);
    }

    @GetMapping("{id}")
    public ResponseEntity<FilmDtoSend> getFilm(@PathVariable("id") int id) {
        Film film = filmService.getById(id);
        return ResponseEntity.ok(new FilmDtoSend(
                film.getNom(),
                film.getDescription(),
                film.getDateDeSortie(),
                film.getDuree(),
                film.getGenre(),
                film.getRealisateur()));
    }

    @PostMapping
    public ResponseEntity<FilmDtoSend> register(@RequestBody FilmDtoReceive filmDtoReceive) {
        Film film = filmService.create(filmDtoReceive);
        FilmDtoSend filmDtoSend = new FilmDtoSend(
                film.getNom(),
                film.getDescription(),
                film.getDateDeSortie(),
                film.getDuree(),
                film.getGenre(),
                film.getRealisateur());

        return new ResponseEntity<>(filmDtoSend, HttpStatus.CREATED);
    }
}

}
