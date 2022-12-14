package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

import java.io.File;

public class VideoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);

        String path = Environment.getExternalStorageDirectory().getPath() + "/DCIM/vid.mp4";
        VideoView videoView = (VideoView) findViewById(R.id.videoView);
        videoView.setVideoURI(Uri.parse(path));

        MediaController mediaController = new MediaController(this);
        videoView.setMediaController(mediaController);
        mediaController.setAnchorView(videoView);
    }
}