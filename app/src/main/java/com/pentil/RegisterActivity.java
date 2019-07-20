package com.pentil;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import com.pentil.myapplication.BuildConfig;
import com.pentil.myapplication.Client;
import com.pentil.myapplication.Constant.Value;
import com.pentil.myapplication.LoginActivity;
import com.pentil.myapplication.Object.InitialSession;
import com.pentil.myapplication.Object.Login;
import com.pentil.myapplication.R;
import com.pentil.myapplication.Return.ReturnLogin;
import com.pentil.myapplication.Return.ReturnRegister;
import com.pentil.myapplication.Server;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterActivity extends AppCompatActivity {
    private DatePickerDialog datePickerDialog;
    private SimpleDateFormat dateFormatter;
    private Button btn;
    InitialSession objct;
    EditText date,email,phone,nik;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        date = findViewById(R.id.date);
        date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDateDialog();
            }
        });
        btn = findViewById(R.id.done_regis);
        email = findViewById(R.id.et_email);
        phone = findViewById(R.id.et_phone);
        nik = findViewById(R.id.nik);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                objct = new InitialSession(email.getText().toString(),nik.getText().toString(),nik.getText().toString(),date.getText().toString());
                send(objct);
//                startActivity(new Intent(RegisterActivity.this,OTPActivity.class));
            }
        });
    }

    public void send(final InitialSession i){
        Client api = Server.builder().create(Client.class);
        Call<ReturnRegister> registerCall = api.initial(i,"Bearer "+ Value.token,Value.aplikasi);
        registerCall.enqueue(new Callback<ReturnRegister>() {
            @Override
            public void onResponse(Call<ReturnRegister> call, Response<ReturnRegister> response) {
                if(response.body().getSuccess().equals("true"))
                {
                   Intent intent = new Intent(RegisterActivity.this,OTPActivity.class);
                   intent.putExtra("nik",nik.getText().toString());
                   startActivity(intent);
                }
                else
                {
                    Toast.makeText(RegisterActivity.this, "Data yang anda masukan salah", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ReturnRegister> call, Throwable t) {

            }
        });
    }
    private void showDateDialog(){

        /**
         * Calendar untuk mendapatkan tanggal sekarang
         */
        Calendar newCalendar = Calendar.getInstance();

        /**
         * Initiate DatePicker dialog
         */
        datePickerDialog = new DatePickerDialog(this,R.style.DialogTheme, new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {

                /**
                 * Method ini dipanggil saat kita selesai memilih tanggal di DatePicker
                 */

                /**
                 * Set Calendar untuk menampung tanggal yang dipilih
                 */
                Calendar newDate = Calendar.getInstance();
                newDate.set(year, monthOfYear, dayOfMonth);

                /**
                 * Update TextView dengan tanggal yang kita pilih
                 */
                date.setText( new SimpleDateFormat("dd/MM/yyyy").format(newDate.getTime()));
            }

        },newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));

        /**
         * Tampilkan DatePicker dialog
         */
        datePickerDialog.show();
    }

}
