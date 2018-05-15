package com.rdr.rodrigocorvera.tarea1labo.Adapters;

import android.content.Context;
import android.media.Image;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.rdr.rodrigocorvera.tarea1labo.Fragments.PlanetFragment;
import com.rdr.rodrigocorvera.tarea1labo.MainActivity;
import com.rdr.rodrigocorvera.tarea1labo.Planet;
import com.rdr.rodrigocorvera.tarea1labo.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rodrigo Corvera on 13/5/2018.
 */

public class PlanetAdapter extends RecyclerView.Adapter<PlanetAdapter.MyViewHolder> {

    Context context;
    List<Planet> lstData = new ArrayList<Planet>();

    public PlanetAdapter(Context context, List<Planet> lstData) {
        this.context = context;
        this.lstData = lstData;
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

        if (lstData.get(position).isFavorite()) {
            holder.favorite.setImageResource(R.drawable.ic_star_yellow);
        }else {
            holder.favorite.setImageResource(R.drawable.ic_star_border_black);
        }

        holder.favorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!lstData.get(holder.getAdapterPosition()).isFavorite()) {
                    //Log.d("Nombre", lstData.get(holder.getAdapterPosition()).getName());
                    holder.favorite.setImageResource(R.drawable.ic_star_yellow);
                    lstData.get(holder.getAdapterPosition()).setFavorite(true);
                    PlanetFragment.sm.sendData("","",0);
                }else {
                    holder.favorite.setImageResource(R.drawable.ic_star_border_black);
                    lstData.get(holder.getAdapterPosition()).setFavorite(false);
                    PlanetFragment.sm.sendData("","",0);
                }
            }
        });

        //holder.image.setImageResource(lstData.get(position).getImage());
    }


    @Override
    public int getItemCount() {
        return lstData.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

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

        @Override
        public void onClick(View view) {
            Log.d("Nombre:", name.getText().toString());
        }
    }



}



