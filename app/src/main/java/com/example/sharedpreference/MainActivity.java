package com.example.sharedpreference;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Preference {


    private EditText editText;
    private TextView txt_value;
    private TextView textView_one;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = (EditText) findViewById(R.id.textView);
        textView_one = (EditText) findViewById(R.id.textView_one);
        txt_value = (TextView) findViewById(R.id.txt_value);

        editText.setText("");
        txt_value.setText(getString("two"));

    }

    public void Button(View view) {

        setValue("two", getText(editText));
//        setValue("one", getText(textView_one));

    }

    @Override
    protected void onResume() {
        super.onResume();

        txt_value.setText(getString("one"));

    }
}
