package com.example.quizprototype;

import android.app.Activity;
import android.os.Build;
import android.text.Html;
import android.util.Log;
import android.widget.TextView;


import androidx.annotation.RequiresApi;

import com.google.gson.Gson;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class QuizData implements Runnable {
    private WeakReference<Activity> doneReference;
    private String category;
    public Results list;

    public QuizData(Activity done, String category) {
        this.doneReference = new WeakReference<Activity>(done);
        this.category = category;
    }

    private Results getHTTP() {
        String TAG = "send";
        Log.d(TAG, "Getting API data");

        HTTPHelper http = new HTTPHelper();
        String url =
                http.readHTTP(
                        category);

        Gson gson = new Gson();
        list = gson.fromJson(url, Results.class);
        return list;
    }

    public Results getFullList() {
        return list;
    }

    public void run() {
        final Results newList = getHTTP();

        final Activity done = doneReference.get();
        if (done != null) {
            done.runOnUiThread(new Runnable() {
                @RequiresApi(api = Build.VERSION_CODES.N)
                @Override
                public void run() {

                    done.setContentView(R.layout.start);
                    TextView question = (TextView) done.findViewById(R.id.questionText);
                    TextView button1 = done.findViewById(R.id.answerOne);
                    TextView button2 = done.findViewById(R.id.answerTwo);
                    TextView button3 = done.findViewById(R.id.answerThree);
                    TextView button4 = done.findViewById(R.id.answerFour);
                    String newQuestion = list.getResultsQuestion(0);
                    String newAnswer = list.getResultsCorrect(0);
                    ArrayList<String> newWrongAnswers = list.getResultsIncorrect(0);
                    question.setText(Html.fromHtml(newQuestion, Html.FROM_HTML_MODE_LEGACY));

                    Random r = new Random();
                    int r1 = r.nextInt(4);
                    int r2 = r.nextInt(4);
                    int r3 = r.nextInt(4);
                    int r4 = r.nextInt(4);

                    while (r2 == r1){
                        r2 = r.nextInt(4);
                    }

                    while (r3 == r1 || r3 == r2){
                        r3 = r.nextInt(4);
                    }

                    while (r4 == r1 || r4 == r2 || r4 == r3){
                        r4 = r.nextInt(4);
                    }

                    switch(r1) {
                        case 0 :
                            button1.setText(Html.fromHtml(newAnswer, Html.FROM_HTML_MODE_LEGACY));
                            break;

                        case 1 :
                            button2.setText(Html.fromHtml(newAnswer, Html.FROM_HTML_MODE_LEGACY));
                            break;

                        case 2 :
                            button3.setText(Html.fromHtml(newAnswer, Html.FROM_HTML_MODE_LEGACY));
                            break;

                        case 3 :
                            button4.setText(Html.fromHtml(newAnswer, Html.FROM_HTML_MODE_LEGACY));
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
            });
        }
    }
}
