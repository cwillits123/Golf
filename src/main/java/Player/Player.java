package Player;
import java.lang.Math.*;
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
    direction.setDirectionToHole(h);
    String surface = getSurface(h);
    if (Ball.getPosX() > h.getYards()) {
      yards = (int) -(Math.random() * 30 + (club.getYardage() * (power * 0.1) - 15));
    } else {
      yards = (int) (Math.random() * 30 + (club.getYardage() * (power * 0.1) - 15));
    }
    if (surface.equals("Sand")) {
      yards = (int) (yards * 0.5);
    } else if (surface.equals("Rough")) {
      yards = (int) (yards * 0.75);
    }
    double accuracy = Math.toRadians(direction.getDirection() - getAccuracy());
    yardsOffCenter = (int) (Math.sin(accuracy) * yards);
    //Overhit out of bounds is 2 stroke pentalty and hit back where you were
    h.addStroke();
    if (!(yardsOffCenter + Ball.getPosY() >= 101 || yardsOffCenter + Ball.getPosY() < 0) && !(Ball.getPosX() + yards >= h.getYards() + 50 || Ball.getPosX() + yards <= 0)) {
      Ball.placeBall(yards + Ball.getPosX(), yardsOffCenter + Ball.getPosY());
      h.setDistance(h.getDistance() - yards);
      if (getSurface(h).equals("Water")) {
        Ball.placeBall(Ball.getPosX() - yards, Ball.getPosY() - yardsOffCenter);
        h.setDistance(h.getDistance() + yards);
      }
    }
    int[] yardsAndAccuracy = {yards, yardsOffCenter};
    System.out.println(Arrays.toString(yardsAndAccuracy));
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