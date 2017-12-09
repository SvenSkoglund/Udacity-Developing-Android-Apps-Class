package com.simplepagewebdesign.futurevalue2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MenuActivity extends AppCompatActivity {

    public EditText interestRate;
    public EditText years;
    public Button submitButton;
    public Button resetButton;
    public static final String yearsMessage =
            "com.example.android.FutureValue2.extra.MESSAGE";
    public static final String rateMessage =
            "com.example.android.FutureValue2.extra.MESSAGE2";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        interestRate = (EditText) findViewById(R.id.interestRate);
        years = (EditText) findViewById(R.id.years);
        submitButton = (Button) findViewById(R.id.submitButton);
        resetButton = (Button) findViewById(R.id.resetButton);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onSubmit();
            }
        });

    }

    public void onSubmit() {
        Intent intent = new Intent(this, MainActivity.class);
        String yearsString = years.getText().toString();
        String rateString = interestRate.getText().toString();
        intent.putExtra(yearsMessage,yearsString);
        intent.putExtra(rateMessage,rateString);
        startActivity(intent);
    }

    public void resetValues(View view) {
        interestRate.setText("10");
        years.setText("20");
    }
}