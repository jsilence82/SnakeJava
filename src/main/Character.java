package main;

public class Character {
    public static final int rec_width = 25;
    public static final int rec_height = 25;
    private int positionx;
    private int positiony;

    public Character(int positionx, int positiony) {
        this.positionx = positionx;
        this.positiony = positiony;
    }

    public boolean intersects(Character character2) {
        return this.positionx == character2.getPositionx() && this.positiony == character2.getPositiony();
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
