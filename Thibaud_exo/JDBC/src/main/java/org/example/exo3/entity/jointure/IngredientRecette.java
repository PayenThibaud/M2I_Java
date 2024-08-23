package org.example.exo3.entity.jointure;

import lombok.Builder;
import lombok.Data;

@Data
@Builder

public class IngredientRecette {
    private int id;
    private int ingredient_id;
    private int recette_id;
}
