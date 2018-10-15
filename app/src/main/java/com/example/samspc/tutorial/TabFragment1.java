package com.example.samspc.tutorial;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by User on 2/28/2017.
 */

public class TabFragment1 extends Fragment {
    private TextView textView;
    public TabFragment1(){


    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tab_fragment1,container,false);
        //textView = (TextView) view.findViewById(R.id.txt_display);
        //textView.setText(getArguments().getString("message"));
        //textView.setText("hello");
        return view;
    }






}