package com.example.exploreide;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText inputEditText;
    private TextView resultTv;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputEditText = findViewById(R.id.inputEditText);
        resultTv = findViewById(R.id.resultTv);
        button = findViewById(R.id.button);

        button.setOnClickListener(view -> {
            String input = String.valueOf(inputEditText.getText());

            try {
                double kg = Double.parseDouble(input);
                double pounds = 2.205 * kg;
                resultTv.setText(String.valueOf(pounds));
            } catch (Exception ex) {
                Toast.makeText(MainActivity.this, "Invalid Input: " + ex.getMessage(), Toast.LENGTH_SHORT).show();
            }

        });
    }
}