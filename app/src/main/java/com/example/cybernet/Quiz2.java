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

public class Quiz2 extends AppCompatActivity {


    private TextView questionTextView;
    private RadioButton answer1RadioButton;
    private RadioButton answer2RadioButton;
    private RadioButton answer3RadioButton;
    private Button nextButton;

    public static Question[] questions = {
            new Question("What is phishing?", "A form of malware which targets the CPU", "A type of social engineering attack", "A way of catching fish", "A type of social engineering attack"),
            new Question("What is the most common way that phishers try to trick people?", "By sending a text message with a link to a virus", "By calling and asking for personal information", "By sending an email with a link to a fake login page", "By sending an email with a link to a fake login page"),
            new Question("How can you protect yourself from phishing?", "By clicking on links without thinking", "By being skeptical of unsolicited emails and messages", "By giving out personal information to anyone who asks", "By being skeptical of unsolicited emails and messages"),
            new Question("What is the purpose of a phishing attack?", "To steal sensitive information like passwords or credit card numbers", "To infect a computer with malware", "To crash a website", "To steal sensitive information like passwords or credit card numbers"),
            new Question("Which of the following is a common feature of a phishing email?", "The email is sent from a legitimate company", "The email contains a link to a website that looks identical to the real one", "The email contains no links or attachments", "The email contains a link to a website that looks identical to the real one"),
            new Question("What should you do if you receive a suspicious email?", "Delete it immediately", "Forward it to all your contacts", "Reply to the sender asking for more information", "Delete it immediately"),
            new Question("What is spear phishing?", "Phishing with a fishing rod", "Phishing aimed at specific individuals or organizations", "Phishing while wearing a spear", "Phishing aimed at specific individuals or organizations"),
            new Question("What is whaling?", "A type of fishing with harpoons", "A type of phishing aimed at senior executives or high-profile targets", "A type of phishing with whales", "A type of phishing aimed at senior executives or high-profile targets"),
            new Question("What is pharming?", "A type of phishing that involves fake websites", "A type of phishing that involves phone calls", "A type of phishing that involves physical mail", "A type of phishing that involves fake websites"),
            new Question("What is vishing?", "A type of phishing that involves social media", "A type of phishing that involves phone calls", "A type of phishing that involves physical mail", "A type of phishing that involves phone calls"),
            new Question("What is smishing?", "A type of phishing that involves social media", "A type of phishing that involves text messages", "A type of phishing that involves physical mail", "A type of phishing that involves text messages"),
    };

    private Question currentQuestion;
    private int currentQuestionIndex = 0;
    private int score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz2);

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
                    Toast.makeText(Quiz2.this, "Please select an answer", Toast.LENGTH_SHORT).show();
                    return;
                } else {

                //If answer is correct score is incremented, if not the correct answer is displayed
                    String selectedAnswer = selectedAnswerRadioButton.getText().toString();
                    if (selectedAnswer.equals(currentQuestion.getCorrectAnswer())) {
                        score++;
                        Toast.makeText(Quiz2.this, "Correct!", Toast.LENGTH_SHORT).show();

                    } else {
                        Toast.makeText(Quiz2.this, "Incorrect Answer! The correct answer is: " + currentQuestion.getCorrectAnswer(), Toast.LENGTH_LONG).show();
                    }
                }
                //Increments the index so the next question is selected
                if (currentQuestionIndex < questions.length - 1) {

                    currentQuestionIndex++;
                    showQuestion();
                } else {
                    // Quiz is finished, show score then redirect back to main menu
                    Intent intent = new Intent(Quiz2.this, ScoreActivity.class);
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





