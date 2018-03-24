package com.example.sebnem.workoutapp;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

public class WorkoutDetailsPage extends AppCompatActivity {

    String[] nameArray = Exercise.eNames();

    Integer[] imageArray = Exercise.eImages();

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout_details);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        String savedExtra = getIntent().getStringExtra("animal");
        TextView myText = (TextView) findViewById(R.id.textID);
        myText.setText(savedExtra);

        String workoutDescripTest = getIntent().getStringExtra("species");
        TextView myText2 = (TextView) findViewById(R.id.textID6);
        myText2.setText(workoutDescripTest);

        Integer workoutImage = getIntent().getIntExtra("maybimage",0);
        ImageView imageView = (ImageView) findViewById(R.id.imageView2);
        imageView.setImageResource(workoutImage);

        showData();

    }

    protected void showData(){
        CustomExerciseListAdapter whatever = new CustomExerciseListAdapter(this, nameArray, imageArray);
        listView = (ListView) findViewById(R.id.listviewWD);
        listView.setAdapter(whatever);

        final List<Exercise> list=Exercise.exercises;

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position,
                                    long id) {
                switch(list.get(position).getType()){

                    case "Cardio":

                        Intent intent = new Intent(WorkoutDetailsPage.this, ExerciseDetailsPage.class);
                        String message = list.get(position).getExerciseName();
                        String message2 = list.get(position).getDescription();
                        String equip = list.get(position).getEquipment();
                        Integer image = list.get(position).getImage();
                        String type = list.get(position).getType();
                        intent.putExtra("cardioName", message);
                        intent.putExtra("species", message2);
                        intent.putExtra("maybimage", image);
                        intent.putExtra("equipment", equip);
                        intent.putExtra("TYPE", type);
                        startActivity(intent);

                        break;

                    case "Muscle":

                        intent = new Intent(WorkoutDetailsPage.this, ExerciseDetailsPage.class);
                        message = list.get(position).getExerciseName();
                        message2 = list.get(position).getDescription();
                        equip = list.get(position).getEquipment();
                        image = list.get(position).getImage();
                        type = list.get(position).getType();
                        //Integer reps = ((Muscle)list.get(position)).getReps(); //what?? solve this -- basically when i do .getReps() it doesn't go through because list is exercise, not muscle..?
                        intent.putExtra("animal", message);
                        intent.putExtra("species", message2);
                        intent.putExtra("maybimage", image);
                        intent.putExtra("equipment", equip);
                        intent.putExtra("TYPE", type);
                        //intent.putExtra("reps", reps);
                        startActivity(intent);

                        break;

                }
            }
        });
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
                intent = new Intent(this, EditWorkoutActivity.class);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
