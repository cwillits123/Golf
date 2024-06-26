package Clubs;

import Courses.Hole;
public class Putter extends GolfClub{

  public Putter() {
    super(0, "Putter");
  }

  public void swing(Hole h) {
    int yards = h.getDistance();
    if (Math.abs(yards) < 9){
      h.addStroke();
      Ball.placeBall(h.getYards(), 50);
    }
    else if (Math.abs(yards) < 18){
      h.addStroke();
      h.addStroke();
      Ball.placeBall(h.getYards(), 50);
    }
    else{
      double x = Math.random() * 2;
      if (x < 1.0){
        h.addStroke();
        h.addStroke();
        Ball.placeBall(h.getYards(), 50);
      }
      else{
        h.addStroke();
        h.addStroke();
        h.addStroke();
        Ball.placeBall(h.getYards(), 50);
      }
    }
  }
}

