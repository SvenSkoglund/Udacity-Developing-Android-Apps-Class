package com.simplepagewebdesign.futurevalue2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.text.DecimalFormat;
import java.util.InputMismatchException;

public class MainActivity extends AppCompatActivity {
    private EditText presentValue;
    private TextView futureValueResult;
    private TextView aboutToSpend;
    private TextView futureValueText;
    private Button calcButton;
    private Button clearButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        calcButton = (Button) findViewById(R.id.calculateButton);
        clearButton = (Button) findViewById(R.id.clearButton);

        presentValue = (EditText) findViewById(R.id.presentValue);
        aboutToSpend = (TextView) findViewById(R.id.aboutToSpend);

        futureValueText = (TextView) findViewById(R.id.futureValueText);
        futureValueResult = (TextView) findViewById(R.id.futureValueResult);

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
        calcButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                returnValue(presentValue.getText().toString());

                // Code here executes on main thread after user presses button
            }
        });
        //        // This code handles the pressing of the "Clear" button
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
        futureValueResult.setVisibility(View.INVISIBLE);
        futureValueText.setVisibility(View.INVISIBLE);
        aboutToSpend.setVisibility(View.VISIBLE);
        presentValue.setVisibility(View.VISIBLE);

    }

    public String returnValue(String input) {
        final DecimalFormat df2 = new DecimalFormat("0.00");
        double inFloat = Double.parseDouble(input);
        double rate = .1;
        double years = 20;
        double outFloat = inFloat * Math.pow((1f + rate), years);
        try {
            futureValueResult.setText("$" + String.valueOf(df2.format(outFloat)));
        } catch (InputMismatchException e) {
            e.printStackTrace();
            Toast.makeText(getApplicationContext(), "Invalid character entry,", Toast.LENGTH_LONG).show();
        }
        futureValueResult.setVisibility(View.VISIBLE);
        futureValueText.setVisibility(View.VISIBLE);
        aboutToSpend.setVisibility(View.INVISIBLE);
        presentValue.setVisibility(View.INVISIBLE);
        return df2.format(outFloat);
    }

}
