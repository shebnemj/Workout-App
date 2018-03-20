package com.example.sebnem.workoutapp;

import java.util.*;

public class Workout {

    private String workoutName;
    private boolean workoutType;
    private String workoutDescription;
    private int duration;
    private ArrayList<Exercise> exerciseList;

    public static final Workout[] workouts={
            new Workout("HIIT",true, "Okay", 10),
            new Workout("Lifts",false, "is this gonna work i wonder", 15),
            new Workout("Lifts",false, "is this gonna work i wonder", 15),
            new Workout("Lifts",false, "is this gonna work i wonder", 15),
            new Workout("Lifts",false, "is this gonna work i wonder", 15),
            new Workout("Lifts",false, "is this gonna work i wonder", 15),
            new Workout("Lifts",false, "is this gonna work i wonder", 15),
            new Workout("Lifts",false, "is this gonna work i wonder", 15),
            new Workout("Yoga",false, "okkkkkk", 15)
    };

    public static String[] wNames(){
        String[] names=new String[workouts.length];
        for (int i=0;i<names.length;i++){
            names[i]=workouts[i].getWorkoutName();
        }
        return names;
    }
    public static Integer[] wImages(){
        Integer[] images=new Integer[workouts.length];
        for (int i=0;i<images.length;i++){
            images[i]=R.drawable.hiit;
        }
        return images;
    }

    public Workout(String name, boolean type, String descrip, int time) {
        setWorkoutName(name);
        setWorkoutType(type);
        setWorkoutDescription(descrip);
        setWorkoutDuration(time);
    }

    public String getWorkoutName() {
        return this.workoutName;
    }

    public boolean getWorkoutType() {
        return this.workoutType;
    }

    public String getWorkoutDescription() {
        return this.workoutDescription;
    }

    public int getWorkoutDuration() {
        return this.duration;
    }

    public void setWorkoutName(String name) {
        this.workoutName = name;
    }

    public void setWorkoutType(boolean type) {
        this.workoutType = type;
    }

    public void setWorkoutDescription(String descrip) {
        this.workoutDescription = descrip;
    }

    public void setWorkoutDuration(int time) {
        this.duration = time;
    }

    public void addWExercise(Exercise ex) {
        exerciseList.add(ex);
    }

    public void removeWExercise(Exercise ex) {
        exerciseList.remove(ex);
    }

    public void printExerciseList() {
        System.out.println("Current exercises within this workout are:");
        for(int i = 0; i < exerciseList.size(); i++){
            System.out.println(exerciseList.get(i).getExerciseName());
        }
    }

    public void printWorkoutInfo(Workout w){
        System.out.println("-----WORKOUT-----");
        System.out.println("Name: "+w.getWorkoutName());
        System.out.println("Type: "+w.getWorkoutType());
        System.out.println("Description: "+w.getWorkoutDescription());
        System.out.println("Duration:" +w.getWorkoutDuration());
        w.printExerciseList();
    }
}
