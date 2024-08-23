package org.example.exo3.DAO;

import org.example.exo3.DAO.abstractDAO.BaseDAO;
import org.example.exo3.entity.Commentaire;
import org.example.exo3.util.DatabaseManager;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CommentaireDAO extends BaseDAO<Commentaire> {

    @Override
    public Commentaire save(Commentaire commentaire) throws SQLException {
        try {
            connection = DatabaseManager.getConnection();
            request = "INSERT INTO commentaire (description) VALUES (?)";
            statement = connection.prepareStatement(request, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, commentaire.getDescription());
            int row = statement.executeUpdate();
            resultSet = statement.getGeneratedKeys();
            if (row != 1) {
                connection.rollback();
                return null;
            }
            if (resultSet.next()) {
                commentaire.setId(resultSet.getInt(1));
            }
            connection.commit();
            return commentaire;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            connection.rollback();
            return null;
        } finally {
            close();
        }
    }

    @Override
    public Commentaire update(Commentaire commentaire) throws SQLException {
        return null;
    }

    @Override
    public Commentaire delete(Commentaire commentaire) throws SQLException {
        return null;
    }

    @Override
    public Commentaire get(int id) throws SQLException {
        try {
            connection = DatabaseManager.getConnection();
            request = "SELECT * FROM commentaire WHERE id = ?";
            statement = connection.prepareStatement(request);
            statement.setInt(1, id);
            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return Commentaire.builder().id(resultSet.getInt(1)).description(resultSet.getString(2)).build();
            }
            return null;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        } finally {
            close();
        }
    }

    @Override
    public List<Commentaire> get() throws SQLException {
        try {
            connection = DatabaseManager.getConnection();
            request = "SELECT * FROM commentaire";
            statement = connection.prepareStatement(request);
            resultSet = statement.executeQuery();
            List<Commentaire> commentaireList = new ArrayList<>();
            while (resultSet.next()) {
                commentaireList.add(Commentaire.builder().id(resultSet.getInt(1)).description(resultSet.getString(2)).build());
            }
            return commentaireList;
        }catch (SQLException e) {
            System.out.println(e.getMessage());
            return new ArrayList<>();
        }finally {
            close();
        }
    }
}
