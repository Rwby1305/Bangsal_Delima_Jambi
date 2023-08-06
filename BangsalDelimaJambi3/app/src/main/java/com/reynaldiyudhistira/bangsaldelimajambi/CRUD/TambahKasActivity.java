package com.reynaldiyudhistira.bangsaldelimajambi.CRUD;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.reynaldiyudhistira.bangsaldelimajambi.MainActivity;
import com.reynaldiyudhistira.bangsaldelimajambi.R;

public class TambahKasActivity extends AppCompatActivity {

    EditText etPemasukanKas, etPengeluaranKas, etCatatanKas;
    Button btnSimpanKas;
    DatabaseReference db = FirebaseDatabase.getInstance().getReference();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah_kas);

        etPemasukanKas = findViewById(R.id.etPemasukanKas);
        etPengeluaranKas = findViewById(R.id.etPengeluaranKas);
        etCatatanKas = findViewById(R.id.etCatatanKas);
        btnSimpanKas = findViewById(R.id.btnSimpanKas);
        btnSimpanKas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String getPemasukanKas = etPemasukanKas.getText().toString();
                String getPengeluaranKas = etPengeluaranKas.getText().toString();
                String getCatatanKas = etCatatanKas.getText().toString();

                if (getPemasukanKas.isEmpty() || getPengeluaranKas.isEmpty() || getCatatanKas.isEmpty()){
                    etPemasukanKas.setError("Masukkan Pemasukan Hari Ini..");
                    etPengeluaranKas.setError("Masukkan Pengeluaran Hari Ini..");
                    etCatatanKas.setError("Masukkan Tanngal Hari Ini..");
                }else {
                    db.child("Kas").push().setValue(new ModelKasActivity(getPemasukanKas, getPengeluaranKas, getCatatanKas)).addOnSuccessListener(new OnSuccessListener<Void>() {
                        @Override
                        public void onSuccess(Void unused) {
                            Toast.makeText(TambahKasActivity.this, "Data Berhasil Disimpan" ,Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(TambahKasActivity.this, MainActivity.class));
                            finish();
                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(TambahKasActivity.this, "Gagal Menyimpan Data", Toast.LENGTH_SHORT).show();
                        }
                    });
                }
            }
        });
    }
}