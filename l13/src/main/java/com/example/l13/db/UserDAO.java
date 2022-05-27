package com.example.l13.db;

import com.example.l13.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDAO extends DAO<User,Integer> {

    public UserDAO(Connection connection) throws SQLException {
        super(connection);
    }

    @Override
    public String getSelectQuery() {
        return "SELECT * FROM Users;";
    }

    @Override
    public String getCreateQuery() {
        return "INSERT INTO Users (ID,login, password) VALUES (?, ?,?);";
    }

    @Override
    public String getUpdateQuery() {
        return  "UPDATE Users " +
                "SET password  = ? " +
                "WHERE ID= ?;";
    }

    @Override
    public String getDeleteQuery() {
        return "DELETE FROM Users WHERE ID = ?;";
    }

    @Override
    protected List<User> parseResultSet(ResultSet rs) throws SQLException {
        ArrayList<User> result = new ArrayList<User>();
        while (rs.next()) {
            User user = new User();
            user.setLogin(rs.getString("login"));
            user.setPassword(rs.getString("password"));
            result.add(user);
        }
        return result;
    }

    @Override
    protected void prepareStatementForInsert(PreparedStatement statement, User entity) throws SQLException {
        statement.setString(1, entity.getLogin());
        statement.setString(2, entity.getPassword());
    }

    @Override
    protected void prepareStatementForUpdate(PreparedStatement statement, User entity) throws SQLException {
        statement.setString(1, entity.getLogin());
        statement.setString(2, entity.getPassword());
    }
}