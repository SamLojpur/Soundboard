package com.example.samspc.tutorial;

import android.content.Context;
import android.os.Bundle;
import android.support.transition.ChangeBounds;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import static com.example.samspc.tutorial.R.layout.tab_fragment1;


public class PagerAdapter extends FragmentPagerAdapter{
    int mNumOfTabs;
    public PagerAdapter(FragmentManager fm) {
        super(fm);
    }

    private Context mContext;

    public PagerAdapter(Context context, FragmentManager fm){
        super(fm);
        mContext = context;
    }



    @Override
    public Fragment getItem(int position) {
//        TabFragment1 tabFragment;
//        tabFragment = new TabFragment1();
//        Bundle bundle = new Bundle();
//        bundle.putString("message", "Fragment :" + position);
//        tabFragment.setArguments(bundle);
//        return tabFragment;
        switch(position){
            case 0:
                return new TabFragment1();
            case 1:
                return new TabFragment2();
            case 2:
                return new TabFragment3();
            default:
                return null;
        }



    }

    public CharSequence getPageTitle(int position){

        switch(position){
            case 0:
                return "wow";
            case 1:
                return "wow2";
            case 2:
                return "program";
            default:
                return null;
        }


    }

    @Override
    public int getCount() {
        return 3;
    }
}
