package com.pentil.myapplication.Object;

import com.google.gson.annotations.SerializedName;

public class Login {
    @SerializedName("username")
    String username;

    @SerializedName("password")
    String password;

    public Login(String username, String password) {
        this.username = username;
        this.password = password;

    }

    public String getUsername() {
        return username;
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
