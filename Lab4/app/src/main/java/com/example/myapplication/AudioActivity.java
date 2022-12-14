package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;

import java.io.File;

public class AudioActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_audio);


        String path = Environment.getExternalStorageDirectory().getPath() + "/DCIM/audio.mp3";
        MediaPlayer player = MediaPlayer.create(this, Uri.parse(path));

        Button playBtn = findViewById(R.id.play);
        playBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                player.start();
            }
        });

        Button stopBtn = findViewById(R.id.stop);
        stopBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                player.pause();
            }
        });
    }
}