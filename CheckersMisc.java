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

    public static int position(int position) {
        return ((87 * position) + 3);
    }

    

    public static int[][][] startPositions() {
        int[][][] startPositions = {
                                        {
                                            {0,0}, {2,0}, {4,0}, {6,0},
                                            {1,1}, {3,1}, {5,1}, {7,1},
                                            {0,2}, {2,2}, {4,2}, {6,2}
                                        },
                                        {
                                            {1,5}, {3,5}, {5,5}, {7,5},
                                            {0,6}, {2,6}, {4,6}, {6,6},
                                            {1,7}, {3,7}, {5,7}, {7,7}
                                        }
                                    };
        return startPositions;
    }
}
