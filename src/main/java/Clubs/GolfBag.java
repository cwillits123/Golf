package Clubs;
import java.util.ArrayList;

public class GolfBag {
    private ArrayList <GolfClub> clubs;
    private int gBalls;
    private int bevs;
  
    public GolfBag(ArrayList<GolfClub> clubs, int gBalls, int                         bevs) {
      this.clubs = clubs; 
      this.gBalls = gBalls; 
      this.bevs = bevs; 
    }
    public GolfBag() {
      this.clubs = new ArrayList<GolfClub>();
      gBalls = 24;
      
    }
}