package com.example.cybernet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class StartGame extends AppCompatActivity {

    TextView tvTimer;
    TextView tvResult;
    ImageView ivShowImage;
    HashMap<String, Integer> map = new HashMap<>();
    ArrayList<String> techList = new ArrayList<>();
    int index;
    Button button1, button2, button3, button4;
    TextView tvPoints;
    int points;
    CountDownTimer countDownTimer;
    long millisUntilFinished;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_game);
        tvTimer = findViewById(R.id.tvTimer);
        tvResult = findViewById(R.id.tvResult);
        ivShowImage = findViewById(R.id.ivShowImage);
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);
        tvPoints = findViewById(R.id.tvPoints);
        index = 0;
        techList.add("Android");
        techList.add("C");
        techList.add("Bootstrap");
        techList.add("Code Igniter");
        map.put(techList.get(0), R.drawable.img);
        map.put(techList.get(1), R.drawable.c);
        map.put(techList.get(2), R.drawable.bootstrap);
        map.put(techList.get(3), R.drawable.codeigniter);
        Collections.shuffle(techList);
        millisUntilFinished = 10000;
        points = 0;
        startGame();
        



    }

    private void startGame() {
        millisUntilFinished = 10000;
        tvTimer.setText(""+ (millisUntilFinished / 1000) + "s");
        tvPoints.setText(points + " / " + techList.size());
        generateQuestions(index);
        countDownTimer = new CountDownTimer(millisUntilFinished, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                tvTimer.setText("" + (millisUntilFinished / 1000) + "s");
            }

            @Override
            public void onFinish() {
                index++;
                if (index > techList.size() -1 ){
                    ivShowImage.setVisibility(View.GONE);
                    button1.setVisibility(View.GONE);
                    button2.setVisibility(View.GONE);
                    button3.setVisibility(View.GONE);
                    button4.setVisibility(View.GONE);
                    Intent intent = new Intent(StartGame.this, GameOver.class);
                    intent.putExtra("points", points);
                    startActivity(intent);
                    finish();
                } else {
                    startGame();
                }

            }
        }.start();
    }

    private void generateQuestions(int index) {
        ArrayList<String> techListTemp = (ArrayList<String>) techList.clone();
        String correctAnswer = techList.get(index);
        techListTemp.remove(correctAnswer);
        Collections.shuffle(techListTemp);
        ArrayList<String> newList = new ArrayList<>();
        newList.add(techListTemp.get(0));
        newList.add(techListTemp.get(1));
        newList.add(techListTemp.get(2));
        newList.add(correctAnswer);
        Collections.shuffle(newList);
        button1.setText(newList.get(0));
        button2.setText(newList.get(1));
        button3.setText(newList.get(2));
        button4.setText(newList.get(3));
        ivShowImage.setImageResource(map.get(techList.get(index)));
    }

    public void nextQuestion(View view) {
        countDownTimer.cancel();
        button1.setEnabled(true);
        button2.setEnabled(true);
        button3.setEnabled(true);
        button4.setEnabled(true);
        index++;
        if(index > techList.size() - 1){
            ivShowImage.setVisibility(View.GONE);
            button1.setVisibility(View.GONE);
            button2.setVisibility(View.GONE);
            button3.setVisibility(View.GONE);
            button4.setVisibility(View.GONE);
            Intent intent = new Intent(StartGame.this, GameOver.class);
            intent.putExtra("points", points);
            startActivity(intent);
            finish();
        } else {

            startGame();
        }

    }
    public void answerSelected(View view) {
        countDownTimer.cancel();
        button1.setEnabled(false);
        button2.setEnabled(false);
        button3.setEnabled(false);
        button4.setEnabled(false);
        String answer = ((Button) view).getText().toString().trim();
        String correctAnswer = techList.get(index);
        if(answer.equals(correctAnswer)){
            points++;
            tvPoints.setText(points + " / " +techList.size());
            tvResult.setText("Correct");
        } else {
            tvResult.setText("Wrong");
        }

    }

}

