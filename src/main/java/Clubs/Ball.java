package Clubs;

public class Ball {
    private static int posX = 0; //Yards down hole
    private static int posY = 50; //Yards off of center

    public Ball() {
        posX = 0;
        posY = 50;
    }

    public Ball(int x, int y) {
        posX = x;
        posY = y;
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
    }
}
