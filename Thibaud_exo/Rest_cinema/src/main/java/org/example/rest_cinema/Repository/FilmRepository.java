package org.example.rest_cinema.Repository;

import org.example.rest_cinema.entity.Film;
import org.example.rest_cinema.entity.Realisateur;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FilmRepository extends CrudRepository<Film, Integer> {
    List<Film> findByRealisateur(Realisateur realisateur);
}
