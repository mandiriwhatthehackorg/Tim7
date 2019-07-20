package com.pentil.myapplication.Return;

import com.google.gson.annotations.SerializedName;

public class ReturnRegister {
    @SerializedName("success")
    String success;

    @SerializedName("data")
    String data;

    @SerializedName("message")
    String message;
}
