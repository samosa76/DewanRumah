package com.samosauus.dewarumah.BeforLogin.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.samosauus.dewarumah.AfterLogin.Activity.MainActivity;
import com.samosauus.dewarumah.R;

public class SignUpActivity extends AppCompatActivity {

    String nama,alamat,email;
    EditText edtNamaLogin,edtAlmatLogin,edtEmailLogin;
    Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        edtNamaLogin = (EditText) findViewById(R.id.edtNamaSU);
        edtAlmatLogin = (EditText)findViewById(R.id.edtAlamatSU);
        edtEmailLogin = (EditText)findViewById(R.id.edtEmailSU);
        btnLogin = (Button)findViewById(R.id.btnSignUp);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                nama = edtNamaLogin.getText().toString();
                alamat = edtAlmatLogin.getText().toString();
                email = edtEmailLogin.getText().toString();

                Intent i = new Intent(getApplicationContext(), MainActivity.class);

                i.getStringExtra(nama);
                i.getStringExtra(alamat);
                i.getStringExtra(email);

                startActivity(i);

            }
        });

    }
}
