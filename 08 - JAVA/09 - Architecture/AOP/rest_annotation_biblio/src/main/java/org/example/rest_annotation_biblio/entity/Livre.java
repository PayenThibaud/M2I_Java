package org.example.rest_annotation_biblio.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "livre")
public class Livre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_livre")
    private int id;

    private String titre;
    private String auteur;

    @ManyToOne
    @JoinColumn(name = "id_bibliotheque")
    private Bibliotheque bibliotheque;
}
