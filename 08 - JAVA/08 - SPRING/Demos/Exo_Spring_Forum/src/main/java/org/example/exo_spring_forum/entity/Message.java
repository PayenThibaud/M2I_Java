package org.example.exo_spring_forum.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity

@Table(name = "message")
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="id_message")
    private int id;

    private String mot;
    private LocalDateTime date;

    @ManyToOne
    @JoinColumn(name ="id_forum")
    private Forum forum;

    @ManyToOne
    @JoinColumn(name ="id_utilisateur")
    private Utilisateur utilisateur;
}
