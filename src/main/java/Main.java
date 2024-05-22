import Courses.*;
import Player.*;
import java.util.ArrayList;
import javax.swing.*;
import java.awt.event.*;

public class Main {
    private static Player player;
    public static void main(String[] args) {
        final Course c = new Course();
        final ArrayList<Hole> h = c.getCourse();
        Drawing.resetTracker();
        final JFrame frame = new JFrame("Start Screen");
        JPanel panel = new JPanel();
        final JTextField experience = new JTextField();
        experience.enableInputMethods(true);
        experience.setColumns(5);
        JLabel lbl = new JLabel("Type in the experience: (Int value from 1 to 10, 10 being Pro): ");
        lbl.setVisible(true);

        JLabel lbl2 = new JLabel("Type in name: ");
        lbl2.setVisible(true);
        final JTextField name = new JTextField();
        name.enableInputMethods(true);
        name.setColumns(10);

        panel.add(lbl2);
        panel.add(name);
        panel.add(lbl);
        panel.add(experience);
        JButton okB = new JButton("Ok");
        okB.setVisible(true);
        ActionListener okButton = new ActionListener() {
            
            public void actionPerformed(ActionEvent e) {
                String nam = name.getText();
                String exp = experience.getText();
                Integer exper = Integer.valueOf(exp);
                player = new Player(nam, exper);
                frame.dispose();
                Drawing.play(c, h.get(17), 17, player);
                Drawing.play(c, h.get(16), 16, player);
                Drawing.play(c, h.get(15), 15, player);
                Drawing.play(c, h.get(14), 14, player);
                Drawing.play(c, h.get(13), 13, player);
                Drawing.play(c, h.get(12), 12, player);
                Drawing.play(c, h.get(11), 11, player);
                Drawing.play(c, h.get(10), 10, player);
                Drawing.play(c, h.get(9), 9, player);
                Drawing.play(c, h.get(8),8, player);
                Drawing.play(c, h.get(7), 7, player);
                Drawing.play(c, h.get(6), 6, player);
                Drawing.play(c, h.get(5), 5, player);
                Drawing.play(c, h.get(4), 4, player);
                Drawing.play(c, h.get(3), 3, player);
                Drawing.play(c, h.get(2), 2, player);
                Drawing.play(c, h.get(1), 1, player);
                Drawing.play(c, h.get(0), 0, player);
            }
        };
        okB.addActionListener(okButton);
        panel.add(okB);
        frame.add(panel);
        frame.pack();
        frame.setVisible(true);
    }
}
