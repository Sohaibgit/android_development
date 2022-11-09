package com.sohaib.dev;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class MyListAdapter extends ArrayAdapter<String> {

    private String[] froms;
    private String[] content;
    private Integer[] imageIds;
    private Activity context;

    public MyListAdapter(Activity context, String[] froms, String[] content, Integer[] imageIds) {
        super(context, R.layout.my_listview_layput, froms);

        this.context = context;
        this.froms = froms;
        this.imageIds = imageIds;
        this.content = content;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        convertView = context.getLayoutInflater().inflate(R.layout.my_listview_layput, parent, false);

        ImageView imageView = convertView.findViewById(R.id.imageView);
        TextView nameTv = convertView.findViewById(R.id.nameTv);
        TextView contentTv = convertView.findViewById(R.id.descriptionTv);

        imageView.setImageResource(imageIds[position]);
        nameTv.setText(froms[position]);
        contentTv.setText(content[position]);

        return convertView;
    }
}
