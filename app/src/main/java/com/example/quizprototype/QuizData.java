package com.example.quizprototype;

import android.app.Activity;
import android.util.Log;


import com.google.gson.Gson;

import java.lang.ref.WeakReference;
import java.util.List;

public class QuizData implements Runnable {
    private WeakReference<Activity> doneReference;
    private List<Question> results;
    private String category;

    public QuizData(Activity done, String category) {
        this.doneReference = new WeakReference<Activity>(done);
        this.category = category;
    }

    private Question getHTTP() {
        String TAG = "send";
        Log.d(TAG, "Getting API data");

        HTTPHelper http = new HTTPHelper();
        String url =
                http.readHTTP(
                        category);
        System.out.println(url);

        Gson gson = new Gson();
        Question list = gson.fromJson(url, Question.class);
        return list;
    }

    public void run() {
        final Question newList = getHTTP();

        final Activity done = doneReference.get();
        if (done != null) {
            done.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    System.out.println(newList);

                }
            });
        }
    }
}
