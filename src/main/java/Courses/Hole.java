import java.util.Arrays;

public class Hole {
  private int par;
  private int yards;
  private int distance;
  private Obstacle[] obstacles;
  private String[][] golfHole;


  /**
   * Obstacles are going to be listed in the respective spots in the array
   * Each obstacle has a width and a height that determines its size
   * teebox and hole are going to be in the array along with the fairway, green, rough
   * all are listed out in the array and the position of the array is given by the shot
   * Starts at teebox which is always [0][middle]
   **/
   public Hole(int par, int yards) {
     int numObs = (int) (Math.random() * 4) + 1;
     obstacles = new Obstacle[numObs];
     for (int i = 0; i < numObs; i++) {
       int type = (int) (Math.random() * 3 + 0.5);
       if (type >= 0 && type <= 2) {
         int width = (int) (Math.random() * 10 + 1);
         int height = (int) (Math.random() * 10 + 1);
         int positionX = (int) (Math.random() * (yards - 30 - height) + 10);
         int positionY = (int) (Math.random() * (yards - 30 - width) + 10);
         obstacles[i] = new Obstacle(width, height, positionX, positionY, "Sand");
       } else {
         int width = (int) (Math.random() * 20 + 1);
         int height = (int) (Math.random() * 20 + 1);
         int positionX = (int) (Math.random() * (yards - 30 - height) + 10);
         int positionY = (int) (Math.random() * (yards - 30 - width) + 10);
         obstacles[i] = new Obstacle(width, height, positionX, positionY, "Water");
       }
     }
     int sizeOfFairway = (int) ((Math.random() * 20 + 0.5) + 30);
     int sizeOfGreen = (int) ((Math.random() * 10 + 0.5) + 20);
     golfHole = new String[yards + 50][101];
     for (int i = 0; i < yards + 50; i++) {
       for (int j = 0; j < 101; j++) {
         if (j <= 1 || j >= 99) {
            golfHole[i][j] = "^"; //Brush
         } else {
            golfHole[i][j] = "#";  //Rough
         }
         if (j >= 50 - sizeOfFairway && j <= 50 + sizeOfFairway && i > 4 && i < yards + 30) {
           golfHole[i][j] = "|";  //Fairway
         }
         if (i == 0 && j == 50) {
           golfHole[i][j] = "T"; //Tee
         }
         if (i == yards && j == 50) {
           golfHole[i][j] = "H"; //Hole
         } else if (i >= yards - sizeOfGreen && i <= yards + sizeOfGreen && j >= 50 - sizeOfGreen && j <= 50 + sizeOfGreen) {
           golfHole[i][j] = " "; //Green
         }
         for (int k = 0; k < numObs; k++) {
           
           if (obstacles[k].getPositionX() <= i && i <= obstacles[k].getPositionX() + obstacles[k].getHeight() && j >= obstacles[k].getPositionY() && j <= obstacles[k].getPositionY() + obstacles[k].getWidth()) {
             golfHole[i][j] = obstacles[k].getName().substring(0, 1);
           }
         }
       }
     }
   }
  public String[][] getGolfHole() {
    return golfHole;
  }
  public int getYards() {
    return yards;
  }

  public String toString() {
    String str = "";
    for (String[] b : golfHole) {
          for (String c : b) {
           str += c;
        }
          str += "\n";
       }
    return str;
  }
  
 // public static void main(String[] args) {
 //   Hole hole = new Hole(3, 600);
 //   String[][] a = hole.getGolfHole();
 //   System.out.println(a.length + " " + a[0].length);
    /**
    *for (int i = 0; i < a.length; i++) {
    * for (int j = 0; j < a[0].length; j++) {
    *   if (a[i][j].equals("Fairway")) {
    *     a[i][j] = "|";
    *   } else if (a[i][j].equals("Green")) {
    *     a[i][j] = " ";
    *   } else if (a[i][j].equals("Brush")) {
    *     a[i][j] = "^";
    *   } else if (a[i][j].equals("Rough")) {
    *     a[i][j] = "#";
    *   } else if (a[i][j].equals("Tee")) {
    *     a[i][j] = "T";
    *   } else if (a[i][j].equals("Hole")) {
    *     a[i][j] = "H";
    *   } else if (a[i][j].equals("Water")) {
    *     a[i][j] = "W";
    *   } else if (a[i][j].equals("Sand")) {
    *     a[i][j] = "S";
    *   } else {
    *     a[i][j] = ".";
    *   }
    * }
**/
//    for (String[] b : a) {
//      for (String c : b) {
//        System.out.print(c);
//      }
//      System.out.println();
//    }
//  }
}