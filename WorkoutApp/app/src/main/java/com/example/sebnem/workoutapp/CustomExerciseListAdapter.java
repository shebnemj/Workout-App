package com.example.sebnem.workoutapp;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class CustomExerciseListAdapter extends ArrayAdapter {

    //to reference the Activity
    private final Activity context;

    //to store the workout images
    private final Integer[] imageIDarray;

    //to store the list of workout names
    private final String[] nameArray;


    public CustomExerciseListAdapter(Activity context, String[] nameArrayParam, Integer[] imageIDArrayParam){

        super(context,R.layout.all_exercises_listview_row,nameArrayParam);

        this.context=context;
        this.imageIDarray = imageIDArrayParam;
        this.nameArray = nameArrayParam;

    }

    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater=context.getLayoutInflater();
        View rowView=inflater.inflate(R.layout.all_exercises_listview_row, null,true);

        //this code gets references to objects in the listview_row.xml file
        TextView nameTextField = (TextView) rowView.findViewById(R.id.nameTextView2ID);
        ImageView imageView = (ImageView) rowView.findViewById(R.id.imageView2ID);

        //this code sets the values of the objects to values from the arrays
        nameTextField.setText(nameArray[position]);
        imageView.setImageResource(imageIDarray[position]);

        return rowView;

    }

    public static void justifyListViewHeightBasedOnChildren (ListView listView) {

        ListAdapter adapter = listView.getAdapter();

        if (adapter == null) {
            return;
        }
        ViewGroup vg = listView;
        int totalHeight = 0;
        for (int i = 0; i < adapter.getCount(); i++) {
            View listItem = adapter.getView(i, null, vg);
            listItem.measure(0, 0);
            totalHeight += listItem.getMeasuredHeight();
        }

        ViewGroup.LayoutParams par = listView.getLayoutParams();
        par.height = totalHeight + (listView.getDividerHeight() * (adapter.getCount() - 1));
        listView.setLayoutParams(par);
        listView.requestLayout();
    }
}
