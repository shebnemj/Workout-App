package com.example.sebnem.workoutapp;

import java. util.*;

public class SEProject {
    private static User user;

    public static void main(String[] args) {

        user =  User.getInstance();
        boolean loop = true;
        
        while(loop)
        {
            homepage();
        }

    }
    
    public static void homepage(){
        System.out.println(" \n HOMEPAGE\n .........");
        System.out.println("Please select one of the following: \n 1. Workouts \n 2.Exercises \n 3.Settings \n 0. Exit System");
        
        int option = inputInt();
        
        if(option == 0)
        {
            System.exit(0);
        }
        else if(option ==1)
        {
            workoutSelect();
        }
        else if (option==2)
        {
            exerciseSelect();
        }
        else if (option==3)
        {
            setting();
        }
        else
        {
            System.out.println("That is an invalid option. Please try again");
            homepage();
        }
    }
    
    public static void workoutSelect(){
        System.out.println("Welcome to the WORKOUT \n ..............");
        System.out.println("\n Workouts Avaliable: ");
        user.displayWorkouts();
        System.out.println("\n Please select one of the following: \n 1. View Workout Info \n 2. Add Workout \n 3. Edit Workout \n 4. Remove Workout \n 5. return to Homepage \n 0. Exit System");
        
        int option = inputInt();
        Workout w;
        if(option == 0)
        {
            System.exit(0);
        }
        else if(option ==1)
        {

            System.out.println("Select a workout by entering a number");
            int n  = inputInt();
            w = user.selectWorkout(n);
            user.viewWorkoutInfo(w);
        }
        else if (option==2)
        {
            System.out.println("checker");
            user.createWorkout();
        }

        else if (option==3)
        {
            System.out.println("Select a workout by entering a number");
            int n  = inputInt();
            w = user.selectWorkout(n);
            user.editWorkout(w);
        }
        else if (option==4)
        {
            System.out.println("Select a workout by entering a number");
            int n  = inputInt();
            w = user.selectWorkout(n);
            user.removeWorkout(w);

            System.out.println("This workout " + w.getWorkoutName()+ " has been removed");
        }
        else if (option==5)
        {
            homepage();
        }
        else
        {
            System.out.println("That is an invalid option. Please try again");
            workoutSelect();
        }
    }
    
    public static void exerciseSelect(){
        System.out.println("Welcome to the EXERCISE \n .........");
        System.out.println("\n Exercise Avaliable: ");
        user.displayExercises();
        System.out.println("\n Please select one of the following: \n 1. View Exercise Info \n 2. Add Exercise \n 3. Edit Exercise \n 4. Remove Exercise \n 5. return to Homepage \n 0. Exit System");
        
        int option = inputInt();
        Exercise ex;
        if(option == 0)
        {
            System.exit(0);
        }
        else if(option ==1)
        {
            System.out.println("Select a exercise by entering a number");
            int n  = inputInt();
            ex = user.selectExercise(n);
            user.viewExerciseInfo(ex);
        }
        else if (option==2)
        {
            System.out.println("What type of Exercise would you like to add? For Muscle (M) or Cardio (C)");
            String exType = input();

            user.createExercise(exType);
        }
        else if (option==3)
        {
            System.out.println("Select a exercise by entering a number");
            int n  = inputInt();
            ex = user.selectExercise(n);
            user.editExercise(ex);
        }
        else if (option==4)
        {
            System.out.println("Select a exercise by entering a number");
            int n  = inputInt();
            ex = user.selectExercise(n);
            user.removeExercise(ex);
        }
        else if (option==5)
        {
            homepage();
        }
        else
        {
            System.out.println("That is an invalid option. Please try again");
            exerciseSelect();
        }

        exerciseSelect();
    }
    
    public static void setting(){
        System.out.println("Welcome to the SETTINGS \n .........");
        System.out.println("\n Please select one of the following: \n 1. Change Name \n 2. Change Weight \n 3. Change Height \n 4. return to Homepage \n 0. Exit System");
        
        int option = inputInt();
        Exercise ex;
        if(option == 0)
        {
            System.exit(0);
        }
        else if(option ==1)
        {
            System.out.println("Please enter a new name");
            String name = input();
            user.setName(name);
        }
        else if (option==2)
        {
            System.out.println("Please enter a new weight");
            double wei = inputDouble();
            user.addWeight(wei);
        }
        else if (option==3)
        {
            System.out.println("Please enter a new height");
            double hei = inputDouble();
            user.addHeight(hei);
        }
        else if (option==4)
        {
            homepage();
        }
        else
        {
            System.out.println("That is an invalid option. Please try again");
            setting();
        }
        
    }
    
    // this method reads the users input
    public static String input()
    {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
    
    // this method converts the input to an integer with the use of an exception to  ensure that the input is an integer
    public static int inputInt () {
        int numInput = -1;
        try {
            numInput = Integer.parseInt(input());
        } catch (NumberFormatException nfe) {
        }

        return numInput;
    }

    // this method converts the input to a double with the use of an exception to  ensure that the input is an double
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

