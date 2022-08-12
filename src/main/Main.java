package main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Main extends JFrame implements KeyListener, ActionListener {

    Snake snake;
    JLabel scoreLabel;
    private int score = 0;
    int delay = 145;

    private Timer timer;

    public Main() {

        this.snake = new Snake(this);

        timer = new Timer(125, this);
        timer.start();

        java.util.Timer drawFood = new java.util.Timer();
        Food start = new Food(this.snake);
        drawFood.schedule(start, 0, 100);

        add(this.snake);
        setTitle("The Snake");
        setSize(600, 600);
        this.addKeyListener(this);
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        scoreLabel = new JLabel("Score: 0");
        scoreLabel.setFont(new Font("Arial", Font.BOLD, 16));
        getContentPane().add(scoreLabel, BorderLayout.NORTH);

    }

    public void endGame() {
        int response = JOptionPane.showConfirmDialog(null, "Your score: " + score +
                        "\nNew Game?", "Game Over!",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (response == JOptionPane.YES_OPTION) {
            EventQueue.invokeLater(Main::new);
        } else if (response == JOptionPane.NO_OPTION) {
            System.exit(0);
        } else if (response == JOptionPane.CLOSED_OPTION) {
            System.exit(0);
        }
    }

    public void updateTimer(){
        --delay;
        timer.stop();
        timer.setDelay(delay);
        timer.start();
    }

    public void updateScore() {
        score++;
        scoreLabel.setText("Score: " + score);
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

        if (key == 39 && !this.snake.getDirection().equals("left")) {
            this.snake.setDirection("right");
        } else if (key == 37 && !this.snake.getDirection().equals("right")) {
            this.snake.setDirection("left");
        } else if (key == 38 && !this.snake.getDirection().equals("down")) {
            this.snake.setDirection("up");
        } else if (key == 40 && !this.snake.getDirection().equals("up")) {
            this.snake.setDirection("down");
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    public static void main(String[] args) {
        EventQueue.invokeLater(Main::new);
    }
}
