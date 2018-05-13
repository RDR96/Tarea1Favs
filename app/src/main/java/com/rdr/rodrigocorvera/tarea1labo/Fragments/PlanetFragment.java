package com.rdr.rodrigocorvera.tarea1labo.Fragments;


import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rdr.rodrigocorvera.tarea1labo.Adapters.PlanetAdapter;
import com.rdr.rodrigocorvera.tarea1labo.MainActivity;
import com.rdr.rodrigocorvera.tarea1labo.R;

/**
 * Created by Rodrigo Corvera on 12/5/2018.
 */

public class PlanetFragment extends Fragment {


    RecyclerView recyclerView;

    public PlanetFragment() {

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.planet_activity,container,false);
        recyclerView  = v.findViewById(R.id.planet_recycleView);
        PlanetAdapter planetAdapter = new PlanetAdapter(getContext(), MainActivity.lstPlanets);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(planetAdapter);
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


}
