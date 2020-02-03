package com.example.fragments_and_viewmodels.ui.adapters;

import com.example.fragments_and_viewmodels.ui.fragments.BaseFragment;
import com.example.fragments_and_viewmodels.ui.fragments.GreenFragment;
import com.example.fragments_and_viewmodels.ui.fragments.MainFragment;
import com.example.fragments_and_viewmodels.ui.fragments.RedFragment;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

public class ViewPagerAdapter extends FragmentPagerAdapter {

    private List<BaseFragment> fragments;
    public ViewPagerAdapter(@NonNull FragmentManager fm) {
        super(fm);
        fragments = Arrays.asList(new RedFragment(), new MainFragment(), new GreenFragment());
    }

    public ViewPagerAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    /*@Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0: return "Red";
            case 1: return "Blue";
            case 2: return "green";
            default: return "";
        }
    }*/

    @Override
    public int getCount() {
        return fragments.size();
    }
}
