package org.example.Demo2.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Plante {
    private int id;
    private String name;
    private int age;
    private String color;
}
