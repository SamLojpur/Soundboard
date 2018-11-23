package com.example.samspc.tutorial;

import android.content.Context;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.io.File;

/**
 * Created by User on 2/28/2017.
 */

public class TabFragment3 extends Fragment {
    private final static int MAX_VOLUME = 100;




    Button btn1;
    Context context;
    public TabFragment3(){


    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tab_fragment3,container,false);
        //textView = (TextView) view.findViewById(R.id.txt_display);
        //textView.setText(getArguments().getString("message"));
        //textView.setText("hello2");
        return view;
    }

    public void onViewCreated (View view, Bundle savedInstanceState) {
        // Setup any handles to view objects here
        // EditText etFoo = (EditText) view.findViewById(R.id.etFoo);
        context = getContext();

        String path = Environment.getExternalStorageDirectory().toString()+"/page3";
        //String path = context.getExternalCacheDir().getAbsolutePath() + "/page3";

        Log.d("Files", "Path: " + path);
        File directory = new File(path);
        File[] files = directory.listFiles();
        Log.d("Files", "Size: "+ files.length);

        for(int i = 0; i < files.length; i++)
        {
            Log.d("Files", "FileName:" + files[i].getName());
        }


        LinearLayout layout = (LinearLayout) view.findViewById(R.id.scrollable_linear);

        for (int i = 0; i < files.length; i++) {
            i = i+0;
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT);
            Button btn = new Button(this.context);
            btn.setId(i);
            final int id_ = btn.getId();
            btn.setText(files[i].getName().substring(0, files[i].getName().lastIndexOf('.'))
            );
            Log.d("Button","button " + id_);
            //btn.setBackgroundColor(Color.rgb(70, 80, 90));
            layout.addView(btn, params);
            btn1 = ((Button) view.findViewById(id_));

            final MediaPlayer alex5minutesMP = MediaPlayer.create(this.context, Uri.parse(path + "/" + files[i].getName()));
            final float volume = (float) (1 - (Math.log(MAX_VOLUME - 100) / Math.log(MAX_VOLUME)));
            alex5minutesMP.setVolume(volume, volume);


            btn1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Toast.makeText(view.getContext(),
                            "Button clicked index = " + id_, Toast.LENGTH_SHORT)
                            .show();
                    alex5minutesMP.start();

                }
            });
        }



        Button alex5minutesBtn = (Button) view.findViewById(R.id.btn_5Minutes);
        final MediaPlayer alex5minutesMP = MediaPlayer.create(this.context, R.raw.alex_5minutes);
        final float volume = (float) (1 - (Math.log(MAX_VOLUME - 100) / Math.log(MAX_VOLUME)));
        alex5minutesMP.setVolume(volume, volume);
        alex5minutesBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alex5minutesMP.start();
            }
        });


    }

}

