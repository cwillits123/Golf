package Clubs;
public class Wedge extends GolfClub{
  private int degrees = 0; 
  public Wedge(String name) {
    if (name.equals("PitchingWedge")){
      degrees = 46;
      super(120, name); 
    }
    else if (name.equals("GapWedge")){
      degrees = 50;
      super(110, name);
    }
    else if (name.equals("SandWedge")){
      degrees = 54;
      super(100, name); 
    }
    else if (name.equals("LobWedge")){
      degrees = 60;
      super(90, name);
    }
  }
}