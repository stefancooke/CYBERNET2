package com.example.cybernet;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;


public class Homescreen extends AppCompatActivity {


    CardView cardGlossary;
    CardView cardProfile;
    CardView cardCourses;
    CardView cardVideos;
    CardView cardQuizzes;
    CardView cardSettings;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homescreen);

        cardGlossary = findViewById(R.id.cardGlossary);
        cardProfile = findViewById(R.id.cardProfile);
        cardCourses = findViewById(R.id.cardCourses);
        cardVideos = findViewById(R.id.cardVideos);
        cardQuizzes = findViewById(R.id.cardQuizzes);
        cardSettings = findViewById(R.id.cardSettings);


        cardGlossary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Homescreen.this, Glossary.class));

            }
        });

        cardProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Homescreen.this, ProfileActivity.class));

            }
        });

        cardCourses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Homescreen.this, CoursesActivity.class));

            }
        });

        cardQuizzes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Homescreen.this, Quizzes.class));

            }
        });

        cardVideos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Homescreen.this, Videos.class));

            }
        });




    }
}