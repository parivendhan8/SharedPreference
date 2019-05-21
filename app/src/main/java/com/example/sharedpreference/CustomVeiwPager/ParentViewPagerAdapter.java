package com.example.sharedpreference.CustomVeiwPager;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

public class ParentViewPagerAdapter extends FragmentPagerAdapter {

    ArrayList<DataModel> list = new ArrayList<DataModel>();


    public ParentViewPagerAdapter(FragmentManager fm, ArrayList<DataModel> list) {
        super(fm);
        this.list = list;
    }

    @Override
    public Fragment getItem(int i) {
        return ParentFragment.newInstance(list.get(i));
    }

    @Override
    public int getCount() {
        return list.size();
    }


}
