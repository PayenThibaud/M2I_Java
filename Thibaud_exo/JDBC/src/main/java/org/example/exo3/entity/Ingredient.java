package org.example.exo3.entity;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Ingredient {
    private int id;
    private String nom;
}
