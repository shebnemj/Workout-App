package com.example.sebnem.workoutapp;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

public class EditWorkoutActivity extends AppCompatActivity implements View.OnClickListener{

    String workoutName;
    String oldWorkoutName;

    String workoutDescrip;

    Integer[] imageArray = Workout.wImages();

    EditText workoutNameEditor;
    EditText workoutDescripEditor;
    List<Workout> list = Workout.workouts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_workout);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        final EditText editText=(EditText)findViewById(R.id.removeExField);

        workoutName = getIntent().getStringExtra("name");
        Workout w=Workout.workouts.get(0);
        for(int i=0;i<Workout.workouts.size();i++){
            if(Workout.workouts.get(i).getWorkoutName().equals(workoutName))
                w=Workout.workouts.get(i);
        }
        final Workout fw=w;
        final int size=w.getExerciseList().size();
        editText.setHint("number between 1 and "+size);
        oldWorkoutName = workoutName;
        workoutNameEditor = (EditText) findViewById(R.id.editWONameEW);
        workoutNameEditor.setText(workoutName);

        workoutDescrip = getIntent().getStringExtra("description");
        workoutDescripEditor = (EditText) findViewById(R.id.editWODescripEW);
        workoutDescripEditor.setText(workoutDescrip);

        Button removeButton =findViewById(R.id.button2);
        removeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int exToRemove=0;
                exToRemove=Integer.parseInt(editText.getText().toString());
                if(exToRemove<=size&&exToRemove>0){
                    fw.getExerciseList().remove(exToRemove-1);
                    Intent intent =new Intent(EditWorkoutActivity.this,AllWorkoutsPage.class);
                    startActivity(intent);
                }
                else{
                    Toast.makeText(getApplicationContext(),"Please enter number between 1 and "+size,Toast.LENGTH_SHORT).show();
                }
            }
        });

        Button editWorkoutButton = (Button) findViewById(R.id.action_edit_workout);
        editWorkoutButton.setOnClickListener(this);

    }

    public void onClick(View view) {
        Intent returnIntent = new Intent();
        int i;

        for(i = 0; i < list.size(); i++){
            if(list.get(i).getWorkoutName().equals(oldWorkoutName)){
                list.get(i).setWorkoutName(workoutNameEditor.getText().toString());
                list.get(i).setWorkoutDescription(workoutDescripEditor.getText().toString());
                break;
            }

        }

        returnIntent.putExtra("name", list.get(i).getWorkoutName());
        returnIntent.putExtra("description", list.get(i).getWorkoutDescription());
        returnIntent.putExtra("image", imageArray[i]);

        setResult(Activity.RESULT_OK,returnIntent);
        finish();

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
