package com.example.l9.db;

import com.microsoft.sqlserver.jdbc.SQLServerDriver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class MyDAO implements db.DAO {


    public MyDAO() {
        try {
            DriverManager.registerDriver(new SQLServerDriver());
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Connection getConnection() throws SQLException {
        String dbURL = "jdbc:sqlserver://localhost:1434;databaseName=JABA;integratedSecurity=true;"
                + "encrypt=true;trustServerCertificate=true";
        return DriverManager.getConnection(dbURL);
    }
}
