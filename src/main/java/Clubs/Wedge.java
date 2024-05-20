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
      setYards(120);
    }
    else if (name.equals("GapWedge")){
      degrees = 50;
      setYards(110);
    }
    else if (name.equals("SandWedge")){
      degrees = 54;
      setYards(100);
    }
    else if (name.equals("LobWedge")){
      degrees = 60;
      setYards(900);
    }
  }
}