package com.dev.miwokapp.adapters;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;

import com.dev.miwokapp.R;
import com.dev.miwokapp.entity.Word;

import java.util.ArrayList;

public class WordAdapter extends ArrayAdapter<Word> {
    private final int colorResourceId;

    public WordAdapter(Activity context, ArrayList<Word> words, int colorResourceId) {
        super(context, 0, words);
        this.colorResourceId = colorResourceId;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }


        Word currentWord = getItem(position);
        TextView miwokTv = listItemView.findViewById(R.id.miwok_tv);
        miwokTv.setText(currentWord.getMiwokTranslation());

        TextView englishTv = listItemView.findViewById(R.id.english_tv);
        englishTv.setText(currentWord.getDefaultTranslation());

        ImageView imageView = listItemView.findViewById(R.id.imageView);
        if (currentWord.getImageResourceId() != 0) {
            imageView.setVisibility(View.VISIBLE);
            imageView.setImageResource(currentWord.getImageResourceId());
        } else {
            imageView.setVisibility(View.GONE);
        }

        View textContainer = listItemView.findViewById(R.id.text_container);
        int color = ContextCompat.getColor(getContext(), colorResourceId);
        textContainer.setBackgroundColor(color);

        return listItemView;
    }
}
