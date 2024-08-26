package ExercicesJDBC.Recette.Dao;

/*
DAO (Data Access Object) : un pattern utilisé pour encapsuler l'accès aux données comme les opérations CRUD (Create, Read, Update, Delete).
*/

import ExercicesJDBC.Recette.Entity.Recette;
import ExercicesJDBC.Recette.Entity.Ingredient; // Besoin de gérer les ingrédients dans les recettes
import ExercicesJDBC.Recette.Entity.Etape; // Besoin de gérer les étapes dans les recettes
import ExercicesJDBC.Recette.Entity.Commentaire; // Besoin de gérer les commentaires sur les recettes
import ExercicesJDBC.Recette.Util.DatabaseManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class RecetteDAO {

    // ----- Propriétés -----

    private Connection connection;
    private PreparedStatement preparedStatement;

    // ----- Constructeur -----

    public RecetteDAO() {
        this.connection = DatabaseManager.getConnection();
    }

    // ----- Méthodes -----

    /**
     * Obtenir une recette par ID
     * @return Recette : Retourne un objet Recette
     */
    public Recette getById(int id) {
        String sql = "SELECT * FROM recette WHERE id = ?";
        try {
            preparedStatement = connection.prepareStatement(sql); // Préparation de la requête SQL pour éviter injection malveillante
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery(); // Exécution de la requête et récupération du résultat

            if (resultSet.next()) {
                // Avec le pattern builder, le getter/setter est automatique :
                Recette recette = Recette.builder() // Utilisation du pattern builder pour créer une instance de Recette
                        .id(resultSet.getInt("id"))
                        .nom(resultSet.getString("nom"))
                        .tempsPrep(resultSet.getInt("temps_prep"))
                        .tempsCuisson(resultSet.getInt("temps_cuisson"))
                        .difficulte(resultSet.getString("difficulte"))
                        .categorieId(resultSet.getInt("categorie_id"))
                        .build();

                return recette; // Retourne l'objet Recette construit
            }
        }
        catch (SQLException e) {
            System.out.println(e.getMessage()); // Affiche message d'erreur en cas de problème avec la requête SQL
        }
        return null; // Retourne null si aucune recette trouvée ou en cas d'erreur
    }


    /**
     * Ajouter une recette
     * @return Recette
     */
    public Recette addRecette(Recette recette) throws SQLException {
        String sql = "INSERT INTO recette (nom, temps_prep, temps_cuisson, difficulte, categorie_id) VALUES (?, ?, ?, ?, ?)";

        try {
            preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, recette.getNom());
            preparedStatement.setInt(2, recette.getTempsPrep());
            preparedStatement.setInt(3, recette.getTempsCuisson());
            preparedStatement.setString(4, recette.getDifficulte());
            preparedStatement.setInt(5, recette.getCategorieId());

            int nbRow = preparedStatement.executeUpdate();
            if (nbRow != 1) {
                connection.rollback();
                return null;
            }

            ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
            if (generatedKeys.next()) {
                recette.setId(generatedKeys.getInt(1));
            }
            connection.commit(); // On commit manuellement la transaction, car on a mis connection.setAutoCommit(false) dans DatabaseManager
            return recette;
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
            connection.rollback(); // Annule transaction si erreur
            return null;
        }
    }


    /**
     * Modifier une recette
     * @return Recette
     */
    public Recette update(Recette recette) throws SQLException {
        String sql = "UPDATE recette SET nom = ?, temps_prep = ?, temps_cuisson = ?, difficulte = ?, categorie_id = ? WHERE id = ?";

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, recette.getNom());
            preparedStatement.setInt(2, recette.getTempsPrep());
            preparedStatement.setInt(3, recette.getTempsCuisson());
            preparedStatement.setString(4, recette.getDifficulte());
            preparedStatement.setInt(5, recette.getCategorieId());
            preparedStatement.setInt(6, recette.getId());

            int nbRow = preparedStatement.executeUpdate();
            if (nbRow > 0) {
                connection.commit();
                return recette;
            }
            else {
                connection.rollback();
                return null;
            }
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
            connection.rollback();
        }
        return null;
    }


    /**
     * Supprimer une recette
     * @return boolean
     */
    public boolean delete(int id) throws SQLException {
        String sql = "DELETE FROM recette WHERE id = ?";

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);

            int nbRows = preparedStatement.executeUpdate();
            if (nbRows > 0) {
                connection.commit();
                return true;
            } else {
                connection.rollback();
                return false;
            }
        }
        catch (SQLException e) {
            connection.rollback();
            throw e;
        }
    }


    /**
     * Obtenir toutes les recettes
     * @return List
     */
    public List<Recette> getAll() {
        String sql = "SELECT * FROM recette";
        List<Recette> recettes = new ArrayList<>();

        try (Statement statement = connection.createStatement(); // Ici, pas besoin de prepare, car il n'y a pas de paramètres dynamiques à injecter dans la requête, donc pas de risque d'injection SQL

        ResultSet resultSet = statement.executeQuery(sql)) { // Exécution de la requête SQL

            // Boucle sur chaque ligne du résultat pour construire les objets Recette :
            while (resultSet.next()) {
                Recette recette = Recette.builder()
                        .id(resultSet.getInt("id"))
                        .nom(resultSet.getString("nom"))
                        .tempsPrep(resultSet.getInt("temps_prep"))
                        .tempsCuisson(resultSet.getInt("temps_cuisson"))
                        .difficulte(resultSet.getString("difficulte"))
                        .categorieId(resultSet.getInt("categorie_id")) // Utilisation de l'ID de la catégorie
                        .build();

                recettes.add(recette); // Ajout de la recette à la liste
            }
        }
        catch (SQLException e) {
            System.out.println(e.getMessage()); // Affiche message d'erreur en cas de problème avec la requête SQL
            e.printStackTrace(); // Pour débogage détaillé
        }

        return recettes; // Retourne la liste de toutes les recettes récupérées
    }


    // ----- Gérer les ingrédients d'une recette -----

    /**
     * Obtenir tous les ingrédients d'une recette
     * @return List<Ingredient> : Retourne une liste d'ingrédients (par ID de recette)
     */
    public List<Ingredient> getIngredientsByRecetteId(int recetteId) throws SQLException {

        String sql = "SELECT ingredient.* " +
                "FROM ingredient " +
                "JOIN recette_ingredient ON ingredient.id = recette_ingredient.ingredient_id " +
                "WHERE recette_ingredient.recette_id = ?"; // Sans alias

//        String sql = "SELECT i.* FROM ingredient i JOIN recette_ingredient ri ON i.id = ri.ingredient_id WHERE ri.recette_id = ?"; // Avec alias

        List<Ingredient> ingredients = new ArrayList<>(); // Création d'une liste pour stocker les ingrédients récupérés

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, recetteId);

            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                // Création d'un objet Ingredient en utilisant le pattern builder :
                Ingredient ingredient = Ingredient.builder()
                        .id(resultSet.getInt("id"))
                        .nom(resultSet.getString("nom"))
                        .build(); // Construction de l'objet Ingredient

                ingredients.add(ingredient); // Ajout de l'ingrédient dabs la liste Ingredient
            }
        }

        return ingredients; // Retourne la liste des ingrédients récupérés
    }


    /**
     * Ajouter un ingrédient à une recette
     */
    public boolean addIngredientToRecette(int recetteId, int ingredientId) throws SQLException {
        String sql = "INSERT INTO recette_ingredient (recette_id, ingredient_id) VALUES (?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, recetteId);
            statement.setInt(2, ingredientId);

            int nbRows = statement.executeUpdate();
            if (nbRows > 0) {
                connection.commit(); // On commit manuellement la transaction, car on a mis connection.setAutoCommit(false) dans DatabaseManager
                return true;
            }
            else {
                connection.rollback(); // Annule la transaction si aucune ligne insérée
                return false;
            }
        }
        catch (SQLException e) {
            connection.rollback(); // Annule la transaction en cas d'erreur
            throw e;
        }
    }


    /**
     * Supprimer un ingrédient d'une recette
     */
    public boolean deleteIngredientFromRecette(int recetteId, int ingredientId) throws SQLException {
        String sql = "DELETE FROM recette_ingredient WHERE recette_id = ? AND ingredient_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, recetteId);
            statement.setInt(2, ingredientId);

            int nbRows = statement.executeUpdate();
            if (nbRows > 0) {
                connection.commit(); // On commit manuellement la transaction, car on a mis connection.setAutoCommit(false) dans DatabaseManager
                return true;
            }
            else {
                connection.rollback(); // Annule la transaction si aucune ligne supprimée
                return false;
            }
        }
        catch (SQLException e) {
            connection.rollback(); // Annule la transaction en cas d'erreur
            throw e;
        }
    }


    // ----- Gérer les étapes d'une recette -----

    /**
     * Obtenir toutes les étapes d'une recette
     * @return List<Etape> : Retourne une liste d'étapes (par ID de recette)
     */
    public List<Etape> getEtapesForRecette(int recetteId) throws SQLException {
        List<Etape> etapes = new ArrayList<>(); // Création d'une liste pour stocker les étapes récupérés.

        String sql = "SELECT * FROM etape WHERE recette_id = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) { // Préparation de la requête SQL pour éviter injection malveillante
            preparedStatement.setInt(1, recetteId);
            ResultSet resultSet = preparedStatement.executeQuery(); // Exécution de la requête SQL et récupération des résultats

            while (resultSet.next()) {
                // Création d'un objet Etape en utilisant le pattern builder :
                etapes.add(Etape.builder()
                        .id(resultSet.getInt("id"))
                        .description(resultSet.getString("description"))
                        .recetteId(resultSet.getInt("recette_id"))
                        .build()); // Construction de l'objet Etape
            }
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
            throw e;
        }
        return etapes; // Ajout de l'étape à la liste Etape
    }


    /**
     * Ajouter une étape à une recette
     */
    public boolean addEtapeToRecette(int recetteId, String description) throws SQLException {
        String sql = "INSERT INTO etape (description, recette_id) VALUES (?, ?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, description);
            preparedStatement.setInt(2, recetteId);

            int nbRows = preparedStatement.executeUpdate();
            if (nbRows > 0) {
                connection.commit(); // On commit manuellement la transaction, car on a mis connection.setAutoCommit(false) dans DatabaseManager
                return true;
            }
            else {
                connection.rollback(); // Annule la transaction si aucune ligne insérée
                return false;
            }
        }
        catch (SQLException e) {
            connection.rollback(); // Annule la transaction en cas d'erreur
            throw e;
        }
    }


    /**
     * Effacer une étape d'une recette
     */
    public boolean deleteEtapeFromRecette(int etapeId) throws SQLException {
        String sql = "DELETE FROM etape WHERE id = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, etapeId);

            int nbRows = preparedStatement.executeUpdate();
            if (nbRows > 0) {
                connection.commit(); // On commit manuellement la transaction, car on a mis connection.setAutoCommit(false) dans DatabaseManager
                return true;
            }
            else {
                connection.rollback(); // Annule la transaction si aucune ligne supprimée
                return false;
            }
        }
        catch (SQLException e) {
            connection.rollback(); // Annule la transaction en cas d'erreur
            throw e;
        }
    }


    // ----- Gérer les commentaires d'une recette -----

    /**
     * Obtenir tous les commentaires d'une recette
     * @return List<Commentaire> : Retourne une liste de commentaires (par ID de recette)
     */
    public List<Commentaire> getCommentairesForRecette(int recetteId) throws SQLException {
        List<Commentaire> commentaires = new ArrayList<>(); // Création d'une liste pour stocker les commentaires récupérés.

        String sql = "SELECT * FROM commentaire WHERE recette_id = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, recetteId);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                // Création d'un objet Commentaire en utilisant le pattern builder :
                Commentaire commentaire = Commentaire.builder()
                        .id(resultSet.getInt("id"))
                        .description(resultSet.getString("description"))
                        .recetteId(resultSet.getInt("recette_id"))
                        .build(); // Construction de l'objet Commentaire

                commentaires.add(commentaire); // Ajout du commentaire à la liste des commentaires
            }
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
            throw e;
        }
        return commentaires; // Retourne la liste des commentaires récupérés
    }


    /**
     * Ajouter un commentaire à une recette
     */
    public boolean addCommentaireToRecette(int recetteId, String description) throws SQLException {
        String sql = "INSERT INTO commentaire (description, recette_id) VALUES (?, ?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, description);
            preparedStatement.setInt(2, recetteId);

            int nbRows = preparedStatement.executeUpdate();
            if (nbRows > 0) {
                connection.commit(); // On commit manuellement la transaction, car on a mis connection.setAutoCommit(false) dans DatabaseManager
                return true;
            }
            else {
                connection.rollback(); // Annule transaction si aucune ligne supprimée en BDD
                return false;
            }
        }
        catch (SQLException e) {
            connection.rollback(); // Annule transaction si erreur
            throw e;
        }
    }


    /**
     * Supprimer un commentaire d'une recette
     */
    public boolean deleteCommentaireFromRecette(int commentaireId) throws SQLException {
        String sql = "DELETE FROM commentaire WHERE id = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, commentaireId);

            int nbRows = preparedStatement.executeUpdate();
            if (nbRows > 0) {
                connection.commit(); // On commit manuellement la transaction, car on a mis connection.setAutoCommit(false) dans DatabaseManager
                return true;
            }
            else {
                connection.rollback(); // Annule transaction si aucune ligne supprimée en BDD
                return false;
            }
        }
        catch (SQLException e) {
            connection.rollback(); // Annule transaction si erreur
            throw e;
        }
    }


}
