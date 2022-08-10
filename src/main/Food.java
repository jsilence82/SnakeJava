package main;

import java.util.Random;

public class Food {

    private int positionx;
    private int positiony;

    public int getPositionx() {
        return positionx;
    }

    public void setPositionx(int positionx) {
        this.positionx = positionx;
    }

    public int getPositiony() {
        return positiony;
    }

    public void setPositiony(int positiony) {
        this.positiony = positiony;
    }

    public Food(){
        this.positionx = 25 * new Random().nextInt(20);
        this.positiony = 25 * new Random().nextInt(20);

    }

}
