package com.example.l13.model;

import com.example.l13.db.Identified;

public class User implements Identified<Integer> {
    private Integer id;
    private String login;
    private String password;
    private ROLE role;

    public User(String login, String password) {
        this.login = login;
        this.password = password;
    }
    public User() {}
    //region Getter and Setter
    @Override
    public Integer getId() {
        return id;
    }
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public ROLE getRole() {
        return role;
    }

    public void setRole(ROLE role) {
        this.role = role;
    }
    //endregion

    public enum ROLE {
        ADMIN, USER, UNKNOWN
    }
}
