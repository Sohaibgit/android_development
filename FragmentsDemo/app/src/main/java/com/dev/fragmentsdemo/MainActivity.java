package com.dev.fragmentsdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.widget.Button;

import com.dev.fragmentsdemo.fragments.FragmentOne;
import com.dev.fragmentsdemo.fragments.FragmentTwo;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button fragmentOneBtn = findViewById(R.id.fragment_one_btn);
        Button fragmentTwoBtn = findViewById(R.id.fragment_two_btn);

        fragmentOneBtn.setOnClickListener(view -> {
            FragmentOne fragmentOne = new FragmentOne();
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.fragment_container, fragmentOne);
            transaction.commit();
        });

        fragmentTwoBtn.setOnClickListener(view -> {
            FragmentTwo fragmentTwo = new FragmentTwo();
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.fragment_container, fragmentTwo);
            transaction.commit();
        });
    }
}