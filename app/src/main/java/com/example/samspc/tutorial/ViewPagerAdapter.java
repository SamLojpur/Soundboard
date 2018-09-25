package com.example.samspc.tutorial;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;



public class ViewPagerAdapter extends FragmentPagerAdapter{
    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        TabFragment tabFragment;
        tabFragment = new TabFragment();
        Bundle bundle = new Bundle();
        //bundle.putInt("message", "Fragment :" + position);
        tabFragment.setArguments(bundle);
        return tabFragment;
    }

    @Override
    public int getCount() {
        return 25;
    }
}
