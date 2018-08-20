package com.samosauus.dewarumah.AfterLogin.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.samosauus.dewarumah.R;

public class DetailMainActivity extends AppCompatActivity {

    TextView txtAfterLoginProject;

    String nama;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_main);

        txtAfterLoginProject = (TextView)findViewById(R.id.txtAfterLoginProject);

        nama = getIntent().getStringExtra("nama");

        txtAfterLoginProject.setText(nama);

    }
}
