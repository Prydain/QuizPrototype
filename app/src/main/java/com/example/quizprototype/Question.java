package com.example.quizprototype;

import java.util.ArrayList;

public class Question {
    private String question;
    private String correct_answer;
    private ArrayList<String> incorrect_answers;

    //class that defines the question, correct answers, and incorrect answers.
    public Question(String question, String correct_answer, ArrayList<String> incorrect_answers) {
        this.question = question;
        this.correct_answer = correct_answer;
        this.incorrect_answers = incorrect_answers;
    }

    //function for easy retrieval of parts of the object.
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
