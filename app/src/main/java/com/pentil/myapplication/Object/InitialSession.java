package com.pentil.myapplication.Object;

import com.google.gson.annotations.SerializedName;

public class InitialSession {
    @SerializedName("email")
    String email;

    @SerializedName("nik")
    String nik;

    @SerializedName("phone")
    String phone;

    @SerializedName("tll")
    String ttl;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNik() {
        return nik;
    }

    public void setNik(String nik) {
        this.nik = nik;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getTtl() {
        return ttl;
    }

    public void setTtl(String ttl) {
        this.ttl = ttl;
    }

    public InitialSession(String email, String nik, String phone, String ttl) {

        this.email = email;
        this.nik = nik;
        this.phone = phone;
        this.ttl = ttl;
    }
}
