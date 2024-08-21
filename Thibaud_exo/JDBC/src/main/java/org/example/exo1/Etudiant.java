package org.example.exo1;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class Etudiant {
    private int id;
    private String nom;
    private String prenom;
    private String numeroDeClasse;
    private String dateDeDiplome;
}
