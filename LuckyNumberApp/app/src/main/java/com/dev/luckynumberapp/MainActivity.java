package com.dev.luckynumberapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.submitButton);

        button.setOnClickListener(view -> {
            EditText editText = findViewById(R.id.nameEditText);
            String name = editText.getText().toString();

            Intent intent = new Intent(this, DisplayNumber.class);
            intent.putExtra("name", name);
            startActivity(intent);
        });
    }
}