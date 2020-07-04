package com.example.quizprototype;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


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

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = getIntent();

        categories = intent.getStringExtra("category");
        i = 0;
        score = 0;

        data = new QuizData(this, categories);

        Thread quizThread = new Thread(data);
        quizThread.start();

        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        setContentView(R.layout.start);

    }

    public void answerButton1 (View view){

        results = data.getFullList();
        Button b = (Button)view;
        String buttonText = b.getText().toString();
        String messageCorrect = "Correct!";
        String messageIncorrect = "Incorrect!";

        if (buttonText == results.getResultsCorrect(i)){
            toasty = new displayToast(this, messageCorrect);

            Thread displayToast = new Thread(toasty);
            displayToast.start();
            score += 1;
            i += 1;
        }

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
        question.setText(newQuestion);

        if (i < 9) {
            Random r = new Random();
            int r1 = r.nextInt(4);
            int r2 = r.nextInt(4);
            int r3 = r.nextInt(4);
            int r4 = r.nextInt(4);

            while (r2 == r1) {
                r2 = r.nextInt(4);
            }

            while (r3 == r1 || r3 == r2) {
                r3 = r.nextInt(4);
            }

            while (r4 == r1 || r4 == r2 || r4 == r3) {
                r4 = r.nextInt(4);
            }

            switch (r1) {
                case 0:
                    button1.setText(newAnswer);
                    break;

                case 1:
                    button2.setText(newAnswer);
                    break;

                case 2:
                    button3.setText(newAnswer);
                    break;

                case 3:
                    button4.setText(newAnswer);
                    break;
                default: // Optional
                    // Statements
            }

            switch (r2) {
                case 0:
                    button1.setText(newWrongAnswers.get(0));
                    break;

                case 1:
                    button2.setText(newWrongAnswers.get(0));
                    break;

                case 2:
                    button3.setText(newWrongAnswers.get(0));
                    break;

                case 3:
                    button4.setText(newWrongAnswers.get(0));
                    break;
                default:
            }

            switch (r3) {
                case 0:
                    button1.setText(newWrongAnswers.get(1));
                    break;

                case 1:
                    button2.setText(newWrongAnswers.get(1));
                    break;

                case 2:
                    button3.setText(newWrongAnswers.get(1));
                    break;

                case 3:
                    button4.setText(newWrongAnswers.get(1));
                    break;
                default:
            }

            switch (r4) {
                case 0:
                    button1.setText(newWrongAnswers.get(2));
                    break;

                case 1:
                    button2.setText(newWrongAnswers.get(2));
                    break;

                case 2:
                    button3.setText(newWrongAnswers.get(2));
                    break;

                case 3:
                    button4.setText(newWrongAnswers.get(2));
                    break;
                default:
            }

        }

        else{
            Intent intent = new Intent(this, ResultsScreen.class);
            intent.putExtra("score", score);

            startActivity(intent);
        }
    }

}
