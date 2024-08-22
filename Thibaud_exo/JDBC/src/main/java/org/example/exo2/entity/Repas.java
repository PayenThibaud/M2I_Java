package org.example.exo2.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder

public class Repas {
    private int id;
    private String date;
    private String heure;
    private String detail;
    private int animaux_id;
}
