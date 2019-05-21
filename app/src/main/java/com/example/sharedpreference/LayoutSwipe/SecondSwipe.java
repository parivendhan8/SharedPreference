package com.example.sharedpreference.LayoutSwipe;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.LinearLayout;

import com.example.sharedpreference.R;

public class SecondSwipe extends AppCompatActivity {

    private LinearLayout parent_layout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_swipe);


        parent_layout = (LinearLayout) findViewById(R.id.parent_layout);
        parent_layout.setOnTouchListener(new RelativeLayoutTouchListener(SecondSwipe.this));
    }
}

