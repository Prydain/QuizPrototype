package com.example.quizprototype;

import android.app.Activity;
import android.widget.Toast;

import java.lang.ref.WeakReference;
import java.util.Dictionary;

public class displayToast implements Runnable {
    private WeakReference<Activity> doneReference;

    private String message;

    public displayToast(Activity done, String message) {
        this.doneReference = new WeakReference<Activity>(done);
        this.message = message;
    }

    public void run() {
        final Activity done = doneReference.get();
        if (done != null) {

            done.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    CharSequence text = message;
                    int duration = Toast.LENGTH_SHORT;
                    Toast toast = Toast.makeText(done, text, duration);
                    toast.show();
                }
            });
        }
    }
}
