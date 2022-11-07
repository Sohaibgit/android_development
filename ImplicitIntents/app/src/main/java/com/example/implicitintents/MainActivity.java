package com.example.implicitintents;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void openWebPage(String url) {
        Uri webpage = Uri.parse(url);
        Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    public void sendEmail(View view) {
        EditText subjectEditText = findViewById(R.id.subjectEditText);
        EditText bodyEditText = findViewById(R.id.bodyEditText);
        String subject = subjectEditText.getText().toString();
        String body = bodyEditText.getText().toString();

        String[] addresses = {"sohaib5764@gmail.com", "development5511@gmail.com"};
        String[] cc = {"sohaib.khalid@systemsltd.com", "testingpurposes94@gmail.com"};

        composeEmail(addresses, cc, subject, body);
    }

    public void composeEmail(String[] addresses, String[] ccAddresses, String subject, String body) {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("*/*");
        intent.putExtra(Intent.EXTRA_EMAIL, addresses);
        intent.putExtra(Intent.EXTRA_CC, ccAddresses);
        intent.putExtra(Intent.EXTRA_SUBJECT, subject);
        intent.putExtra(Intent.EXTRA_TEXT, body);

        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }
}