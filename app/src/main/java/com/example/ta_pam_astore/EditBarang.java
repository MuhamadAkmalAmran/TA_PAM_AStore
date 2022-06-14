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

public class EditBarang extends AppCompatActivity {
    EditText Nama, Jenis, Jumlah;
    Button Update;
    String nama, jenis, jumlah, id;
    DBController dbController = new DBController(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_barang);

        Nama = findViewById(R.id.upNama);
        Jenis = findViewById(R.id.upJenis);
        Jumlah = findViewById(R.id.upJumlah);
        Update = findViewById(R.id.btnUp);

        id = getIntent().getStringExtra("id");
        nama = getIntent().getStringExtra("nama_barang");
        jenis = getIntent().getStringExtra("jenis_barang");
        jumlah = getIntent().getStringExtra("jumlah_barang");

        setTitle("Edit_Barang");
        Nama.setText(nama);
        Jenis.setText(jenis);
        Jumlah.setText(jumlah);

        Update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nama = Nama.getText().toString();
                jenis = Jenis.getText().toString();
                jumlah = Jumlah.getText().toString();

                if (nama.equals("") || jenis.equals("") || jumlah.equals(""))
                {
                    Toast.makeText(getApplicationContext(),"Mohon Isi Data Terlebih Dahulu", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    HashMap<String, String> values = new HashMap<>();
                    values.put("id",id);
                    values.put("nama_barang",nama);
                    values.put("jenis_barang",jenis);
                    values.put("jumlah_barang",jumlah);
                    dbController.UpdateData(values);
                    callHome();
                }
            }
        });
    }

    public void callHome()
    {
        Toast.makeText(getApplicationContext(),"Data Anda Berhasil DiUpdate",Toast.LENGTH_SHORT).show();
        Intent i = new Intent(getApplicationContext(), DaftarBarang.class);
        startActivity(i);
        finish();
    }
}