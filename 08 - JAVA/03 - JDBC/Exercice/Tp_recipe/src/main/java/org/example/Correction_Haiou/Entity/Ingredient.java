package ExercicesJDBC.Recette.Entity;

// Utilisation de Lombok pour générer automatiquement les getters/setters, toString(), etc...
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Ingredient {
    private int id;
    private String nom;
}
