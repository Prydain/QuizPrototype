package com.example.quizprototype;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class QuestionsScreen extends AppCompatActivity {
    public QuizData fullQuiz;
    public QuizData data;
    private String categories;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.start);
        Intent intent = getIntent();

        categories = intent.getStringExtra("category");

        data = new QuizData(this, categories);

        Thread quizThread = new Thread(data);
        quizThread.start();
    }

}
