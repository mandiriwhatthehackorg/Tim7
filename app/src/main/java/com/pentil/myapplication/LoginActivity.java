package com.pentil.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.pentil.myapplication.Object.Login;
import com.pentil.myapplication.Object.Register;
import com.pentil.myapplication.Return.ReturnLogin;
import com.pentil.myapplication.Return.ReturnRegister;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        send();
    }

    public void send(){
        Client api = Server.builder().create(Client.class);
        Login login = new Login("tim7","Tim1234567!");
        Call<ReturnLogin> loginCall = api.login(login);
        loginCall.enqueue(new Callback<ReturnLogin>() {
            @Override
            public void onResponse(Call<ReturnLogin> call, Response<ReturnLogin> response) {
                Toast.makeText(LoginActivity.this, "Berhasil", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<ReturnLogin> call, Throwable t) {

            }
        });

    }
}
