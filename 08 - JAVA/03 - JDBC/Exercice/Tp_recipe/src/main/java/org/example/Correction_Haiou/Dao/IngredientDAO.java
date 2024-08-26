package ExercicesJDBC.Recette.Dao;

/*
DAO (Data Access Object) : un pattern utilisé pour encapsuler l'accès aux données comme les opérations CRUD (Create, Read, Update, Delete).
*/

import ExercicesJDBC.Recette.Entity.Ingredient;
import ExercicesJDBC.Recette.Util.DatabaseManager;

//import java.sql.Connection;
//import java.sql.ResultSet;
//import java.sql.SQLException;
import java.sql.*;

public class IngredientDAO {

    // ----- Propriétés -----

    private Connection connection;
    private Statement statement;
    private PreparedStatement preparedStatement;
    private String request;
    private ResultSet resultSet;

    // ----- Constructeur : -----

    public IngredientDAO() {
        this.connection = DatabaseManager.getConnection();
    }

    // ----- Méthodes : -----

    /**
     * Obtenir un ingrédient par ID
     * @return Ingredient : Retourne un objet Ingredient
     */
    public Ingredient getById(int id) {
        String sql = "SELECT * FROM ingredient WHERE id = ?";

        try {
            preparedStatement = connection.prepareStatement(sql); // Préparation de la requête SQL pour éviter injection malveillante
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery(); // Exécution de la requête et récupération du résultat

            if (resultSet.next()) {
                // Avec le pattern builder, le getter/setter est automatique :
                return Ingredient.builder() // Utilisation du pattern builder pour créer une instance de Ingredient
                        .id(resultSet.getInt("id"))
                        .nom(resultSet.getString("nom"))
                        .build(); // Retourne l'objet Ingredient créé
            }
        }
        catch (SQLException e) {
            System.out.println(e.getMessage()); // Affiche message d'erreur en cas de problème avec la requête SQL
        }
        return null; // Retourne null si aucun ingrédient trouvé ou en cas d'erreur
    }


    /**
     * Ajouter un ingrédient
     * @return Ingredient
     */
    public Ingredient addIngredient(Ingredient ingredient) throws SQLException {
        String sql = "INSERT INTO ingredient (nom) VALUES (?)";

        try {
            preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, ingredient.getNom());

            int nbRow = preparedStatement.executeUpdate();
            if (nbRow != 1) {
                connection.rollback();
                return null;
            }

            ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
            if (generatedKeys.next()) {
                ingredient.setId(generatedKeys.getInt(1));
            }
            connection.commit(); // On commit manuellement la transaction, car on a mis connection.setAutoCommit(false) dans DatabaseManager
            return ingredient; // Retourne l'objet Ingredient créé
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
            connection.rollback(); // Annule la transaction en cas d'erreur
            return null;
        }
    }


    /**
     * Modifier un ingrédient
     * @return Ingredient
     */
    public Ingredient update(Ingredient ingredient) throws SQLException {
        String sql = "UPDATE ingredient SET nom = ? WHERE id = ?";

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, ingredient.getNom());
            preparedStatement.setInt(2, ingredient.getId());

            int nbRow = preparedStatement.executeUpdate();
            if (nbRow > 0) {
                connection.commit(); // On commit manuellement la transaction, car on a mis connection.setAutoCommit(false) dans DatabaseManager
                return ingredient; // Retourner l'objet modifié
            }
            else {
                connection.rollback();
                return null; // Aucun enregistrement modifié
            }
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
            connection.rollback(); // Annule la transaction en cas d'erreur
        }
        return null;
    }


    /**
     * Supprimer un ingrédient
     * @return boolean
     */
    public boolean delete(int id) throws SQLException {
        String sql = "DELETE FROM ingredient WHERE id = ?";

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);

            int nbRows = preparedStatement.executeUpdate();
            if (nbRows > 0) {
                connection.commit(); // On commit manuellement la transaction, car on a mis connection.setAutoCommit(false) dans DatabaseManager
                return true;
            }
            else {
                connection.rollback(); // Annule la transaction si aucune ligne n'a été supprimée
                return false;
            }
        }
        catch (SQLException e) {
            connection.rollback(); // Annule la transaction en cas d'erreur
            throw e;
        }
    }


}
