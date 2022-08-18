package main;

/*
Class for the Food object. It inherits from the TimerTask class, so it can check every second if the Food object is
null. If null, a new Food object is created.

Variables positionx and positiony determines the object's placement in the game field.
 */

import java.util.Random;
import java.util.TimerTask;

public class Food extends TimerTask {

    private int positionx;
    private int positiony;
    private Snake snake;

    public Food(Snake snake) {
        this.snake = snake;
    }

    public Food() {
        this.positionx = 25 * new Random().nextInt(20);
        this.positiony = 25 * new Random().nextInt(20);
    }

    public int getPositionx() {
        return positionx;
    }

    public int getPositiony() {
        return positiony;
    }

    @Override
    public void run() {
        if (this.snake.getFood() == null) {
            this.snake.setFood(new Food());
        }

    }
}
