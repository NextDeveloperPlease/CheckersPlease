public class CheckersMisc {
    public static final int TOTALPIECES = 12;
    public static int numRed;
    public static int numBlack;
    public static final double displacementVariable = 87.0;

    public static void initializer() {
        numRed = 12;
        numBlack = 12;
    }

    public static void setNumPieces(boolean isBlack) {
        if (isBlack) {
            numBlack--;
        } else {
            numRed--;
        }
    }

    public static void resetNumPieces() {
        numRed = 12;
        numBlack = 12;
    }
}
