package com.pentil.myapplication.Object;

import com.google.gson.annotations.SerializedName;

public class Register {
    @SerializedName("email")
    String Email;

    @SerializedName("username")
    String username;

    @SerializedName("password")
    String password;

    @SerializedName("role")
    String role;

    public Register(String email, String username, String password, String role) {
        Email = email;
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
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
