package com.samosauus.dewarumah.AfterLogin.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.samosauus.dewarumah.AfterLogin.Adapter.AdapterProspek;
import com.samosauus.dewarumah.R;

public class ALProspek extends AppCompatActivity {

    AdapterProspek adapterProspek;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alprospek);

        String [] namaProspek = {"Sugeng Aji Prasetya", "Jamaludin Durjabi", "Iko Gilbert", "Albus Severus Potter", "Ilona Ivankha" };
        String [] namaPerumahan = {"Greenland Healthful Living", "Felicity Festival","Felicity Festival","Greenville Darul Istiqomah", "Greenville Cileungsi"};
        String [] nomorProspek = {"081286633518","081736674917","081856297468","0817622098476","081286615396"};

        RecyclerView rvProspek = (RecyclerView)findViewById(R.id.rvDataProspek);

        rvProspek.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        adapterProspek = new AdapterProspek(getApplicationContext(), namaProspek,namaPerumahan,nomorProspek);
        rvProspek.setAdapter(adapterProspek);

    }
}
