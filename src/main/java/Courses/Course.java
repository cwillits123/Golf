package Courses;
import java.util.ArrayList;
import java.util.Collections;

//Par 3 up to 250 (Probably 150 - 250)
//Par 4 from 251 to 470
//Par 5 from 471 to 690
public class Course {
  private ArrayList<Hole> course; 
  private int five = 4; 
  private int three = 4; 
  private int four = 10; 
  public Course() {
    course = new ArrayList<Hole>();
    for (int i = 0; i < 19; i++) {
      if (five != 0) {
        int y = (int) (Math.random() * (650 - 471) + 471);
        course.add(new Hole(5, y));
        five--; 
      } 
      else if (four != 0) {
        int y = (int) (Math.random() * (470 - 251) + 251);
        course.add(new Hole(4, y));
        four--; 
      } 
      else if (three != 0) {
        int y = (int) (Math.random() * (250 - 150) + 150);
        course.add(new Hole(3, y));
        three--; 
      }      
    }
    Collections.shuffle(course);
  }
  public ArrayList<Hole> getCourse() {
    return course;
  }
  public static void main(String[] args){
    Course c = new Course();
    int i = 0;
    for (Hole h : c.getCourse()) {
      i++;
      System.out.println("Hole " + i);
      System.out.println(h);

    }
  }
}
