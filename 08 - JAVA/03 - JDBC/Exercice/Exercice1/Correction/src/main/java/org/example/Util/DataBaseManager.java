package org.example.Util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseManager {
    private final static String url = "jdbc:postgresql://localhost:5432/postgres?currentSchema=exo1";
    private final static String username = "postgres";
    private final static String password = "formation";
    private static Connection connection;

    private DataBaseManager (){
        try{
            connection =  DriverManager.getConnection(url,username,password);
        }catch (SQLException e){
            System.out.println("erreure de connection : \n"+e.getMessage());
        }

    }

    public static synchronized Connection getConnection(){
        if(connection == null){
            new DataBaseManager();
        }
        return connection;
    }
}
