package com.dev.soh;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class SongsAdapter extends RecyclerView.Adapter<SongsAdapter.SongsViewHolder> {
    private final ArrayList<Song> songs;
    private final Context context;

    public SongsAdapter(ArrayList<Song> songs, Context context) {
        this.songs = songs;
        this.context = context;
    }

    @NonNull
    @Override
    public SongsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.recycler_view_layout, parent, false);
        return new SongsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SongsViewHolder holder, int position) {
        Song song = songs.get(position);
        holder.songTitleTv.setText(song.getTitle());

        // highlighting selected song
        if (MediaPlayerHelper.getCurrentIndex() == position){
            holder.songTitleTv.setTextColor(Color.parseColor("#FF0000"));
        }else {
            holder.songTitleTv.setTextColor(Color.parseColor("#000000"));
        }

        holder.itemView.setOnClickListener(v -> {
            MediaPlayerHelper.getMediaPlayer().reset();
            MediaPlayerHelper.setCurrentIndex(position);

            Intent musicPlayerIntent = new Intent(context, MusicPlayerActivity.class);
            Bundle args = new Bundle();
            args.putParcelableArrayList("songsList", songs);
            musicPlayerIntent.putExtras(args);
            context.startActivity(musicPlayerIntent);
        });
    }

    @Override
    public int getItemCount() {
        return songs.size();
    }

    public static class SongsViewHolder extends RecyclerView.ViewHolder {
        TextView songTitleTv;

        public SongsViewHolder(@NonNull View itemView) {
            super(itemView);
            songTitleTv = itemView.findViewById(R.id.song_title_tv);
        }
    }
}
