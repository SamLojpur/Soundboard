package com.example.samspc.tutorial;

import android.Manifest;
import android.app.ActionBar;
import android.content.Context;
import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.support.design.widget.TabLayout;
import android.support.v4.app.ActivityCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.IOException;

public class MainActivity extends AppCompatActivity{

    private Toolbar toolbar;
    private ViewPager viewPager;
    private PagerAdapter adapter;

    private boolean permissionToRecordAccepted = false;
    private String [] permissions = {Manifest.permission.RECORD_AUDIO, Manifest.permission.WRITE_EXTERNAL_STORAGE};
    MediaRecorder recorder = null;
    private String path;
    MediaPlayer mPlayer;
    Boolean isRecording;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        path = getExternalCacheDir().getAbsolutePath() + "/test.mp4";
        final Context context = this;
        isRecording = false;

        ActivityCompat.requestPermissions(this, permissions, 201);



        viewPager = (ViewPager) findViewById(R.id.pager);
        adapter = new PagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        tabLayout.setupWithViewPager(viewPager);




        /*final Button recordBtn = (Button) findViewById(R.id.btn_record);
        recordBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                if (isRecording){
                    recordBtn.setText("Record");
                    isRecording=false;
                    stopRecording();
                }else {
                    recordBtn.setText("Stop");
                    isRecording=true;
                    Toast.makeText(context, String.valueOf(isRecording), Toast.LENGTH_LONG).show();
                    startRecording();
                }
            }
        });
        Button playBtn = (Button) findViewById(R.id.btn_play);
        playBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Boolean isPlaying = false;
                if (isPlaying){
                    mPlayer.release();
                    mPlayer = null;
                }else {
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
        Button emergencyBtn = (Button) findViewById(R.id.btn_emergency);
        final MediaPlayer emergency = MediaPlayer.create(this, R.raw.emergency);
        emergencyBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                emergency.start();
            }
        });
        Button insightBtn = (Button) findViewById(R.id.btn_insight);
        final MediaPlayer insight = MediaPlayer.create(this, R.raw.insight);
        insightBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                insight.start();
            }
        });
        Button investigateBtn = (Button) findViewById(R.id.btn_investigate);
        final MediaPlayer investigate = MediaPlayer.create(this, R.raw.investigate);
        investigateBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                investigate.start();
            }
        });

        Button perception_checkBtn = (Button) findViewById(R.id.btn_perception_check);
        final MediaPlayer perception_check = MediaPlayer.create(this, R.raw.perception_check);
        perception_checkBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                perception_check.start();
            }
        });
        Button sneak_attackBtn = (Button) findViewById(R.id.btn_sneak_attack);
        final MediaPlayer sneak_attack = MediaPlayer.create(this, R.raw.sneak_attack);
        sneak_attackBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                sneak_attack.start();
            }
        });
        Button stealthBtn = (Button) findViewById(R.id.btn_stealth);
        final MediaPlayer stealth = MediaPlayer.create(this, R.raw.stealth);
        stealthBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                stealth.start();
            }
        });*/



    }
    private void startRecording() {
        recorder = new MediaRecorder();
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
    }
    private void stopRecording(){
        if(recorder != null) {
            recorder.stop();
            recorder.release();
            recorder = null;
        }


    }



}
