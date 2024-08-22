package org.example.Demo2.DAO;

import org.example.Demo2.Util.DatabaseManager;
import org.example.Demo2.entity.Commande;
import org.example.Demo2.entity.Plante;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CommandeDAO {
    private Connection connection;
    private PlanteDAO planteDAO;

    public CommandeDAO() {
        this.connection = DatabaseManager.getConnection();
        planteDAO = new PlanteDAO();
    }

    public Commande save (Commande commande) throws SQLException {
        try{
            String request = "INSERT INTO commande (prix,quantite,plante_id) VALUE (?,?,?)";
            PreparedStatement statement = connection.prepareStatement(request, Statement.RETURN_GENERATED_KEYS);
            statement.setFloat(1, commande.getPrix());
            statement.setInt(2,commande.getQuantite());
            statement.setInt(3, commande.getPlante().getId());

            int nbrRow = statement.executeUpdate();

            if(nbrRow != 1){
                connection.rollback();
                return null;
            }
            ResultSet resultSet = statement.getGeneratedKeys();
            if(resultSet.next()){
                commande.setId(resultSet.getInt(1));
            }
            connection.commit();
            return commande;


        }catch (SQLException e){
            System.out.println(e.getMessage());
            connection.rollback();
            return null;

        }
    }

    public List<Commande> getAllByPlante (int idPlante){
        try{
            String request = "SELECT FROM commande WHERE plante_id = ?";
            PreparedStatement statement = connection.prepareStatement(request, Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1,idPlante);

            ResultSet resultSet = statement.executeQuery();

            List<Commande> commandes = new ArrayList<>();
            while (resultSet.next()){
                commandes.add(Commande.builder().id(resultSet.getInt("id"))
                        .prix(resultSet.getFloat("prix"))
                        .quantite(resultSet.getInt("quantite"))
                        .plante(planteDAO.getById(resultSet.getInt("plante_id"))).build());
            }

            return commandes;


        }catch (SQLException e){
            System.out.println(e.getMessage());
            return new ArrayList<>();
        }
    }
}
