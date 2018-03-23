package com.example.sebnem.workoutapp;

import java.util.ArrayList;

public abstract class Exercise {

    private String exerciseName;
    private String description;
    private int imageLink;
    //private String link;
    //private String notes;
    private String equipment;
    private String type;

    public static ArrayList<Exercise> exercises = User.getInstance().getExerciseList();
   // public static ArrayList<Exercise> exercises =initArrayList();

    /*private static ArrayList<Exercise> initArrayList(){
        ArrayList<Exercise> exs=new ArrayList<>();
        exs.add(new Muscle("Barbell Shrugs","",R.drawable.barbell_shrugs,"Barbell"));
        exs.add(new Muscle("Bench Press","",R.drawable.bench_press,"Bench"));
        exs.add(new Muscle("Butterfly Machine","",R.drawable.butterfly_machine,""));
        exs.add(new Muscle("Cable Crossover","",R.drawable.cable_crossover,""));
        exs.add(new Muscle("Chest Dips","",R.drawable.chest_dips,""));
        exs.add(new Muscle("Chin Ups","",R.drawable.chin_ups,""));
        exs.add(new Muscle("Dumbbell Flys","",R.drawable.dumbbell_flys,"Dumbbell"));
        exs.add(new Muscle("Dumbbell Lunges","",R.drawable.dumbbell_lunges,"Dumbbell"));
        exs.add(new Muscle("Front Dumbbell Raise","",R.drawable.front_dumbbell_raise,"Dumbbell"));
        exs.add(new Muscle("Leg Extensions","",R.drawable.leg_extensions,""));
        exs.add(new Muscle("Machine Bench Press","",R.drawable.machine_bench_press,""));
        exs.add(new Muscle("Narrow Stance Leg Press","",R.drawable.narrow_stance_leg_press,""));
        exs.add(new Muscle("Pull Ups","",R.drawable.pull_ups,"N/A"));
        exs.add(new Muscle("Push Ups","",R.drawable.push_ups,"N/A"));
        exs.add(new Muscle("Seated Barbell Shoulder Press","",R.drawable.seated_barbell_shoulder_press,"Barbell"));
        exs.add(new Muscle("Seated Cable Rows","",R.drawable.seated_cable_rows,""));
        exs.add(new Muscle("Seated Leg Curl","",R.drawable.seated_leg_curl,""));
        exs.add(new Muscle("Seated Shoulder Press Machine","",R.drawable.seated_shoulder_press_machine,""));
        exs.add(new Muscle("Shoulder Shrugs","",R.drawable.shoulder_shrugs,""));
        exs.add(new Muscle("Squats Using Dumbbells","",R.drawable.squats_using_dumbbells,"Dumbbells"));
        exs.add(new Muscle("Upright Cable Row","",R.drawable.upright_cable_row,""));
        exs.add(new Muscle("Wide Grip Lat Pull Down","",R.drawable.wide_grip_lat_pull_down,""));
        return exs;
    }

*/

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

    public Exercise(String name, String descrip, int imglink, String equip,String type) {
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

    /*public String getLink() {
        return this.link;
    }*/

    /*public String getNotes() {
        return this.notes;
    }*/

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

    /*public void setLink(String hyperlink) {
        this.link = hyperlink;
    }*/

    /*public void setNotes(String newnote) {
        this.notes = newnote;
    }*/

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


