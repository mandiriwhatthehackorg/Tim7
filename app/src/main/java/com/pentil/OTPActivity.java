package com.pentil;

import android.app.Dialog;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.RequiresApi;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.goodiebag.pinview.Pinview;
import com.pentil.myapplication.Client;
import com.pentil.myapplication.Constant.Value;
import com.pentil.myapplication.HomeReksaActivity;
import com.pentil.myapplication.KTPActivity;
import com.pentil.myapplication.Login1Activity;
import com.pentil.myapplication.Object.InitialSession;
import com.pentil.myapplication.Object.Resend;
import com.pentil.myapplication.R;
import com.pentil.myapplication.Return.ReturnRegister;
import com.pentil.myapplication.Server;
import com.pentil.myapplication.SplashActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class OTPActivity extends AppCompatActivity {
    private Pinview pin;
    private Button btn;
    private TextView tv;
    Intent intent;
    String nik;
    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otp);
        Toolbar toolbar = findViewById(R.id.toolbar);
        intent = getIntent();
        nik = intent.getStringExtra("nik");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        pin = findViewById(R.id.pinview);
        pin.setTextColor(getColor(R.color.colorkuning));
        LayoutInflater inflater = getLayoutInflater();
        final View layout = inflater.inflate(R.layout.toast,
                (ViewGroup) findViewById(R.id.toast_layout_root));
        tv = findViewById(R.id.resendOtp);
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                send(new Resend(nik));
            }
        });
        btn = findViewById(R.id.done_otp);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final Dialog dialog = new Dialog(OTPActivity.this);
                dialog.setContentView(R.layout.toast);
                dialog.show();
                new Handler().postDelayed(new Runnable(){
                    @Override
                    public void run() {
                        /* Create an Intent that will start the Menu-Activity. */
                        Intent mainIntent = new Intent(OTPActivity.this, KTPActivity.class);
                        OTPActivity.this.startActivity(mainIntent);
                        OTPActivity.this.finish();
                    }
                }, 1000);
            }
        });
    }
    public void send(Resend i){
        Client api = Server.builder().create(Client.class);
        Call<ReturnRegister> resend = api.resend(i,"Bearer "+ Value.token,Value.aplikasi);
        resend.enqueue(new Callback<ReturnRegister>() {
            @Override
            public void onResponse(Call<ReturnRegister> call, Response<ReturnRegister> response) {
                if(response.body().getSuccess().equals("true"))
                {
                    Toast.makeText(OTPActivity.this, "Berhasil Dikirim", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(OTPActivity.this, "Data yang anda masukan salah", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ReturnRegister> call, Throwable t) {

            }
        });

    }

}
