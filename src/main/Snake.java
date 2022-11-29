package main;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

import static main.Character.rec_height;
import static main.Character.rec_width;

public class Snake extends JPanel {
    private static final Color color = new Color(255, 255, 255);
    private static final int start = 50;
    private static final int speed = 25;
    private ArrayList<Character> body;
    private String direction;
    private Food food;
    private final Main window;
    private final Stopwatch scoreClock;

    public Snake(main.Main window) {
        this.window = window;

        this.body = new ArrayList<>();
        body.add(new Character(start, start));
        Character last = this.body.get(0);
        body.add(new Character(last.getPositionX() - rec_width, last.getPositionY()));
        Character last_2 = this.body.get(1);
        body.add(new Character(last_2.getPositionX() - rec_width, last_2.getPositionY()));

        this.direction = "right";

        this.scoreClock = new Stopwatch();
        this.scoreClock.start();
    }

    /*
    Adds a new Character block to the end of the Snake. Switch case determines which direction the Snake is currently
    traveling, so it can determine where the last Character block is located and then adds a new Character to the end.
     */
    public void addPart() {
        Character last = this.body.get(this.body.size() - 1);
        switch (this.direction) {
            case "right" -> this.body.add(new Character(last.getPositionX() - rec_width, last.getPositionY()));
            case "left" -> this.body.add(new Character(last.getPositionX() + rec_width, last.getPositionY()));
            case "up" -> this.body.add((new Character(last.getPositionX(), last.getPositionY() + rec_width)));
            case "down" -> this.body.add(new Character(last.getPositionX(), last.getPositionY() - rec_width));
        }
    }

    /*
    The checkCollision method is called after each move of the Snake object. It determines the length of the snake and
    if the head collides with any part of the Snake. It also checks if the head exceeds the boundaries of the window.
    It also checks if the Snake intersects with the Food object

    A return of true ends the game. False allows the game to continue.
     */
    public boolean checkCollision() {
        Character character3 = this.body.get(0);
        for (int i = 1; i < this.body.size(); i++) {
            Character character2 = this.body.get(i);
            if (character3.intersects(character2) || character3.getPositionX() > this.window.getWidth() || character3.getPositionX() < 0
                    || character3.getPositionY() > this.window.getHeight()
                    || character3.getPositionY() < 0){
                return true;
            }
        }

        if (this.food != null) {
            if (character3.intersects(new Character(this.food.getPositionX(), this.food.getPositionY()))) {
                this.food = null;
                this.addPart();
                this.scoreClock.stop();
                this.window.updateScore(this.scoreClock.getElapsedSeconds());
                this.window.updateTimer();
                this.scoreClock.start();
                return false;
            }
        }
        return false;
    }

    public void moveSnake() {

        ArrayList<Character> newList = new ArrayList<>();

        Character first = this.body.get(0);
        Character head = new Character(first.getPositionX(), first.getPositionY());

        // Received from the keyPressed Listener from the Main class. Changes the direction of the head, depending on
        // key pressed.
        switch (this.direction) {
            case "right" -> head.setPositionX(speed);
            case "left" -> head.setPositionX(-speed);
            case "up" -> head.setPositionY(-speed);
            case "down" -> head.setPositionY(speed);
        }
        newList.add(head);

        for (int i = 1; i < this.body.size(); i++) {
            Character previous = this.body.get(i - 1);
            Character newCharacter = new Character(previous.getPositionX(), previous.getPositionY());
            newList.add(newCharacter);
        }

        this.body = newList;
        checkCollision();
        if (checkCollision()){
            this.window.setVisible(false);
            this.window.endGame();
        }
    }

    // Draws the Snake and the Food using Graphics2D class.
    public void drawSnake(Graphics g) {
        moveSnake();

        Graphics2D graphic = (Graphics2D) g;

        if (this.food != null) {
            graphic.setPaint(Color.red);
            graphic.drawOval(this.food.getPositionX(), this.food.getPositionY(), rec_width, rec_height);
            graphic.fillOval(this.food.getPositionX(), this.food.getPositionY(), rec_width, rec_height);
        }

        graphic.setPaint(Color.green);
        for (Character rec : this.body) {
            graphic.drawRect(rec.getPositionX(), rec.getPositionY(), rec_width, rec_height);
            graphic.fillRect(rec.getPositionX(), rec.getPositionY(), rec_width, rec_height);
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        setBackground(color);
        drawSnake(g);
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public String getDirection() {
        return this.direction;
    }

    public Food getFood() {
        return food;
    }

    public void setFood(Food food) {
        this.food = food;
    }
}