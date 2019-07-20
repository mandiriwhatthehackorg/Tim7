package com.pentil.myapplication.Return;

import com.google.gson.annotations.SerializedName;

public class ReturnRegister {
    @SerializedName("success")
    String success;

    @SerializedName("data")
    String data;

    @SerializedName("message")
    String message;

    public String getSuccess() {
        return success;
    }

    public String getData() {
        return data;
    }

    public String getMessage() {
        return message;
    }
}
