package com.simplepagewebdesign.futurevalue2;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toolbar;


import java.text.DecimalFormat;
import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {
    private EditText presentValue;
    private TextView futureValueResult;
    private TextView aboutToSpend;
    private TextView futureValueText;
    private Button calcButton;
    private Button clearButton;
    private Toolbar menu;
    private static final String LOG_TAG = MainActivity.class.getSimpleName();
    public static final String EXTRA_MESSAGE =
            "com.example.android.FutureValue2.extra.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent = getIntent();
        final String years = intent.getStringExtra(MenuActivity.yearsMessage);
        final String rate = intent.getStringExtra(MenuActivity.rateMessage);
        if (years == null && rate == null) {
            launchMenu();
        }

        calcButton = (Button) findViewById(R.id.calculateButton);
        clearButton = (Button) findViewById(R.id.clearButton);

        presentValue = (EditText) findViewById(R.id.presentValue);
        presentValue.setInputType(InputType.TYPE_CLASS_NUMBER);

        aboutToSpend = (TextView) findViewById(R.id.aboutToSpend);

        futureValueText = (TextView) findViewById(R.id.futureValueText);
        if (years != null) {
            futureValueText.setText("Value in " + years + " years:");
        }
        futureValueResult = (TextView) findViewById(R.id.futureValueResult);

        // This code handles the enter key in the EditText for present value

        presentValue.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_DONE) {
                    returnValue(presentValue.getText().toString(), years, rate);
                    return true;
                }
                return false;
            }
        });
        calcButton.setSoundEffectsEnabled(false);
        calcButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                returnValue(presentValue.getText().toString(), years, rate);

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

    private void launchMenu() {
        Log.d(LOG_TAG, "Button clicked!");
        Intent intent2 = new Intent(this, MenuActivity.class);
        //    String message = mMessageEditText.getText().toString();
        startActivity(intent2);
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

    public String returnValue(String input, String yearsString, String rateString) {
        NumberFormat formatter = new DecimalFormat("#0.00");
        if (input.length() > 0) {
            try {
                final MediaPlayer cashSound = MediaPlayer.create(this, R.raw.cashsound);
                cashSound.start();
                futureValueResult.setVisibility(View.VISIBLE);
                futureValueText.setVisibility(View.VISIBLE);
                aboutToSpend.setVisibility(View.INVISIBLE);
                presentValue.setVisibility(View.INVISIBLE);


                double inFloat = Double.parseDouble(input);

                double rate = Double.parseDouble(rateString) / 100;
                double years = Double.parseDouble(yearsString);
                double outFloat = inFloat * Math.pow((1 + rate), years);
                String answerReturn = formatter.format(outFloat);
                futureValueResult.setText("$" + answerReturn);

                return formatter.format(outFloat);

            } catch (NumberFormatException e) {
                futureValueResult.setText("Invalid Input");
                return null;
            }
        }
        else{
            return null;
        }
    }


    public void launchMenu(View view) {
        Log.d(LOG_TAG, "Button clicked!");
        Intent intent2 = new Intent(this, MenuActivity.class);
        //    String message = mMessageEditText.getText().toString();
        startActivity(intent2);
    }
}
