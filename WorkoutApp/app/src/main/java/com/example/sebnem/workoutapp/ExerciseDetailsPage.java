package com.example.sebnem.workoutapp;

import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.os.Bundle;

public class ExerciseDetailsPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise_details);

        String savedExtra = getIntent().getStringExtra("animal");
        TextView myText = (TextView) findViewById(R.id.textID2);
        myText.setText(savedExtra);
    }
}

