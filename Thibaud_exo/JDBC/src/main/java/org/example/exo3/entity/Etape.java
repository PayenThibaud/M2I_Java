package org.example.exo3.entity;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Etape {
    private int id;
    private String description;
}
