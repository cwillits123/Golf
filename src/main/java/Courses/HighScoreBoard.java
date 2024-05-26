package Courses;

public class HighScoreBoard {
    private static String[][] highScores = {{"",""},{"",""},{"",""},{"",""},{"",""},{"",""},{"",""},{"",""},{"",""},{"",""}};


    public static void checkHighScore(String name, int score) {
        String[] nameScore = {name, String.valueOf(score)};
        for (int i = highScores.length - 1; i >= 0; i++) {
            if (Integer.valueOf(highScores[i][1]) > Integer.valueOf(nameScore[1])) {
                String[] temp = highScores[i];
                if (i == 9) {
                    highScores[i] = nameScore;
                } else {
                    highScores[i] = nameScore;
                    highScores[i + 1] = temp;
                }
            }
        }
    }

    public static String[][] getHighScores() {
        return highScores;
    }
}

