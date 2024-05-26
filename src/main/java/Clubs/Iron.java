package Clubs;
public class Iron extends GolfClub{
  private String ironName; 
  
  public Iron(int yards, String name) {
    super(yards, name);
    ironName = name; 
  }

  public String getIronName() {
    return ironName;
  }
}