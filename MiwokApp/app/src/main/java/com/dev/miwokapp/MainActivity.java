package com.dev.miwokapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView numbersTextView = findViewById(R.id.numbers);
        TextView colorsTextView = findViewById(R.id.colors);
        TextView familyTextView = findViewById(R.id.family);
        TextView phrasesTextView = findViewById(R.id.phrases);

        numbersTextView.setOnClickListener(view -> {
            Intent numbersIntent = new Intent(this, NumbersActivity.class);
            startActivity(numbersIntent);
        });

        colorsTextView.setOnClickListener(view -> {
            Intent colorsIntent = new Intent(this, ColorsActivity.class);
            startActivity(colorsIntent);
        });

        familyTextView.setOnClickListener(view -> {
            Intent familyIntent = new Intent(this, FamilyActivity.class);
            startActivity(familyIntent);
        });

        phrasesTextView.setOnClickListener(view -> {
            Intent phrasesIntent = new Intent(this, PhrasesActivity.class);
            startActivity(phrasesIntent);
        });
    }

}