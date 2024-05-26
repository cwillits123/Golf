package Clubs;
public class Wedge extends GolfClub{
  private int degrees = 0; 
  public Wedge(String name) {
    super(0, name);
    setDegrees(name);
  }

  public void setDegrees(String name){
    if (name.equals("PitchingWedge")){
      degrees = 46;
      setYardage(146);
    }
    else if (name.equals("GapWedge")){
      degrees = 50;
      setYardage(135);
    }
    else if (name.equals("SandWedge")){
      degrees = 54;
      setYardage(124);
    }
    else if (name.equals("LobWedge")){
      degrees = 60;
      setYardage(113);
    }
  }
}