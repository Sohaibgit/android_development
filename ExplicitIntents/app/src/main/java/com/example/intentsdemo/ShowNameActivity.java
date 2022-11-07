package com.example.intentsdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class ShowNameActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_name);

        TextView textView = findViewById(R.id.showNameTv);
        Intent intent = getIntent();
        textView.setText(intent.getStringExtra(MainActivity.EXTRA_NAME));
    }
}