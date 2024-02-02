package main;

public class Robot {
    private int x;
    private int y;
    private int direction;
    private boolean isDead;

    public Robot() {
        x = 0;
        y = 0;
        direction = 0;
        isDead = false;
    }

    public void move() {
        if (!isDead) {
            switch (direction) {
                case 0: // North
                    y--;
                    break;
                case 1: // East
                    x++;
                    break;
                case 2: // South
                    y++;
                    break;
                case 3: // West
                    x--;
                    break;
            }
            System.out.println("The robot moves to (" + x + ", " + y + ")");
        } else {
            System.out.println("The robot is dead and cannot move.");
        }
    }

    public void turnLeft() {
        if (!isDead) {
            direction = (direction + 3) % 4; // Turn 90 degrees to the left (counter-clockwise)
            System.out.println("The robot turns left");
        } else {
            System.out.println("The robot is dead and cannot turn.");
        }
    }

    public void turnRight() {
        if (!isDead) {
            direction = (direction + 1) % 4; // Turn 90 degrees to the right (clockwise)
            System.out.println("The robot turns right");
        } else {
            System.out.println("The robot is dead and cannot turn.");
        }
    }

    public int getDirection() {
        return direction;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void die() {
        isDead = true;
        System.out.println("The robot dies");
    }
    public void setDirection(int direction) {
        this.direction = direction;
    }
    public boolean isDead() {
        return isDead;
    }
}