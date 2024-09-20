package org.example.correctionexercice2rest.controller;

import org.example.correctionexercice2rest.dto.film.FilmDtoReceive;
import org.example.correctionexercice2rest.dto.film.FilmDtoSend;
import org.example.correctionexercice2rest.service.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/catalogue/films")
public class FilmController {

    @Autowired
    private FilmService filmService;

    @GetMapping
    public ResponseEntity<List<FilmDtoSend>> getAllFilm (){
        return ResponseEntity.ok(filmService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<FilmDtoSend> getFilmById (@PathVariable("id")long id){
        return ResponseEntity.ok(filmService.findById(id));
    }

    @PostMapping
    public ResponseEntity<FilmDtoSend> addFilm (@Validated @RequestBody FilmDtoReceive filmDtoReceive){
        return ResponseEntity.status(HttpStatus.CREATED).body(filmService.create(filmDtoReceive));
    }

    @PutMapping("/{id}")
    public ResponseEntity<FilmDtoSend> updateFilm (@PathVariable("id") long id,@RequestBody FilmDtoReceive filmDtoReceive) {
        return ResponseEntity.ok(filmService.update(id, filmDtoReceive));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteFilm (@PathVariable("id")long id){
        filmService.delete(id);
        return ResponseEntity.ok("film with id :" +id+" is deleted");
    }
}
