package com.example.l9_10.DB;

import java.sql.*;

public class RequestManager {
    private final Connection connection;

    public RequestManager(Connection connection) {
        this.connection = connection;
    }
    public void addSubject(int group,int ID, String name, int course) throws SQLException {
        PreparedStatement st =connection.prepareStatement("INSERT INTO STUD (GROUP_NUM,STUD_ID,NAME,COURSE) VALUES (?,?,?,?)");
        st.setInt(1,group);
        st.setInt(2,ID);
        st.setString(3,name);
        st.setInt(4,course);
        st.executeUpdate();
    }
    public void addUser(String username, String password, String role) throws SQLException {
        PreparedStatement st = connection.prepareStatement("INSERT INTO UsersTable (login, password, Role) VALUES (?, ?, ?)");
        st.setString(1, username);
        st.setInt(2, password.hashCode());
        st.setString(3, role);
        st.executeUpdate();
    }

    public boolean isUser(String username, String password, String role) throws SQLException {
        PreparedStatement st = connection.prepareStatement("SELECT login, password, Role FROM UsersTable WHERE login = ? AND password = ? AND Role = ?");
        st.setString(1, username);
        st.setInt(2, password.hashCode());
        st.setString(3, role);

        ResultSet resultSet = st.executeQuery();
        return resultSet.next();
    }


    public Connection getConnection() {
        return connection;
    }

    public void close() {
        try {
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
