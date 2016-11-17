package com.wzhy.mvpdemo.bean;

import java.io.Serializable;

/**
 * Created by wzhy on 2016/11/16.
 */

public class User implements Serializable{
    private String username;

    private String password;

    public String getUsername() {
        return username;
    }

    public User() {}

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
