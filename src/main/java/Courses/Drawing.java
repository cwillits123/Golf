package Courses;

import javax.swing.*;
import Clubs.*;
import Player.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;
import java.lang.Thread;


public class Drawing extends Canvas {
    private Hole hole;
    private Player p1;
    private static double pow;
    private static int tracker = 1;

    public Drawing(Hole h, Player p) {
        super();
        hole = h;
        this.p1 = p;
    }
    public static void incTracker() {
        tracker++;
    }

    public static void resetTracker() {
        tracker = 1;
    }

    public static int getTracker() {
        return tracker;
    }

    public static void play(Course c, final Hole h1, int number, final Player p2) {

        //Hole Graphics
            final JFrame finalFrame = new JFrame("High Score");
            final JFrame frame = new JFrame("Hole " + (number + 1));

            final JButton finishGameButton = new JButton("Finish Game");
            JButton scoreButton = new JButton("Scorecard"); //to click to view scorecard
            JButton nextHole = new JButton("Next Hole");
            
            final JTextField power = new JTextField();
            power.enableInputMethods(true);
            power.setColumns(5);

            finishGameButton.setBounds(600, 250, 100, 50);
            scoreButton.setBounds(250, 250, 100, 50);
            nextHole.setBounds(400, 250, 100, 50);

            final JFrame frame1 = new JFrame("Club Selector");
            final Drawing canvas = new Drawing(h1, p2);
            JButton swingB = new JButton("Swing");

            String[][] a = new String[2][1];
            final JTable highScoreTable = new JTable(HighScoreBoard.getHighScores(), a);
            final JPanel panel5 = new JPanel();
            panel5.add(highScoreTable);
            highScoreTable.setVisible(true);
            
            String surface = p2.getSurface(h1);
            String surfaceString = "";
            if (surface.equals("|")) {
                surfaceString += "Fairway";
            } else if (surface.equals(" ")) {
                surfaceString += "Green";
            } else if (surface.equals("#")) {
                surfaceString += "Rough";
            } else if (surface.equals("S")) {
                surfaceString += "Sand";
            } else if (surface.equals("W")) {
                surfaceString += "Water";
            } else if (surface.equals("T")) {
                surfaceString += "Tee";
            } else if (surface.equals("^")) {
                surfaceString += "Brush";
            } else if (surface.equals("H")) {
                surfaceString += "Hole";
            } else {
                surfaceString += "";
            }

            final JLabel holeLabel = new JLabel("Distance: " + p2.useRangeFinder(h1) + "." + "Par: " + h1.getPar() + ". Surface: " + surfaceString);
            holeLabel.setBounds(50,220, 300, 50);
            holeLabel.setVisible(true);

            swingB.setBounds(50, 250, 100, 50);
            frame.add(swingB);
            frame.add(holeLabel);
            frame.add(scoreButton);
            frame.add(nextHole);
            frame.add(finishGameButton);

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
                clubNames[i] = choices.get(i).getName() + " - " + choices.get(i).getYardage();
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
                    try {
                        canvas.swing(cb,canvas,s);
                    } catch (InterruptedException e1) {
                        // TODO Auto-generated catch block
                        e1.printStackTrace();
                    }
                    String surface = p2.getSurface(h1);
                    String surfaceString = "";
                    if (surface.equals("|")) {
                        surfaceString = "Fairway";
                    } else if (surface.equals(" ")) {
                        surfaceString = "Green";
                    } else if (surface.equals("#")) {
                        surfaceString = "Rough";
                    } else if (surface.equals("S")) {
                        surfaceString = "Sand";
                    } else if (surface.equals("W")) {
                        surfaceString = "Water";
                    } else if (surface.equals("T")) {
                        surfaceString = "Tee";
                    } else if (surface.equals("^")) {
                        surfaceString = "Brush";
                    } else if (surface.equals("H")) {
                        surfaceString = "Hole";
                    } else {
                        surfaceString = "";
                    }
                    holeLabel.setText("Distance: " + p2.useRangeFinder(h1) + "." + "Par: " + h1.getPar() + ". Surface: " + surfaceString);
                    canvas.repaint();
                }
            };
            ActionListener listenFinishGame = new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    frame.dispose();
                    finalFrame.add(panel5);
                    finalFrame.pack();
                    finalFrame.setVisible(true);
                    if (s.getScore()[2][17] > 0) {
                        HighScoreBoard.checkHighScore(p2.getName(), s.getSumScore());
                        highScoreTable.repaint();
                        finalFrame.setVisible(true);
                        finalFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    }
                }
            };

            finishGameButton.addActionListener(listenFinishGame);
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
            Integer[][] i = new Integer[19][1];
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
            ActionListener listenHole = new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    if (Ball.getPosX() == h1.getYards() && Ball.getPosY() == 50) {
                        frame.dispose();
                        Ball.placeBallOnTee();
                    }
                }
            };
            scoreButton.addActionListener(listenScore);
            nextHole.addActionListener(listenHole);




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

    public void swing(JComboBox<String> cb, Drawing canvas, Scorecard s) throws InterruptedException {
        String club = cb.getSelectedItem().toString();
        if (club.equals("Driver - 300")) {
            Driver d1 = new Driver();
            p1.swing(d1, pow, hole);
            canvas.drawSwing();
            Thread.sleep(2000);
            if (p1.getSurface(hole).equals("W")) {
                Ball.placeBall(Ball.getPreviousX(), Ball.getPreviousY());
            }
            canvas.drawSwing();
        } else if (club.equals("PitchingWedge - 146")) {
            Wedge w1 = new Wedge("PitchingWedge");
            p1.swing(w1, pow, hole);
            canvas.drawSwing();
            Thread.sleep(2000);
            if (p1.getSurface(hole).equals("W")) {
                Ball.placeBall(Ball.getPreviousX(), Ball.getPreviousY());
            }
            canvas.drawSwing();
        } else if (club.equals("Hybrid - 231")) {
            Hybrid h1 = new Hybrid();
            p1.swing(h1, pow, hole);
            canvas.drawSwing();
            Thread.sleep(2000);
            if (p1.getSurface(hole).equals("W")) {
                Ball.placeBall(Ball.getPreviousX(), Ball.getPreviousY());
            }
            canvas.drawSwing();    
        } else if (club.equals("GapWedge - 135")) {
            Wedge w1 = new Wedge("GapWedge");
            p1.swing(w1, pow, hole);
            canvas.drawSwing();
            Thread.sleep(2000);
            if (p1.getSurface(hole).equals("W")) {
                Ball.placeBall(Ball.getPreviousX(), Ball.getPreviousY());
            }
            canvas.drawSwing();
        } else if (club.equals("SandWedge - 124")) {
            Wedge w1 = new Wedge("SandWedge");
            p1.swing(w1, pow, hole);
            canvas.drawSwing();
            Thread.sleep(2000);
            if (p1.getSurface(hole).equals("W")) {
                Ball.placeBall(Ball.getPreviousX(), Ball.getPreviousY());
            }
            canvas.drawSwing();  
        } else if (club.equals("LobWedge - 113")) {
            Wedge w1 = new Wedge("LobWedge");
            p1.swing(w1, pow, hole);
            canvas.drawSwing();
            Thread.sleep(2000);
            if (p1.getSurface(hole).equals("W")) {
                Ball.placeBall(Ball.getPreviousX(), Ball.getPreviousY());
            }
            canvas.drawSwing();   
        } else if (club.equals("3 Iron - 218")) {
            Iron3 i3 = new Iron3();
            p1.swing(i3, pow, hole);
            canvas.drawSwing();
            Thread.sleep(2000);
            if (p1.getSurface(hole).equals("W")) {
                Ball.placeBall(Ball.getPreviousX(), Ball.getPreviousY());
            }
            canvas.drawSwing();    
        } else if (club.equals("4 Iron - 209")) {
            Iron4 i4 = new Iron4();
            p1.swing(i4, pow, hole);
            canvas.drawSwing();
            Thread.sleep(2000);
            if (p1.getSurface(hole).equals("W")) {
                Ball.placeBall(Ball.getPreviousX(), Ball.getPreviousY());
            }
            canvas.drawSwing();    
        } else if (club.equals("5 Iron - 199")) {
            Iron5 i5 = new Iron5();
            p1.swing(i5, pow, hole);
            canvas.drawSwing();
            Thread.sleep(2000);
            if (p1.getSurface(hole).equals("W")) {
                Ball.placeBall(Ball.getPreviousX(), Ball.getPreviousY());
            }
            canvas.drawSwing();    
        } else if (club.equals("6 Iron - 188")) {
            Iron6 i6 = new Iron6();
            p1.swing(i6, pow, hole);
            canvas.drawSwing();
            Thread.sleep(2000);
            if (p1.getSurface(hole).equals("W")) {
                Ball.placeBall(Ball.getPreviousX(), Ball.getPreviousY());
            }
            canvas.drawSwing();   
        } else if (club.equals("7 Iron - 176")) {
            Iron7 i7 = new Iron7();
            p1.swing(i7, pow, hole);
            canvas.drawSwing();
            Thread.sleep(2000);
            if (p1.getSurface(hole).equals("W")) {
                Ball.placeBall(Ball.getPreviousX(), Ball.getPreviousY());
            }
            canvas.drawSwing();    
        } else if (club.equals("8 Iron - 164")) {
            Iron8 i8 = new Iron8();
            p1.swing(i8, pow, hole);
            canvas.drawSwing();
            Thread.sleep(2000);
            if (p1.getSurface(hole).equals("W")) {
                Ball.placeBall(Ball.getPreviousX(), Ball.getPreviousY());
            }
            canvas.drawSwing();    
        } else if (club.equals("9 Iron - 152")) {
            Iron9 i9 = new Iron9();
            p1.swing(i9, pow, hole);
            canvas.drawSwing();
            Thread.sleep(2000);
            if (p1.getSurface(hole).equals("W")) {
                Ball.placeBall(Ball.getPreviousX(), Ball.getPreviousY());
            }
            canvas.drawSwing();   
        } else if (club.equals("3 Wood - 259")) {
            Wood3 w3 = new Wood3();
            p1.swing(w3, pow, hole);
            canvas.drawSwing();
            Thread.sleep(2000);
            if (p1.getSurface(hole).equals("W")) {
                Ball.placeBall(Ball.getPreviousX(), Ball.getPreviousY());
            }
            canvas.drawSwing();   
        } else if (club.equals("5 Wood - 236")) {
            Wood5 w5 = new Wood5();
            p1.swing(w5, pow, hole);
            canvas.drawSwing();
            Thread.sleep(2000);
            if (p1.getSurface(hole).equals("W")) {
                Ball.placeBall(Ball.getPreviousX(), Ball.getPreviousY());
            }
            canvas.drawSwing();   
        } else if (club.equals("Putter - 0")) {
            Putter p2 = new Putter();
            p2.swing(hole);
            canvas.drawSwing();
            s.updateScore();
        }
    }
}
