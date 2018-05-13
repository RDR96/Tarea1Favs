package com.rdr.rodrigocorvera.tarea1labo.Adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.rdr.rodrigocorvera.tarea1labo.Fragments.PlanetFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rodrigo Corvera on 2/5/2018.
 */

public class ViewPagerAdapter extends FragmentPagerAdapter{


    private final List<Fragment> lsFragment = new ArrayList<Fragment>();
    private final List<String> lstTittle = new ArrayList<>();

    public ViewPagerAdapter (FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return lsFragment.get(position);
    }

    @Override
    public int getCount() {
        return lsFragment.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return lstTittle.get(position);
    }

    public void AddFragment (Fragment fragment, String tittle) {
        lsFragment.add(fragment);
        lstTittle.add(tittle);
    }
}

