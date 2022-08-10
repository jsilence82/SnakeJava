package main;

public class Rectangle {

    private int positionx;
    private int positiony;

    public static final int rec_width = 22;
    public static final int rec_height = 22;

    public Rectangle(int positionx, int positiony){
        this.positionx = positionx;
        this.positiony = positiony;
    }

    public boolean intersects(Rectangle rectangle2){
        return this.positionx == rectangle2.getPositionx() && this.positiony == rectangle2.getPositiony();
    }

    public int getPositionx() {
        return this.positionx;
    }

    public void setPositionx(int increment) {
        this.positionx = this.positionx + increment;
    }

    public int getPositiony() {
        return this.positiony;
    }

    public void setPositiony(int increment) {
        this.positiony = this.positiony + increment;
    }
}
