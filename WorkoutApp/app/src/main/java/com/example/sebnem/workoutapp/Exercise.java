package com.example.sebnem.workoutapp;

import android.support.constraint.solver.widgets.ConstraintAnchor;

public abstract class Exercise {

    private String exerciseName;
    private String description;
    private int imageLink;
    private String link;
    private String notes;
    private String equipment;

    public static final Exercise[] exercises = {
            new Cardio("Climbers","is this gonna work i wonder", R.drawable.yogamatt,"yogamatt","","Yoga Matt",20,2,0),
            new Cardio("Jumping Jacks","Okay",R.drawable.yogamatt,"yogamatt","","Yoga Matt",10,2,0),
            new Cardio("Climbers","is this gonna work i wonder", R.drawable.yogamatt,"yogamatt","","Yoga Matt",20,2,0),
            new Cardio("Climbers","is this gonna work i wonder", R.drawable.abs,"yogamatt","","Yoga Matt",20,2,0),
            new Cardio("Climbers","is this gonna work i wonder", R.drawable.yogamatt,"yogamatt","","Yoga Matt",20,2,0),
            new Cardio("Climbers","is this gonna work i wonder", R.drawable.yogamatt,"yogamatt","","Yoga Matt",20,2,0),
            new Cardio("Climbers","is this gonna work i wonder", R.drawable.yogamatt,"yogamatt","","Yoga Matt",20,2,0),
            new Cardio("Butt Kicks","okkkkkk", R.drawable.yogamatt,"yogamatt","","Yoga Matt",20,2,0)
    };

    public static String[] eNames(){
        String[] names=new String[exercises.length];
        for (int i=0;i<names.length;i++){
            names[i]=exercises[i].getExerciseName();
        }
        return names;
    }
    public static Integer[] eImages(){
        Integer[] images=new Integer[exercises.length];
        for (int i=0;i<images.length;i++){
            images[i]=exercises[i].getImage();
        }
        return images;
    }

    public Exercise(String name, String descrip, int imglink, String hyperlink, String newnote, String equip, int c) {
        setExerciseName(name);
        setDescription(descrip);
        setImage(imglink);
        setLink(hyperlink);
        setNotes(newnote);
        setEquipment(equip);

        ExerciseStats stats = new ExerciseStats();
        stats.setCount(c);
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

    public String getLink() { return this.link; }

    public String getNotes() {
        return this.notes;
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

    public void setLink(String hyperlink) {
        this.link = hyperlink;
    }

    public void setNotes(String newnote) {
        this.notes = newnote;
    }

    public void setEquipment(String equip) {
        this.equipment = equip;
    }

}
