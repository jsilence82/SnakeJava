package main;


/* The Stopwatch class controls the timer which dictates the score. The method nanoTime() is called when a new Food
is created and serves as the start time. It is called again when collision between Snake and Food is detected and
serves as a stop time.
 */
public class Stopwatch {

    private long startTime = 0;
    private long stopTime = 0;
    private boolean watchRunning = false;

    public void start(){
        this.startTime = System.nanoTime();
        this.watchRunning = true;
    }

    public void stop(){
        this.stopTime = System.nanoTime();
        this.watchRunning = true;
    }

    public double getElapsedSeconds() {
        double elapsedTime;
        if (watchRunning){
            elapsedTime = (System.nanoTime() - startTime);
        }
        else {
            elapsedTime = (stopTime - startTime);
        }
        double nanSecondsPerSecond = 1000000000;
        return elapsedTime / nanSecondsPerSecond;
    }
}
