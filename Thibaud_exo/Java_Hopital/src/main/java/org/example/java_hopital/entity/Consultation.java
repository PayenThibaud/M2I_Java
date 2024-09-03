package org.example.java_hopital.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data

@Table(name = "consultation")
public class Consultation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_consultation")
    private int id;
    private String nomMedecin;
    private LocalDate dateDeConsultation;
    private String prescription;
    private String ficheDeSoin;

    @ManyToOne
    @JoinColumn(name = "id_patient")
    private Patient patient;

}
