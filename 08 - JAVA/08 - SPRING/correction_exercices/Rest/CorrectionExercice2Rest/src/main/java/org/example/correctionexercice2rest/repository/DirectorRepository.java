package org.example.correctionexercice2rest.repository;

import org.example.correctionexercice2rest.entity.Director;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DirectorRepository extends CrudRepository<Director,Long> {
}
