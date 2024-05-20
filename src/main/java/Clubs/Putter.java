package Clubs;

import Courses.Hole;
public class Putter extends GolfClub{

  public Putter() {
    super(0, "Putter");
  }

  public void swing(Hole h) {
    int yards = h.getDistance();
    if (yards < 4){
      h.addStroke();
    }
    else if (yards < 7){
      h.addStroke();
      h.addStroke();
    }
    else{
      double x = Math.random() * 2;
      if (x < 1.0){
        h.addStroke();
        h.addStroke();
      }
      else{
        h.addStroke();
        h.addStroke();
        h.addStroke();
      }
    }
  }
}

