package main;

public class Rectangle {

    private int positionx;
    private int positiony;

    public static final int rec_width = 25;
    public static final int rec_height = 25;

    public Rectangle(int positionx, int positiony){
        this.positionx = positionx;
        this.positiony = positiony;
    }

    public boolean intersects(Rectangle rectangle2){
        return this.positionx == rectangle2.getPositionx() && this.positiony == rectangle2.getPositiony()
    }

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
}
