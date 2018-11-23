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

public class TabFragment2 extends Fragment {
    private final static int MAX_VOLUME = 100;
    Context context;
    private Boolean isRecording;
    private String path;
    MediaPlayer mPlayer;
    MediaRecorder recorder;



    private TextView textView;
    public TabFragment2(){


    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tab_fragment2,container,false);
        //textView = (TextView) view.findViewById(R.id.txt_display);
        //textView.setText(getArguments().getString("message"));
        //textView.setText("hello2");
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
        Button insightBtn = (Button) view.findViewById(R.id.btn_pattywhack);
        final MediaPlayer insight = MediaPlayer.create(context, R.raw.luc_pattywhack);
        insightBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                insight.start();
            }
        });
        Button investigateBtn = (Button) view.findViewById(R.id.btn_hallo);
        final MediaPlayer investigate = MediaPlayer.create(context, R.raw.georgiana_hallo);
        investigateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                investigate.start();
            }
        });
        Button AppleSocksBtn = (Button) view.findViewById(R.id.btn_apple_socks);
        final MediaPlayer applesocks = MediaPlayer.create(context, R.raw.jonathan_apple_socks);
        AppleSocksBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                applesocks.start();
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

