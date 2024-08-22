package org.example.exo2.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder

public class AnimauxGardien {
    private int id;
    private Animaux animaux;
    private Gardien gardien;
}
