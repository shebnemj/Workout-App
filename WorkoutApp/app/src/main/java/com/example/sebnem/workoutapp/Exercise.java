package com.example.sebnem.workoutapp;

import java.util.ArrayList;

public abstract class Exercise {

    private String exerciseName;
    private String description;
    private int imageLink;
    private String equipment;
    private String type;

    public static ArrayList<Exercise> exercises = User.getInstance().getExerciseList();

    public static String[] eNames(){
        String[] names=new String[exercises.size()];
        for (int i=0;i<names.length;i++){
            names[i]=exercises.get(i).getExerciseName();
        }
        return names;
    }
    public static Integer[] eImages(){
        Integer[] images=new Integer[exercises.size()];
        for (int i=0;i<images.length;i++){
            images[i]=exercises.get(i).getImage();
        }
        return images;
    }

    public Exercise(String name, String descrip, int imglink, String equip, String type) {
        setExerciseName(name);
        setDescription(descrip);
        setImage(imglink);
        setEquipment(equip);
        ExerciseStats stats = new ExerciseStats();
        stats.setCount(0);
        this.type=type;
    }

    public String getExerciseName() {
        return this.exerciseName;
    }

    public String getDescription() {
        return this.description;
    }

    public int getImage() {
        return this.imageLink;
    }

    public String getEquipment() { return this.equipment; }

    public void setExerciseName(String name) {
        this.exerciseName = name;
    }

    public void setDescription(String descrip) {
        this.description = descrip;
    }

    public void setImage(int imglink) {
        this.imageLink = imglink;
    }

    public void setEquipment(String equip) {
        this.equipment = equip;
    }

    public void setType(String typeOfExercise){
        this.type = typeOfExercise;
    }

    public String getType(){
        return this.type;
    }
}


