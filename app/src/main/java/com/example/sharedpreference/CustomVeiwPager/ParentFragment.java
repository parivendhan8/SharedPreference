package com.example.sharedpreference.CustomVeiwPager;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.sharedpreference.R;

import java.util.ArrayList;

public class ParentFragment extends Fragment {


    private Activity mActivity;
    ToggleVerticalViewPagerScrolling tv;
    ViewPager nestedViewPager;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_parent, null);

        String title = getArguments().getString("title");
        String description = getArguments().getString("description");
        String url = getArguments().getString("url");
        DataModel model = new DataModel(title, description, url);
        nestedViewPager = rootView.findViewById(R.id.nestedViewPager);
        nestedViewPager.setAdapter(new ChildViewPagerAdapter(getChildFragmentManager(), model));




        nestedViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float v, int i1) {
                tv.trigger(position);

                Log.d("viewpager", "nestedViewPager");

            }

            @Override
            public void onPageSelected(int i) {

            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });

        return rootView;
    }

    public static ParentFragment newInstance(DataModel dataModel) {
        ParentFragment fragment = new ParentFragment();
        Bundle args = new Bundle();
        args.putString("title", dataModel.title);
        args.putString("description", dataModel.description);
        args.putString("url", dataModel.url);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        if (context instanceof Activity) {
            mActivity = (Activity) context;
        }

        try {
            tv = (ToggleVerticalViewPagerScrolling) mActivity;
        } catch (ClassCastException e) {
            throw new ClassCastException("Error in retrieving data. Please try again");
        }
    }
}
