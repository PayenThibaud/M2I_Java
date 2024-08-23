package org.example.exo3.DAO;

import org.example.exo3.DAO.abstractDAO.BaseDAO;
import org.example.exo3.entity.Ingredient;
import org.example.exo3.entity.Recette;
import org.example.exo3.util.DatabaseManager;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class RecetteDAO extends BaseDAO<Recette> {
    @Override
    public Recette save(Recette recette) throws SQLException {
        try {
            connection = DatabaseManager.getConnection();
            request = "INSERT INTO recette (nom, tempsPrep, tempsCuisson, difficulte ) VALUES (?, ? , ? , ?)";
            statement = connection.prepareStatement(request, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, recette.getNom());
            statement.setInt(2,recette.getTempsPrep());
            statement.setInt(3,recette.getTempsCuisson());
            statement.setString(4,recette.getDifficulte());
            int row = statement.executeUpdate();
            resultSet = statement.getGeneratedKeys();
            if (row != 1) {
                connection.rollback();
                return null;
            }
            if (resultSet.next()) {
                recette.setId(resultSet.getInt(1));
            }
            connection.commit();
            return recette;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            connection.rollback();
            return null;
        } finally {
            close();
        }
    }


    @Override
    public Recette update(Recette recette) throws SQLException {
        return null;
    }

    @Override
    public Recette delete(Recette recette) throws SQLException {
        return null;
    }

    @Override
    public Recette get(int id) throws SQLException {
        try {
            connection = DatabaseManager.getConnection();
            request = "SELECT * FROM recette WHERE id = ?";
            statement = connection.prepareStatement(request);
            statement.setInt(1, id);
            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return Recette.builder().id(resultSet.getInt(1)).nom(resultSet.getString(2)).tempsPrep(resultSet.getInt(3))
                        .tempsCuisson(resultSet.getInt(4)).difficulte(resultSet.getString(5)).build();
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
    public List<Recette> get() throws SQLException {
        try {
            connection = DatabaseManager.getConnection();
            request = "SELECT * FROM recette";
            statement = connection.prepareStatement(request);
            resultSet = statement.executeQuery();
            List<Recette> recetteList = new ArrayList<>();
            while (resultSet.next()) {
                recetteList.add(Recette.builder().id(resultSet.getInt(1)).nom(resultSet.getString(2)).tempsPrep(resultSet.getInt(3))
                        .tempsCuisson(resultSet.getInt(4)).difficulte(resultSet.getString(5)).build());
            }
            return recetteList;
        }catch (SQLException e) {
            System.out.println(e.getMessage());
            return new ArrayList<>();
        }finally {
            close();
        }
    }
}

