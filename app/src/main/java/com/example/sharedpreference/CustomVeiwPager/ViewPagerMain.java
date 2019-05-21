package com.example.sharedpreference.CustomVeiwPager;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import com.example.sharedpreference.R;

import java.util.ArrayList;

public class ViewPagerMain extends AppCompatActivity implements ToggleVerticalViewPagerScrolling{

    private ParentViewPagerAdapter verticalPagerAdapter;
    private VerticalViewPager verticalViewPager;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.viewpager_main);
        ArrayList<DataModel> dataModels = new ArrayList<>();
        dataModels.add(new DataModel("Android Volley Tutorial", "Android Volley Tutorial", "https://www.journaldev.com/19336/android-nested-viewpager-vertical-viewpager"));
        dataModels.add(new DataModel("Android Volley Tutorial", "Android Volley Tutorial", "https://www.journaldev.com/19336/android-nested-viewpager-vertical-viewpager"));
        dataModels.add(new DataModel("Android Geocoder Reverse Geocoding", "Android Geocoder Reverse Geocoding", "https://www.journaldev.com/19336/android-nested-viewpager-vertical-viewpager"));
        dataModels.add(new DataModel("Android Notification Direct Reply", "Android Notification Direct Reply", "https://www.journaldev.com/19336/android-nested-viewpager-vertical-viewpager"));
        dataModels.add(new DataModel("Rec yclerView Android with Dividers and Contextual Toolbar", "RecyclerView Android with Dividers and Contextual Toolbar", "https://www.journaldev.com/19336/android-nested-viewpager-vertical-viewpager"));

        verticalPagerAdapter = new ParentViewPagerAdapter(getSupportFragmentManager(), dataModels);
        verticalViewPager = findViewById(R.id.container);
        verticalViewPager.setAdapter(verticalPagerAdapter);

        verticalViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

                Log.d("viewpager", "verticalViewPager");

            }

            @Override
            public void onPageSelected(int i) {

            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });


    }

    @SuppressLint("ClickableViewAccessibility")
    @Override
    public void trigger(int page) {

        if (page == 1) {
            verticalViewPager.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    return true;
                }
            });
        } else {
            verticalViewPager.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    return false;
                }
            });
        }
    }

}
