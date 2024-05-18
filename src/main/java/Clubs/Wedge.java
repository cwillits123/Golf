package Clubs;
public class Wedge extends GolfClub{
  private int degrees = 0; 
  public Wedge(int yards, String name) {
    super(yards, name);
    if (name.equals("PitchingWedge")){
      degrees = 46;
    }
    else if (name.equals("GapWedge")){
      degrees = 50;
    }
    else if (name.equals("SandWedge")){
      degrees = 54;
    }
    else if (name.equals("LobWedge")){
      degrees = 60;
    }
  }
}