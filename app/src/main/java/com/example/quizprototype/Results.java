package com.example.quizprototype;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Results {
    private List<Question> results;

    public Results(List<Question> results) {
        this.results = results;
    }

    //getters to access the API data. 
    public String getResultsQuestion(int i) {
        return results.get(i).getQuestion();
    }

    public String getResultsCorrect(int i) {
        return results.get(i).getCorrectAnswer();
    }

    public ArrayList<String> getResultsIncorrect(int i) {
        return results.get(i).getIncorrect_answers();
    }
}
