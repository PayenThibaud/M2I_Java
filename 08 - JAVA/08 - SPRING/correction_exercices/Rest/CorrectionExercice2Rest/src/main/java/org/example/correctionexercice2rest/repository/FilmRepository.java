package org.example.correctionexercice2rest.repository;

import org.example.correctionexercice2rest.entity.Film;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FilmRepository extends CrudRepository<Film,Long> {
}
