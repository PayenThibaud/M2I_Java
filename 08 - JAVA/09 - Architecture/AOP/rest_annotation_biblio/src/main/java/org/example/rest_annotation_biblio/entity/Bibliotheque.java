package org.example.rest_annotation_biblio.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "bibliotheque")
public class Bibliotheque {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_bibliotheque")
    private int id;
    private String nom;
    private String lieu;

    @OneToMany(mappedBy = "bibliotheque")
    private List<Livre> livres;
}
