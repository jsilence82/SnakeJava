package main;

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

    public long getElapsedSeconds() {
        long elapsedTime;
        if (watchRunning){
            elapsedTime = (System.nanoTime() - startTime);
        }
        else {
            elapsedTime = (stopTime - startTime);
        }
        long nanSecondsPerSecond = 1000000000;
        return elapsedTime / nanSecondsPerSecond;
    }
}
