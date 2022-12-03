package com.dev.soh;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.Manifest;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private static final int READ_EXTERNAL_STORAGE_PERMISSION_CODE = 1;

    private RecyclerView recyclerView;
    private TextView noSongsTv;
    private List<AudioModel> songsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        songsList = new ArrayList<>();
        recyclerView = findViewById(R.id.songs_list);
        noSongsTv = findViewById(R.id.no_songs_tv);

        if (!checkPermission()) {
            requestPermission();
        }

        String[] projection = {
                MediaStore.Audio.Media.TITLE,
                MediaStore.Audio.Media.DATA,
                MediaStore.Audio.Media.DURATION
        };
        String selection = MediaStore.Audio.Media.IS_MUSIC + " != 0"; // because we only want music from the database
        Cursor cursor = getContentResolver().query(MediaStore.Audio.Media.EXTERNAL_CONTENT_URI, projection, selection, null, null);

        while (cursor.moveToNext()) {
            AudioModel audioModel = new AudioModel(cursor.getString(0), cursor.getString(1), cursor.getString(2));
            File songFile = new File(audioModel.getPath());
            if (songFile.exists()) {
                songsList.add(audioModel);
            }
        }

        if (songsList.size() > 0) {
            noSongsTv.setVisibility(View.GONE);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
            recyclerView.setAdapter(new SongsAdapter(songsList, this));
        } else {
            noSongsTv.setVisibility(View.VISIBLE);
        }


    }

    private boolean checkPermission() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED) {
            return true;
        } else {
            return false;
        }
    }

    private void requestPermission() {
        if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.READ_EXTERNAL_STORAGE)) {
            Toast.makeText(this, "READ PERMISSION IS REQUIRED, PLEASE ALLOW FROM SETTINGS", Toast.LENGTH_SHORT).show();
        } else {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, READ_EXTERNAL_STORAGE_PERMISSION_CODE);
        }
    }
}