package com.rdr.rodrigocorvera.tarea1labo.Adapters;

import android.content.Context;
import android.media.Image;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.rdr.rodrigocorvera.tarea1labo.Planet;
import com.rdr.rodrigocorvera.tarea1labo.R;

import java.util.List;

/**
 * Created by Rodrigo Corvera on 13/5/2018.
 */

public class PlanetAdapter extends RecyclerView.Adapter<PlanetAdapter.MyViewHolder> {

    Context context;
    List<Planet> lstData;

    public PlanetAdapter(Context context, List<Planet> lstData) {
        this.context = context;
        lstData = lstData;
    }

    @Override
    public PlanetAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.card_view,parent,false);
        final MyViewHolder myviewHolder= new MyViewHolder(v);
        return myviewHolder;
    }


    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        holder.name.setText(lstData.get(position).getName());
        holder.desc.setText(lstData.get(position).getDescription());
        holder.image.setImageResource(lstData.get(position).getImage());
    }


    @Override
    public int getItemCount() {
        return lstData.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        private LinearLayout item_contact;
        private TextView name;
        private TextView desc;
        private ImageView image;
        private ImageView favorite;

        public MyViewHolder (View itemView){
            super(itemView);

            name = itemView.findViewById(R.id.name_id);
            desc = itemView.findViewById(R.id.desc_id);
            image = itemView.findViewById(R.id.image_card);
            favorite = itemView.findViewById(R.id.favorite_image);
        }


    }



}



