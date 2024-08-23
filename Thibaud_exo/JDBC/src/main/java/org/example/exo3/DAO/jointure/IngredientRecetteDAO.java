package org.example.exo3.DAO.jointure;

import org.example.exo3.DAO.abstractDAO.BaseDAO;
import org.example.exo3.entity.Ingredient;
import org.example.exo3.entity.jointure.IngredientRecette;
import org.example.exo3.util.DatabaseManager;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class IngredientRecetteDAO extends BaseDAO<IngredientRecette> {
    @Override
    public IngredientRecette save(IngredientRecette ingredientRecette) throws SQLException {
        try {
            connection = DatabaseManager.getConnection();
            request = "INSERT INTO ingredientrecette (ingredient_id, recette_id) VALUES (?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(request, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setInt(1, ingredientRecette.getIngredient_id());
            preparedStatement.setInt(2, ingredientRecette.getRecette_id());
            int row = preparedStatement.executeUpdate();
            resultSet = preparedStatement.getGeneratedKeys();

            if(row != 1) {
                throw new SQLException();
            }

            if(resultSet.next()) {
                ingredientRecette.setId(resultSet.getInt(1));
            }
            connection.commit();
            return ingredientRecette;
        }catch (SQLException e) {
            System.out.println(e.getMessage());
            connection.rollback();
            return null;
        }finally {
            close();
        }
    }

    @Override
    public IngredientRecette update(IngredientRecette ingredientRecette) throws SQLException {
        return null;
    }

    @Override
    public boolean delete(int id) throws SQLException {
        return false;
    }

    public boolean deleteByRecetteId(int recetteId) throws SQLException {
        try {
            connection = DatabaseManager.getConnection();
            request = "DELETE FROM ingredientrecette WHERE recette_id = ?";
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

    public boolean deleteByIngredientId(int ingredientId) throws SQLException {
        try {
            connection = DatabaseManager.getConnection();
            request = "DELETE FROM ingredientrecette WHERE ingredient_id = ?";
            statement = connection.prepareStatement(request);
            statement.setInt(1, ingredientId);
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


    @Override
    public IngredientRecette get(int id) throws SQLException {
        return null;
    }

    @Override
    public List<IngredientRecette> get() throws SQLException {
        return List.of();
    }

    public List<Ingredient> getIngredientByRecetteId ( int id) throws SQLException {
        connection = DatabaseManager.getConnection();
        List<Ingredient> ingredients = new ArrayList<>();
        request = "SELECT i.id as ingredientId, i.nom as ingredientNom " +
                " FROM ingredient as i " +
                " INNER JOIN ingredientrecette as e ON e.ingredient_id = i.id " +
                " WHERE e.recette_id = ?";

        statement = connection.prepareStatement(request);
        statement.setInt(1, id);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            ingredients.add(Ingredient.builder()
                    .id(resultSet.getInt(1))
                    .nom(resultSet.getString(2))
                    .build());
        }
        return ingredients;
    }
}
