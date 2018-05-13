package com.rdr.rodrigocorvera.tarea1labo;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.rdr.rodrigocorvera.tarea1labo.Adapters.PlanetAdapter;
import  com.rdr.rodrigocorvera.tarea1labo.Adapters.ViewPagerAdapter;
import com.rdr.rodrigocorvera.tarea1labo.Fragments.PlanetFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TabLayout tab = findViewById(R.id.tabLayout_id);
        ViewPager pages = findViewById(R.id.viewPager_id);

         ViewPagerAdapter planetAdapter = new ViewPagerAdapter(getSupportFragmentManager());
         planetAdapter.AddFragment(new PlanetFragment(),"Planetas");

         pages.setAdapter(planetAdapter);

         tab.setupWithViewPager(pages);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setElevation(0);

    }
}
