package com.example.quizprototype;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Random;

public class QuestionsScreen extends AppCompatActivity {
    public displayToast toasty;
    public QuizData data;
    private String categories;
    public Results results;
    public int i;
    public int score;
    public String scoreCategory;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //starts the question screen activity and retrieves variables.
        Intent intent = getIntent();

        categories = intent.getStringExtra("category");
        scoreCategory = intent.getStringExtra("scoreCategory");
        i = 0;
        score = 0;

        //begins API call
        data = new QuizData(this, categories);

        Thread quizThread = new Thread(data);
        quizThread.start();

        //pauses the display activity so the API call can finish.
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        setContentView(R.layout.start);

    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public void answerButton1 (View view){

        results = data.getFullList();
        Button b = (Button)view;
        String buttonText = b.getText().toString();
        String messageCorrect = "Correct!";
        String messageIncorrect = "Incorrect!";

        //displays correct toast message if correct answer is selected.
        //increments the loop and adds to score.
        if (buttonText.compareTo(results.getResultsCorrect(i)) == 0){
            toasty = new displayToast(this, messageCorrect);

            Thread displayToast = new Thread(toasty);
            displayToast.start();
            score += 1;
            i += 1;
        }

        //displays incorrect toast and doesn't add to score. increments loop.
        else {
            toasty = new displayToast(this, messageIncorrect);

            Thread displayToast = new Thread(toasty);
            displayToast.start();
            i += 1;
        }

        TextView question = (TextView) findViewById(R.id.questionText);
        TextView button1 = findViewById(R.id.answerOne);
        TextView button2 = findViewById(R.id.answerTwo);
        TextView button3 = findViewById(R.id.answerThree);
        TextView button4 = findViewById(R.id.answerFour);
        String newQuestion = results.getResultsQuestion(i);
        String newAnswer = results.getResultsCorrect(i);
        ArrayList<String> newWrongAnswers = results.getResultsIncorrect(i);
        question.setText(Html.fromHtml(newQuestion, Html.FROM_HTML_MODE_LEGACY));

        //begins the loop that displays the different questions and answers.
        if (i < 9) {
            Random r = new Random();
            int r1 = r.nextInt(4);
            int r2 = r.nextInt(4);
            int r3 = r.nextInt(4);
            int r4 = r.nextInt(4);

            //assigns random variables for each button.
            while (r2 == r1) {
                r2 = r.nextInt(4);
            }

            while (r3 == r1 || r3 == r2) {
                r3 = r.nextInt(4);
            }

            while (r4 == r1 || r4 == r2 || r4 == r3) {
                r4 = r.nextInt(4);
            }

            //switch statements display data using the random number to randomize their position.
            switch(r1) {
                case 0 :
                    button1.setText(Html.fromHtml(newAnswer, Html.FROM_HTML_MODE_LEGACY));
                    //button1.setText(newAnswer);
                    break;

                case 1 :
                    button2.setText(Html.fromHtml(newAnswer, Html.FROM_HTML_MODE_LEGACY));
                    //button2.setText(newAnswer);
                    break;

                case 2 :
                    button3.setText(Html.fromHtml(newAnswer, Html.FROM_HTML_MODE_LEGACY));
                    //button3.setText(newAnswer);
                    break;

                case 3 :
                    button4.setText(Html.fromHtml(newAnswer, Html.FROM_HTML_MODE_LEGACY));
                    //button4.setText(newAnswer);
                    break;
                default : // Optional
                    // Statements
            }

            switch(r2) {
                case 0 :
                    button1.setText(Html.fromHtml(newWrongAnswers.get(0), Html.FROM_HTML_MODE_LEGACY));
                    break;

                case 1 :
                    button2.setText(Html.fromHtml(newWrongAnswers.get(0), Html.FROM_HTML_MODE_LEGACY));
                    break;

                case 2 :
                    button3.setText(Html.fromHtml(newWrongAnswers.get(0), Html.FROM_HTML_MODE_LEGACY));
                    break;

                case 3 :
                    button4.setText(Html.fromHtml(newWrongAnswers.get(0), Html.FROM_HTML_MODE_LEGACY));
                    break;
                default :
            }

            switch(r3) {
                case 0 :
                    button1.setText(Html.fromHtml(newWrongAnswers.get(1), Html.FROM_HTML_MODE_LEGACY));
                    break;

                case 1 :
                    button2.setText(Html.fromHtml(newWrongAnswers.get(1), Html.FROM_HTML_MODE_LEGACY));
                    break;

                case 2 :
                    button3.setText(Html.fromHtml(newWrongAnswers.get(1), Html.FROM_HTML_MODE_LEGACY));
                    break;

                case 3 :
                    button4.setText(Html.fromHtml(newWrongAnswers.get(1), Html.FROM_HTML_MODE_LEGACY));
                    break;
                default :
            }

            switch(r4) {
                case 0 :
                    button1.setText(Html.fromHtml(newWrongAnswers.get(2), Html.FROM_HTML_MODE_LEGACY));
                    break;

                case 1 :
                    button2.setText(Html.fromHtml(newWrongAnswers.get(2), Html.FROM_HTML_MODE_LEGACY));
                    break;

                case 2 :
                    button3.setText(Html.fromHtml(newWrongAnswers.get(2), Html.FROM_HTML_MODE_LEGACY));
                    break;

                case 3 :
                    button4.setText(Html.fromHtml(newWrongAnswers.get(2), Html.FROM_HTML_MODE_LEGACY));
                    break;
                default :
            }

        }

        //when 10 questions have been displayed, moves on to the results.
        else{
            Intent intent = new Intent(this, ResultsScreen.class);
            intent.putExtra("score", score);
            intent.putExtra("category", scoreCategory);

            startActivity(intent);
        }
    }

}
