package main;

public class Character {
    public static final int rec_width = 25;
    public static final int rec_height = 25;
    private int positionX;
    private int positionY;

    public Character(int positionX, int positionY) {
        this.positionX = positionX;
        this.positionY = positionY;
    }

    public boolean intersects(Character character2) {
        return this.positionX == character2.getPositionX() && this.positionY == character2.getPositionY();
    }

    public int getPositionX() {
        return this.positionX;
    }

    public void setPositionX(int increment) {
        this.positionX = this.positionX + increment;
    }

    public int getPositionY() {
        return this.positionY;
    }

    public void setPositionY(int increment) {
        this.positionY = this.positionY + increment;
    }
}
