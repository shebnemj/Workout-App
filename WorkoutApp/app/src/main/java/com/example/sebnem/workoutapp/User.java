package com.example.sebnem.workoutapp;

import java.util.*;
import java.io.*;


public class User {

    private static User instance;
    private String userName="John";
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

        userHeight.add(1.795);
        userHeight.add(1.8);
        userHeight.add(1.8);
        userHeight.add(1.8);
        userHeight.add(1.8);

        userWeight.add(71.7);
        userWeight.add(69.8);
        userWeight.add(67.5);
        userWeight.add(67.0);
        userWeight.add(68.2);
    }

    public static User getInstance() {
        if(instance == null) {
            instance = new User();
        }
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

    public ArrayList<Exercise> getExerciseList() {
        return exerciseList;
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
        ArrayList<Exercise> exs=new ArrayList<>();
        exs.add(new Muscle("Barbell Shrugs","Grip a barbell with your palms facing towards your body about a shoulder-width apart. Stand up straight with your abs drawn in and your back straight. The barbell should be resting in front of your waist and your shoulders should be dropped as much as possible.\n" +
                "\n" +
                "Slowly raise the barbell up by contracting your traps and raising your shoulders. Raise the bar as high as possible, then hold this top postion for a moment.\n" +
                "\n" +
                "Slowly lower the bar back to the starting position.",R.drawable.barbell_shrugs,"Barbell"));
        exs.add(new Muscle("Bench Press","Lie flat on the benches with your feet firmly on the ground. The bar should be resting on the bench's rack.\n" +
                "\n" +
                "Lift the bar off the rack and hold it above your chest in the starting position. Lower the bar down until it touches your chest. Hold this position briefly and make sure you have complete control of the bar. Now raise the bar up to the starting postion.\n" +
                "\n" +
                "Return the bar to the rack after you've completed your set.",R.drawable.bench_press,"Bench"));
        exs.add(new Muscle("Butterfly Machine","Sit on the machine with your back flat. Adjust the height of the seat so that the pads of the machine are at your chest height. put your forearms against the pads.\n" +
                "\n" +
                "Push the pads together as you squeeze your chest. Push until the pads meet in the middle. Hold this position for a moment then return to the starting position.\n" +
                "\n",R.drawable.butterfly_machine,""));
        exs.add(new Muscle("Cable Crossover","Attach handles to the higher pulleys of both cable machines. Stand between the two machines with your legs and waist slightly bent. Grip the handles of the pulleys with your palms facing down and your arms out to your sides.\n" +
                "\n" +
                "Slowly pull the handles down towards the floor until they touch or cross over in front of you. Hold this position for a few moments then return to the starting position.",R.drawable.cable_crossover,""));
        exs.add(new Muscle("Chest Dips","Grip the bars of the dip bar and push yourself up to the starting position. Your arms should be straight and fairly close to your body. Keep your knees bent so that your feet never touch the ground.\n" +
                "\n" +
                "Slowly lower your body, leading with your chest as you go down. Your chest should start pointing down towards the ground at a 45 degree angle. Lower your body until you feel a stretch in your chest and shoulders, then begin to slowly raise your body up again.\n" +
                "\n",R.drawable.chest_dips,"Dip Bar"));
        exs.add(new Muscle("Chin Ups","Grasp a chin up bar with a slightly wider than shoulder width grip.\n" +
                "\n" +
                "Keeping your body straight pull yourself up and to one side of the bar.\n" +
                "\n" +
                "Lower your body back down to the starting position.\n" +
                "\n" +
                "Raise yourself to the other side of the bar.",R.drawable.chin_ups,""));
        exs.add(new Muscle("Dumbbell Flys","Lie on a flat bench with your arms out to your sides. Your elbows should be pointing down to the ground and your palms up to the ceiling. You should hold the dumbbells at roughly the height of your shoulders.\n" +
                "\n" +
                "Focus on using your chest to bring your arms up until the dumbbells are directly above your chest. Your biceps and triceps should just be stabilizing your arms. You shouldn't be using them for any of the lifting.\n" +
                "\n" +
                "In the top position your elbows should be facing outwards and your palms facing inwards towards each other.\n" +
                "\n" +
                "Hold the dumbbells briefly at the top then slowly lower them. Again, focus on using your chest to control the downwards motion.\n" +
                "\n",R.drawable.dumbbell_flys,"Dumbbell, bench"));
        exs.add(new Muscle("Dumbbell Lunges","Grasp a dumbbell in each hand.\n" +
                "\n" +
                "Stand with your feet about 8 inches apart, toes facing forward.\n" +
                "\n" +
                "Take a step forward (2-3 feet) keeping your abs drawn in and your upper body straight.\n" +
                "\n" +
                "Slowly lower one knee down as if kneeling while keeping your other knee bent at a 90 degree angle, do not let your knee touch the ground.\n" +
                "\n" +
                "Lower your body to just above the floor and hold for a moment before returning to the starting position.",R.drawable.dumbbell_lunges,"Dumbbell"));
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
