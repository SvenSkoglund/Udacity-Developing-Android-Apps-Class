package com.simplepagewebdesign.futurevalue;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.KeyListener;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.util.InputMismatchException;

import static android.R.attr.format;

public class MainActivity extends AppCompatActivity {
    private EditText presentValue;
    private TextView futureValueResult;
    private TextView aboutToSpend;
    Typeface tf = Typeface.createFromAsset(aboutToSpend.getContext().getAssets(), "fonts/thelightfont.ttf");
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        presentValue = (EditText) findViewById(R.id.presentValue);
        futureValueResult = (TextView) findViewById(R.id.futureValueResult);
        aboutToSpend = (TextView) findViewById(R.id.aboutToSpend);
        aboutToSpend.setTypeface(tf);
        final Button calcButton = (Button) findViewById(R.id.calculateButton);


        // This code handles the enter key in the EditText for present value
        presentValue.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                returnValue(presentValue.getText().toString());
                return false;
            }
        });

        // This code handles the pressing of the "Calculate" button
        calcButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                returnValue(presentValue.getText().toString());
                // Code here executes on main thread after user presses button
            }
        });

        // This code handles the pressing of the "Clear" button
        final Button clearButton = (Button) findViewById(R.id.clear);
        clearButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                clearValues();
                //Code here executes on main threa10d after user presses button
            }
        });

    }


    // This method clears the values in the TextViews
    public void clearValues() {
        presentValue.setText("");
        futureValueResult.setText("");
    }

    //This method takes the presentValue EditText, runs a calculation and puts the new value in the futureValue TextView
    public String returnValue(String input) {
        final DecimalFormat df2 = new DecimalFormat("0.00");
        double inFloat = Double.parseDouble(input);
        double rate = .1;
        double years = 20;
        double outFloat = inFloat * Math.pow((1f + rate), years);
        try {
            futureValueResult.setText("$"+String.valueOf(df2.format(outFloat)));
        }catch(InputMismatchException e){
            e.printStackTrace();
            Toast.makeText(getApplicationContext(),"Invalid character entry,",Toast.LENGTH_LONG).show();
        }
        return df2.format(outFloat);
    }

}