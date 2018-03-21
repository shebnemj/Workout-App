package com.example.sebnem.workoutapp;

import java.util.*;

public class UserStats {

	private User user;
	private ArrayList<Workout> allWorkouts;
	private ArrayList<Exercise> allExercises;

        public UserStats() {
        
        
        }
        
	public int exerciseCompleted() {
            int tempCount = 0;
            for(int i=0; i>allExercises.size();i++){}
                 //   tempCount += allExercises.get(i)
            return tempCount;
	}

	public int workoutCompleted() {
		int tempCount = 0;
            for(int i=0; i>allWorkouts.size();i++){}
                    // tempCount += allWorkouts.get(i);
            return tempCount;
	}

	/*public float averageTime() {
		float temp = 0;
		for(int i = 0; i < allWorkouts.size(); i++){
            temp += allWorkouts.get(i).getWorkoutDuration();

        }
		return temp;
	}

	public float averageTime() {
		float temp = 0;
		for(int i = 0; i < allWorkouts.size(); i++){
            temp += allWorkouts.get(i).getWorkoutDuration();

        }
		return temp / allWorkouts.size();
	}
*/
	public double BMI() { //Work in progress (Not tested)
            ArrayList<Double> tempW = user.getWeight();
            ArrayList<Double> tempH = user.getHeight();
            double BMIW = tempW.get(tempW.size() - 1);
            double BMIH = tempH.get(tempH.size() - 1);
            return (BMIW / BMIH) / BMIH;
            
	}

}