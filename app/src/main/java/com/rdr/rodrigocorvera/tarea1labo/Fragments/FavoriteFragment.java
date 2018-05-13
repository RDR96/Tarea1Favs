package com.rdr.rodrigocorvera.tarea1labo.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rdr.rodrigocorvera.tarea1labo.Planet;
import com.rdr.rodrigocorvera.tarea1labo.R;

import java.util.List;

/**
 * Created by Rodrigo Corvera on 13/5/2018.
 */

public class FavoriteFragment extends android.support.v4.app.Fragment {


    public static List<Planet> lstFavorite;
    public static RecyclerView rv;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.favorite_activity, container, false);
        rv = view.findViewById(R.id.favorite_recycleView);


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
}
