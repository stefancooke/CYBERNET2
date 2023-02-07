package com.example.cybernet;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;


public class Homescreen extends AppCompatActivity {


    CardView cardHome;
    CardView cardProfile;
    CardView cardCourses;
    CardView cardVideos;
    CardView cardArticles;
    CardView cardSettings;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homescreen);

        cardHome = findViewById(R.id.cardHome);
        cardProfile = findViewById(R.id.cardProfile);
        cardCourses = findViewById(R.id.cardCourses);
        cardVideos = findViewById(R.id.cardVideos);
        cardArticles = findViewById(R.id.cardArticles);
        cardSettings = findViewById(R.id.cardSettings);


        cardHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        cardProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Homescreen.this, ProfileActivity.class));

            }
        });


    }
}