package com.example.quizprototype;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class Launch extends AppCompatActivity {

    protected void onCreate (Bundle savedInstanceState) {

        //creates launch window
        super.onCreate(savedInstanceState);
        setContentView(R.layout.launch);

    }

    public void launchGame(View view){

        //starts the next window
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);

    }
}
