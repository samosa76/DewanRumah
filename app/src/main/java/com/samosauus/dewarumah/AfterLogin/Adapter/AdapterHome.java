package com.samosauus.dewarumah.AfterLogin.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.samosauus.dewarumah.AfterLogin.Activity.DetailMainActivity;
import com.samosauus.dewarumah.R;

/**
 * Created by Asus on 8/4/2018.
 */

public class AdapterHome extends RecyclerView.Adapter<AdapterHome.ViewHolder> {

    private String [] mNProject2 = new String[0];
    private LayoutInflater inflater;
    private Context c;

    public AdapterHome(Context c, String[] NProject2) {

        this.inflater = LayoutInflater.from(c);
        this.mNProject2 = NProject2;
        this.c = c.getApplicationContext();
    }

    @Override
    public AdapterHome.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = inflater.inflate(R.layout.costum_home, parent,false);
        ViewHolder viewHolder = new ViewHolder(v);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(AdapterHome.ViewHolder holder, int position) {

        final String NProject2 = mNProject2[position];
        holder.txtListProject.setText(NProject2);
        holder.imgListProject.setImageResource(R.mipmap.ic_launcher);
        holder.cvListProject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(c, DetailMainActivity.class);
                i.putExtra("nama",NProject2);
                c.startActivity(i);

            }
        });

    }

    @Override
    public int getItemCount() {
        return mNProject2.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imgListProject;
        TextView txtListProject;
        CardView cvListProject;

        public ViewHolder(View itemView) {
            super(itemView);

            cvListProject = (CardView)itemView.findViewById(R.id.cvListProject);
            imgListProject = (ImageView) itemView.findViewById(R.id.imgListProject);
            txtListProject = (TextView)itemView.findViewById(R.id.txtListProject);

        }
    }
}
