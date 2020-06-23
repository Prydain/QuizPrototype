package com.example.quizprototype;

import java.util.ArrayList;

public class Question {
    private String question;
    private String correct_answer;
    private ArrayList<String> incorrect_answers;

    public Question(String question, String correct_answer, ArrayList<String> incorrect_answers) {
        this.question = question;
        this.correct_answer = correct_answer;
        this.incorrect_answers = incorrect_answers;
    }

    public String getQuestion() {
        return question;
    }

    public String getCorrectAnswer() {
        return correct_answer;
    }

    public ArrayList<String> getIncorrect_answers() {
            return incorrect_answers;
    }
}
