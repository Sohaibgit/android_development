package com.dev.soh;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class MusicPlayerActivity extends AppCompatActivity {

    private TextView currentTimeTv, totalTimeTv, songTitleTv;
    private ImageView playPauseView, previousView, nextView, musicIconView;
    private SeekBar seekBar;
    private ArrayList<Song> songs;
    private Song currentSong;
    private MediaPlayer mediaPlayer;
    private int rotationValue;

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

        // so that this text view will be marquee
        songTitleTv.setSelected(true);

        songs = getIntent().getExtras().getParcelableArrayList("songsList");
        mediaPlayer = MediaPlayerHelper.getMediaPlayer();
        setResourcesWithMusic();

        this.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                if (mediaPlayer != null) {
                    seekBar.setProgress(mediaPlayer.getCurrentPosition());
                    currentTimeTv.setText(convertToMMSS(String.valueOf(mediaPlayer.getCurrentPosition())));

                    if (mediaPlayer.isPlaying()) {
                        playPauseView.setImageResource(R.drawable.ic_baseline_pause_24);
                        musicIconView.setRotation(rotationValue++);
                    } else {
                        playPauseView.setImageResource(R.drawable.ic_baseline_play_arrow_24);
                        musicIconView.setRotation(0);
                    }
                }

                new Handler().postDelayed(this, 100);
            }
        });

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if (mediaPlayer != null && fromUser) {
                    mediaPlayer.seekTo(progress);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    private void setResourcesWithMusic() {
        currentSong = songs.get(MediaPlayerHelper.getCurrentIndex());
        songTitleTv.setText(currentSong.getTitle());
        totalTimeTv.setText(convertToMMSS(currentSong.getDuration()));

        playPauseView.setOnClickListener(v -> pausePlay());
        nextView.setOnClickListener(v -> playNextSong());
        previousView.setOnClickListener(v -> playPreviousSong());

        playMusic();
    }

    private String convertToMMSS(String duration) {
        long millis = Long.parseLong(duration);
        return String.format(Locale.ENGLISH, "%02d:%02d",
                TimeUnit.MILLISECONDS.toMinutes(millis) % TimeUnit.HOURS.toMinutes(1),
                TimeUnit.MILLISECONDS.toSeconds(millis) % TimeUnit.MINUTES.toSeconds(1));
    }

    private void playMusic() {
        mediaPlayer.reset();
        try {
            mediaPlayer.setDataSource(currentSong.getPath());
            mediaPlayer.prepare();
            mediaPlayer.start();
            seekBar.setProgress(0);
            seekBar.setMax(mediaPlayer.getDuration());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void playNextSong() {
        // if next song is last song
        if (MediaPlayerHelper.getCurrentIndex() == songs.size() - 1) {
            return;
        }

        MediaPlayerHelper.setCurrentIndex(MediaPlayerHelper.getCurrentIndex() + 1);
        setResourcesWithMusic();
    }

    private void playPreviousSong() {
        // if previous song is 1st song
        if (MediaPlayerHelper.getCurrentIndex() == 0) {
            return;
        }

        MediaPlayerHelper.setCurrentIndex(MediaPlayerHelper.getCurrentIndex() - 1);
        setResourcesWithMusic();
    }

    private void pausePlay() {
        if (mediaPlayer.isPlaying()) {
            mediaPlayer.pause();
        } else {
            mediaPlayer.start();
        }
    }
}