package com.rdr.rodrigocorvera.tarea1labo;

import android.graphics.drawable.Drawable;
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

public class MainActivity extends AppCompatActivity implements PlanetFragment.sendMessage, FavoriteFragment.sendMessage{

    public static List<Planet> lstPlanets;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         TabLayout tab = findViewById(R.id.tabLayout_id);
         ViewPager pages = findViewById(R.id.viewPager_id);
         fillPlanets();
         ViewPagerAdapter planetAdapter = new ViewPagerAdapter(getSupportFragmentManager());

         planetAdapter.AddFragment(new PlanetFragment(),"Planetas");
         planetAdapter.AddFragment(new FavoriteFragment(), "Favoritos");
         pages.setAdapter(planetAdapter);

        tab.setupWithViewPager(pages);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setElevation(0);
    }

    @Override
    public void sendData(String name, String number, int option) {
        String tag = "android:switcher:" + R.id.viewPager_id + ":" + 1;
        FavoriteFragment f = (FavoriteFragment) getSupportFragmentManager().findFragmentByTag(tag);
        f.displayReceivedData(name, number, option);
    }

    @Override
    public void sendDataFromFavorite(String name, String number, int option) {
        String tag = "android:switcher:" + R.id.viewPager_id + ":" + 0;
        PlanetFragment f = (PlanetFragment) getSupportFragmentManager().findFragmentByTag(tag);
        f.displayReceivedData(name, number, option);
    }

    public void fillPlanets () {
        lstPlanets = new ArrayList<Planet>();
        lstPlanets.add(new Planet("Mercurio", "1er planeta", null,false,0));
        lstPlanets.add(new Planet("Venus", "2do planeta", null, false,1));
        lstPlanets.add(new Planet("Tierra", "3er planeta", null, false,2));
        lstPlanets.add(new Planet("Marte", "4to planeta", null, false,3));
        lstPlanets.add(new Planet("Jupiter", "5to planeta", null, false,4));
        lstPlanets.add(new Planet("Saturno", "6to planeta", null, false,5));
        lstPlanets.add(new Planet("Urano", "7mo planeta", null, false,6));
        lstPlanets.add(new Planet("Neptuno", "8vo planeta", null, false,7));
    }



}
