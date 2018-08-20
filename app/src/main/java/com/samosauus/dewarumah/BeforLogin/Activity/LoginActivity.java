package com.samosauus.dewarumah.BeforLogin.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.samosauus.dewarumah.AfterLogin.Activity.MainActivity;
import com.samosauus.dewarumah.R;

public class LoginActivity extends AppCompatActivity {

    EditText edtAlamatLogin,edtNamaLogin;
    String nama,alamat;
    Button btnClik;
    TextView txtSignUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        edtAlamatLogin = (EditText)findViewById(R.id.edtAlamatLogin);
        edtNamaLogin = (EditText)findViewById(R.id.edtNamaLogin);
        btnClik = (Button)findViewById(R.id.btnLogin);
        txtSignUp = (TextView)findViewById(R.id.txtSignUp);

        btnClik.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                nama = edtNamaLogin.getText().toString();
                alamat = edtAlamatLogin.getText().toString();

                Intent i = new Intent(getApplicationContext(), MainActivity.class);

                i.putExtra("nama",nama );
                i.putExtra("alamat",alamat );

                startActivity(i);
                finish();

            }
        });

        txtSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplication(),SignUpActivity.class));
            }
        });

    }
}
