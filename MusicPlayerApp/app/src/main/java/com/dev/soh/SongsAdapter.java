package com.dev.soh;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class SongsAdapter extends RecyclerView.Adapter<SongsAdapter.SongsViewHolder> {
    private List<AudioModel> songs;
    private Context context;

    public SongsAdapter(List<AudioModel> songs, Context context) {
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
        AudioModel song = songs.get(position);
        holder.songTitleTv.setText(song.getTitle());
        holder.itemView.setOnClickListener(v -> {
            MediaPlayerHelper.getMediaPlayer().reset();

            Intent musicPlayerIntent = new Intent(context, MusicPlayerActivity.class);
            musicPlayerIntent.putExtra("SONG", song);
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
