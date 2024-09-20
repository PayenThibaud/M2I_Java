package org.example.rest_annotation_biblio.repository;

import org.example.rest_annotation_biblio.entity.Livre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LivreRepository extends CrudRepository<Livre, Integer> {
}
