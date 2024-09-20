package org.example.rest_annotation_biblio.repository;

import org.example.rest_annotation_biblio.entity.Bibliotheque;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BibliothequeRepository extends CrudRepository<Bibliotheque, Integer> {
    Bibliotheque findByNom(String nom);
}
