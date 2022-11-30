package com.dev.recyclerviewdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recycler_view);

        List<Email> emails = new ArrayList<>();
        emails.add(new Email("One", "Number One", R.drawable.number_one));
        emails.add(new Email("Two", "Number Two", R.drawable.number_two));
        emails.add(new Email("Three", "Number Three", R.drawable.number_three));
        emails.add(new Email("Four", "Number Four", R.drawable.number_four));
        emails.add(new Email("Five", "Number Five", R.drawable.number_five));
        emails.add(new Email("Six", "Number Six", R.drawable.number_six));
        emails.add(new Email("Seven", "Number Seven", R.drawable.number_seven));
        emails.add(new Email("Eight", "Number Eight", R.drawable.number_eight));
        emails.add(new Email("Nine", "Number Nine", R.drawable.number_nine));
        emails.add(new Email("Ten", "Number Ten", R.drawable.number_ten));

        EmailAdapter emailAdapter = new EmailAdapter(emails);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        recyclerView.setAdapter(emailAdapter);
    }
}