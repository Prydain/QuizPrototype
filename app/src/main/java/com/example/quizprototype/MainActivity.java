package com.example.quizprototype;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    // URL for each category
    private String category;
    private String videoGamesURL;
    private String filmURL;
    private String scienceURL;
    private String historyURL;
    private String generalURL;


    public Results list;

    public String scoreCategory;
    //keys for loading and saving to SharedPreferences
    public String highScoreKey = "highScore";
    public String videoGameKey = "videoGames";
    public String filmKey = "film";
    public String scienceKey = "science";
    public String historyKey = "history";
    public String generalKey = "general";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //intent grabbed from the Launch.java
        Intent intent = getIntent();
        category = "none";

        //sets the url variables for the api call
        setContentView(R.layout.activity_main);
        videoGamesURL = "https://opentdb.com/api.php?amount=10&category=15&difficulty=medium&type=multiple";
        filmURL = "https://opentdb.com/api.php?amount=10&category=11&difficulty=medium&type=multiple";
        scienceURL = "https://opentdb.com/api.php?amount=10&category=18&difficulty=medium&type=multiple";
        historyURL = "https://opentdb.com/api.php?amount=10&category=23&difficulty=medium&type=multiple";
        generalURL = "https://opentdb.com/api.php?amount=10&category=9&difficulty=medium&type=multiple";

        //loads each of the scores from Shared Preferences, defaulting to 0.
        SharedPreferences sharedPref = getApplicationContext().getSharedPreferences(highScoreKey, MODE_PRIVATE);
        String videoGameHighScore = sharedPref.getString(videoGameKey, "0");
        String filmHighScore = sharedPref.getString(filmKey, "0");
        String scienceHighScore = sharedPref.getString(scienceKey, "0");
        String historyHighScore = sharedPref.getString(historyKey, "0");
        String generalHighScore = sharedPref.getString(generalKey, "0");

        TextView videoGameButton = findViewById(R.id.videoGames);
        TextView filmButton = findViewById(R.id.filmButton);
        TextView scienceButton = findViewById(R.id.scienceButton);
        TextView historyButton = findViewById(R.id.historyButton);
        TextView generalButton = findViewById(R.id.generalButton);

        videoGameButton.setText("Video Games \n" + "High Score: " + videoGameHighScore);
        filmButton.setText("Film \n" + "High Score: " + filmHighScore);
        scienceButton.setText("Computer Science \n" + "High Score: " + scienceHighScore);
        historyButton.setText("History \n" + "High Score: " + historyHighScore);
        generalButton.setText("General \n" + "High Score: " + generalHighScore);
        //end of loading

    }

    //each button sets the url for api call and preps the category for later score saving.
    public void setVideoGamesURL(View view) {
        category = videoGamesURL;
        scoreCategory = "videoGames";
    }

    public void setFilmURL(View view) {
        category = filmURL;
        scoreCategory = "film";
    }

    public void setScienceURL(View view) {
        category = scienceURL;
        scoreCategory = "science";
    }

    public void setHistoryURL(View view) {
        category = historyURL;
        scoreCategory = "history";
    }

    public void setGeneralURL(View view) {
        category = generalURL;
        scoreCategory = "general";
    }

    //checks if a category was picked and then starts the new activity with the category and save.
    public void getAPIData(View view) {
        findViewById(R.id.startButton);
        if (category != "none") {
            Intent intent = new Intent(this, QuestionsScreen.class);
            intent.putExtra("category", category);
            intent.putExtra("scoreCategory", scoreCategory);

            startActivity(intent);
        }
    }
}
