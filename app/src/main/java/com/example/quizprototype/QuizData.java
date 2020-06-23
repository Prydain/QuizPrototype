package com.example.quizprototype;

import android.app.Activity;
import android.util.Log;


import com.google.gson.Gson;

import java.lang.ref.WeakReference;
import java.util.List;

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
                @Override
                public void run() {
                    for(int i = 0; i < 10; i++) {
                        System.out.println(newList.getResultsQuestion(i) + " " + newList.getResultsCorrect(i) + " " + newList.getResultsIncorrect(i));
                    }
                }
            });
        }
    }
}
