package com.example.quizprototype;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    private String category;
    private String videoGamesURL;
    private String filmURL;
    private String scienceURL;
    private String historyURL;
    private String generalURL;
    public Results list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        videoGamesURL = "https://opentdb.com/api.php?amount=10&category=15&difficulty=medium&type=multiple";
        filmURL = "https://opentdb.com/api.php?amount=10&category=11&difficulty=medium&type=multiple";
        scienceURL = "https://opentdb.com/api.php?amount=10&category=18&difficulty=medium&type=multiple";
        historyURL = "https://opentdb.com/api.php?amount=10&category=23&difficulty=medium&type=multiple";
        generalURL = "https://opentdb.com/api.php?amount=10&category=9&difficulty=medium&type=multiple";
    }

    public void setVideoGamesURL(View view) {
        category = videoGamesURL;
    }

    public void setFilmURL(View view) {
        category = filmURL;
    }

    public void setScienceURL(View view) {
        category = scienceURL;
    }

    public void setHistoryURL(View view) {
        category = historyURL;
    }

    public void setGeneralURL(View view) {
        category = generalURL;
    }


    public void getAPIData(View view) {
        findViewById(R.id.startButton);

        Intent intent = new Intent(this, QuestionsScreen.class);
        intent.putExtra("category", category);

        startActivity(intent);
    }
}
