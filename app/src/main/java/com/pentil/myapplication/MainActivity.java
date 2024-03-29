package com.pentil.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.pentil.myapplication.Object.Register;
import com.pentil.myapplication.Return.ReturnRegister;

import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        try {
            send();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (KeyStoreException e) {
            e.printStackTrace();
        } catch (KeyManagementException e) {
            e.printStackTrace();
        }
    }

    public void send() throws NoSuchAlgorithmException, KeyStoreException, KeyManagementException {
        Client api = Server.builder().create(Client.class);
        Register register = new Register("ariya123@bankmandiri.co.id","tim711","Tim1234567!","1");
        Call<ReturnRegister> registerCall = api.register(register);
        registerCall.enqueue(new Callback<ReturnRegister>() {
            @Override
            public void onResponse(Call<ReturnRegister> call, Response<ReturnRegister> response) {
                Toast.makeText(MainActivity.this, "Berhasil", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<ReturnRegister> call, Throwable t) {

            }
        });

    }
}
