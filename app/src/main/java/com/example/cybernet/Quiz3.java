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




public class Quiz3 extends AppCompatActivity {


    private TextView questionTextView;
    private RadioButton answer1RadioButton;
    private RadioButton answer2RadioButton;
    private RadioButton answer3RadioButton;
    private Button nextButton;

    public static Question[] questions = {
            new Question("Which of the following is a red flag of phishing?", "Urgency to act immediately", "Well-known company logo", "Personalized greeting", "Urgency to act immediately"),
            new Question("What should you do if you receive a suspicious email?", "Reply to the sender and ask for more information", "Click on links and download attachments", "Forward the email to your supervisor or IT department", "Forward the email to your supervisor or IT department"),
            new Question("Which of the following is a red flag of a phishing website?", "Secure website address (https://)", "Unprofessional design and layout", "Contact information provided", "Unprofessional design and layout"),
            new Question("What should you do if you suspect you have fallen victim to a phishing scam?", "Keep it to yourself and don't tell anyone", "Report it to your supervisor or IT department immediately", "Try to fix it yourself", "Report it to your supervisor or IT department immediately"),
            new Question("Which of the following is a red flag of a phishing email?", "Email was forwarded to you", "Spelling and grammar errors", "Links that go to legitimate websites", "Spelling and grammar errors"),
            new Question("What is a red flag of phishing in an online advertisement?", "The ad contains a call to action",  "The ad contains a celebrity endorsement", "The ad redirects to a different website", "The ad redirects to a different website"),
            new Question("What is a red flag of phishing in a message requesting a password reset?", "The message was unsolicited", "The message came from a trusted source", "The message was sent during business hours", "The message was unsolicited"),
            new Question("Which of the following is a red flag of phishing in a link?", "The link directs you to a different website than expected", "The link contains a country code domain (.ru)", "The link is shortened", "The link directs you to a different website than expected"),
            new Question("What is a red flag of phishing in an attachment?", "The attachment is a PDF", "The attachment is password-protected", "The attachment is a .exe file", "The attachment is a .exe file"),
            new Question("What is a red flag of phishing in a URL?", "The URL contains https", "The URL contains the name of a legitimate company", "The URL contains a long string of random characters", "The URL contains a long string of random characters")
    };

    private Question currentQuestion;
    private int currentQuestionIndex = 0;
    private int score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz3);

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
                    Toast.makeText(Quiz3.this, "Please select an answer", Toast.LENGTH_SHORT).show();
                    return;
                } else {

                    //If answer is correct score is incremented, if not the correct answer is displayed
                    String selectedAnswer = selectedAnswerRadioButton.getText().toString();
                    if (selectedAnswer.equals(currentQuestion.getCorrectAnswer())) {
                        score++;
                        Toast.makeText(Quiz3.this, "Correct!", Toast.LENGTH_SHORT).show();

                    } else {
                        Toast.makeText(Quiz3.this, "Incorrect Answer! The correct answer is: " + currentQuestion.getCorrectAnswer(), Toast.LENGTH_LONG).show();
                    }
                }
                //Increments the index so the next question is selected
                if (currentQuestionIndex < questions.length - 1) {

                    currentQuestionIndex++;
                    showQuestion();
                } else {
                    // Quiz is finished, show score then redirect back to main menu
                    Intent intent = new Intent(Quiz3.this, ScoreActivity.class);
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





