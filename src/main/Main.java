package main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Main extends JFrame implements KeyListener, ActionListener {
    Snake snake;

    public Main(){

        this.snake = new Snake(this);

        Timer timer = new Timer(150, this);
        timer.start();

        java.util.Timer drawFood = new java.util.Timer();
        Food start = new Food(this.snake);
        drawFood.schedule(start,0,2000);

        add(this.snake);
        setTitle("The Snake");
        setSize(525, 525);
        this.addKeyListener(this);
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

        int key = e.getKeyCode();

        if(key == 39 && !this.snake.getDirection().equals("left")) {
            this.snake.setDirection("right");
        } else if(key == 37 && !this.snake.getDirection().equals("right")){
            this.snake.setDirection("left");
        } else if(key == 38 && !this.snake.getDirection().equals("down")){
            this.snake.setDirection("up");
        } else if (key == 40 && !this.snake.getDirection().equals("up")) {
            this.snake.setDirection("down");
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    public static void main(String[] args){
        EventQueue.invokeLater(Main::new);
    }
}
