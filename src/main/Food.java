package main;

/*
Class for the Food object. It inherits from the TimerTask class, so it can check every second if the Food object is
null. If null, a new Food object is created.

Variables positionX and positionY determines the object's placement in the game field.
 */

import java.util.Random;
import java.util.TimerTask;

public class Food extends TimerTask {

    private int positionX;
    private int positionY;
    private Snake snake;

    public Food(Snake snake) {
        this.snake = snake;
    }

    public Food() {
        this.positionX = 25 * new Random().nextInt(20);
        this.positionY = 25 * new Random().nextInt(20);
    }

    public int getPositionX() {
        return positionX;
    }

    public int getPositionY() {
        return positionY;
    }

    @Override
    public void run() {
        if (this.snake.getFood() == null) {
            this.snake.setFood(new Food());
        }

    }
}
