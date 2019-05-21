package com.example.sharedpreference.Preference;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.AbsListView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.sharedpreference.R;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment implements Event {


    ListView listView;
    private int listViewTouchAction = -1;
    private boolean set = false;
    Event event;
    private View view1;


    public HomeFragment() {
    }


    MainEvent mainEvent;

    @SuppressLint("ClickableViewAccessibility")
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);

        View view = inflater.inflate(R.layout.fragment, container, false);

        listView = view.findViewById(R.id.listView);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(view.getContext(), android.R.layout.simple_list_item_1, getString());
        listView.setAdapter(adapter);

        int count = listView.getCount();

        ViewParent parent = listView.getParent();




        SessionData.getInstance().setEvent(this);

//        ((Scroll) getActivity()).setEvent(this);

        listView.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {


            }

            @SuppressLint("LongLogTag")
            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {

                Log.d("list_count_visibleItemCount", " = " + visibleItemCount);
                Log.d("list_count_firstVisibleItem", " = " + firstVisibleItem);

                if (set)
                {
                    if (firstVisibleItem == 0)
                        view.getParent().requestDisallowInterceptTouchEvent(false);
                    else
                        view.getParent().requestDisallowInterceptTouchEvent(true);
                }

            }
        });


        listView.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View view, MotionEvent event) {

                view1 = view;

//                if (set)
//                {
//                    set = false;
//                }
//                else
//                {
//                    set = true;
//                    view.getParent().requestDisallowInterceptTouchEvent(false);
//                }
//                view.getParent().requestDisallowInterceptTouchEvent(true);

                return false;
            }
        });


//        listView.setOnTouchListener(new ListView.OnTouchListener() {
//            @Override
//            public boolean onTouch(View v, MotionEvent Event) {
//                int action = Event.getAction();
//                switch (action) {
//                    case MotionEvent.ACTION_MOVE:
//                        // Disallow ScrollView to intercept touch events.
//                        v.getParent().requestDisallowInterceptTouchEvent(true);
//                        break;
//
//                    case MotionEvent.ACTION_UP:
//                        // Allow ScrollView to intercept touch events.
//                        v.getParent().requestDisallowInterceptTouchEvent(false);
//                        break;
//                }
//
//                // Handle ListView touch events.
//                v.onTouchEvent(Event);
//                return true;
//            }
//        });




        return view;


    }

    List<String> getString()
    {
        List<String> stringList = new ArrayList<String>();

        for (int i = 1; i <= 20 ; i++)
        {
         stringList.add(i + "");
        }

        return stringList;
    }


    @SuppressLint("ClickableViewAccessibility")
    private void setListViewScrollable(final ListView list) {
        list.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                listViewTouchAction = event.getAction();
                if (event.getAction() == MotionEvent.ACTION_MOVE) {
                    list.scrollBy(0, 1);
                }
                return false;
            }
        });

        list.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {

            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
                if (listViewTouchAction == MotionEvent.ACTION_MOVE) {
                    list.scrollBy(0, -1);
                }
            }
        });
    }


    @Override
    public void nofifyMe(Boolean value) {

        Log.d(" notify" , "" + value);

        set = value;

        if (view1 != null)
        {
            if (value)
            {
//            view1.getParent().requestDisallowInterceptTouchEvent(value);
            }
            else
            {
//            view1.getParent().requestDisallowInterceptTouchEvent(value);
            }
        }


    }
}
