package com.simplepagewebdesign.futurevalue;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
    public void clearValues () {

    }

    public float returnValue (int input){
        float output = input;
        return output;
    }
}