package ExercicesJDBC.Recette.Entity;

// Utilisation de Lombok pour générer automatiquement les getters/setters, toString(), etc...
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class Recette {
    private int id;
    private String nom;
    private int tempsPrep; // Temps de préparation en min
    private int tempsCuisson; // Temps de cuisson en min
    private String difficulte; // Difficulté (Facile, Moyen, Difficile)

    private int categorieId; // Catégorie associée. Utilisation de l'ID de la catégorie

    /*
    Attention, si on crée un Objet Categorie (par exemple) :

    private Categorie categorie; // Pour y accéder dans DAO c'est : recette.getCategorie().getId() au lieu de recette.getCategorieId()
    */

    private List<Ingredient> ingredients; // Liste des ingrédients. On doit gérer les ingrédients des recettes
    private List<Etape> etapes; // Liste des étapes. On doit gérer les étapes des recettes
    private List<Commentaire> commentaires; // Liste des commentaires. On doit gérer les commentaires des recettes
}
