package com.example.sebnem.workoutapp;

import java.util.*;
import java.io.*;


public class User {

    private static User instance = new User();
    private String userName;
    private ArrayList<Double> userWeight;
    private ArrayList<Double> userHeight;
    private ArrayList<Workout> workoutList;
    private ArrayList<Exercise> exerciseList;

    private User() {
        userHeight = new ArrayList<>();
        userWeight = new ArrayList<>();
        workoutList = new ArrayList<>();
        exerciseList = new ArrayList<>();
        exerciseList = setExercises();
        workoutList = setWorkouts();
    }

    public static User getInstance() {
        return instance;
    }

    public void setName(String name) {
        userName = name;
    }

    public String getName() {
        return userName;
    }

    public ArrayList<Double> getWeight() {
        return userWeight;
    }

    public void addWeight(double weight) {
        userWeight.add((double) weight);
    }

    public ArrayList<Double> getHeight() {
        return userHeight;
    }

    public void addHeight(double height) {
        userHeight.add((double) height);
    }

    //******************************** EXERCISE METHODS **********************************//
    // display a list of all exercises
    public void displayExercises() {
        for (int i = 0; i < exerciseList.size(); i++) {
            System.out.println("Exercise " + (i + 1) + ": " + exerciseList.get(i).getExerciseName() + "\n");
        }
    }

    // show information about a specific exercise
    public void viewExerciseInfo(Exercise ex) {
        System.out.println("Exercise Name: "+ex.getExerciseName() + "\n Description: " + ex.getDescription() + "\n Equipment: "  + ex.getEquipment());
    }


	// adds a created exercise to the list of exercises
	public void createExercise(String exType) {
        Exercise exN;

        System.out.println("Name of the exercise?");
        String exNName = input();
        System.out.println("Description");
        String des = input();
        System.out.println("Equipment");
        String equip = input();

        if (exType.equalsIgnoreCase("m")) {
            System.out.println("Number of reps");
            int rep = inputInt();
            System.out.println("weight");
            double equipW = inputDouble();
            System.out.println("Muscle Name/Type");
            String mName = input();
            exN = new Muscle(exNName, des, rep ,equip);
            exerciseList.add(exN);
            System.out.println("Exercise Added");
        }
        else{
            System.out.println("Time");
            int t = inputInt();
            System.out.println("Distance");
            double d = inputDouble();
            exN = new Cardio(exNName, des,t ,equip);
            exerciseList.add(exN);
            System.out.println("Exercise Added");
        }
    }

    public void editExercise(Exercise ex) {
        System.out.println("What would you like to edit \n 1. Name \n 2. Description \n 3. Equipment \n 0. Return to Homepage");
        int option = inputInt();

        if(option == 0)
        {
            SEProject.homepage();
        }
        else if(option ==1)
        {
            System.out.println("Change name to:");
            String newN = input();
            ex.setExerciseName(newN);
            System.out.println("Exercise name has been edited");
        }
        else if (option==2)
        {
            System.out.println("Change description to:");
            String newD = input();
            ex.setDescription(newD);
            System.out.println("Exercise description has been edited");
        }
        else if (option==3)
        {
            System.out.println("Change equipment to:");
            String newE = input();
            ex.setExerciseName(newE);
            System.out.println("Exercise equipment has been edited");
        }
    }

    
    public Exercise selectExercise(int n) {
        if (n <= exerciseList.size()){
            return exerciseList.get(n-1);
        }
        System.out.println("Wrong exercise selected");
        return null;
    }

    // removes an exercise from the list of exercises

    public void removeExercise(Exercise ex) {

        exerciseList.remove(ex);
        System.out.println("Exercise has been removed");
    }

    //******************************** WORKOUT METHODS **********************************//

    public void displayWorkouts() {
        for (int i = 0; i < workoutList.size(); i++) {
            System.out.println("Workout " + (i + 1) + ": " + workoutList.get(i).getWorkoutName());
        }
    }

    public void viewWorkoutInfo(Workout w) {
        //System.out.println(w.getWorkoutName() + ", " + w.getWorkoutDescription() + ", " + w.getWorkoutDuration() + ", " + w.getWorkoutType());
        w.printWorkoutInfo();
    }

    public void createWorkout() {
        Workout wN;
        System.out.println(" What is the Workout Name");
        String wNName = input();
        System.out.println("What is the workout description");
        String wNDes = input();
        System.out.println("What is the workout duration");
        int wNDur = inputInt();

        wN = new Workout(wNName, true,wNDes,wNDur);

        boolean cont = true;

        while(cont){
            System.out.println("What exercises would you like to add? Please the number of the exercise you wish to add or 0 to stop");
            displayExercises();
            int userInput = inputInt();
            if(userInput <= exerciseList.size()) {
                if (userInput == 0) {
                    System.out.println("No More Exercises will be added");
                    cont = false;
                } else {
                    Exercise exW = selectExercise(userInput);
                    wN.addWExercise(exW);
                    System.out.println("Exercise " + exW.getExerciseName() + " has been added to the new workout " + wN.getWorkoutName());
                    cont = true;
                }
            }
            else{
                System.out.println("Invalid Input");
                cont = true;
            }
        }
        workoutList.add(wN);
        viewWorkoutInfo(wN);
    }

    // TODO - edit a specific workout
    public void editWorkout(Workout w) {
        System.out.println("What would you like to edit \n 1. Name \n 2. Description \n 3. Duration \n 4. Add Exercise \n 5. Remove Exercise \n 0. Return to Homepage");
        int option = inputInt();

        if(option == 0)
        {
            SEProject.homepage();
        }
        else if(option ==1)
        {
            System.out.println("Change name to:");
            String newN = input();
            w.setWorkoutName(newN);
            System.out.println("Workout name has been edited");
        }
        else if (option==2)
        {
            System.out.println("Change description to:");
            String newD = input();
            w.setWorkoutDescription(newD);
            System.out.println("Workout description has been edited");
        }
        else if (option==3)
        {
            System.out.println("Change Duration to:");
            int newDur = inputInt();
            w.setWorkoutDuration(newDur);
            System.out.println("Workout duration has been edited");
        }
        else if (option == 4){
            System.out.println("Exercises in the Workout " + w.getWorkoutName() +":");
            w.printExerciseList();
            System.out.println("Exercise avaliable to add");
            displayExercises();
            System.out.println("Select the exercise you wish to add to the workout by entering its number");
            int n  = inputInt();
            Exercise exAddW = selectExercise(n);

            w.addWExercise(exAddW);
            w.printWorkoutInfo();
            SEProject.workoutSelect();
        }
        else if (option==5){
            System.out.println("Exercises in the Workout " + w.getWorkoutName() +":");
            w.printExerciseList();

            System.out.println("Select the exercise you wish to remove by entering its number");
            int n  = inputInt();
            Exercise exRemW = w.selectExfromW(n);
            w.removeWExercise(exRemW);
            w.printWorkoutInfo();
            SEProject.workoutSelect();

        }

    }

    public void removeWorkout(Workout w) {
        workoutList.remove(w);
    }

    public Workout selectWorkout(int n) {
        if (n <= workoutList.size()) {
            return workoutList.get(n-1);
        }
        System.out.println("Wrong workout selected");
        return null;
    }

/************************************* READ FROM TEXT FILE*****************************/
    // this method reads from a text file to import the data of the ex4

    public ArrayList<Exercise> setExercises()
    {
        ArrayList<Exercise> exercisesSaved = new ArrayList<Exercise>();
        //exercisesSaved.add(new Cardio("TreadmillExercise", "Running", "Treadmill", 4, 10, 4.1 ));
        //System.out.println("added");
        try
        {
            Scanner input = new Scanner(new File("src/ExerciseList.txt"));
            while (input.hasNext()){
                String line =input.nextLine();
                String [] temp = line.split("#");
                if (temp[0].equals("c"))
                {
                    exercisesSaved.add(new Cardio(temp[1], temp[2], 3, temp[3]));
                }
                else if (temp[0].equals("m"))
                {
                    exercisesSaved.add(new Muscle(temp[1], temp[2], 4, temp[3]));
                }
            }
            return exercisesSaved;
        }

        catch(IOException e)
        {
            System.out.println("ERROR: The data has not been imported successfully");
        }
        return exercisesSaved;
    }

    public ArrayList<Workout> setWorkouts()
    {
        ArrayList<Workout> workoutsSaved = new ArrayList<Workout>();
        Workout wSave;
        Exercise exAddW;
        //exercisesSaved.add(new Cardio("TreadmillExercise", "Running", "Treadmill", 4, 10, 4.1 ));
        //System.out.println("added");
        try
        {
            Scanner input = new Scanner(new File("src/WorkoutList.txt"));
            while (input.hasNext()){
                String line =input.nextLine();
                String [] temp = line.split("#");

                wSave =new Workout(temp[0], true, temp[1], Integer.parseInt(temp[2]));

                 for(int i=3; i<temp.length; i++){

                     exAddW = selectExercise(Integer.parseInt(temp[i]));
                     wSave.addWExercise(exAddW);

                 }
                workoutsSaved.add(wSave);

            }
            return workoutsSaved;
        }

        catch(IOException e)
        {
            System.out.println("ERROR: The data has not been imported successfully");
        }
        return workoutsSaved;
    }


/***************************** INPUT METHODS *****************************/
    // this method reads the users input
    public static String input()
    {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    // this method converts the input to an integer with the use of an exception to  eb=nsure that the input is an integer
    public static int inputInt () {
        int numInput = -1;
        try {
            numInput = Integer.parseInt(input());
        } catch (NumberFormatException nfe) {
        }

        return numInput;
    }

    // this method converts the input to an integer with the use of an exception to  eb=nsure that the input is an integer
    public static double inputDouble ()
    {
        double numInput = -1;
        try
        {
            numInput = Double.parseDouble(input());
        }
        catch (NumberFormatException nfe)
        {
        }

        return numInput;
    }
}
