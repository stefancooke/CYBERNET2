package com.example.cybernet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Arrays;
import java.util.Collections;




public class Quiz5 extends AppCompatActivity {


    private TextView questionTextView;
    private RadioButton answer1RadioButton;
    private RadioButton answer2RadioButton;
    private RadioButton answer3RadioButton;
    private Button nextButton;

    // Real Life Example Quiz
    public static Question[] questions = {
            new Question("Which of the following is a red flag of phishing?", "Urgency to act immediately", "Well-known company logo", "Personalized greeting", "Urgency to act immediately"),
    };

    private Question currentQuestion;
    private int currentQuestionIndex = 0;
    private int score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz5);

        score = 0;

        questionTextView = findViewById(R.id.question_textview);
        answer1RadioButton = findViewById(R.id.answer1_radiobutton);
        answer2RadioButton = findViewById(R.id.answer2_radiobutton);
        answer3RadioButton = findViewById(R.id.answer3_radiobutton);
        nextButton = findViewById(R.id.next_button);

        currentQuestion = questions[0];

        Collections.shuffle(Arrays.asList(questions));


        showQuestion();
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //This checks whether or not an answer was selected
                RadioGroup answerRadioGroup = findViewById(R.id.answer_radiogroup);
                int selectedAnswerId = answerRadioGroup.getCheckedRadioButtonId();
                RadioButton selectedAnswerRadioButton = findViewById(selectedAnswerId);

                if (selectedAnswerId == -1 || selectedAnswerRadioButton == null) { // Check for null selectedAnswerRadioButton
                    selectedAnswerId = -1; // Manually set selectedAnswerId to -1)
                    Toast.makeText(Quiz5.this, "Please select an answer", Toast.LENGTH_SHORT).show();
                    return;
                } else {

                    //If answer is correct score is incremented, if not the correct answer is displayed
                    String selectedAnswer = selectedAnswerRadioButton.getText().toString();
                    if (selectedAnswer.equals(currentQuestion.getCorrectAnswer())) {
                        score++;
                        Toast.makeText(Quiz5.this, "Correct!", Toast.LENGTH_SHORT).show();

                    } else {
                        Toast.makeText(Quiz5.this, "Incorrect Answer! The correct answer is: " + currentQuestion.getCorrectAnswer(), Toast.LENGTH_LONG).show();
                    }
                }
                //Increments the index so the next question is selected
                if (currentQuestionIndex < questions.length - 1) {

                    currentQuestionIndex++;
                    showQuestion();
                } else {
                    // Quiz is finished, show score then redirect back to main menu
                    Intent intent = new Intent(Quiz5.this, ScoreActivity.class);
                    intent.putExtra("SCORE_KEY", score);
                    intent.putExtra("NumQuestions", questions.length);
                    startActivity(intent);
                    finish();
                }
            }
        });
    }


    private void showQuestion() {
        // reset radio group selection to none to avoid ghost clicks
        RadioGroup answerRadioGroup = findViewById(R.id.answer_radiogroup);
        answerRadioGroup.clearCheck();
        currentQuestion = questions[currentQuestionIndex];
        // Updates current question to match the question index
        Question question = questions[currentQuestionIndex];
        questionTextView.setText(question.getText());
        answer1RadioButton.setText(question.getAnswer1());
        answer2RadioButton.setText(question.getAnswer2());
        answer3RadioButton.setText(question.getAnswer3());
        answer1RadioButton.setChecked(false);
        answer2RadioButton.setChecked(false);
        answer3RadioButton.setChecked(false);
    }




}





