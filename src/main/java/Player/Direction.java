package Player;


import Courses.*;
import Clubs.*;
import java.lang.Math;


public class Direction {
    private final static double NORTH = 0;
    private final static double EAST = 90;
    private final static double SOUTH = 180;
    private final static double WEST = 270;
    private final static double NORTH_EAST = 45;
    private final static double SOUTH_EAST = 135;
    private final static double SOUTH_WEST = 225;
    private final static double NORTH_WEST = 315;
    private double direction;

    public Direction() {
        this.direction = NORTH;
    }

    public Direction(double degrees) {
        if (degrees >= 360) {
            degrees = degrees % 360;
        }
        if (degrees == 0) {
            this.direction = NORTH;
        } else if (degrees == 45) {
            this.direction = NORTH_EAST;
        } else if (degrees == 90) {
            this.direction = EAST;
        } else if (degrees == 135) {
            this.direction = SOUTH_EAST;
        } else if (degrees == 180) {
            this.direction = SOUTH;
        } else if (degrees == 225) {
            this.direction = SOUTH_WEST;
        } else if (degrees == 270) {
            this.direction = WEST;
        } else if (degrees == 315) {
            this.direction = NORTH_WEST;
        } else {
            this.direction = degrees;
        }
    }

    public double getDirection() {
        return direction;
    }

    public void setDirection(double degrees) {
        if (degrees >= 360) {
            degrees = degrees % 360;
        }
        if (degrees == 0) {
            this.direction = NORTH;
        } else if (degrees == 45) {
            this.direction = NORTH_EAST;
        } else if (degrees == 90) {
            this.direction = EAST;
        } else if (degrees == 135) {
            this.direction = SOUTH_EAST;
        } else if (degrees == 180) {
            this.direction = SOUTH;
        } else if (degrees == 225) {
            this.direction = SOUTH_WEST;
        } else if (degrees == 270) {
            this.direction = WEST;
        } else if (degrees == 315) {
            this.direction = NORTH_WEST;
        } else {
            this.direction = degrees;
        }
    }

    public void setDirectionToHole(Hole h) {
        int[] a = h.getHoleLocation();
        double yards = a[0];
        int posHole = a[1];
        int ballPosYards = Ball.getPosX();
        int ballPos = Ball.getPosY();
        double degrees;
        double opposite = ballPos - posHole;
        if (opposite != 0){
            if (yards > ballPosYards) {
                double hypotenuse = yards - ballPosYards;
                degrees = Math.toDegrees(Math.asin(opposite / hypotenuse));
                if (degrees < 0) {
                    degrees = 360 + degrees;
                }
            } else if (yards < ballPosYards) {
                double hypotenuse = ballPosYards - yards;
                degrees = Math.toDegrees(Math.asin(opposite / hypotenuse));
                degrees = degrees + 180;
            } else {
                degrees = NORTH;
            }
        } else {
            degrees = NORTH;
        }
        this.direction = degrees;
    }

}
