package main;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

import static main.Main.updateScore;
import static main.Rectangle.rec_height;
import static main.Rectangle.rec_width;

public class Snake extends JPanel {
    private static final Color color = new Color(255, 255, 255);
    private static final int start = 50;
    private static final int speed = 25;
    private ArrayList<Rectangle> body;
    private String direction;
    private Food food;
    private final Main window;


    public Snake(main.Main window) {
        this.window = window;

        this.body = new ArrayList<>();
        body.add(new Rectangle(start, start));
        Rectangle last = this.body.get(0);
        body.add(new Rectangle(last.getPositionx() - rec_width, last.getPositiony()));
        Rectangle last_2 = this.body.get(1);
        body.add(new Rectangle(last_2.getPositionx() - rec_width, last_2.getPositiony()));

        this.direction = "right";
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public String getDirection() {
        return this.direction;
    }

    public void addPart() {
        Rectangle last = this.body.get(this.body.size() - 1);
        switch (this.direction) {
            case "right" -> this.body.add(new Rectangle(last.getPositionx() - rec_width, last.getPositiony()));
            case "left" -> this.body.add(new Rectangle(last.getPositionx() + rec_width, last.getPositiony()));
            case "up" -> this.body.add((new Rectangle(last.getPositionx(), last.getPositiony() + rec_width)));
            case "down" -> this.body.add(new Rectangle(last.getPositionx(), last.getPositiony() - rec_width));
        }
    }

    public void checkCollision() {
        Rectangle rectangle3 = this.body.get(0);
        for (int i = 1; i < this.body.size(); i++) {
            Rectangle rectangle2 = this.body.get(i);

            if (rectangle3.intersects(rectangle2) || rectangle3.getPositionx() > this.window.getWidth()
                    || rectangle3.getPositionx() < 0 || rectangle3.getPositiony() > this.window.getHeight()
                    || rectangle3.getPositiony() < 0) {
                this.window.setVisible(false);
                int response = JOptionPane.showConfirmDialog(null, "Your score: " + Main.score +
                                "\nNew Game?", "Game Over!",
                        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (response == JOptionPane.YES_OPTION) {
                    new Main();
                } else if (response == JOptionPane.NO_OPTION) {
                    System.exit(0);
                } else if (response == JOptionPane.CLOSED_OPTION) {
                    System.exit(0);
                }
            }
        }

        if (this.food != null) {
            if (rectangle3.intersects(new Rectangle(this.food.getPositionx(), this.food.getPositiony()))) {
                this.food = null;
                this.addPart();
                updateScore();
            }
        }
    }

    public void moveSnake() {

        ArrayList<Rectangle> newList = new ArrayList<>();

        Rectangle first = this.body.get(0);
        Rectangle head = new Rectangle(first.getPositionx(), first.getPositiony());

        switch (this.direction) {
            case "right" -> head.setPositionx(speed);
            case "left" -> head.setPositionx(-speed);
            case "up" -> head.setPositiony(-speed);
            case "down" -> head.setPositiony(speed);
        }
        newList.add(head);

        for (int i = 1; i < this.body.size(); i++) {
            Rectangle previous = this.body.get(i - 1);
            Rectangle newRectangle = new Rectangle(previous.getPositionx(), previous.getPositiony());
            newList.add(newRectangle);
        }

        this.body = newList;
        checkCollision();
    }

    public void drawSnake(Graphics g) {
        moveSnake();

        Graphics2D graphic = (Graphics2D) g;

        if (this.food != null) {
            graphic.setPaint(Color.red);
            graphic.drawOval(this.food.getPositionx(), this.food.getPositiony(), rec_width, rec_height);
            graphic.fillOval(this.food.getPositionx(), this.food.getPositiony(), rec_width, rec_height);
        }

        graphic.setPaint(Color.green);
        for (Rectangle rec : this.body) {
            graphic.drawRect(rec.getPositionx(), rec.getPositiony(), rec_width, rec_height);
            graphic.fillRect(rec.getPositionx(), rec.getPositiony(), rec_width, rec_height);
        }
    }

    public Food getFood() {
        return food;
    }

    public void setFood(Food food) {
        this.food = food;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        setBackground(color);
        drawSnake(g);
    }
}
