package com.rdr.rodrigocorvera.tarea1labo.Adapters;

import android.app.Fragment;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.rdr.rodrigocorvera.tarea1labo.Fragments.FavoriteFragment;
import com.rdr.rodrigocorvera.tarea1labo.Fragments.PlanetFragment;
import com.rdr.rodrigocorvera.tarea1labo.Planet;
import com.rdr.rodrigocorvera.tarea1labo.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rodrigo Corvera on 13/5/2018.
 */

public class FavoriteAdapter extends RecyclerView.Adapter<FavoriteAdapter.MyViewHolder> {

    Context context;
    List<Planet> lstData;
    public static ImageView favorite;

    public FavoriteAdapter(Context context, List<Planet> lstData) {
        this.context = context;
        this.lstData = lstData;
    }

    @Override
    public FavoriteAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.card_view,parent,false);
        final FavoriteAdapter.MyViewHolder myviewHolder= new FavoriteAdapter.MyViewHolder(v);

        favorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FavoriteFragment.removeItem(myviewHolder.getAdapterPosition(), context);
                FavoriteFragment.smFavorite.sendDataFromFavorite("","", 0);
                //PlanetFragment.sm.sendData("","",0);
            }
        });

        return myviewHolder;
    }


    @Override
    public void onBindViewHolder(final FavoriteAdapter.MyViewHolder holder, final int position) {
        holder.name.setText(lstData.get(position).getName());
        holder.desc.setText(lstData.get(position).getDescription());
        favorite.setImageResource(R.drawable.ic_star_yellow);


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
