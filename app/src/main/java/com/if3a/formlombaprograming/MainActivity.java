package com.if3a.formlombaprograming;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.time.Instant;

public class MainActivity extends AppCompatActivity {
    private EditText etNama, etNoWhatsapp, etAlamat, etPassword, etPin;
    private RadioGroup rgJenisKelamin;
    private RadioButton rbJeniskelamin;
    private Button btnDaftar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNama = findViewById(R.id.et_nama);
        etNoWhatsapp = findViewById(R.id.et_no_wa);
        etAlamat = findViewById(R.id.et_alamat);
        etPassword = findViewById(R.id.et_password);
        etPin = findViewById(R.id.et_pin);
        rgJenisKelamin = findViewById(R.id.rg_jk);
        btnDaftar = findViewById(R.id.btn_daftar);

        btnDaftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String nama = etNama.getText().toString();
                String noWhatsaap = etNoWhatsapp.getText().toString();
                String alamat = etAlamat.getText().toString();
                String password = etPassword.getText().toString();
                String pin = etPin.getText().toString();

                int jenisKelaminID = rgJenisKelamin.getCheckedRadioButtonId();
                rbJeniskelamin = findViewById(jenisKelaminID);

                String jenisKelamin = rbJeniskelamin.getText().toString();

                if (nama.trim().equals("")) {
                    etNama.setError("Nama Tidak Boleh Kosong");
                } else if (noWhatsaap.trim().equals("")) {
                    etNoWhatsapp.setError("No Whatsapp Tidak Boleh Kosong");
                } else if (alamat.trim().equals("")) {
                    etAlamat.setError("Alamat Tidak Boleh Kosong");
                } else if (password.trim().equals("")) {
                    etPassword.setError("Password Tidak Boleh Kosong");
                } else if (pin.trim().equals("")) {
                    etPin.setError("PIN Tidak Boleh Kosong");
                } else{
                    Intent intent = new Intent(MainActivity.this, ConfirmActivity.class) ;
                    intent.putExtra("varNama",nama);
                    intent.putExtra("varNoWhatsapp",noWhatsaap);
                    intent.putExtra("varAlamat",alamat);
                    intent.putExtra("varJenisKelamin",jenisKelamin);
                    startActivity(intent);
                }


            }
        });





    }

    @Override
    protected void onResume() {
        super.onResume();
        etNama.setText("");
        etNoWhatsapp.setText("");
        etAlamat.setText("");
        etPassword.setText("");
        etPin.setText("");
    }
}