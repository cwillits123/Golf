
import java.lang.Math.*;

public class Player {
  private String name;
  private int age;
  private int experience;
  private int yardsOffCenter;

  public Player(String n, int a, int e, int h) {
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
  public int[] swing(GolfClub club, double power) {
    int yards = (int) (Math.random() * 30 + (club.getYardage() * (0.01) * power - 15));
    double accuracy = Math.toRadians(getAccuracy());
    yardsOffCenter = (int) (Math.sin(accuracy) * yards);
    int[] yardsAndAccuracy = {yards, yardsOffCenter};
    //Overhit out of bounds is 2 stroke pentalty and hit back where you were
    return yardsAndAccuracy;
  }

  // returns the yards to the hole
  public int useRangeFinder() {
    return 1;
  }

  //returns angle of accuracy of the swing and where it ends up
  public int getAccuracy() {
    return (int) (Math.random() * (60.0/experience) - (30.0/experience));
  }
  //Use course to figure out the position of obstacles
  public String getSurface() {
    return "h";
  }

  

  
}