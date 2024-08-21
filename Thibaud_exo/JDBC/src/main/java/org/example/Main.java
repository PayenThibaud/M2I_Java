package org.example;

import java.sql.*;

public class Main {
    public static void main(String[] args) {
        String ulr = "jdbc:postgresql://localhost:5432/postgres?currentSchema=public";
        String user = "postgres";
        String password = "thibaud";

        Connection connection;

        try{
            connection = DriverManager.getConnection(ulr,user,password);
            if(connection != null) {
                System.out.println("connexion ok");

                Statement statement = connection.createStatement();
//                String request = "INSERT INTO livre (titre, auteur) VALUES ('monlivre','auteur')";
//                int nbrRows = statement.executeUpdate(request);
//                if(nbrRows == 1) {
//                    System.out.println("Le livre a bien ete ajouter");
//                }

                Livre livre = Livre.builder()
                        .titre("test")
                        .auteur("otor")
                        .build();


                String requestAdd = "INSERT INTO livre (titre, auteur) VALUES (?, ?)";
                PreparedStatement ps = connection.prepareStatement(requestAdd);
                ps.setString(1,livre.getTitre());
                ps.setString(2,livre.getAuteur());
                ps.executeUpdate();

                String request2 = "SELECT * FROM livre";
                ResultSet resultSet = statement.executeQuery(request2);

                while (resultSet.next()) {
                    System.out.println(resultSet.getString("titre") + ", " + resultSet.getString("auteur"));
                }
            }
            else {
                System.out.println("connexion fail");
            }
        }
        catch(SQLException e){
            System.out.println("erreur durant la connexion" + e.getMessage());
        }
    }
}