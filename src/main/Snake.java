package main;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

import static main.Rectangle.rec_height;
import static main.Rectangle.rec_width;

public class Snake extends JPanel {

    private static final Color color = new Color(115,162,78);
    private static int start = 250;
    private static int speed = 25;

    private ArrayList<Rectangle> body;

    private String direction;

    private Food food;
    private Main window;


    public Snake(main.Main window){
        this.window = window;

        this.body = new ArrayList<>();
        body.add(new Rectangle(start, start));
        Rectangle last = this.body.get(0);
        body.add(new Rectangle(last.getPositionx() - rec_width, last.getPositiony()));
        Rectangle last_2 = this.body.get(1);
        body.add(new Rectangle (last_2.getPositionx() - rec_width, last_2.getPositiony()));

        this.direction = "right";
    }

    public void setDirection(String direction){
        this.direction = direction;
    }

    public String getDirection(){
        return this.direction;
    }

    public void checkCollision(){

    }

    public void moveSnake(){

    }

    public void drawSnake(){

    }

}
