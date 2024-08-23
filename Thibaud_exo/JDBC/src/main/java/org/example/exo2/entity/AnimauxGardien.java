package org.example.exo2.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder

public class AnimauxGardien {
    private int id;
    private int animaux_id;
    private int gardien_id;
}
