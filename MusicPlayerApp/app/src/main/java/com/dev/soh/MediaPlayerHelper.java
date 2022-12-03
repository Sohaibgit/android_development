package com.dev.soh;

import android.media.MediaPlayer;

public class MediaPlayerHelper {
    private static MediaPlayer mediaPlayer;

    public static MediaPlayer getMediaPlayer() {
        if (mediaPlayer == null){
            mediaPlayer = new MediaPlayer();
        }

        return mediaPlayer;
    }
}
