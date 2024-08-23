package org.example.exo3.entity.jointure;

import lombok.Builder;
import lombok.Data;

@Data@Builder
public class CommentaireRecette {
    private int id;
    private int commentaire_id;
    private int recette_id;
}
