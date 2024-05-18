package Clubs;
public class GolfClub {
  private int yardage;
  private String clubName;

  public GolfClub(int yards, String club) {
     yardage = yards; 
     clubName = club;
  }
  
  public int getDistance() {
    return yardage;
  }
  
  public int getYardage() {
    return yardage;
  }

  public String getName() {
    return clubName;
  }
}