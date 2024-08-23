package org.example.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class GardienAnimal {
    private int id;
    private int id_gardien;
    private int id_animal;
}
