package org.example.exo2.entity;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder

public class Animaux {
    private int id;
    private String nom;
    private String race;
    private String description;
    private String habitat;
    private int age;
    private List<Repas> repas;
    private List<Integer> gardien_id;
}
