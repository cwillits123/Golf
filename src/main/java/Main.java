import Courses.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Course c = new Course();
        ArrayList<Hole> h = c.getCourse();
        Drawing.resetTracker();
        Drawing.play(c, h.get(0), 0);
        Drawing.play(c, h.get(1), 1);
        Drawing.play(c, h.get(2), 2);
        Drawing.play(c, h.get(3), 3);
        Drawing.play(c, h.get(4), 4);
        Drawing.play(c, h.get(5), 5);
        Drawing.play(c, h.get(6), 6);
        Drawing.play(c, h.get(7), 7);
        Drawing.play(c, h.get(8), 8);
        Drawing.play(c, h.get(9), 9);
        Drawing.play(c, h.get(10), 10);
        Drawing.play(c, h.get(11), 11);
        Drawing.play(c, h.get(12), 12);
        Drawing.play(c, h.get(13), 13);
        Drawing.play(c, h.get(14), 14);
        Drawing.play(c, h.get(15), 15);
        Drawing.play(c, h.get(16), 16);
        Drawing.play(c, h.get(17), 17);
    }
}
