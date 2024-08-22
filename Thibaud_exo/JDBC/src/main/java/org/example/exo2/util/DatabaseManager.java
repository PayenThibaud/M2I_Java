package org.example.exo2.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseManager {
    private static final String url = "jdbc:postgresql://localhost:5432/postgres?currentSchema=public";
    private static final String username = "postgres";
    private static final String password = "thibaud";

    public static Connection getConnection() {
        try {
            Connection conn = DriverManager.getConnection(url, username, password);
            conn.setAutoCommit(false);
            return conn;
        }catch (SQLException e) {
            System.out.println("erreur de connection : " + e.getMessage());
            return null;
        }
    }
}
