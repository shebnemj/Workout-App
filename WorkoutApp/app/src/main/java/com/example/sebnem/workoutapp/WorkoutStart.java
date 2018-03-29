package com.example.sebnem.workoutapp;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import java.util.List;

/**
 * Created by sebnem on 24/03/2018.
 */

public class WorkoutStart extends AppCompatActivity {

    TextView workoutStartTimer;
    private CountDownTimer countDownTimer;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout_start_countdown);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        workoutStartTimer = (TextView) findViewById(R.id.workoutSCD);

        workoutStartCountdown();
    }

    private void workoutStartCountdown(){

        workoutStartTimer.setText("4");
        countDownTimer = new CountDownTimer(4 * 1000,1000){

            @Override
            public void onTick(long millisUntilFinished){
                workoutStartTimer.setText("" + millisUntilFinished/1000);
            }

            public void onFinish(){
                Intent intent = new Intent(WorkoutStart.this, ExerciseTimer.class);
                String workoutName = getIntent().getStringExtra("name");
                intent.putExtra("name", workoutName);
                startActivity(intent);
            }
        };

        countDownTimer.start();
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
