package com.example.sebnem.workoutapp;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ExerciseTimer  extends AppCompatActivity {

    boolean resumed;
    private int seconds=0;
    private boolean startRun;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer);



        if(savedInstanceState != null){
            seconds = savedInstanceState.getInt("seconds");
            startRun=savedInstanceState.getBoolean("startRun");
        }

        Timer();



    }

    public void onSaveInstanceState(Bundle saveInstanceState){
        saveInstanceState.putInt("seconds", seconds);
        saveInstanceState.putBoolean("startRun", startRun);
    }

    public void onClickStart(View view){
        startRun=true;
        final TextView tStatus = (TextView)findViewById(R.id.textStatus);
        tStatus.setText("Running");
    }

    public void onClickStop(View view){
        startRun=false;
        final TextView tStatus = (TextView)findViewById(R.id.textStatus);
        tStatus.setText("Paused");
    }

    public void onClickReset(View view){
        startRun=false;
        seconds=0;
        final TextView tStatus = (TextView)findViewById(R.id.textStatus);
        tStatus.setText("Paused");
    }

    private void Timer(){
        final TextView timeView = (TextView)findViewById(R.id.timerTextView);
        final Handler handler = new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {
                int hours = seconds/3600;
                int minutes = (seconds%3600)/60;
                int secs = seconds%60;

                String time = String.format("%d:%02d:%02d", hours, minutes, secs);

                timeView.setText(time);

                if(startRun){
                    seconds++;
                }

                handler.postDelayed(this, 1000);
            }
        });

    }
}
