package com.example.intentsdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_NAME = "com.example.intentsdemo.MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void nextActivity(View view) {
        Intent intent = new Intent(this, ShowNameActivity.class);
        EditText nameEditText = findViewById(R.id.nameEditText);
        String name = nameEditText.getText().toString();
        intent.putExtra(EXTRA_NAME, name);
        startActivity(intent);
    }
}