package com.dev.soh;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MusicPlayerActivity extends AppCompatActivity {

    private TextView currentTimeTv, totalTimeTv, songTitleTv;
    private ImageView playPauseView, previousView, nextView, musicIconView;
    private SeekBar seekBar;
    private AudioModel song;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music_player);

        currentTimeTv = findViewById(R.id.current_time);
        totalTimeTv = findViewById(R.id.total_time);
        songTitleTv = findViewById(R.id.song_title);
        playPauseView = findViewById(R.id.play_pause);
        previousView = findViewById(R.id.previous);
        nextView = findViewById(R.id.next);
        musicIconView = findViewById(R.id.music_player_icon_big);
        seekBar = findViewById(R.id.seek_bar);

        song = (AudioModel) getIntent().getSerializableExtra("SONG");
    }
}