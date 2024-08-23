package org.example.exo3.DAO;

import org.example.exo3.DAO.abstractDAO.BaseDAO;
import org.example.exo3.entity.Commentaire;
import org.example.exo3.entity.Etape;
import org.example.exo3.util.DatabaseManager;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class EtapeDAO extends BaseDAO<Etape> {
    @Override
    public Etape save(Etape etape) throws SQLException {
        try {
            connection = DatabaseManager.getConnection();
            request = "INSERT INTO etape (description) VALUES (?)";
            statement = connection.prepareStatement(request, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, etape.getDescription());
            int row = statement.executeUpdate();
            resultSet = statement.getGeneratedKeys();
            if (row != 1) {
                connection.rollback();
                return null;
            }
            if (resultSet.next()) {
                etape.setId(resultSet.getInt(1));
            }
            connection.commit();
            return etape;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            connection.rollback();
            return null;
        } finally {
            close();
        }
    }

    @Override
    public Etape update(Etape etape) throws SQLException {
        return null;
    }

    @Override
    public Etape delete(Etape etape) throws SQLException {
        return null;
    }

    @Override
    public Etape get(int id) throws SQLException {
        try {
            connection = DatabaseManager.getConnection();
            request = "SELECT * FROM etape WHERE id = ?";
            statement = connection.prepareStatement(request);
            statement.setInt(1, id);
            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return Etape.builder().id(resultSet.getInt(1)).description(resultSet.getString(2)).build();
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
    public List<Etape> get() throws SQLException {
        try {
            connection = DatabaseManager.getConnection();
            request = "SELECT * FROM etape";
            statement = connection.prepareStatement(request);
            resultSet = statement.executeQuery();
            List<Etape> etapeList = new ArrayList<>();
            while (resultSet.next()) {
                etapeList.add(Etape.builder().id(resultSet.getInt(1)).description(resultSet.getString(2)).build());
            }
            return etapeList;
        }catch (SQLException e) {
            System.out.println(e.getMessage());
            return new ArrayList<>();
        }finally {
            close();
        }
    }
}
