package org.example.exo3.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Categorie {
    private int id;
    private String nom;
}
