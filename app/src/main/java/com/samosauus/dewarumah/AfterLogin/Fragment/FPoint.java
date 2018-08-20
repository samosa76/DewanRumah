package com.samosauus.dewarumah.AfterLogin.Fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.samosauus.dewarumah.AfterLogin.Activity.TokoActivity;
import com.samosauus.dewarumah.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class FPoint extends Fragment {

    Button btnBelanja;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_fpoint, container, false);

        btnBelanja = (Button)v.findViewById(R.id.btnBelanja);

        btnBelanja.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(getActivity(), TokoActivity.class));

            }
        });

        return v;
    }

}
