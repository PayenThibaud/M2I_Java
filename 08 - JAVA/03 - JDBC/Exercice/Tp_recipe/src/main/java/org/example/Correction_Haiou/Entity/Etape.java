package ExercicesJDBC.Recette.Entity;

// Utilisation de Lombok pour générer automatiquement les getters/setters, toString(), etc...
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Etape {
    private int id;
    private String description;
    private int recetteId; // Relation avec la recette
}
