package org.example.exo3.DAO.abstractDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public abstract class BaseDAO <T> {

    protected PreparedStatement statement;
    protected Connection connection;
    protected ResultSet resultSet;
    protected String request;

    public BaseDAO() {

    }

    public abstract T save(T t) throws SQLException;
    public abstract T update(T t) throws SQLException;
    public abstract T delete(T t) throws SQLException;
    public abstract T get (int id) throws SQLException;
    public abstract List<T> get () throws SQLException;

    protected void close () throws SQLException {
        if (statement != null && !statement.isClosed()) {
            statement.close();
        }
        if (connection != null && !connection.isClosed()) {
            connection.close();
        }
        if (resultSet != null && !resultSet.isClosed()) {
            resultSet.close();
        }
    }
}
