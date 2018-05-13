package com.rdr.rodrigocorvera.tarea1labo;

import android.media.Image;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.rdr.rodrigocorvera.tarea1labo.Adapters.PlanetAdapter;
import  com.rdr.rodrigocorvera.tarea1labo.Adapters.ViewPagerAdapter;
import com.rdr.rodrigocorvera.tarea1labo.Fragments.FavoriteFragment;
import com.rdr.rodrigocorvera.tarea1labo.Fragments.PlanetFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public static List<Planet> lstPlanets;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TabLayout tab = findViewById(R.id.tabLayout_id);
        ViewPager pages = findViewById(R.id.viewPager_id);

         ViewPagerAdapter planetAdapter = new ViewPagerAdapter(getSupportFragmentManager());
         planetAdapter.AddFragment(new PlanetFragment(),"Planetas");
         planetAdapter.AddFragment(new FavoriteFragment(), "Favoritos");
         pages.setAdapter(planetAdapter);

         tab.setupWithViewPager(pages);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setElevation(0);

    }

    public void fillPlanets () {
        lstPlanets = new ArrayList<Planet>();
        lstPlanets.add(new Planet("Mercurio", "1er planeta", null));

    }



}
