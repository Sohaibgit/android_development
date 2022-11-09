package com.sohaib.dev;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;


public class MainActivity extends AppCompatActivity {

    private Integer[] imageIds = {
            R.drawable.image_1,
            R.drawable.image_2,
            R.drawable.image_3,
            R.drawable.image_4,
            R.drawable.image_5,
            R.drawable.image_6,
            R.drawable.image_7,
            R.drawable.image_8
    };

    private String[] froms = {
            "Sohaib Khan",
            "Aslam Khan",
            "Akram Khan",
            "Daniyal Khan",
            "UET Taxila",
            "NUST",
            "Telenor Pakistan",
            "Zong 4G"
    };

    private String[] content = {
            "PFB the required details",
            "Hi, Hope you are doing well",
            "Hello Sir/Madam, I am writing in reference to my last email",
            "Hi Sohaib, Please share the below details",
            "Hi Sohaib, Please share your roll number",
            "Hi Sohaib, This is an email from NUST",
            "Welcome to Telenor Pakistan",
            "Pakistan fastest internet"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = findViewById(R.id.listView);
        MyListAdapter adapter = new MyListAdapter(this, froms, content, imageIds);
        listView.setAdapter(adapter);
    }
}