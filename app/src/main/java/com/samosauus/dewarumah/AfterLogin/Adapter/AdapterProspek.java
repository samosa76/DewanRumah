package com.samosauus.dewarumah.AfterLogin.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.samosauus.dewarumah.R;

/**
 * Created by Asus on 8/6/2018.
 */

public class AdapterProspek extends RecyclerView.Adapter<AdapterProspek.ViewHolder>{

    private String[] mnamaProspek = new String[0];
    private String[] mnamaPerumahan = new String[0];
    private String[] mnomorProspek = new String[0];
    private LayoutInflater inflater;

    public AdapterProspek(Context context, String[] namaProspek, String[] namaPerumahan, String[] nomorProspek) {

        this.inflater = LayoutInflater.from(context);
        this.mnamaProspek = namaProspek;
        this.mnamaPerumahan = namaPerumahan;
        this.mnomorProspek = nomorProspek;

    }

    @Override
    public AdapterProspek.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = inflater.inflate(R.layout.costum_prospek,parent,false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;

    }

    @Override
    public void onBindViewHolder(AdapterProspek.ViewHolder holder, int position) {

        String namaProspek = mnamaProspek[position];
        String namaPerumahan = mnamaPerumahan[position];

        holder.txtNamaProspek.setText(namaProspek);
        holder.txtNamaPerumahan.setText(namaPerumahan);
        holder.cvProspek.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    @Override
    public int getItemCount() {

        return mnamaPerumahan.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView txtNamaProspek,txtNamaPerumahan;
        LinearLayout cvProspek;

        public ViewHolder(View itemView) {
            super(itemView);

            txtNamaPerumahan = (TextView)itemView.findViewById(R.id.txtNamaPerumahan);
            txtNamaProspek= (TextView)itemView.findViewById(R.id.txtNamaProspek);
            cvProspek = (LinearLayout)itemView.findViewById(R.id.cvProspek);



        }
    }
}
