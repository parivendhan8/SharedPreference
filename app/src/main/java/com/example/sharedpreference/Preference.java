package com.example.sharedpreference;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.logging.FileHandler;


public class Preference extends AppCompatActivity {

    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        sharedPreferences = getSharedPreferences("Preference", MODE_PRIVATE);
        editor = sharedPreferences.edit();

    }

    void debug(String tag, String message)
    {
        Log.d(tag, message);
    }

    void setValue(@NonNull String key, String value)
    {
        editor.putString( key, value);
        editor.commit();

    }

    String getString(String key)
    {
        HashMap<String, Object> map = (HashMap<String, Object>) sharedPreferences.getAll();
        if (map.size() != 0)
        {
            if (map.containsKey(key))
            return map.get(key).toString();
            else
            return "No data";
        }
        else
            return "";
    }

    <T> T getValue(String key)
    {
        HashMap<String, Object> map1 = (HashMap<String, Object>) sharedPreferences.getAll();
        return (T)map1.get(key);

    }

    String getText(View view)
    {
        EditText editText = (EditText) view;
        return editText.getText().toString();

    }

    String findDatatype(Object o)
    {
        if (o instanceof Integer) {
            return "int";
        } else if (o instanceof String) {
            return "String";
        } else if (o instanceof Boolean) {
            return "Boolean";
        } else if (o instanceof ArrayList) {
            return "ArrayList";
        }
        return  " ";
    }





    /* Loggers */

    public  FileHandler logger = null;
    private String filename = "winserve_log";

    boolean isExternalStorageAvailable = false;
    boolean isExternalStorageWriteable = false;
    String state = Environment.getExternalStorageState();


    public void addLog(String message) {

        if (Environment.MEDIA_MOUNTED.equals(state)) {
            // We can read and write the media
            isExternalStorageAvailable = isExternalStorageWriteable = true;
        } else if (Environment.MEDIA_MOUNTED_READ_ONLY.equals(state)) {
            // We can only read the media
            isExternalStorageAvailable = true;
            isExternalStorageWriteable = false;
        } else {
            // Something else is wrong. It may be one of many other states, but all we need
            //  to know is we can neither read nor write
            isExternalStorageAvailable = isExternalStorageWriteable = false;
        }

        File dir = new File(Environment.getExternalStorageDirectory().getAbsolutePath());
        if (Environment.MEDIA_MOUNTED.equals(state)) {
            if(!dir.exists()) {
                Log.d("Dir created ", "Dir created ");
                dir.mkdirs();
            }

            File logFile = new File(Environment.getExternalStorageDirectory().getAbsolutePath()+"/"+filename+".txt");

            if (!logFile.exists())  {
                try  {
                    Log.d("File created ", "File created ");
                    logFile.createNewFile();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
            try {
                //BufferedWriter for performance, true to set append to file flag
                Date date = new Date() ;
                @SuppressLint("SimpleDateFormat") SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss") ;
                //File file = new File(dateFormat.format(date) + ".tsv") ;
                BufferedWriter buf = new BufferedWriter(new FileWriter(logFile, true));



                buf.write( message + "\r\n");
                buf.newLine();

//                        buf.write("");

                buf.flush();
                buf.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }


}
