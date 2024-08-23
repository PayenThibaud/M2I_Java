package org.example.exo3.DAO;

import org.example.exo3.DAO.abstractDAO.BaseDAO;
import org.example.exo3.entity.Commentaire;
import org.example.exo3.entity.Ingredient;
import org.example.exo3.util.DatabaseManager;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class IngredientDAO extends BaseDAO<Ingredient> {
    @Override
    public Ingredient save(Ingredient ingredient) throws SQLException {
        try {
            connection = DatabaseManager.getConnection();
            request = "INSERT INTO ingredient (nom) VALUES (?)";
            statement = connection.prepareStatement(request, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, ingredient.getNom());
            int row = statement.executeUpdate();
            resultSet = statement.getGeneratedKeys();
            if (row != 1) {
                connection.rollback();
                return null;
            }
            if (resultSet.next()) {
                ingredient.setId(resultSet.getInt(1));
            }
            connection.commit();
            return ingredient;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            connection.rollback();
            return null;
        } finally {
            close();
        }
    }

    @Override
    public Ingredient update(Ingredient ingredient) throws SQLException {
        return null;
    }

    @Override
    public Ingredient delete(Ingredient ingredient) throws SQLException {
        return null;
    }

    @Override
    public Ingredient get(int id) throws SQLException {
        try {
            connection = DatabaseManager.getConnection();
            request = "SELECT * FROM ingredient WHERE id = ?";
            statement = connection.prepareStatement(request);
            statement.setInt(1, id);
            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return Ingredient.builder().id(resultSet.getInt(1)).nom(resultSet.getString(2)).build();
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
    public List<Ingredient> get() throws SQLException {
        try {
            connection = DatabaseManager.getConnection();
            request = "SELECT * FROM ingredient";
            statement = connection.prepareStatement(request);
            resultSet = statement.executeQuery();
            List<Ingredient> ingredientList = new ArrayList<>();
            while (resultSet.next()) {
                ingredientList.add(Ingredient.builder().id(resultSet.getInt(1)).nom(resultSet.getString(2)).build());
            }
            return ingredientList;
        }catch (SQLException e) {
            System.out.println(e.getMessage());
            return new ArrayList<>();
        }finally {
            close();
        }
    }
}
