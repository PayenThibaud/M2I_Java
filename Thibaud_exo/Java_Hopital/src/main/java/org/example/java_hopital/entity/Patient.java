package org.example.java_hopital.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data

@Table(name = "patient")
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_patient")
    private int id;
    private String nom;
    private String prenom;
    private LocalDate dateDeNaissance;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "patient")
    private List<Consultation> consultations = new ArrayList<>();
}
