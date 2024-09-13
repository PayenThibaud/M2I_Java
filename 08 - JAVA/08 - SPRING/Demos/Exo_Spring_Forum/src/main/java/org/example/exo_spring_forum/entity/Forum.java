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

@Table(name = "forum")
public class Forum {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="id_forum")
    private int id;

    private String titre;

    @ManyToOne
    @JoinColumn(name ="id_utilisateur")
    private Utilisateur utilisateur;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "forum")
    private List<Message> messages = new ArrayList<>();
}