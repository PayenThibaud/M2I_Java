package org.example.Demo2.DAO;

import org.example.Demo2.entity.Plante;
import org.example.Demo2.Util.DatabaseManager;

import java.sql.*;

public class PlanteDAO {
    private Connection connection;

    public PlanteDAO() {
        this.connection = DatabaseManager.getConnection();
    }

    public Plante save (Plante plante) throws SQLException{
        try{
            String request = "INSERT INTO plante (name,age,color) VALUE (?,?,?)";
            PreparedStatement statement = connection.prepareStatement(request, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, plante.getName());
            statement.setInt(2,plante.getAge());
            statement.setString(3, plante.getColor());

            int nbrRow = statement.executeUpdate();

            if(nbrRow != 1){
                connection.rollback();
                return null;
            }
            ResultSet resultSet = statement.getGeneratedKeys();
            if(resultSet.next()){
                plante.setId(resultSet.getInt(1));
            }
            connection.commit();
            return plante;


        }catch (SQLException e){
                System.out.println(e.getMessage());
                connection.rollback();
                return null;

        }
    }

    public Plante getById (int id){
        try{
            String request = "SELECT FROM plante WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(request);
            statement.setInt(1,id);

            ResultSet resultSet = statement.executeQuery();

            if(resultSet.next()){
                return Plante.builder().id(resultSet.getInt("id"))
                        .name(resultSet.getString("name"))
                        .age(resultSet.getInt("age"))
                        .color(resultSet.getString("color")).build();
            }

            return null;
        }catch (SQLException ex){
            System.out.println(ex.getMessage());
            return null;
        }
    }
}
