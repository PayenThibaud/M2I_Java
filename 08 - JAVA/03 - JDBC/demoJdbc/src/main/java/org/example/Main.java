package org.example;

import java.rmi.ConnectException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5432/";
        String username = "postgres";
        String password = "formation";

        Connection connection;

        try{
            connection = DriverManager.getConnection(url,username,password);
            if(connection != null){
                System.out.println("connexion ok");
            }else{
                System.out.println("connexion echoué");
            }

        }catch (SQLException ex){
            System.out.println("erreur durant la connection\n"+ ex.getMessage());
        }
    }
}