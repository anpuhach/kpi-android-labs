/*
* Лабораторна робота №1
* Варіант: 7
* Виконав: Пугач Антон ІО-03
*/

package com.example.lab1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView orderText = findViewById(R.id.textView2);

        Button responseButton = findViewById(R.id.button);
        responseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                StringBuilder order = new StringBuilder();

                List<CheckBox> checkBoxes = new ArrayList<>();
                checkBoxes.add(findViewById(R.id.checkBox));
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
                    orderText.setText(order);
                }
            }
        });
    }
}