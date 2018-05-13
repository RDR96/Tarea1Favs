package com.rdr.rodrigocorvera.tarea1labo.Fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
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


    public static List<Planet> lstFavorite;
    public static RecyclerView rv;
    private static Context context;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.planet_activity, container, false);
        rv = view.findViewById(R.id.planet_recycleView);
        FavoriteAdapter favoriteAdapter = new FavoriteAdapter(getContext(), MainActivity.lstPlanets);
        rv.setLayoutManager(new LinearLayoutManager(getActivity()));
        rv.setAdapter(favoriteAdapter);
        return rv;
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
                lstFavorite.add(new Planet(planet.getName(),planet.getDescription(), null,planet.isFavorite(),counter));
                counter++;
            }
        }



        FavoriteAdapter favoriteAdapter = new FavoriteAdapter(getContext(), MainActivity.lstPlanets);
        rv.setLayoutManager(new LinearLayoutManager(getActivity()));
        rv.setAdapter(favoriteAdapter);
    }
}
