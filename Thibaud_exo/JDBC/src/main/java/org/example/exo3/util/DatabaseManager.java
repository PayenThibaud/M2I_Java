package org.example.exo3.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseManager {
    private static final String url = "jdbc:postgresql://localhost:5432/postgres?currentSchema=public";
    private static final String username = "postgres";
    private static final String password = "thibaud";

    public static Connection getConnection() throws SQLException {
        Connection connection = DriverManager.getConnection(url,username,password);
        connection.setAutoCommit(false);
        return connection;
    }
}
