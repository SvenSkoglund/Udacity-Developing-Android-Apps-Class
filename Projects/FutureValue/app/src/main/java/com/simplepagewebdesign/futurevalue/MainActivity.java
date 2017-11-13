package com.simplepagewebdesign.futurevalue;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.util.InputMismatchException;
public class MainActivity extends AppCompatActivity {
    private EditText presentValue;
    private TextView futureValueResult;
    private TextView aboutToSpend;
    private TextView futureValueText;
    private Button calcButton;
    private Button clearButton;
    //final Button menuButton = (Button) findViewById(R.id.menuButton);
   // final Button submitButton = (Button) findViewById(R.id.submitButton);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        calcButton = (Button) findViewById(R.id.calculateButton);
        //final Button resetButton = (Button) findViewById(R.id.resetButton);
        clearButton = (Button) findViewById(R.id.clearButton);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        presentValue = (EditText) findViewById(R.id.presentValue);
        futureValueResult = (TextView) findViewById(R.id.futureValueResult);
        futureValueText = (TextView) findViewById(R.id.futureValueText);
        aboutToSpend = (TextView) findViewById(R.id.aboutToSpend);


        // This code handles the enter key in the EditText for present value
        presentValue.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                returnValue(presentValue.getText().toString());
                futureValueResult.setVisibility(View.VISIBLE);
                futureValueText.setVisibility(View.VISIBLE);
                aboutToSpend.setVisibility(View.INVISIBLE);
                presentValue.setVisibility(View.INVISIBLE);
                return false;
            }
        });


        // This code handles the pressing of the "Calculate" button
        calcButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                returnValue(presentValue.getText().toString());
                futureValueResult.setVisibility(View.VISIBLE);
                futureValueText.setVisibility(View.VISIBLE);
                aboutToSpend.setVisibility(View.INVISIBLE);
                presentValue.setVisibility(View.INVISIBLE);
                // Code here executes on main thread after user presses button
            }
        });

//        menuButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                showMenu();
//            }
//        });
//        // This code handles the pressing of the "Clear" button
        clearButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                clearValues();
                futureValueResult.setVisibility(View.INVISIBLE);
                futureValueText.setVisibility(View.INVISIBLE);
                aboutToSpend.setVisibility(View.VISIBLE);
                presentValue.setVisibility(View.VISIBLE);
                //Code here executes on main threa10d after user presses button
            }
        });

    }

//    public void showMenu (){
//        submitButton.setVisibility(View.VISIBLE);
//        resetButton.setVisibility(View.VISIBLE);
//    }


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