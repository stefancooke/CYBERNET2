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




public class Quiz4 extends AppCompatActivity {


    private TextView questionTextView;
    private RadioButton answer1RadioButton;
    private RadioButton answer2RadioButton;
    private RadioButton answer3RadioButton;
    private Button nextButton;


    //Phishing Prevention Questions
    public static Question[] questions = {
            new Question("Which of the following is a best practice for creating strong passwords?", "Using the same password for multiple accounts", "Using a password with fewer than 8 characters", "Using a combination of letters, numbers, and symbols", "Using a combination of letters, numbers, and symbols"),
            new Question("What should you do if you think you've received a phishing email?", "Open it and respond to it", "Inform and Report the attack to an IT support member or online", "Check if the links in the email are legitimate by opening them", "Inform and Report the attack to an IT support member or online"),
            new Question("When checking for signs of phishing, What should you do?", "Check if the email is addressed to you personally and check if its a legitimate email", "Be suspicious of threatening language like 'Click here immediately'", "All of the above", "All of the above"),

    };

    private Question currentQuestion;
    private int currentQuestionIndex = 0;
    private int score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz4);

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
                    Toast.makeText(Quiz4.this, "Please select an answer", Toast.LENGTH_SHORT).show();
                    return;
                } else {

                    //If answer is correct score is incremented, if not the correct answer is displayed
                    String selectedAnswer = selectedAnswerRadioButton.getText().toString();
                    if (selectedAnswer.equals(currentQuestion.getCorrectAnswer())) {
                        score++;
                        Toast.makeText(Quiz4.this, "Correct!", Toast.LENGTH_SHORT).show();

                    } else {
                        Toast.makeText(Quiz4.this, "Incorrect Answer! The correct answer is: " + currentQuestion.getCorrectAnswer(), Toast.LENGTH_LONG).show();
                    }
                }
                //Increments the index so the next question is selected
                if (currentQuestionIndex < questions.length - 1) {

                    currentQuestionIndex++;
                    showQuestion();
                } else {
                    // Quiz is finished, show score then redirect back to main menu
                    Intent intent = new Intent(Quiz4.this, ScoreActivity.class);
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





