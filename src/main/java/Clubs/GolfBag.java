package Clubs;
import java.util.ArrayList;

public class GolfBag {
    private ArrayList<GolfClub> clubs;
    private int gBalls;
  
    public GolfBag(int gBalls) {
      clubs = new ArrayList<GolfClub>();
      clubs.add(new Driver());
      clubs.add(new Iron6());
      clubs.add(new Iron3());
      clubs.add(new Iron4());
      clubs.add(new Iron5());
      clubs.add(new Iron7());
      clubs.add(new Iron8());
      clubs.add(new Iron9());
      clubs.add(new Wedge("PitchingWedge"));
      clubs.add(new Wedge("SandWedge"));
      clubs.add(new Wedge("LobWedge"));
      clubs.add(new Wedge("GapWedge"));
      clubs.add(new Putter());
      clubs.add(new Wood());
      this.gBalls = gBalls;  
    }
    public GolfBag() {
      clubs = new ArrayList<GolfClub>();
      clubs.add(new Driver());
      clubs.add(new Iron6());
      clubs.add(new Iron3());
      clubs.add(new Iron4());
      clubs.add(new Iron5());
      clubs.add(new Iron7());
      clubs.add(new Iron8());
      clubs.add(new Iron9());
      clubs.add(new Wedge("PitchingWedge"));
      clubs.add(new Wedge("SandWedge"));
      clubs.add(new Wedge("LobWedge"));
      clubs.add(new Wedge("GapWedge"));
      clubs.add(new Putter());
      clubs.add(new Wood());
      gBalls = 24;
      
    }

    public ArrayList<GolfClub> getClubs() {
      return clubs;
    }
}