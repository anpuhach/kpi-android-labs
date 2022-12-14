package com.example.lab1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.widget.TextView;

public class ShowDataActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_data);

        Context context = getApplicationContext();

        String data = DataUtilities.readFromFile(context);
        if (data.isEmpty() || data.contains("FileNotFoundException"))
        {
            data = "The file is empty.";
        }

        ((TextView) findViewById(R.id.textView)).setText(data);
    }
}