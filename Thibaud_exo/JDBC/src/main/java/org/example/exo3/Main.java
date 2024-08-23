package org.example.exo3;

import org.example.exo3.DAO.*;
import org.example.exo3.DAO.jointure.CommentaireRecetteDAO;
import org.example.exo3.DAO.jointure.EtapeRecetteDAO;
import org.example.exo3.DAO.jointure.IngredientRecetteDAO;
import org.example.exo3.entity.*;
import org.example.exo3.entity.jointure.CommentaireRecette;
import org.example.exo3.entity.jointure.EtapeRecette;
import org.example.exo3.entity.jointure.IngredientRecette;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {

//        Ingredient :


        IngredientDAO ingredientDAO = new IngredientDAO();
        Ingredient ingredient = Ingredient.builder()
                .nom("Ananas")
                .build();

        ingredientDAO.save(ingredient);

//        Etape :

        EtapeDAO etapeDAO = new EtapeDAO();
        Etape etape = Etape.builder()
                .description("Cuir")
                .build();

        etapeDAO.save(etape);

//        Categorie :

        CategorieDAO categorieDAO = new CategorieDAO();
        Categorie categorie = Categorie.builder()
                .nom("Gateau")
                .build();

        categorieDAO.save(categorie);

//        Commentaire :

        CommentaireDAO commentaireDAO = new CommentaireDAO();
        Commentaire commentaire = Commentaire.builder()
                .description("gros com")
                .build();

        commentaireDAO.save(commentaire);

//        Recette :

        RecetteDAO recetteDAO = new RecetteDAO();
        Recette recette = Recette.builder()
                .nom("Pizza aux pommes")
                .tempsPrep(30)
                .tempsCuisson(120)
                .difficulte("Imposssible")
                .categorie(categorieDAO.get(5))
                .build();

        recetteDAO.save(recette);

//        Jointure Commentaire - Recette

        CommentaireRecetteDAO commentaireRecetteDAO = new CommentaireRecetteDAO();
        CommentaireRecette commentaireRecette = CommentaireRecette.builder()
                .commentaire_id(1)
                .recette_id(1)
                .build();

        commentaireRecetteDAO.save(commentaireRecette);


//        Jointure Etape - Recette

        EtapeRecetteDAO etapeRecetteDAO = new EtapeRecetteDAO();
        EtapeRecette etapeRecette = EtapeRecette.builder()
                .etape_id(1)
                .recette_id(1)
                .build();

        etapeRecetteDAO.save(etapeRecette);

//        Jointure Ingredit - Recette

        IngredientRecetteDAO ingredientRecetteDAO = new IngredientRecetteDAO();
        IngredientRecette ingredientRecette = IngredientRecette.builder()
                .ingredient_id(1)
                .recette_id(1)
                .build();

        ingredientRecetteDAO.save(ingredientRecette);

        System.out.println(recetteDAO.get(1));


//        test delete

        ingredientDAO.delete(1);

        System.out.println(recetteDAO.get(1));

        recetteDAO.delete(1);

        System.out.println(recetteDAO.get(1));

//        mettre a jour

        Categorie categorie2 = Categorie.builder()
                .id(2)
                .nom("Gato")
                .build();

        categorieDAO.update(categorie2);

        Commentaire commentaire2 = Commentaire.builder()
                .id(2)
                .description("Coucou")
                .build();

        commentaireDAO.update(commentaire2);

    }


}
