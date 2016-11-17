package com.paw.servertrello.models;

/**
 * Created by Jakub on 2016-10-24.
 */
public class Credentials {
    private String login;
    private String password;

    public Credentials() {
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
}