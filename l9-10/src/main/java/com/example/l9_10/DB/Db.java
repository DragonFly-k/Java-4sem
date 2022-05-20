package com.example.l9_10.DB;

import java.sql.*;

public class Db {
    private Connection connection;
    public Db() throws SQLException, ClassNotFoundException {
        String url = "jdbc:sqlserver://DESKTOP-M01CN9D;database=Users;trustServerCertificate=true;encrypt=false;IntegratedSecurity=false";
        String user = "sa";
        String pass = "123456";
        connection = DriverManager.getConnection(url, user,pass);
    }
    public void addUser(String username, String password, String role) throws SQLException {
        Statement myStmt = connection.createStatement();
        myStmt.execute("INSERT INTO `UsersTable` (`login`, `password`, `Role`) " +
                "VALUES ('"+username+"', '"+password.hashCode()+"', '"+role+"');");
    }
    public boolean isUser(String username, String password, String role) throws SQLException {
        PreparedStatement st = connection.prepareStatement("SELECT `login`, `password`, `Role` FROM `UsersTable` WHERE `login` = '"+username+
                "' AND `password` = '"+password.hashCode()+"' AND `Role` = '"+role+"'");

        ResultSet resultSet = st.executeQuery();
        return resultSet.next();
    }
    public void closeConnection() throws SQLException {
        //ClearTableUsers();
        connection.close();
    }
    public void FillTableUsers() throws SQLException {
        Statement myStmt = connection.createStatement();
        myStmt.execute("INSERT INTO `UsersTable` (`login`, `password`, `Role`) " +
                "VALUES ('Kate', '"+"1234".hashCode()+"', 'admin'),"+
                "       ('User', '"+"12345".hashCode()+"', 'user'),"+
                "       ('Hun', '"+"123".hashCode()+"', 'user')");
    }
    public void ClearTableUsers() throws SQLException {
        Statement myStmt = connection.createStatement();
        myStmt.execute("DELETE FROM `UsersTable`");
    }
}
