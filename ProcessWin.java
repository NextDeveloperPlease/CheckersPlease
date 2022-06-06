public class ProcessWin {

    private static int p1Wins, p2Wins;
    private static int p1Pieces, p2Pieces;

    public ProcessWin() {
        p1Pieces = Pieces.numRed;
        p2Pieces = Pieces.numBlack;
    }

    public static void update() {
        p1Pieces = Pieces.numRed;
        p2Pieces = Pieces.numBlack;

        if (p1Pieces == 0) {
            p2Wins++;
        } else if (p2Pieces == 0) {
            p1Wins++;
        }
    }

    public static int[] getWins() {
        int[] wins = {p1Wins, p2Wins};
        return wins;
    }

    public static void resetWins() {
        p1Wins = 0;
        p2Wins = 0;
    }
}
