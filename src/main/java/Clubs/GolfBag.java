package Clubs;
import java.util.ArrayList;

public class GolfBag {
    private ArrayList<GolfClub> clubs;
    private int gBalls;
  
    public GolfBag(int gBalls) {
      this.clubs = new ArrayList<GolfClub>();
      clubs.add(new Driver());
      clubs.add(new Iron6());
      clubs.add(new Iron3());
      clubs.add(new Iron4());
      clubs.add(new Iron5());
      clubs.add(new Iron7());
      clubs.add(new Iron8());
      clubs.add(new Iron9());
      clubs.add(new Wedge1("PitchingWedge"));
      clubs.add(new Wedge2("SandWedge"));
      clubs.add(new Wedge3("LobWedge"));
      clubs.add(new Wedge4("GapWedge"));
      clubs.add(new Putter());
      clubs.add(new Wood());
      this.gBalls = gBalls;  
    }
    public GolfBag() {
      this.clubs = new ArrayList<GolfClub>();
      clubs.add(new Driver());
      clubs.add(new Iron6());
      clubs.add(new Iron3());
      clubs.add(new Iron4());
      clubs.add(new Iron5());
      clubs.add(new Iron7());
      clubs.add(new Iron8());
      clubs.add(new Iron9());
      clubs.add(new Wedge1("PitchingWedge"));
      clubs.add(new Wedge2("SandWedge"));
      clubs.add(new Wedge3("LobWedge"));
      clubs.add(new Wedge4("GapWedge"));
      clubs.add(new Putter());
      clubs.add(new Wood());
      gBalls = 24;
      
    }

    public ArrayList<Clubs> getClubs() {
      return clubs
    }
}