package com.example.sebnem.workoutapp;

public class ExerciseTimer {

	private int exerciseDuration;
    private int seconds = 0;
	private int minutes = 0;
	boolean running = true;
    

    public ExerciseTimer(int duration){
    	exerciseDuration = duration;

    }

    public void Pause() {
    	Resume(); //Needs to be implemented
    }

    public void Run() {
        

        while (running) {

            try {

                Thread.sleep(1000);

                seconds += 1;

                if(seconds ==  60) { //Change 60 to lower number for easier testing

                    minutes+= 1;

                    seconds = 0;

                }
                if(minutes==exerciseDuration){
                    running = false;
                }

                System.out.println(minutes + " : " + seconds); //Prints every second. Comment if too many outputs
            } 
            catch (InterruptedException e) {

                running = false;

                e.printStackTrace();
            }

        }
        Complete();
	}

	public void Resume() {

	}

	public void Complete() {
		System.out.println("Exercise Complete");
	}

	public int getExerciseDuration() { 
		return this.exerciseDuration;
	}

	public void setExerciseDuration(int time) {
		this.exerciseDuration = time;
	}

}