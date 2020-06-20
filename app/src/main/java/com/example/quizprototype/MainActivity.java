package com.example.quizprototype;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    private String category;
    private String videoGamesURL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        videoGamesURL = "https://opentdb.com/api.php?amount=10&category=15&difficulty=medium&type=boolean";
    }

    // Testing this out
    // Joe test
    // Shad test
    //Amberlee test

    public void videGames()
    {
        findViewById(R.id.sportsButton);
        category = videoGamesURL;
    }

    public void start(View view) {
        findViewById(R.id.startButton);
        StartScreen start = new StartScreen(category);

        Thread forecastThread = new Thread(start);
        forecastThread.start();
    }
}
