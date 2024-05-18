public class Obstacle {
  private int width;
  private int height;
  private String name;
  private int positionX;
  private int positionY;

  public Obstacle(int w, int h, int pX, int pY, String n) {
    width = w;
    height = h;
    name = n;
    positionX = pX;
    positionY = pY;
  }

  public int getWidth() {
    return width;
  }

  public int getHeight() {
    return height;
  }

  public String getName() {
    return name;
  }

  public int getPositionX() {
    return positionX;
  }

  public int getPositionY() {
    return positionY;
  }
}