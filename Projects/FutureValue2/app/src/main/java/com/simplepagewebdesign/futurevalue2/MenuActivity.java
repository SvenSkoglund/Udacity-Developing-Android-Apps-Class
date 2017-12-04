package com.simplepagewebdesign.futurevalue2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class MenuActivity extends AppCompatActivity {

    public EditText interestRate;
    public EditText years;
    public Button submitButton;
    public Button resetButton;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        interestRate = (EditText) findViewById(R.id.interestRate);
        years = (EditText) findViewById(R.id.years);
        submitButton = (Button) findViewById(R.id.submitButton);
        resetButton = (Button) findViewById(R.id.resetButton);


    }
}
