package com.example.quizprototype;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class Launch extends AppCompatActivity {

    protected void onCreate (Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.launch);
    }

    public void launchGame(View view){

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);

    }
}
