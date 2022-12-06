package com.dev.soh;

import android.media.MediaPlayer;

public class MediaPlayerHelper {
    private static MediaPlayer mediaPlayer;
    private static int currentIndex;

    public static MediaPlayer getMediaPlayer() {
        if (mediaPlayer == null){
            mediaPlayer = new MediaPlayer();
        }

        return mediaPlayer;
    }

    public static int getCurrentIndex() {
        return currentIndex;
    }

    public static void setCurrentIndex(int currentIndex) {
        MediaPlayerHelper.currentIndex = currentIndex;
    }
}
