package org.example.DAO;

import org.example.entity.Gardien;
import org.example.util.DatabaseManager;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class GardienDAO extends BaseDAO<Gardien> {

    private GardienAnimalDAO gardienAnimalDAO;

    public GardienDAO( ) {
        this.gardienAnimalDAO = new GardienAnimalDAO();
    }

    @Override
    public Gardien save(Gardien element) throws SQLException {
        try{
            connection = DatabaseManager.getConnection();
            request = "INSERT INTO gardien (name) VALUE (?)";
            statement = connection.prepareStatement(request, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1,element.getName());
            int row = statement.executeUpdate();
            resultSet = statement.getGeneratedKeys();
            if(row != 1){
                throw new SQLException();
            }
            if(resultSet.next()){
                element.setId(resultSet.getInt(1));
            }
            connection.commit();
            return element;
        }catch (SQLException e){
            System.out.println(e.getMessage());
            connection.rollback();
            return null;
        }finally {
            close();
        }
    }

    @Override
    public boolean delete(Gardien element) throws SQLException {
        return false;
    }

    @Override
    public Gardien update(Gardien element) throws SQLException {
        return null;
    }

    @Override
    public Gardien get(int id) throws SQLException {
        return null;
    }

    @Override
    public List<Gardien> get() throws SQLException {
        try{
            List<Gardien> enclos = new ArrayList<>();
            connection = DatabaseManager.getConnection();
            request = "SELECT * FROM gardien";
            statement = connection.prepareStatement(request);
            resultSet = statement.executeQuery();
            if(resultSet.next()){
                enclos.add(Gardien.builder()
                        .id(resultSet.getInt("id"))
                        .name(resultSet.getString("name"))
                        .animals(gardienAnimalDAO.getAnimalByGardienId(resultSet.getInt("id")))
                        .build());
            }
            return enclos;
        }catch (SQLException e){
            System.out.println(e.getMessage());
            return new ArrayList<>();
        }finally {
            close();
        }
    }
}
