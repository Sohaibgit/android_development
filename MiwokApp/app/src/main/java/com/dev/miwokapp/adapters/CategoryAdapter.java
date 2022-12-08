package com.dev.miwokapp.adapters;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.dev.miwokapp.fragments.ColorsFragment;
import com.dev.miwokapp.fragments.FamilyFragment;
import com.dev.miwokapp.fragments.NumbersFragment;
import com.dev.miwokapp.fragments.PhrasesFragment;

public class CategoryAdapter extends FragmentPagerAdapter {

    public CategoryAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new NumbersFragment();
            case 1:
                return new FamilyFragment();
            case 2:
                return new ColorsFragment();
            case 3:
                return new PhrasesFragment();
        }

        return new NumbersFragment();
    }

    @Override
    public int getCount() {
        return 4;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        String title = null;

        switch (position) {
            case 0:
                title = "NUMBERS";
                break;
            case 1:
                title = "FAMILY";
                break;
            case 2:
                title = "COLORS";
                break;
            case 3:
                title = "PHRASES";
                break;
        }

        return title;
    }
}
