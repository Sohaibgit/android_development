package com.dev.fragmentsdemo.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.dev.fragmentsdemo.R;
import com.dev.fragmentsdemo.SecondActivity;

public class FragmentOne extends Fragment {

    public FragmentOne() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_one, container, false);

        TextView textView = view.findViewById(R.id.fragment_one_tv);
        textView.setOnClickListener(v -> {
            Intent intent = new Intent(getContext(), SecondActivity.class);
            startActivity(intent);
        });

        return view;
    }
}