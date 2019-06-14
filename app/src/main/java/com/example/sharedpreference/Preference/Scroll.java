package com.example.sharedpreference.Preference;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ScrollView;

import com.example.sharedpreference.R;

public class Scroll extends Preference {

    private ScrollView parentScroll;
    private LinearLayout first_item;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private ListView lstvNextTracks;
    private String TAG = Scroll.class.getSimpleName();
    private MainEvent mainEvent;
    Event event;
    public static int send_value = 0;


    @SuppressLint("ClickableViewAccessibility")
    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.scroll_layout);

        tabLayout=(TabLayout)findViewById(R.id.tabLayout);
        viewPager=(ViewPager)findViewById(R.id.viewPager);

        tabLayout.addTab(tabLayout.newTab().setText("Home"));
        tabLayout.addTab(tabLayout.newTab().setText("Sport"));

        mainEvent = new MainEvent();
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        final MyAdapter adapter = new MyAdapter(Scroll.this,getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(adapter);

        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        parentScroll = (ScrollView) findViewById(R.id.parentScroll);
        first_item = (LinearLayout) findViewById(R.id.first_item);

        parentScroll.setOnScrollChangeListener(new View.OnScrollChangeListener() {
            @Override
            public void onScrollChange(View v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {

                debug("parentScroll", " = " + scrollY + " ," + scrollX);
                mainEvent.doEvent(true);

//                mainEvent.getEvent().nofifyMe(true);

//                Event.nofifyMe(true);


                int s_X = parentScroll.getScrollX();
                int s_Y = parentScroll.getScrollY();


                SessionData.getInstance().getEvent().nofifyMe(true);

                 if (s_Y > 200)
                {
                    debug(TAG, "Success");

//                    event.nofifyMe(true);

//                    SecondEvent secondEvent = new SecondEvent();

//                    secondEvent.nofifyMe(true);

//                    send_value = s_Y;

                }

                debug("s_Y", " " +  s_Y );

                if (scrollY > 190)
                {
//                    parentScroll.requestDisallowInterceptTouchEvent(true);
                }

                if (scrollY > 15)
                {

                    if (first_item.getVisibility() == View.VISIBLE)
                    {
                        debug("first_item", " = true");

                    }
                    else
                    {
                        debug("first_item", " = false");
                    }
                }

            }
        });

//        parentScroll.setOnTouchListener(new View.OnTouchListener()
//        {
//
//            @Override
//            public boolean onTouch(View v, MotionEvent Event)
//            {
//
//                for (int i = 0; i < parentScroll.getChildCount(); i++)
//                {
//                    if (parentScroll.getChildAt(i) instanceof ListView)
//                    {
//                        lstvNextTracks = (ListView) parentScroll.getChildAt(i);
//                    }
//
//                }
//
//
//                int arr[] = new int[] { 1, 2 };
//                lstvNextTracks.getLocationOnScreen(arr);
//
//                /* Get bounds of child Listview*/
//                int lstvTop = arr[0];
//                int lstvBottom = arr[1] + lstvNextTracks.getHeight();
//                int lstvLeft = arr[1];
//                int lstvRight = arr[0] + lstvNextTracks.getWidth();
//
//                float x = Event.getRawX();
//                float y = Event.getRawY();
//
//                if (Event.getAction() == MotionEvent.ACTION_DOWN)
//                {
//                    /*check if child ListView bounds are touched*/
//                    if (x > lstvTop && x < lstvBottom && y > lstvLeft && y < lstvRight)
//                    {
//                        parentScroll.clearFocus();
//                        /*This statement tells the ScrollView to do not handle this touch Event, so the child Listview will handle this touch Event and will scroll */
//                        parentScroll.requestDisallowInterceptTouchEvent(true);
//                        /*The child Listview isFocusable attribute must be set to true otherwise it will not work*/
//                        lstvNextTracks.requestFocus();
//                        return true;
//                    } else
//                        return false;
//                } else if (Event.getAction() == MotionEvent.ACTION_MOVE)
//                {
//
//                    if (x > lstvTop && x < lstvBottom && y > lstvLeft && y < lstvRight)
//                    {
//                        parentScroll.clearFocus();
//                        parentScroll.requestDisallowInterceptTouchEvent(true);
//                        lstvNextTracks.requestFocus();
//                        return true;
//                    } else
//                        return false;
//                } else if (Event.getAction() == MotionEvent.ACTION_UP)
//                {
//                    parentScroll.clearFocus();
//                    parentScroll.requestDisallowInterceptTouchEvent(true);
//                    lstvNextTracks.requestFocus();
//                    return false;
//                } else
//                {
//                    return false;
//                }
//            }
//        });

    }

    public void setEvent(Event event)
    {
        this.event = event;
    }




}
