package com.example.ta_pam_astore;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ProfilActivity extends AppCompatActivity {
    TextView p1, p2, p3, p4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profil);

        //menghubungkan variabel t1 dengan componen TextView pada layout
        p1 = findViewById(R.id.pNama);

        p2 = findViewById(R.id.pEmail);

        p3 = findViewById(R.id.pTelpon);

        p4 = findViewById(R.id.pPassword);

        Bundle bundle = getIntent().getExtras();

        String tNama = bundle.getString("nama");

        String tEmail = bundle.getString("email");

        String tTelpon = bundle.getString("telpon");

        String tPass = bundle.getString("pass");

        p1.setText(tNama);

        p2.setText(tEmail);

        p3.setText(tTelpon);

        p4.setText(tPass);
    }
}