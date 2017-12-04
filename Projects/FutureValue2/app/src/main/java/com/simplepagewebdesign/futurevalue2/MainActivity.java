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
        String years = intent.getStringExtra(MenuActivity.yearsMessage);
        String rate = intent.getStringExtra(MenuActivity.rateMessage);
       // menu = (Toolbar) findViewById(R.id.settingsButton);

        calcButton = (Button) findViewById(R.id.calculateButton);
        clearButton = (Button) findViewById(R.id.clearButton);

        presentValue = (EditText) findViewById(R.id.presentValue);
        presentValue.setInputType(InputType.TYPE_CLASS_NUMBER);

        aboutToSpend = (TextView) findViewById(R.id.aboutToSpend);

        futureValueText = (TextView) findViewById(R.id.futureValueText);
        futureValueResult = (TextView) findViewById(R.id.futureValueResult);

        // This code handles the enter key in the EditText for present value
        presentValue.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if(actionId == EditorInfo.IME_ACTION_DONE){
                    returnValue(presentValue.getText().toString());
                    return true;
                }
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

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.menu, menu);
//        return true;
//    }

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


    public void launchMenu(View view) {
        Log.d(LOG_TAG, "Button clicked!");
        Intent intent = new Intent(this,MenuActivity.class);
    //    String message = mMessageEditText.getText().toString();
        startActivity(intent);
    }
}
