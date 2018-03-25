package com.example.sebnem.workoutapp;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by sebnem on 24/03/2018.
 */

public class WorkoutStart extends AppCompatActivity {

    TextView workoutStartTimer;
    private CountDownTimer countDownTimer;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout_start_countdown);

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
                setContentView(R.layout.activity_workout);
            }
        };

        countDownTimer.start();
    }
}
