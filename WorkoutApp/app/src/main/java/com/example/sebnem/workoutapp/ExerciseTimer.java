package com.example.sebnem.workoutapp;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ExerciseTimer  extends AppCompatActivity {

    TextView exerciseTimer;
    private CountDownTimer countDownnTimer;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        exerciseTimer = (TextView) findViewById(R.id.timertext);

        TextView exName = (TextView) findViewById(R.id.textID15);
        exName.setText("Name of Exercise");

        TextView exDescrip = (TextView) findViewById(R.id.textID19);
        exDescrip.setText("Feature to be implemented in the future.");

        workoutStartCountdown();

    }

    private void workoutStartCountdown(){

        exerciseTimer.setText("11");
        countDownnTimer = new CountDownTimer(11 * 1000,1000){

            @Override
            public void onTick(long millisUntilFinished){
                exerciseTimer.setText("" + millisUntilFinished/1000);
            }

            public void onFinish(){
                Intent intent = new Intent(ExerciseTimer.this, MainActivity.class);
                startActivity(intent);
            }
        };

        countDownnTimer.start();

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the app bar.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_settings:
                Intent intent = new Intent(this, SettingsActivity.class);
                startActivity(intent);
                return true;
            case R.id.action_profile:
                intent = new Intent(this, ProfileActivity.class);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
