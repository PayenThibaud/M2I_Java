package ExercicesJDBC.Recette.Dao;

/*
DAO (Data Access Object) : un pattern utilisé pour encapsuler l'accès aux données comme les opérations CRUD (Create, Read, Update, Delete).
*/

import ExercicesJDBC.Recette.Entity.Etape;
import ExercicesJDBC.Recette.Util.DatabaseManager;

import java.sql.*;


public class EtapeDAO {

    // ----- Propriétés -----

    private Connection connection;
    private PreparedStatement preparedStatement;

    // ----- Constructeur -----

    public EtapeDAO() {
        this.connection = DatabaseManager.getConnection();
    }

    // ----- Méthodes -----

    /**
     * Obtenir une étape par ID
     * @return Etape : Retourne un objet Etape
     */
    public Etape getById(int id) {
        String sql = "SELECT * FROM etape WHERE id = ?";
        try {
            preparedStatement = connection.prepareStatement(sql); // Préparation de la requête SQL pour éviter injection malveillante
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery(); // Exécution de la requête et récupération du résultat

            if (resultSet.next()) {
                // Avec le pattern builder, le getter/setter est automatique :
                return Etape.builder() // Utilisation du pattern builder pour créer une instance de Ingredient
                        .id(resultSet.getInt("id"))
                        .description(resultSet.getString("description"))
                        .recetteId(resultSet.getInt("recette_id"))
                        .build(); // Retourne l'objet Etape créé
            }
        }
        catch (SQLException ex) {
            System.out.println(ex.getMessage()); // Affiche message d'erreur en cas de problème avec la requête SQL
        }
        return null; // Retourne null si aucune Etape trouvée ou en cas d'erreur
    }


    /**
     * Ajouter une étape
     * @return Etape
     */
    public Etape addEtape(Etape etape) throws SQLException {
        String sql = "INSERT INTO etape (description, recette_id) VALUES (?, ?)";

        try {
            preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, etape.getDescription());
            preparedStatement.setInt(2, etape.getRecetteId());

            int nbRow = preparedStatement.executeUpdate();
            if (nbRow != 1) {
                connection.rollback();
                return null;
            }

            ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
            if (generatedKeys.next()) {
                etape.setId(generatedKeys.getInt(1));
            }
            connection.commit(); // On commit manuellement la transaction, car on a mis connection.setAutoCommit(false) dans DatabaseManager
            return etape; // Retourne l'objet Etape créé
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
            connection.rollback();
            return null;
        }
    }


    /**
     * Modifier une étape
     * @return Etape
     */
    public Etape update(Etape etape) throws SQLException {
        String sql = "UPDATE etape SET description = ?, recette_id = ? WHERE id = ?";

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, etape.getDescription());
            preparedStatement.setInt(2, etape.getRecetteId());
            preparedStatement.setInt(3, etape.getId());

            int nbRow = preparedStatement.executeUpdate();
            if (nbRow > 0) {
                connection.commit(); // On commit manuellement la transaction, car on a mis connection.setAutoCommit(false) dans DatabaseManager
                return etape; // Retourner l'objet modifié
            }
            else {
                connection.rollback();
                return null; // Aucun enregistrement modifié
            }
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
            connection.rollback();
        }
        return null;
    }


    /**
     * Supprimer une étape
     * @return boolean
     */
    public boolean delete(int id) throws SQLException {
        String sql = "DELETE FROM etape WHERE id = ?";

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
