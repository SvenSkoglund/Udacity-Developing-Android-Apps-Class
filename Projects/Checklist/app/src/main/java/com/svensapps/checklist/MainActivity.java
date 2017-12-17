package com.svensapps.checklist;

import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.media.MediaPlayer;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import static java.lang.Math.random;


public class MainActivity extends AppCompatActivity {

    public MediaPlayer mp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#F4F2F3")));
        actionBar.setTitle(Html.fromHtml("<font color=#FF7000 >Mediation Goals</font>"));

        final CheckBox chk1 = (CheckBox) findViewById(R.id.chk1);
        chk1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onCheckboxClicked(chk1);
            }
        });
        final CheckBox chk2 = (CheckBox) findViewById(R.id.chk2);
        chk2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onCheckboxClicked(chk2);
            }
        });
        final CheckBox chk3 = (CheckBox) findViewById(R.id.chk3);
        chk3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onCheckboxClicked(chk3);
            }
        });
        final CheckBox chk4 = (CheckBox) findViewById(R.id.chk4);
        chk4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onCheckboxClicked(chk4);
            }
        });
        final CheckBox chk5 = (CheckBox) findViewById(R.id.chk5);
        chk5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onCheckboxClicked(chk5);
            }
        });
        final CheckBox chk6 = (CheckBox) findViewById(R.id.chk6);
        chk6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onCheckboxClicked(chk6);
            }
        });
        final CheckBox chk7 = (CheckBox) findViewById(R.id.chk7);
        chk7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onCheckboxClicked(chk7);
            }
        });

    }


    public void onCheckboxClicked(CheckBox chkbox) {
        int rand = (int) (Math.random()*100);
        if (chkbox.isChecked()) {
            stopPlaying();
            if (rand < 26) {
                mp = MediaPlayer.create(this, R.raw.cheer1);
                mp.start();
            }
            if (rand > 25 && rand < 51) {
                mp = MediaPlayer.create(this, R.raw.cheer2);
                mp.start();
            }
            if (rand > 50 && rand < 76) {
                mp = MediaPlayer.create(this, R.raw.cheer3);
                mp.start();
            }
            if (rand > 75 && rand <= 100) {
                mp = MediaPlayer.create(this, R.raw.cheer4);
                mp.start();
            }
        }
//         else {
//            stopPlaying();
//            if (rand < 26) {
//                mp = MediaPlayer.create(this, R.raw.aww1);
//                mp.start();
//            }
//            if (rand > 25 && rand < 51){
//                mp = MediaPlayer.create(this,R.raw.aww2);
//                mp.start();
//            }
//            if (rand > 50 && rand < 76){
//                mp = MediaPlayer.create(this,R.raw.aww3);
//                mp.start();
//            }
//            if (rand > 75 && rand <= 100) {
//                mp = MediaPlayer.create(this, R.raw.aww4);
//                mp.start();
//            }
//        }
    }

    private void stopPlaying() {
        if (mp != null) {
            mp.stop();
            mp.release();
            mp = null;
        }
    }
}

