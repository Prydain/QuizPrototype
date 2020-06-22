package com.example.quizprototype;

import java.util.ArrayList;

public class Question {
    private String question;
    private String correctAnswer;
    private ArrayList<String> incorrect_answers;

    public Question(String question, String correctAnswer, ArrayList<String> incorrect_answers) {
        this.question = question;
        this.correctAnswer = correctAnswer;
        this.incorrect_answers = incorrect_answers;
    }
}
