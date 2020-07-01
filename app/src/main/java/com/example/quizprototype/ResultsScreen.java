package com.example.quizprototype;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ResultsScreen extends AppCompatActivity {

    public int finalScore;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.results);
        Intent intent = getIntent();
        finalScore = intent.getIntExtra("score", 0);

        TextView scoreField = findViewById(R.id.textView2);
        scoreField.setText(String.valueOf(finalScore));

    }
}
