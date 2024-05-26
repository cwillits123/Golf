package Courses;

import java.util.*;


public class Scorecard{
    private Integer[][] score;
    private ArrayList<Hole> c1;
    private int sumScore = 0;
    public Scorecard(Course c) {
        score = new Integer[3][19];
        for (int i = 0; i < score[0].length; i++) {
            score[0][i] = i + 1;
            if (i == 18) {
                score[0][i] = 0;
            }
        }
        c1 = c.getCourse();
        int sumPar = 0;
        for (int j = 0; j < score[1].length; j++) {
            if (j == 18) {
                score[1][j] = sumPar;
            } else{ 
                score[1][j] = c1.get(j).getPar();
                sumPar += c1.get(j).getPar();
            }
        }
    }

    public void updateScore() {
        
        for (int i = 0; i < score[2].length; i++) {
            if (i == 18) {
                score[2][i] = sumScore;
            } else {
                int j = c1.get(i).getStroke();
                score[2][i] = j;
                sumScore += j;
            }
        }
    }

    public int getSumScore() {
        return sumScore;
    }

    public Integer[][] getScore() {
        return score;
    }

    public String toString() {
        String str = "|";
        for (Integer[] i : score) {
            for (int j : i) {
                str += " " + j + " |";
            }
            str += "\n";
        }
        return str;
    }
}
