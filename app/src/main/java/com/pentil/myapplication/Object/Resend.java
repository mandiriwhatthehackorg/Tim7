package com.pentil.myapplication.Object;

import com.google.gson.annotations.SerializedName;

public class Resend {
    @SerializedName("email")
    String Email;

    public Resend(String email) {
        Email = email;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }
}
