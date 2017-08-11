package com.example.tngp17_001.homework2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    protected static TextView valueText;
    protected static TextView signText;
    protected int sumValue = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        valueText = (TextView) findViewById(R.id.value);
        signText = (TextView) findViewById(R.id.sign);
    }

    protected void onClickNumButton(View view) {
        Button b = (Button) view;
        String buttonText = b.getText().toString();
        int oldValue = 0;
        int newValue = Integer.parseInt(buttonText);
        try {
            oldValue = Integer.parseInt(valueText.getText().toString());
        } catch (NumberFormatException e) {
            oldValue = 0;
            e.printStackTrace();
        }
        if (!(signText.getText().toString().equals(""))) {

            if (signText.getText().toString().equals("+")) {
                sumValue = oldValue + newValue;
            } else if (signText.getText().toString().equals("-")) {
                sumValue = oldValue - newValue;
                if (sumValue < 0) {
                    sumValue = 0;
                }
            }
            valueText.setText(String.valueOf(sumValue));
        } else {
            valueText.setText("");
        }

    }

    protected void onClickSignButton(View view) {
        Button b = (Button) view;
        String buttonText = b.getText().toString();
        signText.setText(buttonText);
    }

    protected void onClickClearButton(View view) {
        sumValue = 0;
        valueText.setText("");
        signText.setText("");
    }
}
