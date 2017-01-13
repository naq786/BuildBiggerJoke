package com.example.androidjokelibrary;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;


public class JokeDisplayActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.jokeactivity_main);

        TextView jokeDisplayTextView = (TextView)findViewById(R.id.jokeDisplayText);
        Intent i = getIntent();
        String jokeDisplayText = i.getStringExtra("JOKE_DISPLAY");
        Log.d("JOKE_DISPLAY_I",jokeDisplayText);
        jokeDisplayTextView.setText(jokeDisplayText);
    }

}
