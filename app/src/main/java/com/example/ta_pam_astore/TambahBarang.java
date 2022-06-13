package com.example.ta_pam_astore;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class TambahBarang extends AppCompatActivity {
    EditText IdBrg, NBrg, JBrg, JmlBrg;
    Button btnTmbh;
    String Id, Nama, Jenis, Jumlah;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah_barang);

        btnTmbh = findViewById(R.id.btnAdd);
        IdBrg = findViewById(R.id.edId);
        NBrg = findViewById(R.id.edNBrg);
        JBrg = findViewById(R.id.edJenis);
        JmlBrg = findViewById(R.id.edJumlah);

        btnTmbh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Id = IdBrg.getText().toString();
                Nama = NBrg.getText().toString();
                Jenis = JBrg.getText().toString();
                Jumlah = JmlBrg.getText().toString();

                if (Id.isEmpty() && Nama.isEmpty() && Jenis.isEmpty() && Jumlah.isEmpty())
                {
                    Toast.makeText(getApplicationContext(),"Isi Data Barang Anda", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"Data Anda Berhasil Di Simpan",Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(getApplicationContext(), DaftarBarang.class);
                    startActivity(i);
                }
                }


        });
    }
}