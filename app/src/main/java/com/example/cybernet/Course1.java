package com.example.cybernet;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

public class Course1 extends AppCompatActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course1);

        VideoView videoView = findViewById(R.id.videoviewer);
        String videoPath = "android.resource://" + getPackageName() + "/" +R.raw.course2;
        Uri uri = Uri.parse(videoPath);
        videoView.setVideoURI(uri);

        MediaController mediaController = new MediaController(this);
        videoView.setMediaController(mediaController);

        mediaController.setAnchorView(videoView);
        videoView.start();

    }




}

