package org.example.exo3.entity;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class Recette {
    private int id;
    private String nom;
    private int tempsPrep;
    private int tempsCuisson;
    private String difficulte;
    private List<Ingredient> ingredientList;
    private List<Etape> etapeList;
    private List<Commentaire> commentaireList;
    private Categorie categorie;
}
