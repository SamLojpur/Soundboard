package com.example.samspc.tutorial;

import android.content.Context;
import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;

/**
 * Created by User on 2/28/2017.
 */

public class TabFragment1 extends Fragment {
    private TextView textView;
    Context context;
    private Boolean isRecording;
    private String path;
    MediaPlayer mPlayer;
    MediaRecorder recorder;





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
    public void onViewCreated (View view, Bundle savedInstanceState) {
        // Setup any handles to view objects here
        // EditText etFoo = (EditText) view.findViewById(R.id.etFoo);
        context = getContext();


        this.path = context.getExternalCacheDir().getAbsolutePath() + "/test.mp4";
        this.isRecording = false;


        final Button recordBtn = (Button) view.findViewById(R.id.btn_record);
        recordBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isRecording) {
                    recordBtn.setText("Record");
                    isRecording = false;
                    stopRecording(recorder);
                } else {
                    recordBtn.setText("Stop");
                    isRecording = true;
                    Toast.makeText(context, String.valueOf(isRecording), Toast.LENGTH_LONG).show();
                    recorder = startRecording();
                }
            }
        });
        Button playBtn = (Button) view.findViewById(R.id.btn_play);
        playBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Boolean isPlaying = false;
                if (isPlaying) {
                    mPlayer.release();
                    mPlayer = null;
                } else {
                    mPlayer = new MediaPlayer();
                    try {
                        mPlayer.setDataSource(path);
                        mPlayer.prepare();
                        mPlayer.start();
                    } catch (IOException e) {
                        Log.e("test", "prepare() failed");
                    }

                }
            }
        });


        Button emergencyBtn = (Button) view.findViewById(R.id.btn_emergency);
        final MediaPlayer emergency = MediaPlayer.create(this.context, R.raw.emergency);
        emergencyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                emergency.start();
            }
        });
        Button insightBtn = (Button) view.findViewById(R.id.btn_insight);
        final MediaPlayer insight = MediaPlayer.create(context, R.raw.insight);
        insightBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                insight.start();
            }
        });
        Button investigateBtn = (Button) view.findViewById(R.id.btn_investigate);
        final MediaPlayer investigate = MediaPlayer.create(context, R.raw.investigate);
        investigateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                investigate.start();
            }
        });

        Button perception_checkBtn = (Button) view.findViewById(R.id.btn_perception_check);
        final MediaPlayer perception_check = MediaPlayer.create(context, R.raw.perception_check);
        perception_checkBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                perception_check.start();
            }
        });
        Button sneak_attackBtn = (Button) view.findViewById(R.id.btn_sneak_attack);
        final MediaPlayer sneak_attack = MediaPlayer.create(context, R.raw.sneak_attack);
        sneak_attackBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sneak_attack.start();
            }
        });
        Button stealthBtn = (Button) view.findViewById(R.id.btn_stealth);
        final MediaPlayer stealth = MediaPlayer.create(context, R.raw.stealth);
        stealthBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stealth.start();
            }
        });
    }

    private MediaRecorder startRecording() {
        MediaRecorder recorder = new MediaRecorder();
        recorder.setAudioSource(MediaRecorder.AudioSource.MIC);
        recorder.setOutputFormat(MediaRecorder.OutputFormat.MPEG_4);
        recorder.setOutputFile(path);
        recorder.setAudioEncoder(MediaRecorder.AudioEncoder.AAC);
        //recorder.setAudioEncoder(MediaRecorder.getAudioSourceMax());

        recorder.setAudioEncodingBitRate(44100 *16);
        recorder.setAudioSamplingRate(44100);

        try {
            recorder.prepare();
            recorder.start();

        } catch (IOException e) {
            Log.e("Test", "prepare() failed");
        }catch (IllegalStateException e) {
            e.printStackTrace();
        }
        return recorder;
    }
    private void stopRecording( MediaRecorder recorder){
        if(recorder != null) {
            recorder.stop();
            recorder.release();
            recorder = null;
        }






    }




}