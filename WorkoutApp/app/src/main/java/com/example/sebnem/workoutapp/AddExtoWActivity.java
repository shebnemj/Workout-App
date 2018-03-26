package
        com.example.sebnem.workoutapp;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class AddExtoWActivity extends AppCompatActivity {

    MyCustomAdapter dataAdapter = null;
    Workout wN;
    ArrayList<WorkoutEx> exSelected = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_exto_w);
        String wName = getIntent().getStringExtra("wName");
        String wDes = getIntent().getStringExtra("wDes");
        int wDur = getIntent().getIntExtra("wDur", 10);
        int wImg = getIntent().getIntExtra("wImg", R.drawable.abs);

        wN = new Workout(wName,true, wDes,wDur,wImg);
        Workout.workouts.add(wN);
        displayListView();

        checkButtonClick();

        confirmButtonClick();

    }

    private void displayListView(){
        ArrayList<Exercise>exAval = User.getInstance().getExerciseList();
        ArrayList<WorkoutEx>eList = new ArrayList<>();

        for(int i =0; i<exAval.size(); i++){
            WorkoutEx exW = new WorkoutEx(exAval.get(i), false);
            eList.add(exW);
        }

        dataAdapter = new MyCustomAdapter(this, R.layout.workoutex_info, eList);
        ListView listView = (ListView) findViewById(R.id.listView1);
        // Assign adapter to ListView
        listView.setAdapter(dataAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                // When clicked, show a toast with the TextView text
                WorkoutEx e = (WorkoutEx) parent.getItemAtPosition(position);
                Toast.makeText(getApplicationContext(),
                        "Clicked on : " + e.getExName(), Toast.LENGTH_LONG)
                        .show();
            }
        });
    }

    private class MyCustomAdapter extends ArrayAdapter<WorkoutEx> {
        private ArrayList<WorkoutEx> eList;

        public MyCustomAdapter(Context context, int textViewResourceId,

                               ArrayList<WorkoutEx> eList) {
            super(context, textViewResourceId, eList);
            this.eList = new ArrayList<WorkoutEx>();
            this.eList.addAll(eList);
        }

        private class ViewHolder {
            TextView exercise;
            CheckBox exName;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            ViewHolder holder = null;

            Log.v("ConvertView", String.valueOf(position));

            if (convertView == null) {

                LayoutInflater vi = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);

                convertView = vi.inflate(R.layout.workoutex_info, null);

                holder = new ViewHolder();
                holder.exercise = (TextView) convertView.findViewById(R.id.code);
                holder.exName = (CheckBox) convertView
                        .findViewById(R.id.checkBox1);

                convertView.setTag(holder);

                holder.exName.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        CheckBox cb = (CheckBox) v;
                        WorkoutEx _state = (WorkoutEx) cb.getTag();

                        Toast.makeText(
                                getApplicationContext(),
                                "Checkbox: " + cb.getText() + " -> "
                                        + cb.isChecked(), Toast.LENGTH_LONG)
                                .show();

                        _state.setSelected(cb.isChecked());
                    }
                });

            } else {
                holder = (ViewHolder) convertView.getTag();
            }

            WorkoutEx state = eList.get(position);

            holder.exercise.setText(" (" + state.getEx() + ")");
            holder.exName.setText(state.getExName());
            holder.exName.setChecked(state.isSelected());

            holder.exName.setTag(state);

            return convertView;
        }

    }
    private void checkButtonClick() {

        Button myButton = (Button)findViewById(R.id.findSelected);

        myButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                StringBuffer responseText = new StringBuffer();
                responseText.append("Exercises selected...\n");

                ArrayList<WorkoutEx> elist = dataAdapter.eList;

                for (int i = 0; i < elist.size(); i++) {
                    WorkoutEx state = elist.get(i);

                    if (state.isSelected()) {
                        responseText.append("\n" + state.getExName());
                    }
                }

                Toast.makeText(getApplicationContext(), responseText,
                        Toast.LENGTH_LONG).show();

                exSelected=elist;
            }
        });
    }

    private void confirmButtonClick() {

        Button myButton = (Button)findViewById(R.id.create);

        myButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                for(int i=0; i<exSelected.size(); i++){
                    Exercise exAdd = exSelected.get(i).getEx();
                    wN.addWExercise(exAdd);
                }

                Intent intent = new Intent(AddExtoWActivity.this, AllWorkoutsPage.class);
                startActivity(intent);
            }
        });
    }
}
