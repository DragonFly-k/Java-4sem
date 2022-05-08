package com.example.l9.requests;

import com.example.l9.db.MyDAO;
import com.example.l9.models.Sortmethod;

import java.sql.*;
import java.util.ArrayList;

public class SortRequest {
    private final Connection connection;

    public SortRequest() throws SQLException {
        MyDAO dao = new MyDAO();
        connection = dao.getConnection();
    }

    public ArrayList<Sortmethod> selectSorts() throws SQLException {
        ArrayList<Sortmethod> methods = new ArrayList<>();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from sort_methods");
        while (resultSet.next()) {
            String name = resultSet.getString("name");
            String speed = resultSet.getString("speed");
            methods.add(new Sortmethod(name, speed));
        }

        return methods;
    }

    public void addSort(String name, String speed) throws SQLException {
        String query = "insert into sort_methods values (?, ?)";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, name);
        statement.setString(2, speed);
        statement.executeUpdate();
        statement.close();
    }

    public void updateSort(String name, String speed) throws SQLException {
        String query = "update java_servlet.dbo.sort_methods set speed = ? where name = ?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, speed);
        statement.setString(2, name);
        statement.executeUpdate();
        statement.close();
    }

    public void deleteSort(String name) throws SQLException {
        String query = "delete from java_servlet.dbo.sort_methods where name = ?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, name);
        statement.executeUpdate();
        statement.close();
    }
}