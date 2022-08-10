import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Snake extends JPanel {

    private static final Color color = new Color(115,162,78);
    private static int start = 250;
    private static int speed = 25;

    private ArrayList body;

    private Food food;
    private Main window;


    public Snake(main.Main window){
        this.window = window;

        this.body = new ArrayList();

    }

    public void checkCollision(){

    }

    public void moveSnake(){

    }

    public void drawSnake(){

    }



}
