import java.util.ArrayList;

public class ProcessWin {

    private static int p1Wins, p2Wins;
    public static int p1Pieces, p2Pieces, tempRedPieces, tempblackPieces;
    private static ArrayList<Piece> removedPieces;
    private static boolean first;

    public ProcessWin() {
        p1Pieces = CheckersMisc.numRed;
        p2Pieces = CheckersMisc.numBlack;
        removedPieces = new ArrayList<>();

        tempRedPieces = 0;
        tempblackPieces = 0;
        Piece[] redPieces = Pieces.getPieces()[0];
        Piece[] blackPieces = Pieces.getPieces()[1];

        try {
            if (first);
        } catch (Exception e) {
            first = true;
        }

        for (int i = 0; i < 12; i++) {
            if (redPieces[i].getPosition()[0] !=9 && redPieces[i].getPosition()[1] != 9) {
                tempRedPieces++;
            } 
            if (blackPieces[i].getPosition()[0] != 9 && blackPieces[i].getPosition()[1] != 9) {
                tempblackPieces++;
            } 
        }
        first = false;
    }

    public static void update() {

        p1Pieces = tempRedPieces;
        p2Pieces = tempblackPieces;

        if (p1Pieces == 0 || p2Pieces == 0) {
            if (p1Pieces == 0) {
                p2Wins++;
            } else if (p2Pieces == 0) {
                p1Wins++;
            }
            Pieces.resetPieces();
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

    public static void getTotalPiecesLeft() {
        Piece[] redPieces = Pieces.getPieces()[0];
        Piece[] blackPieces = Pieces.getPieces()[1];

        for (int i = 0; i < 12; i++) {
            if (redPieces[i].getPosition()[0] == 9 && redPieces[i].getPosition()[1] == 9 && !removedPieces.contains(redPieces[i]) && !removedPieces.contains(blackPieces[i])) {
                tempRedPieces--;
                removedPieces.add(redPieces[i]);
                System.out.println(redPieces[i].getPosition()[0] + " " + redPieces[i].getPosition()[1]);
            }
            if (blackPieces[i].getPosition()[0] == 9 && blackPieces[i].getPosition()[1] == 9 && !removedPieces.contains(redPieces[i]) && !removedPieces.contains(blackPieces[i])) {
                tempblackPieces--;
                removedPieces.add(blackPieces[i]);
                System.out.println(blackPieces[i].getPosition()[0] + " " + blackPieces[i].getPosition()[1]);
            }
        }
        p1Pieces = tempRedPieces;
        p2Pieces = tempblackPieces;
        NumPieces.update();
    }
}
