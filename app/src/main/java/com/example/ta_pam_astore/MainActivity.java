package com.example.ta_pam_astore;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText etUser, etPass;
    Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etUser = (EditText) findViewById(R.id.edUser);
        etPass = (EditText) findViewById(R.id.edPass);
        btnLogin = (Button) findViewById(R.id.btnLogin);

        setTitle("Login");

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = etUser.getText().toString();
                String pass = etPass.getText().toString();

                if (user.isEmpty() && pass.isEmpty()) {
                    etUser.setError("Username diperlukan");
                    etPass.setError("Password diperlukan");

                }
                else if(user.equals("admin") && pass.equals("admin"))
                {
                    Toast.makeText(MainActivity.this, "Login Sukses", Toast.LENGTH_LONG).show();
                    Intent i = new Intent(getApplicationContext(), HomeActivity.class);
                    startActivity(i);
                }
                else if (user.equals("admin") && pass != ("admin"))
                {
                    Toast.makeText(MainActivity.this, "Password Salah", Toast.LENGTH_LONG).show();
                }
                else if (user!=("admin") && pass.equals("admin"))
                {
                    Toast.makeText(MainActivity.this, "Username Salah", Toast.LENGTH_LONG).show();
                }
            }
        });

    }
}