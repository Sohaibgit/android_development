package com.dev.mediaplayerdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private MediaPlayer player;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button playButton = findViewById(R.id.play_button);
        Button pauseButton = findViewById(R.id.pause_button);
        Button stopButton = findViewById(R.id.stop_button);

        playButton.setOnClickListener(view -> {
            if (player == null){
                player = MediaPlayer.create(this, R.raw.music);
            }

            player.start();
            player.setOnCompletionListener(mp -> stopPlayer());
        });

        pauseButton.setOnClickListener(view -> {
            if (player!=null){
                player.pause();
            }
        });

        stopButton.setOnClickListener(view -> {
            stopPlayer();
        });
    }

    private void stopPlayer(){
        if (player != null){
            player.release();
            player = null;
            Toast.makeText(this, "MediaPlayer released", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        stopPlayer();
    }
}