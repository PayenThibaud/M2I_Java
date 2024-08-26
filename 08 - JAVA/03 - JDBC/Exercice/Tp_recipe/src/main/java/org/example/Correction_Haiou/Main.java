package ExercicesJDBC.Recette;

/* Exercice Java JDBC : Gestion de recette
- Notre application gérera des recettes qui contiendront des ingrédients, des étapes, des commentaires et qui seront associés à une catégorie. Tous ces éléments seront stockés en BDD grâce à JDBC.
- On pourra créer, modifier et supprimer les recettes, les ingrédients, les étapes et les commentaires.
- On aura une gestion des ingrédients pour chaque recette permettant de les ajouter et de les supprimer d'une recette.

ingredient :
    - nom

etape :
    - description

categorie :
    - nom

commentaire :
    - description

recette :
    - nom
    - tempsPrep
    - tempsCuisson
    - difficulte

    - ingredients

    - etapes
    - commentaires
    - categorie

On utilise la relation many-to-many entre les tables recette et ingredient.

- Bonus : Vous ajouterez un affichage des éléments sélectionnés durant leurs ajouts, ainsi qu'une confirmation de l'ajout.
*/


import ExercicesJDBC.Recette.Entity.Ingredient; // L'importation explicite de Ingredient est nécessaire dans Main si on interagit directement avec cette classe (par exemple, en instanciant des objets Ingredient ou en les passant comme paramètres)
import ExercicesJDBC.Recette.Entity.Categorie;
import ExercicesJDBC.Recette.Entity.Commentaire;
import ExercicesJDBC.Recette.Entity.Etape;
import ExercicesJDBC.Recette.Entity.Recette;
import ExercicesJDBC.Recette.Dao.IngredientDAO;
import ExercicesJDBC.Recette.Dao.CategorieDAO;
import ExercicesJDBC.Recette.Dao.CommentaireDAO;
import ExercicesJDBC.Recette.Dao.EtapeDAO;
import ExercicesJDBC.Recette.Dao.RecetteDAO;

/*
Entity : Contient les propriétés. Et éventuellement des méthodes de base liées à l'objet (ex : validation, conversion).

DAO : Contient les méthodes pour interagir avec BDD (ex : CRUD).
*/

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;


public class Main {

    public static void main(String[] args) throws SQLException {

        // Propriétés :
        int id;
        int recetteId;
        int ingredientId;
        int commentaireId;

        Ingredient ingredient_db;
        Categorie cat_db;
        Commentaire commentaire_db;
        Etape etape_db;
        Recette recette_db;

        CategorieDAO categorieDAO = new CategorieDAO();
        CommentaireDAO commentaireDAO = new CommentaireDAO();
        EtapeDAO etapeDAO = new EtapeDAO();
        IngredientDAO ingredientDAO = new IngredientDAO();
        RecetteDAO recetteDAO = new RecetteDAO();


        // ==================== Ingredient ====================

        // ----- SELECT Ingredient (Test ok) -----

        id = 1;  // Exemple d'ID d'ingrédient à récupérer
        ingredient_db = ingredientDAO.getById(id);

        if (ingredient_db != null) {
            System.out.println("Ingrédient récupéré : " + ingredient_db);
        }
        else {
            System.out.println("Aucun ingrédient trouvé avec ID : " + id);
        }

        // ----- CREATE Ingredient (Test ok) -----

        try {
            ingredient_db = Ingredient.builder()
                .nom("Ingredient XX")
                .build();

            ingredient_db = ingredientDAO.addIngredient(ingredient_db);
            System.out.println("Ingrédient ajouté : " + ingredient_db);
        }
        catch (SQLException e) {
            e.printStackTrace();
        }

        // ----- UPDATE Ingredient (Test ok) -----

        id = 10;  // ID d'ingrédient à modifier
        Ingredient existingIngredient = ingredientDAO.getById(id);

        if (existingIngredient != null) {
            existingIngredient.setNom("Ingrédient modifié");

            Ingredient updatedIngredient = ingredientDAO.update(existingIngredient);
            if (updatedIngredient != null) {
                System.out.println("Ingrédient mis à jour : " + updatedIngredient);
            }
            else {
                System.out.println("Erreur edit");
            }
        }
        else {
            System.out.println("Aucun ingrédient trouvé avec ID : " + id);
        }

        // ----- DELETE Ingredient (Test ok) -----

        id = 10;  // ID d'ingrédient à supprimer
        boolean deleted = ingredientDAO.delete(id);

        if (deleted) {
            System.out.println("Ingrédient supprimé avec succès.");
        }
        else {
            System.out.println("Erreur suppression ou cet id n'existe pas : " + id);
        }


        // ==================== Catégorie ====================

        // ----- SELECT Catégorie (Test ok) -----

        id = 1;  // Exemple d'ID de catégorie à récupérer
        cat_db = categorieDAO.getById(id);

        if (cat_db != null) {
            System.out.println("Catégorie récupérée : " + cat_db);
        }
        else {
            System.out.println("Aucune catégorie trouvée avec ID : " + id);
        }

        // ----- CREATE Catégorie (Test ok) -----

        try {
            cat_db = Categorie.builder()
                .nom("XZZ")
                .build();

            cat_db = categorieDAO.addCategorie(cat_db);
            System.out.println("Catégorie ajoutée : " + cat_db);
        }
        catch (SQLException e) {
            e.printStackTrace();
        }

        // ----- UPDATE Catégorie (Test ok) -----

        id = 4;  // ID de catégorie à modifier
        Categorie existingCategorie = categorieDAO.getById(id);

        if (existingCategorie != null) {
            existingCategorie.setNom("Catégorie modifiée");

            Categorie updatedCategorie = categorieDAO.update(existingCategorie);
            if (updatedCategorie != null) {
                System.out.println("Catégorie mis à jour : " + updatedCategorie);
            }
            else {
                System.out.println("Erreur edit");
            }
        }
        else {
            System.out.println("Aucune catégorie avec ID : " + id);
        }


        // ----- DELETE Catégorie (Test ok) -----

        id = 4;  // ID de catégorie à supprimer
        boolean deleted2 = categorieDAO.delete(id);

        if (deleted2) {
            System.out.println("Catégorie supprimée avec succès.");
        }
        else {
            System.out.println("Erreur suppression ou cet id n'existe pas : " + id);
        }


        // ==================== Commentaire ====================

        // ----- SELECT Commentaire (Test ok) -----

        id = 1;  // Exemple d'ID de commentaire à récupérer
        commentaire_db = commentaireDAO.getById(id);

        if (commentaire_db != null) {
            System.out.println("Commentaire récupéré : " + commentaire_db);
        }
        else {
            System.out.println("Aucun commentaire trouvé avec ID : " + id);
        }

        // ----- CREATE Commentaire (Test ok) -----

        id = 1;  // Exemple d'ID de recette où créer le commentaire

        try {
            commentaire_db = Commentaire.builder()
                    .description("C'est pas bon !")
                    .recetteId(id)
                    .build();

            commentaire_db = commentaireDAO.addCommentaire(commentaire_db);
            System.out.println("Commentaire ajouté : " + commentaire_db);
        }
        catch (SQLException e) {
            e.printStackTrace();
        }

        // ----- UPDATE Commentaire (Test ok) -----

        id = 2;  // ID de commentaire à modifier
        Commentaire existingCommentaire = commentaireDAO.getById(id);

        if (existingCommentaire != null) {
            existingCommentaire.setDescription("Vraiment pas bon !");

            Commentaire updatedCommentaire = commentaireDAO.update(existingCommentaire);
            if (updatedCommentaire != null) {
                System.out.println("Commentaire modifié : " + updatedCommentaire);
            }
            else {
                System.out.println("Erreur de modification");
            }
        }
        else {
            System.out.println("Aucun commentaire avec ID : " + id);
        }

        // ----- DELETE Commentaire (Test ok) -----

        id = 3;  // ID de commentaire à supprimer
        boolean deleted3 = commentaireDAO.delete(id);

        if (deleted3) {
            System.out.println("Commentaire supprimé.");
        }
        else {
            System.out.println("Erreur de suppression ou cet ID n'existe pas : " + id);
        }


        // ==================== Etape ====================

        // ----- SELECT Etape (Test ok) -----

        id = 1;  // Exemple d'ID d'étape à récupérer
        etape_db = etapeDAO.getById(id);

        if (etape_db != null) {
            System.out.println("Étape récupérée : " + etape_db);
        }
        else {
            System.out.println("Aucune étape trouvée avec ID : " + id);
        }

        // ----- CREATE Etape (Test ok) -----

        id = 1;  // Exemple ID de recette où créer l'étape

        try {
            etape_db = Etape.builder()
                    .description("Mettre au four.")
                    .recetteId(id) // Exemple d'ID de recette
                    .build();

            etape_db = etapeDAO.addEtape(etape_db);
            System.out.println("Étape ajoutée : " + etape_db);
        }
        catch (SQLException e) {
            e.printStackTrace();
        }

        // ----- UPDATE Etape (Test ok) -----

        id = 4;  // ID d'étape à modifier
        Etape existingEtape = etapeDAO.getById(id);

        if (existingEtape != null) {
            existingEtape.setDescription("Enfourner pendant 45 min.");
//            existingEtape.setRecetteId(1); // Modification de l'ID de recette, si nécessaire

            Etape updatedEtape = etapeDAO.update(existingEtape);
            if (updatedEtape != null) {
                System.out.println("Étape mise à jour : " + updatedEtape);
            }
            else {
                System.out.println("Erreur edit");
            }
        }
        else {
            System.out.println("Aucune étape avec ID : " + id);
        }

        // ----- DELETE Etape (Test ok) -----

        id = 4;  // ID d'étape à supprimer
        boolean deleted4 = etapeDAO.delete(id);

        if (deleted4) {
            System.out.println("Étape supprimée.");
        }
        else {
            System.out.println("Erreur suppression ou cet id n'existe pas : " + id);
        }


        // ==================== Recette ====================

        // ----- Afficher toutes les Recettes (Test ok) -----

        List<Recette> recettes = recetteDAO.getAll(); // Récupère toutes les données de recette depuis la BDD et stocke dans une liste

        System.out.println("----- Toutes les recettes : -----");
        for (Recette recette : recettes) { // Boucle for-each pour afficher toutes les recettes depuis la liste
            System.out.println(recette);
        }
        System.out.println("----- -----");


        // ----- SELECT Recette (Test ok) -----

        id = 1;  // Exemple d'ID de recette à récupérer
        recette_db = recetteDAO.getById(id);

        if (recette_db != null) {
            System.out.println("Recette récupérée : " + recette_db);
        }
        else {
            System.out.println("Aucune recette avec ID : " + id);
        }

        // ----- CREATE Recette (Test ok) -----

        try {
            int id_cat = 1;  // Exemple d'ID de catégorie
            int temps = 15; // Exemple de temps de préparation en min
            int temps2 = 45; // Exemple de temps de cuisson en min
            recette_db = Recette.builder()
                    .nom("Omelette de dinosaure")
                    .tempsPrep(temps)
                    .tempsCuisson(temps2)
                    .difficulte("Difficile")
                    .categorieId(id_cat) // Utilisation de l'ID de la catégorie
                    .build();

            recette_db = recetteDAO.addRecette(recette_db);
            System.out.println("Recette ajoutée : " + recette_db);

        }
        catch (SQLException e) {
            e.printStackTrace();
        }

        // ----- UPDATE Recette (Test ok) -----

        id = 2;  // ID de recette à modifier
        Recette existingRecette = recetteDAO.getById(id);

        if (existingRecette != null) {
            existingRecette.setNom("Nom recette modifié");

            Recette updatedRecette = recetteDAO.update(existingRecette);
            if (updatedRecette != null) {
                System.out.println("Recette modifiée : " + updatedRecette);
            }
            else {
                System.out.println("Erreur edit");
            }
        }
        else {
            System.out.println("Aucune recette avec ID : " + id);
        }

        // ----- DELETE Recette (Test ok) -----

        id = 2;  // ID de recette à supprimer
        boolean deleted5 = recetteDAO.delete(id);

        if (deleted5) {
            System.out.println("Recette supprimée.");
        }
        else {
            System.out.println("Erreur suppression ou cet ID n'existe pas : " + id);
        }


        // ==================== Gestion des ingrédients pour Recettes ====================

        // ----- Afficher les ingrédients d'une recette (Test ok) -----

        recetteId = 1; // ID de recette où on veut afficher la liste d'ingrédients

        try {
            List<Ingredient> ingredients = recetteDAO.getIngredientsByRecetteId(recetteId); // Récupère toutes les données d'ingrédients depuis la BDD et stocke dans une liste

            System.out.println("----- Ingrédients de la recette " + recetteId + ": -----");
            for (Ingredient ingredient : ingredients) { // Boucle for-each pour afficher tous les ingrédients dans la liste
                System.out.println(ingredient);
            }
            System.out.println("----- -----");
        }
        catch (SQLException e) {
            e.printStackTrace();
        }


        // ----- Ajouter un ingrédient à une recette (Test ok) -----

        recetteId = 1; // ID de recette où on veut ajouter l'ingrédient
        ingredientId = 2; // ID d'ingrédient à ajouter à dans la recette

        try {
            boolean added = recetteDAO.addIngredientToRecette(recetteId, ingredientId);
            if (added) {
                System.out.println("Ingrédient ajouté à la recette.");
            }
            else {
                System.out.println("Erreur d'ajout d'ingrédient.");
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }

        // ----- Supprimer un ingrédient d'une recette (Test ok) -----

        try {
            boolean removed = recetteDAO.deleteIngredientFromRecette(recetteId, ingredientId);
            if (removed) {
                System.out.println("Ingrédient supprimé de la recette.");
            }
            else {
                System.out.println("Erreur suppression de l'ingrédient ou aucun ingrédient avec cet ID.");
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }


        // ==================== Gestion des étapes pour Recettes ====================

        // ----- Afficher les étapes d'une recette (Test ok) -----

        List<Etape> etapes = recetteDAO.getEtapesForRecette(recetteId); // Récupère toutes les données des étapes depuis la BDD et stocke dans une liste

        System.out.println("----- Etapes de la recette " + recetteId + ": -----");
        for (Etape etape : etapes) { // Boucle for-each pour afficher toutes les étapes dans la liste
            System.out.println(etape);
        }
        System.out.println("----- -----");


        try {

            // ----- Ajouter une étape à une recette (Test ok) -----

            recetteId = 1; // ID de la recette
            String description = "Ajouter des haricots magiques.";

            if (recetteDAO.addEtapeToRecette(recetteId, description)) { // Appel à la fonction addEtapeToRecette()
                System.out.println("Étape ajoutée à la recette.");
            }
            else {
                System.out.println("Erreur d'ajout d'étape.");
            }


            // ----- Supprimer une étape à une recette (Test ok) -----

            int etapeId = 3; // ID de l'étape à supprimer

            if (recetteDAO.deleteEtapeFromRecette(etapeId)) { // Appel à la fonction deleteEtapeFromRecette()
                System.out.println("Étape supprimée de la recette.");
            }
            else {
                System.out.println("Erreur suppression d'étape ou aucune étape avec cet ID.");
            }


        }
        catch (SQLException e) {
            e.printStackTrace();
        }


        // ==================== Gestion des commentaires des Recettes ====================

        // ----- Afficher tous les commentaires d'une recette -----

        recetteId = 1; // ID de la recette où on veut afficher les commentaires

        List<Commentaire> commentaires = recetteDAO.getCommentairesForRecette(recetteId); // Récupère toutes les données des commentaires depuis la BDD et stocke dans une liste

        System.out.println("----- Commentaires pour la recette " + recetteId + " : ----- ");
        for (Commentaire commentaire : commentaires) {
            System.out.println(commentaire.getDescription());
        }
        System.out.println("----- -----");


        // ----- Ajouter un commentaire à une recette -----

        recetteId = 1; // ID de la recette où on veut ajouter un commentaire
        String description = "C'est dégueu !";

        if (recetteDAO.addCommentaireToRecette(recetteId, description)) {
            System.out.println("Commentaire ajouté !");
        }
        else {
            System.out.println("Erreur ajout du commentaire.");
        }

        // ----- Supprimer un commentaire d'une recette -----

        commentaireId = 5; // ID du commentaire à supprimer

        if (recetteDAO.deleteCommentaireFromRecette(commentaireId)) {
            System.out.println("Commentaire supprimé !");
        }
        else {
            System.out.println("Erreur suppression du commentaire ou aucun ID avec ce commentaire.");
        }

    }

}
