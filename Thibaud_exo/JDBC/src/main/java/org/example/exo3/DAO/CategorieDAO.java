package org.example.exo3.DAO;

import org.example.exo3.DAO.abstractDAO.BaseDAO;
import org.example.exo3.entity.Categorie;
import org.example.exo3.util.DatabaseManager;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CategorieDAO extends BaseDAO<Categorie> {

    @Override
    public Categorie save(Categorie categorie) throws SQLException {
        try {
            connection = DatabaseManager.getConnection();
            request = "INSERT INTO categorie (nom) VALUES (?)";
            statement = connection.prepareStatement(request, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, categorie.getNom());
            int row = statement.executeUpdate();
            resultSet = statement.getGeneratedKeys();
            if(row != 1) {
                connection.rollback();
                return null;
            }
            if(resultSet.next()) {
                categorie.setId(resultSet.getInt(1));
            }
            connection.commit();
            return categorie;
        }catch(SQLException e) {
            System.out.println(e.getMessage());
            connection.rollback();
            return null;
        }finally {
            close();
        }
    }

    @Override
    public Categorie update(Categorie categorie) throws SQLException {
        return null;
    }

    @Override
    public Categorie delete(Categorie categorie) throws SQLException {
        return null;
    }

    @Override
    public Categorie get(int id) throws SQLException {
        try {
            connection = DatabaseManager.getConnection();
            request = "SELECT * FROM categorie WHERE id = ?";
            statement = connection.prepareStatement(request);
            statement.setInt(1, id);
            resultSet = statement.executeQuery();
            if(resultSet.next()) {
                return Categorie.builder()
                        .id(resultSet.getInt(1))
                        .nom(resultSet.getNString(2))
                        .build();
            }
            return null;
        }catch(SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }finally {
            close();
        }
    }

    @Override
    public List<Categorie> get() throws SQLException {
        try {
            List<Categorie> categories = new ArrayList<Categorie>();
            connection = DatabaseManager.getConnection();
            request = "SELECT * FROM categorie";
            statement = connection.prepareStatement(request);
            resultSet = statement.executeQuery();
            while(resultSet.next()) {
                categories.add(Categorie.builder()
                        .id(resultSet.getInt(1))
                        .nom(resultSet.getNString(2))
                        .build());
            }
            return categories;
        }catch(SQLException e) {
            System.out.println(e.getMessage());
            return new ArrayList<>();
        }finally {
            close();
        }
    }
}
