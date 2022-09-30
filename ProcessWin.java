public class ProcessWin {

    private static int p1Wins, p2Wins;
    public static int p1Pieces, p2Pieces;

    public ProcessWin() {
        p1Pieces = CheckersMisc.numRed;
        p2Pieces = CheckersMisc.numBlack;
    }

    public static void update() {

        if (p1Pieces == 0 || p2Pieces == 0) {
            if (p1Pieces == 0) {
                p2Wins++;
            } else if (p2Pieces == 0) {
                p1Wins++;
            }
            Pieces.resetPieces();
            p1Pieces = CheckersMisc.numRed;
            p2Pieces = CheckersMisc.numBlack;
            NumPieces.update();
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

    public static void resetPieces() {
        p1Pieces = CheckersMisc.numRed;
        p2Pieces = CheckersMisc.numBlack;
        NumPieces.update();
    }

    public static void removePiece(String color) {
        if (color == "red") {
            p1Pieces--;
        } else {
            p2Pieces--;
        }
        NumPieces.update();
    }
}
