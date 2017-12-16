package com.svensapps.checklist;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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

    }


    public void onCheckboxClicked(CheckBox chkbox) {

         MediaPlayer cheerSound = MediaPlayer.create(this, R.raw.cheer1);
         MediaPlayer awwSound = MediaPlayer.create(this, R.raw.aww1);
        if (chkbox.isChecked()) {
            awwSound.stop();
            cheerSound.start();
        } else {
            cheerSound.stop();
            awwSound.start();
        }
    }
}

