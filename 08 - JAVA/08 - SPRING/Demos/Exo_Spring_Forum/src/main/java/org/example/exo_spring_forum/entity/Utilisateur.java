package org.example.exo_spring_forum.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity

@Table(name = "utilisateur")
public class Utilisateur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="id_utilisateur")
    private int id;

    private String nom;
    private String password;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "utilisateur")
    private List<Forum> forums = new ArrayList<>();

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "utilisateur")
    private List<Message> messages = new ArrayList<>();
}
