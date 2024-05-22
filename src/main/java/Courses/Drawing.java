package Courses;

import javax.swing.*;
import Clubs.*;
import Player.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;


public class Drawing extends Canvas {
    private Hole hole;
    private Player p1;
    private static double pow;

    public Drawing(Hole h, Player p) {
        super();
        hole = h;
        p1 = p;
    }
    public static void main(String[] args) {

        //Hole Graphics
        Course c = new Course();
        ArrayList<Hole> h = c.getCourse();
        Player p1 = new Player("Billy", 40, 10);
        Hole h1 = h.get(0);
        JFrame frame = new JFrame("Hole " + (1));
        JButton scoreButton = new JButton("Scorecard"); //to click to view scorecard
        final JTextField power = new JTextField();
        power.enableInputMethods(true);
        power.setColumns(5);
        scoreButton.setBounds(250, 250, 100, 50);
        final JFrame frame1 = new JFrame("Club Selector");
        final Drawing canvas = new Drawing(h1, p1);
        JButton swingB = new JButton("Swing");
        swingB.setBounds(50, 250, 100, 50);
        frame.add(swingB);
        frame.add(scoreButton);
        canvas.setSize(1500, 300);
        JPanel panel = new JPanel();
        frame1.add(panel);
        JLabel lbl = new JLabel("Select one of the possible choices and click OK. Type in the power: ");
        lbl.setVisible(true);

        panel.add(lbl);
        panel.add(power);
        GolfBag gb = new GolfBag();
        ArrayList<GolfClub> choices = gb.getClubs();
        String[] clubNames = new String[choices.size()];
        for (int i = 0; i < choices.size(); i++) {
            clubNames[i] = choices.get(i).getName();
        }
        final JComboBox<String> cb = new JComboBox<String>(clubNames);
        cb.setVisible(true);
        final Scorecard s = new Scorecard(c);
        ActionListener listen = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame1.setVisible(true);
         }
        };
        ActionListener listenOK = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String x = power.getText();
                pow = Double.valueOf(x);
                frame1.dispose();
                canvas.swing(cb,canvas,s);
                canvas.repaint();
            }
        };
        JButton okButton = new JButton("Ok");
        okButton.addActionListener(listenOK);
        panel.add(okButton);
        swingB.addActionListener(listen);
        panel.setLocation(200, 200);
        frame.add(canvas);
        frame.pack();
        panel.add(cb);
        cb.setVisible(true);
        frame1.pack();


        //Scoreboard Graphics
        final JFrame frame2 = new JFrame("Scorecard");
        JPanel panel2 = new JPanel();
        Integer[][] i = new Integer[1][19];
        JTable table = new JTable(s.getScore(), i);
        JButton okButton2 = new JButton("Ok");
        ActionListener okListen3 = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame2.dispose();
            }
        };
        panel2.add(table);
        panel2.add(okButton2);
        okButton2.addActionListener(okListen3);
        table.setVisible(true);
        frame2.add(panel2);
        frame2.pack();
        ActionListener listenScore = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame2.setVisible(true);
            }
        };
        scoreButton.addActionListener(listenScore);




        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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

    public void swing(JComboBox<String> cb, Drawing canvas, Scorecard s) {
        String club = cb.getSelectedItem().toString();
        if (club.equals("Driver")) {
            Driver d1 = new Driver();
            p1.swing(d1, pow, hole);
            canvas.drawSwing();
            s.updateScore();
        } else if (club.equals("PitchingWedge")) {
            Wedge w1 = new Wedge("PitchingWedge");
            p1.swing(w1, pow, hole);
            canvas.drawSwing();
            s.updateScore();    
        } else if (club.equals("GapWedge")) {
            Wedge w1 = new Wedge("GapWedge");
            p1.swing(w1, pow, hole);
            canvas.drawSwing();
            s.updateScore();    
        } else if (club.equals("SandWedge")) {
            Wedge w1 = new Wedge("SandWedge");
            p1.swing(w1, pow, hole);
            canvas.drawSwing();
            s.updateScore();    
        } else if (club.equals("LobWedge")) {
            Wedge w1 = new Wedge("LobWedge");
            p1.swing(w1, pow, hole);
            canvas.drawSwing();
            s.updateScore();    
        } else if (club.equals("3 Iron")) {
            Iron3 i3 = new Iron3();
            p1.swing(i3, pow, hole);
            canvas.drawSwing();
            s.updateScore();    
        } else if (club.equals("4 Iron")) {
            Iron4 i4 = new Iron4();
            p1.swing(i4, pow, hole);
            canvas.drawSwing();
            s.updateScore();    
        } else if (club.equals("5 Iron")) {
            Iron5 i5 = new Iron5();
            p1.swing(i5, pow, hole);
            canvas.drawSwing();
            s.updateScore();    
        } else if (club.equals("6 Iron")) {
            Iron6 i6 = new Iron6();
            p1.swing(i6, pow, hole);
            canvas.drawSwing();
            s.updateScore();    
        } else if (club.equals("7 Iron")) {
            Iron7 i7 = new Iron7();
            p1.swing(i7, pow, hole);
            canvas.drawSwing();
            s.updateScore();    
        } else if (club.equals("8 Iron")) {
            Iron8 i8 = new Iron8();
            p1.swing(i8, pow, hole);
            canvas.drawSwing();
            s.updateScore();    
        } else if (club.equals("9 Iron")) {
            Iron9 i9 = new Iron9();
            p1.swing(i9, pow, hole);
            canvas.drawSwing();
            s.updateScore();    
        } else if (club.equals("Wood")) {
            Wood w2 = new Wood();
            p1.swing(w2, pow, hole);
            canvas.drawSwing();
            s.updateScore();    
        } else if (club.equals("Putter")) {
            Putter p2 = new Putter();
            p2.swing(hole);
            canvas.drawSwing();
            s.updateScore();
        }
    }
}
