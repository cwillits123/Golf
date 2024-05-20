package Courses;

import javax.swing.JFrame;
import Clubs.*;
import Player.*;
import java.awt.*;
import java.util.*;


public class Drawing extends Canvas {
    private Hole hole;

    public Drawing(Hole h) {
        super();
        hole = h;
    }
    public static void main(String[] args) {
        Course c = new Course();
        ArrayList<Hole> h = c.getCourse();
        for (int i = 0; i < h.size(); i++) {
            Ball.placeBallOnTee(); 
            JFrame frame = new JFrame("Hole " + (i + 1));
            Canvas canvas = new Drawing(h.get(i));
            canvas.setSize(1500, 300);
            frame.add(canvas);
            frame.pack();
            frame.setVisible(true);
        }
        Player p1 = new Player("Billy", 40, 10);
        Hole h1 = h.get(0);
        JFrame frame = new JFrame("Hole " + (1));
        Drawing canvas = new Drawing(h1);
        canvas.setSize(1500, 300);
        frame.add(canvas);
        frame.pack();
        frame.setVisible(true);
        Scorecard s = new Scorecard(c);
        System.out.println(s);
        Driver d1 = new Driver();
        p1.getSurface(h1);
        int[] a = p1.swing(d1, 10, h1);
        System.out.println(Arrays.toString(a));
        p1.getSurface(h1);
        canvas.drawSwing();
        s.updateScore();
        System.out.println(s);
    }

    public void paint(Graphics g) {
        Color brushColor = new Color(228,220,138); //Brush color
        Color sandColor = new Color(194, 178, 128); //Sand color
        Color greenColor = new Color(64, 116, 86); //Green color
        Color fairwayColor = new Color(82,122,86); //Fairway color
        Color waterColor =  new Color(15,94,156); //Water color
        Color holeColor = new Color(255,255,255); //Hole color
        Color teeBoxColor = new Color(255,40,40); //Teebox color
        Color roughColor = new Color(1,50,32); //Rough color
        g.setColor(brushColor);
        //g.fillRect(0,0, 2*101, 2*(hole.getYards() + 50));
        g.fillRect(10,10,2*(hole.getYards() + 50), 2*101);
        g.setColor(roughColor);
        //g.fillRect(2*2,0, 2*96, 2*(hole.getYards() + 50));
        g.fillRect(10,2*2 + 10,2*(hole.getYards() + 50),2*96);
        g.setColor(fairwayColor);
       // g.fillRect(2*(50 - hole.getSizeOfFairway()), 2*4, 2*2*hole.getSizeOfFairway(), 2*(hole.getYards() + 30));
        g.fillRect(2*4 + 10, 2*(50 - hole.getSizeOfFairway()) + 10,2*(hole.getYards() + 30),2*2*hole.getSizeOfFairway());
        g.setColor(teeBoxColor);
        //g.fillRect(2*50,0,2*1,2*1);
        g.fillRect(10,2*50 + 10,2*1,2*1);
        g.setColor(greenColor);
        //g.fillRect(2*(50 - hole.getSizeOfGreen()), 2*(hole.getYards() - hole.getSizeOfGreen()), 2*2*hole.getSizeOfGreen(), 2*2*hole.getSizeOfGreen());
        g.fillRect(10 + 2*(hole.getYards() - hole.getSizeOfGreen()), 10 + 2*(50 - hole.getSizeOfGreen()),2*2*hole.getSizeOfGreen(),2*2*hole.getSizeOfGreen());
        g.setColor(holeColor);
        //g.fillRect(2*50,2*hole.getYards(),2*1,2*1);
        g.fillRect(10 + 2*hole.getYards(),2*50 + 10,2*1,2*1);
        Obstacle[] obstacles = hole.getObstacles();
        for (Obstacle obs : obstacles) {
            String obsName = obs.getName();
            int obsPosX = obs.getPositionX();
            int obsPosY = obs.getPositionY();
            int obsWidth = obs.getWidth();
            int obsHeight = obs.getHeight();
            if (obsName.equals("Sand")) {
                g.setColor(sandColor);
                //g.fillRect(2*obsPosY, 2*obsPosX, 2*obsWidth, 2*obsHeight);
                g.fillRect(2*obsPosX + 10,2*obsPosY + 10,2*obsHeight,2*obsWidth);
            } else if (obsName.equals("Water")) {
                g.setColor(waterColor);
                //g.fillRect(2*obsPosY, 2*obsPosX, 2*obsWidth, 2*obsHeight);
                g.fillRect(2*obsPosX + 10,2*obsPosY + 10,2*obsHeight,2*obsWidth);
            }
        }
        g.setColor(brushColor);
        g.fillRect(0,0,10,300);
        g.fillRect(0,0,1500,10);
        g.fillRect(0,202,1500,300);
        g.fillRect(2*(hole.getYards() + 50), 0, 1500,300);
        g.setColor(Color.white);
        g.fillOval(2*(Ball.getPosX()) + 10, 2*(Ball.getPosY())+10, 4, 4);
    }
    public void drawSwing() {
        repaint();
    }
}
