package org.example.correctionexercice2rest.service;

import org.example.correctionexercice2rest.Exception.NotFoundException;
import org.example.correctionexercice2rest.dto.film.FilmDtoReceive;
import org.example.correctionexercice2rest.dto.film.FilmDtoSend;
import org.example.correctionexercice2rest.entity.Film;
import org.example.correctionexercice2rest.repository.FilmRepository;
import org.example.correctionexercice2rest.util.FilmType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FilmService implements BaseService<FilmDtoReceive, FilmDtoSend> {

    @Autowired
    private FilmRepository filmRepository;
    @Autowired
    private DirectorService directorService;

    private final DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    @Override
    public FilmDtoSend create(FilmDtoReceive received) {
        Film film = Film.builder()
                .name(received.getName())
                .description(received.getDescription())
                .duration(received.getDuration())
                .filmType(FilmType.values()[received.getFilmType()])
                .releaseDate(LocalDate.parse(received.getReleaseDateStr(),dateFormatter))
                .director(directorService.getDirectorById(received.getDirectorId()))
                .build();

        filmRepository.save(film);
        return filmToFilmDtoSend(film);
    }

    @Override
    public FilmDtoSend update(long id, FilmDtoReceive received) {
        Film film = getById(id);
        film.setName(received.getName());
        film.setDescription(received.getDescription());
        film.setDuration(received.getDuration());
        film.setReleaseDate(LocalDate.parse(received.getReleaseDateStr(),dateFormatter));
        film.setFilmType(FilmType.values()[received.getFilmType()]);
        film.setDirector(directorService.getDirectorById(received.getDirectorId()));

        filmRepository.save(film);
        return filmToFilmDtoSend(film);
    }

    @Override
    public boolean delete(long id) {
        Film film = getById(id);
        filmRepository.delete(film);
        return true;
    }

    @Override
    public FilmDtoSend findById(long id) {
        return filmToFilmDtoSend(getById(id));
    }

    @Override
    public List<FilmDtoSend> getAll() {
        return filmsToFilmDtoSends((List<Film>) filmRepository.findAll());
    }

    public Film getById (long id){
        return filmRepository.findById(id).orElseThrow(()->new NotFoundException("film not found at id :"+id));
    }

    public FilmDtoSend filmToFilmDtoSend (Film film){
        return FilmDtoSend.builder()
                .id(film.getId())
                .name(film.getName())
                .description(film.getDescription())
                .duration(film.getDuration())
                .filmType(film.getFilmType())
                .releaseDate(film.getReleaseDate())
                .director(film.getDirector())
                .build();
    }

    private List<FilmDtoSend> filmsToFilmDtoSends (List<Film> films){
        return films.stream().map(this::filmToFilmDtoSend).collect(Collectors.toList());
    }
}
