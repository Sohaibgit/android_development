package com.dev.activitylifecycle;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Toast.makeText(this, "onCreate is called (SecondActivity)", Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(this, "onStart is called (SecondActivity)", Toast.LENGTH_LONG).show();
    }


    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(this, "onResume is called (SecondActivity)", Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(this, "onStop is called (SecondActivity)", Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(this, "onPause is called (SecondActivity)", Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(this, "onDestroy is called (SecondActivity)", Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Toast.makeText(this, "onRestart is called (SecondActivity)", Toast.LENGTH_LONG).show();
    }

    @Override
    public void finish() {
        super.finish();
        Toast.makeText(this, "finish is called (SecondActivity)", Toast.LENGTH_LONG).show();
    }
}