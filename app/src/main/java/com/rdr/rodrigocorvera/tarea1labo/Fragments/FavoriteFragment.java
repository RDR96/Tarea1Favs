package com.rdr.rodrigocorvera.tarea1labo.Fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rdr.rodrigocorvera.tarea1labo.Adapters.FavoriteAdapter;
import com.rdr.rodrigocorvera.tarea1labo.Adapters.PlanetAdapter;
import com.rdr.rodrigocorvera.tarea1labo.MainActivity;
import com.rdr.rodrigocorvera.tarea1labo.Planet;
import com.rdr.rodrigocorvera.tarea1labo.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rodrigo Corvera on 13/5/2018.
 */

public class FavoriteFragment extends Fragment {


    public static RecyclerView recyclerView;
    public static FavoriteFragment.sendMessage smFavorite;
    public static ArrayList<Planet> lstFavorite;

    public FavoriteFragment() {

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.favorite_activity,container,false);
        recyclerView  = v.findViewById(R.id.favorite_recycleView);
        return recyclerView;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }


    public void displayReceivedData(String name, String number, int option) {
        lstFavorite = new ArrayList<Planet>();
        int counter = 0;
        for (Planet planet : MainActivity.lstPlanets) {
            if (planet.isFavorite()) {
                lstFavorite.add(new Planet(planet.getName(),planet.getDescription(), null,planet.isFavorite(), planet.getOriginalPosition(), counter));
                counter++;
            }
        }
        FavoriteAdapter favoriteAdapter = new FavoriteAdapter(getContext(), lstFavorite);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        favoriteAdapter.notifyDataSetChanged();
        recyclerView.setAdapter(favoriteAdapter);
    }

    public static void removeItem (int position, Context context) {

        MainActivity.lstPlanets.get(lstFavorite.get(position).getOriginalPosition()).setFavorite(false);
        lstFavorite.remove(position);

        int counter = 0;

        for ( Planet Element : lstFavorite) {
            Element.setFavPos(counter);
            counter++;
        }

        //RecyclerViewAdapterFavorite recyclerViewAdapter2 = new RecyclerViewAdapterFavorite(FragmentContact.context, favoriteData);

        FavoriteAdapter recyclerViewAdapter = new FavoriteAdapter(context, lstFavorite);
        recyclerView.removeViewAt(position);
        recyclerViewAdapter.notifyItemRemoved(position);
        recyclerViewAdapter.notifyItemRangeChanged(position, lstFavorite.size());
        recyclerViewAdapter.notifyDataSetChanged();

    }

    public interface sendMessage{
        void sendDataFromFavorite(String name,String number, int option);
    }


    @Override
    public void onAttach(Context context) {
        Log.d("Mensaje", "Entro en el attach!!!!!!!!!!!");
        super.onAttach(context);
        try {
            smFavorite = (sendMessage) getActivity();
        } catch (ClassCastException e) {
            throw new ClassCastException("Error in retrieving data. Please try again");
        }


    }

}
