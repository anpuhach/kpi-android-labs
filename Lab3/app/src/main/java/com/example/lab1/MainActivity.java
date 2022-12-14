/*
 * Лабораторна робота №3
 * Варіант: 7
 * Виконав: Пугач Антон ІО-03
 */

package com.example.lab1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    public static Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = getApplicationContext();
        setContentView(R.layout.activity_main);

        OptionsFragment fragment1 = new OptionsFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, fragment1, "OPTIONS_FRAGMENT").commit();

        Button okBtn = findViewById(R.id.okBtn);
        okBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                okBtn.setEnabled(true);
                StringBuilder order = new StringBuilder();

                List<CheckBox> checkBoxes = new ArrayList<>();
                checkBoxes.add(findViewById(R.id.checkBox1));
                checkBoxes.add(findViewById(R.id.checkBox2));
                checkBoxes.add(findViewById(R.id.checkBox3));
                checkBoxes.add(findViewById(R.id.checkBox4));
                checkBoxes.add(findViewById(R.id.checkBox5));

                for (CheckBox item : checkBoxes) {
                    if (item.isChecked())
                        order.append(item.getText().toString()).append(", ");
                }

                if (order.length() == 0) {
                    Toast.makeText(MainActivity.this, "Select at least 1 option!", Toast.LENGTH_SHORT).show();
                } else {
                    okBtn.setEnabled(false);
                    ResultFragment fragment2 = new ResultFragment(order);
                    FragmentTransaction frTrans = getSupportFragmentManager().beginTransaction();
                    frTrans.replace(R.id.frameLayout, fragment2);
                    frTrans.addToBackStack(null);
                    frTrans.commit();

                    DataUtilities.writeToFile(order.toString(), context);
                }
            }
        });

        Button openShowDataActivity = findViewById(R.id.openActData);
        openShowDataActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, ShowDataActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

        OptionsFragment test = (OptionsFragment) getSupportFragmentManager().findFragmentByTag("OPTIONS_FRAGMENT");
        if (test != null && test.isVisible()) {
            Button okBtn = findViewById(R.id.okBtn);
            okBtn.setEnabled(true);
        }
    }
}