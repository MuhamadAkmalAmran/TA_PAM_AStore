package com.example.ta_pam_astore;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.ta_pam_astore.database.DBController;

import java.util.HashMap;

public class TambahBarang extends AppCompatActivity {
    EditText NBrg, JBrg, JmlBrg;
    Button btnTmbh;
    String Nama, Jenis, Jumlah;
    DBController dbController = new DBController(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah_barang);

        btnTmbh = findViewById(R.id.btnAdd);
        NBrg = findViewById(R.id.edNBrg);
        JBrg = findViewById(R.id.edJenis);
        JmlBrg = findViewById(R.id.edJumlah);

        btnTmbh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Nama = NBrg.getText().toString();
                Jenis = JBrg.getText().toString();
                Jumlah = JmlBrg.getText().toString();

                if (Nama.equals("") || Jenis.equals("") || Jumlah.equals(""))
                {
                    Toast.makeText(getApplicationContext(),"Lengkapi Data",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    HashMap<String, String> queryValues = new HashMap<>();
                    queryValues.put("nama_barang", Nama);
                    queryValues.put("jenis_barang", Jenis);
                    queryValues.put("jumlah_barang", Jumlah);
                    dbController.insertData(queryValues);
                    callhome();
                }

                }


        });
    }

    public void callhome()
    {
        Toast.makeText(getApplicationContext(),"Data Anda Berhasil Di Simpan", Toast.LENGTH_SHORT).show();
        Intent i = new Intent(getApplicationContext(), DaftarBarang.class);
        startActivity(i);
        finish();
    }
}