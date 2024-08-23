package org.example.exo3.DAO.jointure;

import org.example.exo3.DAO.abstractDAO.BaseDAO;
import org.example.exo3.entity.Commentaire;
import org.example.exo3.entity.jointure.CommentaireRecette;
import org.example.exo3.util.DatabaseManager;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CommentaireRecetteDAO extends BaseDAO<CommentaireRecette> {

    @Override
    public CommentaireRecette save(CommentaireRecette commentaireRecette) throws SQLException {
        try {
        connection = DatabaseManager.getConnection();
        request = "INSERT INTO commentairerecette (commentaire_id, recette_id) VALUES (?, ?)";
        statement = connection.prepareStatement(request, Statement.RETURN_GENERATED_KEYS);
        statement.setInt(1, commentaireRecette.getCommentaire_id());
        statement.setInt(2, commentaireRecette.getRecette_id());
        int rowsAffected = statement.executeUpdate();
        resultSet = statement.getGeneratedKeys();
        if (rowsAffected !=1 ) {
            throw new SQLException();
        }
        if (resultSet.next()) {
            commentaireRecette.setId(resultSet.getInt(1));
        }
        connection.commit();
        return commentaireRecette;
    }catch (SQLException e) {
            System.out.println(e.getMessage());
        connection.rollback();
        return null;
        }finally {
            close();
        }
    }

    @Override
    public CommentaireRecette update(CommentaireRecette commentaireRecette) throws SQLException {
        return null;
    }

    @Override
    public boolean delete(int id) throws SQLException {
        return false;
    }

    public boolean deleteByCommentaireId(int commentaireId) throws SQLException {
        try {
            connection = DatabaseManager.getConnection();
            request = "DELETE FROM commentairerecette WHERE commentaire_id = ?";
            statement = connection.prepareStatement(request);
            statement.setInt(1, commentaireId);
            int rowsAffected = statement.executeUpdate();

            if (rowsAffected ==1) {
                connection.commit();
                return true;
            } else{
                connection.rollback();
                return false;
            }
            }catch (SQLException e) {
            System.out.println(e.getMessage());
            connection.rollback();
            return false;
        }finally {
            close();
        }
    }

    public boolean deleteByRecetteId(int recetteId) throws SQLException {
        try {
            connection = DatabaseManager.getConnection();
            request = "DELETE FROM commentairerecette WHERE recette_id = ?";
            statement = connection.prepareStatement(request);
            statement.setInt(1, recetteId);
            int rowsAffected = statement.executeUpdate();

            if (rowsAffected ==1) {
                connection.commit();
                return true;
            } else{
                connection.rollback();
                return false;
            }
        }catch (SQLException e) {
            System.out.println(e.getMessage());
            connection.rollback();
            return false;
        }finally {
            close();
        }
    }

//    public boolean delete(CommentaireRecette commentaireRecette) throws SQLException {
//        try {
//            connection = DatabaseManager.getConnection();
//            request = "DELETE FROM commentairerecette WHERE id = ?";
//            statement = connection.prepareStatement(request);
//            statement.setInt(1, commentaireRecette.getId());
//            int rowsAffected = statement.executeUpdate();
//            if (rowsAffected !=1) {
//                throw new SQLException();
//            }
//            connection.commit();
//            return true;
//        }catch (SQLException e) {
//            System.out.println(e.getMessage());
//            connection.rollback();
//            return false;
//        }finally {
//            close();
//        }
//    }

    @Override
    public CommentaireRecette get(int id) throws SQLException {
        return null;
    }

    @Override
    public List<CommentaireRecette> get() throws SQLException {
        return List.of();
    }

    public List<Commentaire> getCommentaireByRecetteID (int id) throws SQLException {
        List<Commentaire> commentaireList = new ArrayList<>();
        connection = DatabaseManager.getConnection();
        request = "SELECT c.id as commentaireId, c.description as commentaireDescription " +
                " FROM commentaire as c " +
                " INNER JOIN commentairerecette as e ON e.commentaire_id = c.id " +
                " WHERE e.recette_id = ?";

        statement = connection.prepareStatement(request);
        statement.setInt(1, id);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            commentaireList.add(Commentaire.builder()
                    .id(resultSet.getInt("commentaireId"))
                    .description(resultSet.getString("commentaireDescription"))
                    .build());

        }
        return commentaireList;
    }
}
