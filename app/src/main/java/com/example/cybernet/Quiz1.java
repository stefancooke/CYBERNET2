package com.example.cybernet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Quiz1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz1);
    }


    public void startGame(View view) {
        Intent intent = new Intent(Quiz1.this, StartGame.class);
        startActivity(intent);
        finish();


    }
}