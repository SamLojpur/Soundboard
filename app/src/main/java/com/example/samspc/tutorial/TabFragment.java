package com.example.samspc.tutorial;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by User on 2/28/2017.
 */

public class TabFragment extends Fragment {
    private TextView textView;
    public TabFragment(){


    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tab_fragment,container,false);
        textView = (TextView) view.findViewById(R.id.txt_display);
        textView.setText(getArguments().getString("message"));

        return view;
    }
}