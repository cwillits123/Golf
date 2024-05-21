package Player;
import java.lang.Math.*;
import Clubs.*;
import Courses.*;

public class Player {
  private String name;
  private int age;
  private int experience;
  private int yardsOffCenter;
  

  public Player(String n, int a, int e) {
    name = n;
    age = a;
    if (e > 0 && e <= 10) {
      experience = e;
    } else {
      throw new IllegalArgumentException("Experience must be between 1 and 10 inclusive");
    }
  }

  public String getName() {
    return name;
  }

  public int getAge() {
    return age;
  }

  public int getExperience() {
    return experience;
  }
  
  //returns the yards of the swing
  public int[] swing(GolfClub club, double power, Hole h) {
    int yards;
    if (useRangeFinder(h) < 0) {
      yards = -(int) (Math.random() * 30 + (club.getYardage() * (power * 0.1) - 15));
    } else {
      yards = (int) (Math.random() * 30 + (club.getYardage() * (power * 0.1) - 15));
    }
    double accuracy = Math.toRadians(getAccuracy());
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

  

  
}