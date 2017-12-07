package com.simplepagewebdesign.futurevalue2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

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
    private Toolbar menu;
    private static final String LOG_TAG = MainActivity.class.getSimpleName();
    public static final String EXTRA_MESSAGE =
            "com.example.android.FutureValue2.extra.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent = getIntent();
        if (intent.hasExtra("yearsMessage") && intent.hasExtra("rateMessage")) {
            final String years = intent.getStringExtra(MenuActivity.yearsMessage);
            final String rate = intent.getStringExtra(MenuActivity.rateMessage);
        }
        if (!intent.hasExtra("yearsMessage") || !intent.hasExtra("rateMessage")) {
            final String years = "20";
            final String rate = ".1";
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
        final String finalYears = years;
        final String finalRate = rate;
        presentValue.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_DONE) {
                    returnValue(presentValue.getText().toString(), finalYears, finalRate);
                    return true;
                }
                return false;
            }
        });
        final String finalYears1 = years;
        final String finalRate1 = rate;
        calcButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                returnValue(presentValue.getText().toString(), finalYears1, finalRate1);

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

    public String returnValue(String input, String yearsString, String rateString) {
        final DecimalFormat df2 = new DecimalFormat("0.00");
        futureValueResult.setVisibility(View.VISIBLE);
        futureValueText.setVisibility(View.VISIBLE);
        aboutToSpend.setVisibility(View.INVISIBLE);
        presentValue.setVisibility(View.INVISIBLE);

        double inFloat = Double.parseDouble(input);
        double rate = .1;
        double years = 20;
        double outFloat = inFloat * Math.pow((1f + rate), years);
        return df2.format(outFloat);

    }


    public void launchMenu(View view) {
        Log.d(LOG_TAG, "Button clicked!");
        Intent intent = new Intent(this, MenuActivity.class);
        //    String message = mMessageEditText.getText().toString();
        startActivity(intent);
    }
}
