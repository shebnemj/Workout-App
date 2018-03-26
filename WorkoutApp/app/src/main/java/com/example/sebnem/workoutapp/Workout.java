package com.example.sebnem.workoutapp;

import java.util.*;

public class Workout {

    private String workoutName;
    private boolean workoutType;
    private String workoutDescription;
    private int duration;
    private int imageLink;
    private ArrayList<Exercise> exerciseList;

    public static ArrayList<Workout> workouts= User.getInstance().getWorkoutList();

    public ArrayList<Exercise> list=Exercise.exercises;

    public static String[] wNames(){
        String[] names=new String[workouts.size()];
        for (int i=0;i<names.length;i++){
            names[i]=workouts.get(i).getWorkoutName();
        }
        return names;
    }
    public static Integer[] wImages(){
        Integer[] images=new Integer[workouts.size()];
        for (int i=0;i<images.length;i++){
            images[i]=workouts.get(i).getWorkoutImageLink();
        }
        return images;
    }

    public static ArrayList<ArrayList<Exercise>> wExercises(){
        ArrayList<ArrayList<Exercise>> exercises=new ArrayList<>();
        for (int i=0;i<workouts.size();i++){
            exercises.add(workouts.get(i).getExerciseList());
        }
        return exercises;
    }

    public Workout(String name, boolean type, String descrip, int time, int imagelink) {
        setWorkoutName(name);
        setWorkoutType(type);
        setWorkoutDescription(descrip);
        setWorkoutDuration(time);
        setWorkoutImageLink(imagelink);
        exerciseList = new ArrayList<>();
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

    public int getWorkoutImageLink() {
        return this.imageLink;
    }

    public void setWorkoutImageLink(int imglink) {
        this.imageLink = imglink;
    }

    private ArrayList<Exercise> getExerciseList(){return this.exerciseList;}

    public void printExerciseList() {
        System.out.println("Current exercises within this workout are:");
        for(int i = 0; i < exerciseList.size(); i++){
            System.out.println(exerciseList.get(i).getExerciseName());
        }
    }

    public void printWorkoutInfo(){
        System.out.println("-----WORKOUT-----");
        System.out.println("Name: "+getWorkoutName());
        System.out.println("Type: "+getWorkoutType());
        System.out.println("Description: "+getWorkoutDescription());
        System.out.println("Duration:" +getWorkoutDuration());
        printExerciseList();
    }

    public Exercise selectExfromW(int n){
        if (n <= exerciseList.size()){
            return exerciseList.get(n-1);
        }
        System.out.println("Wrong exercise selected");
        return null;
    }
}
