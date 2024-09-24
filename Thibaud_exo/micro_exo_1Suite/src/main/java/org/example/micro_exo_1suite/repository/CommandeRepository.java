package org.example.micro_exo_1suite.repository;

import org.example.micro_exo_1suite.entity.Commande;
import org.springframework.data.repository.CrudRepository;

public interface CommandeRepository extends CrudRepository<Commande, Integer> {
    List<Commande> findByDateBetween(Date from, Date to);
}
