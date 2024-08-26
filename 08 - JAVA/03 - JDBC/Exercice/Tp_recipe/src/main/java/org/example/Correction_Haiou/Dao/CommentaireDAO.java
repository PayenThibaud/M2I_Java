package ExercicesJDBC.Recette.Dao;

/*
DAO (Data Access Object) : un pattern utilisé pour encapsuler l'accès aux données comme les opérations CRUD (Create, Read, Update, Delete).
*/

import ExercicesJDBC.Recette.Entity.Commentaire;
import ExercicesJDBC.Recette.Util.DatabaseManager;
import java.sql.*;


public class CommentaireDAO {

    // ----- Propriétés -----

    private Connection connection;
    private PreparedStatement preparedStatement;

    // ----- Constructeur -----

    public CommentaireDAO() {
        this.connection = DatabaseManager.getConnection();
    }

    // ----- Méthodes -----

    /**
     * Obtenir un commentaire par ID
     * @return Commentaire : Retourne un objet Commentaire
     */
    public Commentaire getById(int id) {
        String sql = "SELECT * FROM commentaire WHERE id = ?";

        try {
            preparedStatement = connection.prepareStatement(sql); // Préparation de la requête SQL pour éviter injection malveillante
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery(); // Exécution de la requête et récupération du résultat

            if (resultSet.next()) {
                // Avec le pattern builder, le getter/setter est automatique :
                return Commentaire.builder() // Utilisation du pattern builder pour créer une instance de Ingredient
                        .id(resultSet.getInt("id"))
                        .description(resultSet.getString("description"))
                        .recetteId(resultSet.getInt("recette_id"))
                        .build(); // Retourne l'objet Ingredient créé
            }
        }
        catch (SQLException e) {
            System.out.println(e.getMessage()); // Affiche message d'erreur en cas de problème avec la requête SQL
        }
        return null; // Retourne null si aucun commentaire trouvé ou en cas d'erreur
    }


    /**
     * Ajouter un commentaire
     * @return Commentaire
     */
    public Commentaire addCommentaire(Commentaire commentaire) throws SQLException {
        String sql = "INSERT INTO commentaire (description, recette_id) VALUES (?, ?)";

        try {
            preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, commentaire.getDescription());
            preparedStatement.setInt(2, commentaire.getRecetteId());

            int nbRow = preparedStatement.executeUpdate();
            if (nbRow != 1) {
                connection.rollback();
                return null;
            }

            ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
            if (generatedKeys.next()) {
                commentaire.setId(generatedKeys.getInt(1));
            }
            connection.commit(); // On commit manuellement la transaction, car on a mis connection.setAutoCommit(false) dans DatabaseManager
            return commentaire; // Retourne l'objet Ingredient créé
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
            connection.rollback(); // Annule la transaction en cas d'erreur
            return null;
        }
    }

    /**
     * Modifier un commentaire
     * @return Commentaire
     */
    public Commentaire update(Commentaire commentaire) throws SQLException {
        String sql = "UPDATE commentaire SET description = ?, recette_id = ? WHERE id = ?";

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, commentaire.getDescription());
            preparedStatement.setInt(2, commentaire.getRecetteId());
            preparedStatement.setInt(3, commentaire.getId());

            int nbRow = preparedStatement.executeUpdate();
            if (nbRow > 0) {
                connection.commit(); // On commit manuellement la transaction, car on a mis connection.setAutoCommit(false) dans DatabaseManager
                return commentaire;
            }
            else {
                connection.rollback(); // Annule la transaction si aucune ligne n'a été ajoutée
                return null;
            }
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
            connection.rollback(); // Annule la transaction en cas d'erreur
        }
        return null;
    }


    /**
     * Supprimer un commentaire
     * @return boolean
     */
    public boolean delete(int id) throws SQLException {
        String sql = "DELETE FROM commentaire WHERE id = ?";

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
