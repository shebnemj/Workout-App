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
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class WorkoutDetailsPage extends AppCompatActivity implements View.OnClickListener {

    ArrayList<ArrayList<Exercise>> wExerciseList = Workout.wExercises();
    List<Workout> workoutList = Workout.workouts;

    ListView listView;

    String workoutName;

    String workoutDescrip;

    TextView myText;
    TextView myText2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout_details);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        workoutName = getIntent().getStringExtra("name");
        myText = (TextView) findViewById(R.id.textID);
        myText.setText(workoutName);

        workoutDescrip = getIntent().getStringExtra("description");
        myText2 = (TextView) findViewById(R.id.textID6);
        myText2.setText(workoutDescrip);

        Integer workoutImage = getIntent().getIntExtra("image",0);
        ImageView imageView = (ImageView) findViewById(R.id.imageView2);
        imageView.setImageResource(workoutImage);

        ImageButton startWorkout = (ImageButton) findViewById(R.id.startWorkoutButton);
        startWorkout.setOnClickListener(this);

        showData();

    }

    public void onClick(View view) {

        Intent intent = new Intent(WorkoutDetailsPage.this, WorkoutStart.class);
        startActivity(intent);

    }

    protected void showData(){

        int i;

        for(i = 0; i < workoutList.size(); i++){
            if(workoutList.get(i).getWorkoutName().equals(workoutName)) {
                break;
            }
        }

        final List<Exercise> list = wExerciseList.get(i);

        String[] nameArray = new String[list.size()];

        for (int j=0;j<nameArray.length;j++){
            nameArray[j]=list.get(j).getExerciseName();
        }

        Integer[] imageArray = new Integer[list.size()];

        for (int j=0;j<imageArray.length;j++){
            imageArray[j]=list.get(j).getImage();
        }


        CustomExerciseListAdapter whatever = new CustomExerciseListAdapter(this, nameArray, imageArray);
        listView = (ListView) findViewById(R.id.listviewWD);
        listView.setAdapter(whatever);


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
        Intent intent;
        Intent editintent;
        switch (item.getItemId()) {
            case R.id.action_settings:
                intent = new Intent(this, SettingsActivity.class);
                startActivity(intent);
                return true;
            case R.id.action_profile:
                intent = new Intent(this, ProfileActivity.class);
                startActivity(intent);
                return true;
            case R.id.action_edit:
                editintent = new Intent(this, EditWorkoutActivity.class);

                editintent.putExtra("name", workoutName);
                editintent.putExtra("description", workoutDescrip);

                startActivityForResult(editintent, 1);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }


    //@Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // check that it is the SecondActivity with an OK result
        if (requestCode == 1) {
            if (resultCode == RESULT_OK) { // Activity.RESULT_OK

                // get String data from Intent
                workoutName = data.getStringExtra("name");
                workoutDescrip = data.getStringExtra("description");

                // set text view with string
                TextView myText = (TextView) findViewById(R.id.textID);
                myText.setText(workoutName);

                myText2 = (TextView) findViewById(R.id.textID6);
                myText2.setText(workoutDescrip);

            }
        }
    }

}
