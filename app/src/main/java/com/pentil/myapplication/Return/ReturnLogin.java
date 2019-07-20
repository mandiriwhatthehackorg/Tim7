package com.pentil.myapplication.Return;

import com.google.gson.annotations.SerializedName;

public class ReturnLogin {
    @SerializedName("success")
    String success;

    @SerializedName("data")
    DataLogin data;

    @SerializedName("message")
    String message;
}
