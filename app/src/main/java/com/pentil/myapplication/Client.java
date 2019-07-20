package com.pentil.myapplication;

import android.util.Log;

import com.pentil.myapplication.Object.InitialSession;
import com.pentil.myapplication.Object.Login;
import com.pentil.myapplication.Object.Register;
import com.pentil.myapplication.Object.Resend;
import com.pentil.myapplication.Return.ReturnLogin;
import com.pentil.myapplication.Return.ReturnRegister;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface Client {
    @POST("register")
    Call<ReturnRegister> register(@Body Register register);

    @POST("login")
    Call<ReturnLogin> login(@Body Login login);

    @POST("initiate/createSession")
    Call<ReturnRegister> initial(@Body InitialSession initialSession, @Header("Authorization") String token,@Header("Content-Type") String aplikasi);

    @POST("initiate/resendOTP")
    Call<ReturnRegister> resend(@Body Resend resend, @Header("Authorization") String token,@Header("Content-Type") String aplikasi);

}
