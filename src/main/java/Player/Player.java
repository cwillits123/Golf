package Player;
import java.lang.Math;
import Clubs.*;
import Courses.*;
import java.util.Arrays;

public class Player {
  private String name;
  private int experience;
  private int yardsOffCenter;
  private Direction direction;
  

  public Player(String n, int e) {
    name = n;
    if (e > 0 && e <= 10) {
      experience = e;
    } else {
      throw new IllegalArgumentException("Experience must be between 1 and 10 inclusive");
    }
    this.direction = new Direction();
  }

  public String getName() {
    return name;
  }


  public int getExperience() {
    return experience;
  }
  
  //returns the yards of the swing
  public int[] swing(GolfClub club, double power, Hole h) {
    int yards;
    int[] yardsAndAccuracy = new int[2];
    direction.setDirectionToHole(h);
    double dir = direction.getDirection();
    //System.out.println("HoleYards: " + h.getYards());
    //System.out.println("Direction: " + dir);
    if ((dir >= 0 && dir < 90)) {
      // Work on adding the direction to be changed based off of the angle to the hole. The orignial code is probably good for when facing hole straight on
      String surface = getSurface(h);
      yards = (int) (Math.random() * 30 + (club.getYardage() * (power * 0.1) - 15));
      //System.out.println("yards: " + yards);
      if (surface.equals("S")) {
        yards = (int) (yards * 0.5);
      } else if (surface.equals("#")) {
        yards = (int) (yards * 0.75);
      }
      double actualXDist = Math.cos(Math.toRadians(-dir)) * yards;
      //System.out.println("ActualXDist: " + actualXDist);
      double accuracy = Math.toRadians(-dir + getAccuracy());
      //System.out.println("Accuracy: -dir + accuracy : " + accuracy);
      yardsOffCenter = (int) (Math.tan(accuracy) * actualXDist);
      int xDist = (int) actualXDist;
      //System.out.println("xDist: " + xDist);
      //Overhit out of bounds is 2 stroke pentalty and hit back where you were
      h.addStroke();
      if (!(yardsOffCenter + Ball.getPosY() >= 101 || yardsOffCenter + Ball.getPosY() < 0) && !(Ball.getPosX() + xDist >= h.getYards() + 50 || Ball.getPosX() + xDist <= 0)) {
        Ball.placeBall(xDist + Ball.getPosX(), yardsOffCenter + Ball.getPosY());
        h.setDistance(h.getDistance() - xDist);
        //System.out.println("Surface: " + getSurface(h));
        if (!getSurface(h).equals("W")) {
          Ball.setPreviousPos(Ball.getPosX(), Ball.getPosY());
        }
      }
      yardsAndAccuracy[0] = xDist;
      yardsAndAccuracy[1] = yardsOffCenter;
    } else if ((dir >= 90 && dir < 180)) {
      String surface = getSurface(h);
      yards = (int) -(Math.random() * 30 + (club.getYardage() * (power * 0.1) - 15));
      //System.out.println("Yards: " + yards);
      if (surface.equals("S")) {
        yards = (int) (yards * 0.5);
      } else if (surface.equals("#")) {
        yards = (int) (yards * 0.75);
      }
      double actualXDist = -(Math.cos(Math.toRadians(dir)) * yards);
      //System.out.println("ActualXDist: " + actualXDist);
      double accuracy = Math.toRadians(dir + getAccuracy());
      //System.out.println("Accuracy: dir + accuracy : " + accuracy);
      yardsOffCenter = (int) (Math.sin(accuracy) * actualXDist);
      //Overhit out of bounds is 2 stroke pentalty and hit back where you were
      int xDist = (int) actualXDist;
      //System.out.println("xDist: " + xDist);
      h.addStroke();
      if (!(yardsOffCenter + Ball.getPosY() >= 101 || yardsOffCenter + Ball.getPosY() < 0) && !(Ball.getPosX() + xDist >= h.getYards() + 50 || Ball.getPosX() + xDist <= 0)) {
        Ball.placeBall(xDist + Ball.getPosX(), yardsOffCenter + Ball.getPosY());
        h.setDistance(h.getDistance() - xDist);
        //System.out.println("Surface: " + getSurface(h));
        if (!getSurface(h).equals("W")) {
          Ball.setPreviousPos(Ball.getPosX(), Ball.getPosY());
        }
      } 
      yardsAndAccuracy[0] = xDist;
      yardsAndAccuracy[1] = yardsOffCenter;
    } else if ((dir >= 180 && dir < 270)) {
      String surface = getSurface(h);
      yards = (int) -(Math.random() * 30 + (club.getYardage() * (power * 0.1) - 15));
      //System.out.println("Yards: " + yards);
      if (surface.equals("S")) {
        yards = (int) (yards * 0.5);
      } else if (surface.equals("#")) {
        yards = (int) (yards * 0.75);
      }
      double actualXDist = -(Math.cos(Math.toRadians(dir)) * yards);
      //System.out.println("ActualXDist: " + actualXDist);
      double accuracy = Math.toRadians(dir + getAccuracy());
      //System.out.println("Accuracy: dir + accuracy : " + accuracy);
      yardsOffCenter = (int) (Math.sin(accuracy) * actualXDist);
      //Overhit out of bounds is 2 stroke pentalty and hit back where you were
      int xDist = (int) actualXDist;
      //System.out.println("xDist: " + xDist);
      h.addStroke();
      if (!(yardsOffCenter + Ball.getPosY() >= 101 || yardsOffCenter + Ball.getPosY() < 0) && !(Ball.getPosX() + xDist >= h.getYards() + 50 || Ball.getPosX() + xDist <= 0)) {
        Ball.placeBall(xDist + Ball.getPosX(), yardsOffCenter + Ball.getPosY());
        h.setDistance(h.getDistance() - xDist);
        //System.out.println("Surface: " + getSurface(h));
        if (!getSurface(h).equals("W")) {
          Ball.setPreviousPos(Ball.getPosX(), Ball.getPosY());
        }
      }
      yardsAndAccuracy[0] = xDist;
      yardsAndAccuracy[1] = yardsOffCenter;
    } else if ((dir >= 270 && dir < 360)) {
      String surface = getSurface(h);
      yards = (int) (Math.random() * 30 + (club.getYardage() * (power * 0.1) - 15));
      //System.out.println("yards: " + yards);
      if (surface.equals("S")) {
        yards = (int) (yards * 0.5);
      } else if (surface.equals("#")) {
        yards = (int) (yards * 0.75);
      }
      double actualXDist = Math.cos(Math.toRadians(-dir)) * yards;
      //System.out.println("ActualXDist: " + actualXDist);
      double accuracy = Math.toRadians(-dir + getAccuracy());
      //System.out.println("Accuracy: -dir + accuracy : " + accuracy);
      yardsOffCenter = (int) (Math.sin(accuracy) * actualXDist);
      //Overhit out of bounds is 2 stroke pentalty and hit back where you were
      int xDist = (int) actualXDist;
      //System.out.println("xDist: " + xDist);
      h.addStroke();
      if (!(yardsOffCenter + Ball.getPosY() >= 101 || yardsOffCenter + Ball.getPosY() < 0) && !(Ball.getPosX() + xDist >= h.getYards() + 50 || Ball.getPosX() + xDist <= 0)) {
        Ball.placeBall(xDist + Ball.getPosX(), yardsOffCenter + Ball.getPosY());
        h.setDistance(h.getDistance() - xDist);
        //System.out.println("Surface: " + getSurface(h));
        if (!getSurface(h).equals("W")) {
          Ball.setPreviousPos(Ball.getPosX(), Ball.getPosY());
        }
      }
      yardsAndAccuracy[0] = xDist;
      yardsAndAccuracy[1] = yardsOffCenter;
    }
    //System.out.println("Yards and Accuracy: " + Arrays.toString(yardsAndAccuracy));
    //System.out.println("BallX and BallY: " + Arrays.toString(new int[] {Ball.getPosX(), Ball.getPosY()}));
    //System.out.println("----------------------------------------");
    return yardsAndAccuracy;
  }

  // returns the yards to the hole
  public int useRangeFinder(Hole h) {
    return h.getDistance();
  }

  //returns angle of accuracy of the swing and where it ends up
  public int getAccuracy() {
    return (int) (Math.random() * (60.0/experience) - (30.0/experience));
  }
  //Use course to figure out the position of obstacles
  public String getSurface(Hole h) {
    String[][] g = h.getGolfHole();
    return g[Ball.getPosX()][Ball.getPosY()];
  }

  public void setDirection(Direction direction) {
    this.direction = direction;
  }

  public Direction getDirection() {
    return direction;
  }

  

  
}