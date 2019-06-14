package com.example.sharedpreference.Preference;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.example.sharedpreference.R;

import java.util.ArrayList;

public class List extends AppCompatActivity {

    ListView listView;
    private int listViewTouchAction = -1;
    private boolean set = false;
    private LinearLayout toolbar;
    private int mLastFirstVisibleItem = 0;
    private boolean mIsScrollingUp = false;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment);
        getSupportActionBar().hide();

        toolbar = (LinearLayout) findViewById(R.id.toolbar);
//
//

        listView = (ListView) findViewById(R.id.listView);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(List.this, android.R.layout.simple_list_item_1, getString());
        listView.setAdapter(adapter);

        listView.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {

//                Log.d("scrollState", scrollState + "");

                if(scrollState == 0)
                    Log.i("scrollState", "  scrolling stopped...");


                if (view.getId() == listView.getId()) {
                    final int currentFirstVisibleItem = listView.getFirstVisiblePosition();
                    if (currentFirstVisibleItem > mLastFirstVisibleItem) {
                        mIsScrollingUp = false;

//                        toolbar.animate().translationY(-toolbar.getBottom()).setInterpolator(new AccelerateInterpolator()).start();
                        toolbar.animate().translationY(-toolbar.getBottom()).setDuration(250)
                                .setInterpolator(new AccelerateInterpolator())
                                .setListener(
                                new AnimatorListenerAdapter() {
                                    @Override
                                    public void onAnimationEnd(Animator animation) {
                                        super.onAnimationEnd(animation);

                                        toolbar.setVisibility(View.GONE);
                                    }
                                }
                        );

                        Log.i("scrollState", "  scrolling down...");
                    } else if (currentFirstVisibleItem < mLastFirstVisibleItem) {
                        mIsScrollingUp = true;

//                        toolbar.animate().translationY(0).setInterpolator(new DecelerateInterpolator()).start();


                        if (toolbar.getVisibility() == View.GONE)
                        {
                            toolbar.animate().translationY(0).setDuration(250)
                                    .setInterpolator(new AccelerateInterpolator())
                                    .setListener(
                                    new AnimatorListenerAdapter() {
                                        @Override
                                        public void onAnimationEnd(Animator animation) {
                                            super.onAnimationEnd(animation);

                                            toolbar.setVisibility(View.VISIBLE);
                                        }
                                    }
                            );
                        }


                        Log.i("scrollState", "  scrolling up...");
                    }

                    mLastFirstVisibleItem = currentFirstVisibleItem;

                }
            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {



            }
        });









        listView.setOnItemClickListener((a, b, c, d) -> {

        });


    }

    java.util.List<String> getString()
    {
        java.util.List<String> stringList = new ArrayList<String>();

        for (int i = 1; i <= 20 ; i++)
        {
            stringList.add(i + "");
        }

        return stringList;
    }


}
