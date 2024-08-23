package org.example.exo3.entity.jointure;

import lombok.Builder;
import lombok.Data;

@Data
@Builder

public class EtapeRecette {
    private int id;
    private int etape_id;
    private int recette_id;
}
