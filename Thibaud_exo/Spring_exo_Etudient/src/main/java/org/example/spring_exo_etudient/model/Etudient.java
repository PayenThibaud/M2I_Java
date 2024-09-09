package org.example.spring_exo_etudient.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Etudient {
    private String nom;
    private String prenom;
    private String email;
    private int agee;
}
