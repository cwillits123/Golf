package Clubs;

public class Ball {
    private static int posX = 0; //Yards down hole
    private static int posY = 50; //Yards off of center
    private static int previousX = 0; //Previous positions for the ball
    private static int previousY = 50;

    public Ball() {
        posX = 0;
        posY = 50;
        previousX = 0;
        previousY = 50;
    }

    public Ball(int x, int y) {
        posX = x;
        posY = y;
        previousX = posX;
        previousY = posY;
    }

    public static void placeBall(int x, int y) {
        posX = x;
        posY = y;
    }

    public static int getPosX() {
        return posX;
    }

    public static int getPosY() {
        return posY;
    }

    public static void placeBallOnTee() {
        posX = 0;
        posY = 50;
        previousX = 0;
        previousY = 50;
    }

    public static int getPreviousX() {
        return previousX;
    }

    public static int getPreviousY() {
        return previousY;
    }

    public static void returnToPreviousPosition() {
        posX = previousX;
        posY = previousY;
    }

    public static void setPreviousPos(int x, int y) {
        previousX = x;
        previousY = y;
    }
}
