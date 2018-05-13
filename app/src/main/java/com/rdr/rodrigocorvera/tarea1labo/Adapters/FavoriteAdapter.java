package com.rdr.rodrigocorvera.tarea1labo.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

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
    List<Planet> lstData = new ArrayList<Planet>();


    public FavoriteAdapter(Context context, List<Planet> lstData) {
        this.context = context;
        this.lstData = lstData;
    }


    @Override
    public FavoriteAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.card_view,parent,false);
        final MyViewHolder viewHolder= new FavoriteAdapter.MyViewHolder(v);
        return viewHolder;

    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        holder.name.setText(lstData.get(position).getName());
        holder.desc.setText(lstData.get(position).getDescription());
        holder.favorite.setImageResource(R.drawable.ic_star_yellow);
        holder.favorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!lstData.get(holder.getAdapterPosition()).isFavorite()) {
                    holder.favorite.setImageResource(R.drawable.ic_star_yellow);
                    lstData.get(holder.getAdapterPosition()).setFavorite(true);
                }else {
                    holder.favorite.setImageResource(R.drawable.ic_star_border_black);
                    lstData.get(holder.getAdapterPosition()).setFavorite(false);
                }
            }
        });
        //holder.image.setImageResource(lstData.get(position).getImage());

    }

    @Override
    public int getItemCount() {
        return 0;
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
