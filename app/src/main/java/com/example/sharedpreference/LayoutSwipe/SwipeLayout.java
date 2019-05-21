package com.example.sharedpreference.LayoutSwipe;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.LinearLayout;

import com.example.sharedpreference.R;

public class SwipeLayout extends AppCompatActivity {

    private LinearLayout parent_layout;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_swipe);

        parent_layout = (LinearLayout) findViewById(R.id.parent_layout);
//        parent_layout.setOnTouchListener(new RelativeLayoutTouchListener(SecondSwipe.this));


    }


    public void swipe(View childView)
    {
        childView.animate()
                .translationX(250)
                .setDuration(300)
                .setInterpolator(new AccelerateDecelerateInterpolator())
                .setListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animation) {
//                        childView.setVisibility(View.GONE);

                        childView.setTranslationY(0);
                    }
                });



    }

    public void Button1(View view) {
        swipe(parent_layout);
    }
}
