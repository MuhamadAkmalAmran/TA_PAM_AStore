package com.example.ta_pam_astore;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HomeActivity extends AppCompatActivity {
    Button btn_tmbh, btn_daftar, btn_profil;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        btn_profil = findViewById(R.id.btnProfile);
        btn_tmbh = findViewById(R.id.btnTmbh);
        btn_daftar = findViewById(R.id.btnDaftar);

        btn_profil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Bundle bundle = getIntent().getExtras();

                String tNama = bundle.getString("nama");

                String tEmail = bundle.getString("email");

                String tTelpon = bundle.getString("telpon");

                String tPass = bundle.getString("pass");

                Bundle b = new Bundle();

                b.putString("nama", tNama.trim());

                b.putString("email",tEmail.trim());

                b.putString("telpon", tTelpon.trim());

                b.putString("pass", tPass.trim());


                Intent i = new Intent(getApplicationContext(), ProfilActivity.class);
                i.putExtras(b);
                startActivity(i);
            }
        });

        btn_tmbh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), TambahBarang.class);
                startActivity(i);
            }
        });

        btn_daftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), DaftarBarang.class);
                startActivity(i);
            }
        });


    }
}