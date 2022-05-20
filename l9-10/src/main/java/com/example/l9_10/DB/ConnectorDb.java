package com.example.l9_10.DB;

import com.microsoft.sqlserver.jdbc.SQLServerDriver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectorDb {

    public ConnectorDb() {
        try {
            DriverManager.registerDriver(new SQLServerDriver());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public Connection getConnection(String dataBase) throws SQLException {
        String url = String.format("jdbc:sqlserver://DESKTOP-M01CN9D;database=%s;trustServerCertificate=true;encrypt=false;IntegratedSecurity=false",dataBase);
        String user = "sa";
        String password = "123456";
        return DriverManager.getConnection(url, user, password);
    }
}
