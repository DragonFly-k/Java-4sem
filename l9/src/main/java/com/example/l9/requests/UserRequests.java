package com.example.l9.requests;


import com.example.l9.db.MyDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRequests {
    private final Connection connection;

    public UserRequests() throws SQLException {
        MyDAO dao = new MyDAO();
        connection = dao.getConnection();
    }

    public void addUser(String login, String password) throws SQLException {
        String query = "insert into user_auth values (?, ?, ?)";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, login);
        statement.setInt(2, password.hashCode());
        statement.setString(3, "user");
        statement.executeUpdate();
        statement.close();
    }

    public String checkUser(String login, String password) throws SQLException {
        PreparedStatement statement = connection.prepareStatement("select password, status from user_auth where login = ?");
        statement.setString(1, login);
        ResultSet resultSet = statement.executeQuery();
        if (resultSet.next()) {
            int retrieved_password = resultSet.getInt("password");
            return retrieved_password == password.hashCode() ? resultSet.getString("status") : "null";
        }
        return "null";
    }
}