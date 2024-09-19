package org.example.rest_cinema.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "film")
public class Film {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_film")
    private int id;
    private String nom;
    private String description;
    private LocalDate dateDeSortie;
    private int duree;
    private String genre;

    @ManyToOne
    @JoinColumn(name = "id_realisateur")
    private Realisateur realisateur;
}
