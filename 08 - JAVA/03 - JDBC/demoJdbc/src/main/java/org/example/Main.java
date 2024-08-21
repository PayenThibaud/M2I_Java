package org.example;

import com.sun.source.tree.LambdaExpressionTree;

import java.rmi.ConnectException;
import java.sql.*;

public class Main {
    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5432/";
//        String url = "jdbc:postgresql://localhost:5432/postgres?currentSchema=exo1";
        String username = "postgres";
        String password = "formation";

        Connection connection;

        try{
            connection = DriverManager.getConnection(url,username,password);
            if(connection != null){
                System.out.println("connexion ok");

                // statement classique
//                Statement statement = connection.createStatement();
//                String request = "INSERT INTO book (title,author,publisher,isbn) VALUES ('monlivre','auteur','publisher','123456789')";
//                int nbrRow = statement.executeUpdate(request);
//                if(nbrRow == 1){
//                    System.out.println("le livre a bien ete ajouté");
//                }


                // prepared statement
                Book bookCreated = Book.builder()
                        .title("monlivreLombok")
                        .author("lombok")
                        .publisher("lombok")
                        .isbn("01010101").build();

                String requestAdd = "INSERT INTO book (title,author,publisher,isbn) VALUES (?,?,?,?)";
                PreparedStatement preparedStatement = connection.prepareStatement(requestAdd,Statement.RETURN_GENERATED_KEYS);
                preparedStatement.setString(1, bookCreated.getTitle());
                preparedStatement.setString(2, bookCreated.getAuthor());
                preparedStatement.setString(3, bookCreated.getPublisher());
                preparedStatement.setString(4, bookCreated.getIsbn());
                preparedStatement.executeUpdate();

                ResultSet generatedKeys = preparedStatement.getGeneratedKeys();

                if(generatedKeys.next()){
                    bookCreated.setId(generatedKeys.getInt(1));
                }

                System.out.println(bookCreated);


                // recuperation des données
                String request = "SELECT * FROM book WHERE id = ?";
                PreparedStatement statement = connection.prepareStatement(request);
                statement.setInt(1,2);

                ResultSet resultSet = statement.executeQuery();

                if(resultSet.next()){
                    Book book = Book.builder().id(resultSet.getInt("id"))
                            .title(resultSet.getString("title"))
                            .author(resultSet.getString("author"))
                            .publisher(resultSet.getString("publisher"))
                            .isbn(resultSet.getString("isbn")).build();
                    System.out.println(book);
                }


//                while(resultSet.next()){
//                    System.out.println(resultSet.getString("title")+" / "+resultSet.getString("author"));
//                }

                connection.close();
            }else{
                System.out.println("connexion echoué");
            }



        }catch (SQLException ex){
            System.out.println("erreur durant la connection\n"+ ex.getMessage());
        }


    }
}