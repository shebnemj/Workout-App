package com.example.sebnem.workoutapp;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.method.ScrollingMovementMethod;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import android.os.Bundle;

import java.util.ArrayList;

public class ExerciseDetailsPage extends AppCompatActivity implements View.OnClickListener {

    ArrayList<ArrayList<Exercise>> wExerciseList = Workout.wExercises();
    Exercise ex=Exercise.exercises.get(0);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //String exerciseType = getIntent().getStringExtra("TYPE");
        final String exName = getIntent().getStringExtra("name");
        for(int i=0;i<Exercise.exercises.size();i++){
            if(Exercise.exercises.get(i).getExerciseName().equals(exName))
                ex=Exercise.exercises.get(i);
        }
        switch(ex.getType()){

            case "Cardio":

                setContentView(R.layout.activity_exercise_cardio_details);

                Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
                setSupportActionBar(toolbar);
                ActionBar actionBar = getSupportActionBar();
                actionBar.setDisplayHomeAsUpEnabled(true);

                //String exerciseNameC = getIntent().getStringExtra("cardioName");
                TextView nameC = (TextView) findViewById(R.id.textID20);
                nameC.setText(ex.getExerciseName());

                //String exerciseDescriptionC = getIntent().getStringExtra("species");
                TextView myTextt2 = (TextView) findViewById(R.id.textID140);
                myTextt2.setText(ex.getDescription());
                myTextt2.setMovementMethod(new ScrollingMovementMethod());

                //String exerciseEquipmentC = getIntent().getStringExtra("equipment");
                TextView myTextt3 = (TextView) findViewById(R.id.textID160);
                myTextt3.setText(ex.getEquipment());

                //Integer cardioImage = getIntent().getIntExtra("maybimage",0);
                ImageView imageViewC = (ImageView) findViewById(R.id.imageView4);
                imageViewC.setImageResource(ex.getImage());

                TextView typeCardio = (TextView) findViewById(R.id.textID110);
                typeCardio.setText("Cardio");

                break;

            case "Muscle":

                setContentView(R.layout.activity_exercise_muscle_details);

                Toolbar toolbarr = (Toolbar) findViewById(R.id.toolbar);
                setSupportActionBar(toolbarr);
                ActionBar actionBarr = getSupportActionBar();
                actionBarr.setDisplayHomeAsUpEnabled(true);

                //String savedExtra = getIntent().getStringExtra("animal");
                TextView myText = (TextView) findViewById(R.id.textID2);
                myText.setText(ex.getExerciseName());

                //String exerciseDescripTest = getIntent().getStringExtra("species");
                TextView myText2 = (TextView) findViewById(R.id.textID14);
                myText2.setText(ex.getDescription());
                myText2.setMovementMethod(new ScrollingMovementMethod());

                //String exerciseEquipment = getIntent().getStringExtra("equipment");
                TextView myText3 = (TextView) findViewById(R.id.textID16);
                myText3.setText(ex.getEquipment());

                //Integer exerciseReps = getIntent().getIntExtra("reps",0);
                TextView repsMuscle = (TextView) findViewById(R.id.textID30);
                repsMuscle.setText("10");

                //Integer muscleImage = getIntent().getIntExtra("maybimage",0);
                ImageView imageView = (ImageView) findViewById(R.id.imageView3);
                imageView.setImageResource(ex.getImage());

                TextView typeMuscle = (TextView) findViewById(R.id.textID11);
                typeMuscle.setText(ex.getType());

                Button removeExButton = (Button) findViewById(R.id.removeEx);
                removeExButton.setOnClickListener(this);

                break;

        }
    }

    public void onClick(View view) {

        Intent intent = new Intent(ExerciseDetailsPage.this, AllExercisesPage.class);

        for (int i = 0;i<Exercise.exercises.size();i++) {
            if(Exercise.exercises.get(i).equals(ex)){

                for(int j=0;j<wExerciseList.size();j++){
                    for(int k = 0; k < wExerciseList.get(j).size();k++){
                        if(wExerciseList.get(j).get(k).equals(ex)){
                            wExerciseList.get(j).remove(k);
                        }
                    }
                }

                Exercise.exercises.remove(i);
                break;
            }
        }



        startActivity(intent);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the app bar.
        getMenuInflater().inflate(R.menu.menu_edit, menu);
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
            case R.id.action_edit:
                intent=new Intent(this,EditExerciseActivity.class);
                intent.putExtra("pos",getIntent().getIntExtra("pos",0));
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}

