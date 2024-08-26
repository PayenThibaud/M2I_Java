package ExercicesJDBC.Recette.Util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseManager {
//    private static final String url_db = "jdbc:mysql://localhost:3306/recette";
//    private static final String username_db = "root";
//    private static final String password_db = "";

    private static final String url_db = "jdbc:postgresql://localhost:5432/recette";
    private static final String username_db = "postgres";
    private static final String password_db = "1234";

    public static Connection getConnection () {
        try {
            Connection connection = DriverManager.getConnection(url_db, username_db, password_db);
            connection.setAutoCommit(false); // On commit manuellement les transactions. Il faudra commit manuellement avec : connection.commit();
            return connection;
        }
        catch (SQLException e) {
            System.out.println("Erreur de connexion");
            return null;
        }
    }
}