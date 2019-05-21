package com.example.sharedpreference.CustomVeiwPager;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.view.View;

class ChildViewPagerAdapter extends FragmentPagerAdapter {


    DataModel model;


    public ChildViewPagerAdapter(FragmentManager fm, DataModel model) {
        super(fm);
        this.model = model;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return ChildFragment.newInstance(model, false);
            case 1:
                return ChildFragment.newInstance(model, true);
            default:
                return ChildFragment.newInstance(model, true);
        }
    }

    @Override
    public int getCount() {
        return 2;
    }


    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {

        return "Child Fragment " + position;
    }
}
