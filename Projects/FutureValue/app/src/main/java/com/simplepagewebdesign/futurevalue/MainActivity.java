package com.simplepagewebdesign.futurevalue;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.InputMismatchException;

import static android.R.attr.format;

public class MainActivity extends AppCompatActivity {
    private EditText presentValue;
    private TextView futureValueResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        presentValue = (EditText) findViewById(R.id.presentValue);
        futureValueResult = (TextView) findViewById(R.id.futureValueResult);
        final Button calcButton = (Button) findViewById(R.id.calculateButton);
        calcButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                returnValue(presentValue.getText().toString());
                // Code here executes on main thread after user presses button
            }
        });
        final Button clearButton = (Button) findViewById(R.id.clear);
        clearButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                clearValues();
                //Code here executes on main threa10d after user presses button
            }
        });
    }



    public void clearValues() {
        presentValue.setText("");
        futureValueResult.setText("");
    }

    public double returnValue(String input) {

        double inFloat = Double.parseDouble(input);
        double rate = .1;
        double years = 20;
        double outFloat = inFloat * Math.pow((1f + rate), years);
        try {
            futureValueResult.setText(String.valueOf(outFloat));
        }catch(InputMismatchException e){
            e.printStackTrace();
        }
        return outFloat;
    }

}