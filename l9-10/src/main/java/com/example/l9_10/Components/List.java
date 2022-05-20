package com.example.l9_10.Components;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class List {
    private final Connection connection;
    ArrayList<Subject> subjects = new ArrayList<>();

    public List(Connection connection) throws SQLException {
        this.connection = connection;
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM STUD");
        while (resultSet.next()) {
            {
                subjects.add(new Subject(resultSet.getInt("GROUP_NUM"),
                        resultSet.getInt("STUD_ID"),
                        resultSet.getString("NAME"),
                        resultSet.getInt("COURSE")));
            }
        }
    }
    public ArrayList<Subject> getList() {
        return subjects;
    }
}
