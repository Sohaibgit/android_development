package com.dev.recyclerviewdemo;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class EmailAdapter extends RecyclerView.Adapter<EmailAdapter.EmailViewHolder> {
    private List<Email> emails;

    public EmailAdapter(List<Email> emails) {
        this.emails = emails;
    }

    @NonNull
    @Override
    public EmailViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_layout, parent, false);
        return new EmailViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EmailViewHolder holder, int position) {
        Email email = emails.get(position);
        holder.imageView.setImageResource(email.getImageResourceId());
        holder.title.setText(email.getTitle());
        holder.subject.setText(email.getSubject());
        holder.itemView.setOnClickListener(v -> Toast.makeText(v.getContext(), "Row " + position + " Clicked", Toast.LENGTH_SHORT).show());
    }

    @Override
    public int getItemCount() {
        return emails.size();
    }

    public static class EmailViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView title;
        TextView subject;

        public EmailViewHolder(@NonNull View itemView) {
            super(itemView);
            this.imageView = itemView.findViewById(R.id.image_icon);
            this.title = itemView.findViewById(R.id.title);
            this.subject = itemView.findViewById(R.id.subject);
        }
    }
}
