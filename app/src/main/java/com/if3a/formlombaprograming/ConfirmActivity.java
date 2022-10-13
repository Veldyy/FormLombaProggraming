package com.if3a.formlombaprograming;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class ConfirmActivity extends AppCompatActivity
{
    DatePickerDialog datePickerDialog;
    TextView tvNama, tvJk, tvNoWhatsapp, tvAlamat,tvTanggal;
    Button btnTanggal,btnKonfirmasi;
    String nama,jk,noWhatsapp,alamat,chooseDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comfirm);

        tvNama = findViewById(R.id.tv_nama);
        tvJk = findViewById(R.id.tv_jeniskelamin);
        tvNoWhatsapp = findViewById(R.id.tv_no_wa);
        tvAlamat = findViewById(R.id.tv_alamatlengkap);
        tvTanggal = findViewById(R.id.tv_tanggal);

        btnTanggal = findViewById(R.id.btn_tanggal);
        btnKonfirmasi = findViewById(R.id.btn_konfirmasi);

        //menampilkan intent dari mainActivity.java
        Intent terima = getIntent();
        nama = terima.getStringExtra("varNama");
        noWhatsapp = terima.getStringExtra("varNoWhatsapp");
        alamat = terima.getStringExtra("varAlamat");
        jk = terima.getStringExtra("varJenisKelamin");

        tvNama.setText(nama);
        tvNoWhatsapp.setText(noWhatsapp);
        tvAlamat.setText(alamat);
        tvJk.setText(jk);

        btnTanggal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar newCalender = Calendar.getInstance();

                datePickerDialog = new DatePickerDialog(ConfirmActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int month, int dayOfMonth) {
                        String tahun = Integer.toString(year);
                        String bulan = Integer.toString(month + 1);
                        String tanggal = Integer.toString(dayOfMonth);
                        chooseDate = tanggal + "/" + bulan + "/" + tahun;
                        tvTanggal.setText(chooseDate);
                    }
                },newCalender.get(Calendar.YEAR), newCalender.get(Calendar.MONTH), newCalender.get(Calendar.DAY_OF_MONTH));

                datePickerDialog.show();
            }
        });

        btnKonfirmasi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder dialog = new AlertDialog.Builder(ConfirmActivity.this);
                dialog.setTitle("Perhatian");
                dialog.setMessage("Apakah Data Yang Anda Isi Telah Benar ? ");

                dialog.setPositiveButton("Ya", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(ConfirmActivity.this, "Terimaksih Pendaftaran Anda Berhasil", Toast.LENGTH_LONG).show();
                        finish();
                    }
                });
                dialog.setNegativeButton("Tidak", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
                dialog.show();
            }
        });
    }
}