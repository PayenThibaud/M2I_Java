package org.example.exo3.DAO.jointure;

import org.example.exo3.DAO.abstractDAO.BaseDAO;
import org.example.exo3.entity.Etape;
import org.example.exo3.entity.jointure.EtapeRecette;
import org.example.exo3.util.DatabaseManager;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class EtapeRecetteDAO extends BaseDAO<EtapeRecette> {
    @Override
    public EtapeRecette save(EtapeRecette etapeRecette) throws SQLException {
        try {
            connection = DatabaseManager.getConnection();
            request = "INSERT INTO etaperecette (etape_id, recette_id) VALUES (?, ?)";
            statement = connection.prepareStatement(request, Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, etapeRecette.getEtape_id());
            statement.setInt(2, etapeRecette.getRecette_id());
            int rowsAffected = statement.executeUpdate();
            resultSet = statement.getGeneratedKeys();
            if(rowsAffected != 1) {
                throw new SQLException();
            }
            if(resultSet.next()) {
                etapeRecette.setId(resultSet.getInt(1));
            }
            connection.commit();
            return etapeRecette;
        }catch (SQLException e) {
            System.out.println(e.getMessage());
            connection.rollback();
            return null;
        }finally {
            close();
        }
    }

    @Override
    public EtapeRecette update(EtapeRecette etapeRecette) throws SQLException {
        return null;
    }

    @Override
    public boolean delete(int id) throws SQLException {
        return false;
    }

    public boolean deleteByEtapeId(int etapeId) throws SQLException {
        try {
            connection = DatabaseManager.getConnection();
            request = "DELETE FROM etaperecette WHERE etape_id = ?";
            statement = connection.prepareStatement(request);
            statement.setInt(1, etapeId);
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
            request = "DELETE FROM etaperecette WHERE recette_id = ?";
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


    @Override
    public EtapeRecette get(int id) throws SQLException {
        return null;
    }

    @Override
    public List<EtapeRecette> get() throws SQLException {
        return List.of();
    }

    public List<Etape> getEtapeByRecetteID (int id) throws SQLException {
        connection = DatabaseManager.getConnection();
        List<Etape> etapes = new ArrayList<>();
        request = "SELECT e.id as etapeId, e.description as etapeDescription " +
                " FROM etape as e " +
                " INNER JOIN etaperecette as b ON b.etape_id = e.id" +
                " WHERE b.recette_id = ?";

        statement = connection.prepareStatement(request);
        statement.setInt(1, id);
        resultSet = statement.executeQuery();
        while (resultSet.next()) {
            etapes.add(Etape.builder()
                    .id(resultSet.getInt("etapeId"))
                    .description(resultSet.getString("etapeDescription"))
                    .build());
        }
        return etapes;
    }
}
