package org.example.exo_spring_forum.repository;

import org.example.exo_spring_forum.entity.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UtilisateurRepository extends JpaRepository<Utilisateur, Integer> {

    Utilisateur findByNom(String nom);
}
