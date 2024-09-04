package org.example.java_jee_rest_voiture;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data

public class Voiture {
    private int id;
    private String nom;
    private Date dateDeFabrication;
    private String couleur;
}
