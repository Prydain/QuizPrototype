package com.example.quizprototype;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Results {
    private List<Question> results;

    public Results(List<Question> results) {
        this.results = results;
    }

    public List<String> getResultsQuestion(int i) {
        return Collections.singletonList(results.get(i).getQuestion());
    }

    public List<String> getResultsCorrect(int i) {
        return Collections.singletonList(results.get(i).getCorrectAnswer());
    }

    public List<ArrayList<String>> getResultsIncorrect(int i) {
        return Collections.singletonList(results.get(i).getIncorrect_answers());
    }
}
