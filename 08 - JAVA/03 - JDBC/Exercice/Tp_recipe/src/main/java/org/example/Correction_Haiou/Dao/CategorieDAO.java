package ExercicesJDBC.Recette.Dao;

/*
DAO (Data Access Object) : un pattern utilisé pour encapsuler l'accès aux données comme les opérations CRUD (Create, Read, Update, Delete).
*/

import ExercicesJDBC.Recette.Entity.Categorie;
import ExercicesJDBC.Recette.Util.DatabaseManager;

//import java.sql.Connection;
//import java.sql.ResultSet;
//import java.sql.SQLException;
import java.sql.*;

public class CategorieDAO {

    // ----- Propriétés -----

    private Connection connection;
    private Statement statement;
    private PreparedStatement preparedStatement;
    private String request;
    private ResultSet resultSet;

    // ----- Constructeur : -----

    public CategorieDAO() {
        this.connection = DatabaseManager.getConnection();
    }

    // ----- Méthodes : -----

    /**
     * Obtenir une catégorie
     */
    public Categorie getById(int id) {
        String sql = "SELECT * FROM categorie WHERE id = ?";

        try {
            preparedStatement = connection.prepareStatement(sql); // Préparation de la requête SQL pour éviter injection malveillante
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery(); // Exécution de la requête et récupération du résultat

            if (resultSet.next()) {
                // Avec le pattern builder, le getter/setter est automatique :
                return Categorie.builder() // Utilisation du pattern builder pour créer une instance de Ingredient
                        .id(resultSet.getInt("id"))
                        .nom(resultSet.getString("nom"))
                        .build(); // Retourne l'objet Categorie créé
            }
            return null;
        }
        catch (SQLException ex) {
            System.out.println(ex.getMessage()); // Affiche message d'erreur en cas de problème avec la requête SQL
            return null; // Retourne null si aucun ingrédient trouvé ou en cas d'erreur
        }
    }


    /**
     * Ajouter une catégorie
     */
    public Categorie addCategorie(Categorie categorie) throws SQLException {
        String sql = "INSERT INTO categorie (nom) VALUES (?)";

        try {
            preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, categorie.getNom());

            int nbRow = preparedStatement.executeUpdate();
            if (nbRow != 1) {
                connection.rollback();
                return null;
            }

            ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
            if (generatedKeys.next()) {
                categorie.setId(generatedKeys.getInt(1));
            }
            connection.commit(); // On commit manuellement la transaction, car on a mis connection.setAutoCommit(false) dans DatabaseManager
            return categorie; // Retourne l'objet Categorie créé
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
            connection.rollback(); // Annule la transaction en cas d'erreur
            return null;
        }
    }


    /**
     * Modifier une catégorie
     */
    public Categorie update(Categorie categorie) throws SQLException {
        String sql = "UPDATE categorie SET nom = ? WHERE id = ?";

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, categorie.getNom());
            preparedStatement.setInt(2, categorie.getId());

            int nbRow = preparedStatement.executeUpdate();
            if (nbRow > 0) {
                connection.commit(); // On commit manuellement la transaction, car on a mis connection.setAutoCommit(false) dans DatabaseManager
                return categorie; // Retourner l'objet modifié
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
     * Supprimer une catégorie
     */
    public boolean delete(int id) throws SQLException {
        String sql = "DELETE FROM categorie WHERE id = ?";

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
