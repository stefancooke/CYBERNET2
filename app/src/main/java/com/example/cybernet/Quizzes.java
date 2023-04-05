package com.example.cybernet;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Quizzes extends AppCompatActivity {


    CardView cardQuiz1;
    CardView cardQuiz2;
    CardView cardQuiz3;
    CardView cardQuiz4;
    CardView cardQuiz5;
    CardView cardQuiz6;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quizzes);

        cardQuiz1 = findViewById(R.id.cardQuiz1);
        cardQuiz2 = findViewById(R.id.cardQuiz2);
        cardQuiz3 = findViewById(R.id.cardQuiz3);
        cardQuiz4 = findViewById(R.id.cardQuiz4);
        cardQuiz5 = findViewById(R.id.cardQuiz5);
        cardQuiz6 = findViewById(R.id.cardQuiz6);


        cardQuiz1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Quizzes.this, Quiz1.class));

            }
        });

        cardQuiz2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Quizzes.this, Quiz2.class));

            }
        });

        cardQuiz3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Quizzes.this, Quiz3.class));

            }
        });

        cardQuiz4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Quizzes.this, Quizzes.class));

            }
        });

        cardQuiz5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Quizzes.this, Videos.class));

            }
        });

        cardQuiz6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Quizzes.this, Homescreen.class));

            }
        });





    }
}