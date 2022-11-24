package com.dev.luckynumberapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class DisplayNumber extends AppCompatActivity {

    TextView nameTextView;
    Button shareBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_number);

        nameTextView = findViewById(R.id.luckyNumberTextView);
        shareBtn = findViewById(R.id.shareLuckyNumberBtn);

        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        int luckyNumber = getRandomNumber();

        nameTextView.setText("" + luckyNumber);

        shareBtn.setOnClickListener(view -> {
            shareData(name, String.valueOf(luckyNumber));
        });
    }

    private void shareData(String name, String luckyNumber) {
        Intent i = new Intent(Intent.ACTION_SEND);
        i.setType("pain/text");
        i.putExtra(Intent.EXTRA_SUBJECT, name + " got lucky today!");
        i.putExtra(Intent.EXTRA_TEXT, "His lucky number is " + luckyNumber);

        startActivity(Intent.createChooser(i, "Choose a platform to share data"));
    }

    private int getRandomNumber() {
        Random random = new Random();
        return random.nextInt(1000);
    }
}