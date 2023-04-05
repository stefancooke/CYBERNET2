package com.example.cybernet;


public class Question {

    private String text;
    private String answer1;
    private String answer2;
    private String answer3;
    private String correctAnswer;

    public Question(String text, String answer1, String answer2, String answer3, String correctAnswer) {
        this.text = text;
        this.answer1 = answer1;
        this.answer2 = answer2;
        this.answer3 = answer3;
        this.correctAnswer = correctAnswer;
    }

    public String getText() {
        return text;
    }

    public String getAnswer1() {
        return answer1;
    }

    public String getAnswer2() {
        return answer2;
    }

    public String getAnswer3() {
        return answer3;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }
}
