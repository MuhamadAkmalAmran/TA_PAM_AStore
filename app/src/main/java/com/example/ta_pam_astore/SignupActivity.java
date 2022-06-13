package com.example.ta_pam_astore;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignupActivity extends AppCompatActivity {
    EditText ednama, edemail, edpass, edtelpon;
    Button btnSign;
    String nama, email, pass, telpon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        ednama = findViewById(R.id.edNama);
        edemail = findViewById(R.id.edEmails);
        edpass = findViewById(R.id.edPassword);
        edtelpon = findViewById(R.id.edTelpon);
        btnSign = findViewById(R.id.btnSingup);

        btnSign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nama = ednama.getText().toString();
                email = edemail.getText().toString();
                telpon = edtelpon.getText().toString();
                pass = edpass.getText().toString();

                if (nama.isEmpty() && email.isEmpty() && telpon.isEmpty() && pass.isEmpty())
                {
                    Toast.makeText(getApplicationContext(),"Isi Semua Data dengan Benar",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(getApplicationContext(), "Sign Up Sukses", Toast.LENGTH_SHORT).show();

                    Bundle b = new Bundle();

                    b.putString("nama", nama.trim());

                    b.putString("email",email.trim());

                    b.putString("telpon", telpon.trim());

                    b.putString("pass", pass.trim());

                    Intent i = new Intent(getApplicationContext(), HomeActivity.class);
                    i.putExtras(b);

                    startActivity(i);
                }
            }
        });

    }
}