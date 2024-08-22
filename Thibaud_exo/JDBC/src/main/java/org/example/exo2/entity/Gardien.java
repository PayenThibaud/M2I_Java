package org.example.exo2.entity;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder

public class Gardien {
    private int id;
    private String nom;
    private List<Integer> animaux_id;
}
