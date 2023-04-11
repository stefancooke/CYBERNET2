package com.example.cybernet;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class CoursesActivity extends AppCompatActivity {





    CardView cardCourse0;
    CardView cardCourse1;
    CardView cardCourse2;
    CardView cardCourse3;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_courses);

        cardCourse0 = findViewById(R.id.cardCourse0);
        cardCourse1 = findViewById(R.id.cardCourse1);
        cardCourse2 = findViewById(R.id.cardCourse2);
        cardCourse3 = findViewById(R.id.cardCourse3);


        cardCourse0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CoursesActivity.this, Course0.class));

            }
        });

        cardCourse1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CoursesActivity.this, Course1.class));

            }
        });

        cardCourse2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CoursesActivity.this, Course2.class));

            }
        });

        cardCourse3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CoursesActivity.this, Course3.class));

            }
        });







    }
}