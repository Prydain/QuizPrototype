package com.example.quizprototype;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ResultsScreen extends AppCompatActivity {

    public int finalScore;
    public String category;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.results);
        Intent intent = getIntent();
        finalScore = intent.getIntExtra("score", 0);
        category = intent.getStringExtra("category");


        TextView scoreField = findViewById(R.id.textView2);
        scoreField.setText(String.valueOf(finalScore));


        SharedPreferences savedScore =
                getApplicationContext().getSharedPreferences("highScore", Context.MODE_PRIVATE);

        String oldScore = savedScore.getString(category, "0");

        if (oldScore.compareTo(String.valueOf(finalScore)) < 0) {
            SharedPreferences.Editor editor = savedScore.edit();
            editor.putString(category, String.valueOf(finalScore));
            editor.apply();
        }
    }
    public void returnMainMenu(View view) {
        findViewById(R.id.mainMenuButton);

        Intent intent = new Intent(this, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }
}
