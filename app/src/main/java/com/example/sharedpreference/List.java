package com.example.sharedpreference;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class List extends AppCompatActivity {

    ListView listView;
    private int listViewTouchAction = -1;
    private boolean set = false;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment);


        listView = (ListView) findViewById(R.id.listView);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(List.this, android.R.layout.simple_list_item_1, getString());
        listView.setAdapter(adapter);


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
