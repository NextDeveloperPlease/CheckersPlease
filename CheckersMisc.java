import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class CheckersMisc {
    public static final int TOTALPIECES = 12;
    public static final int[] DEATHSPACE = {9,9};
    public static int numRed;
    public static int numBlack;
    private static int historyIndex;
    public static final double displacementVariable = 87.0;
    public static int[][][][] locationHistory;
    public static boolean redTurn;

    public static void initializer() {
        numRed = 12;
        numBlack = 12;
        historyIndex = 0;
        redTurn = true;
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

    public static void switchPlayers() {
        if (redTurn) {
            redTurn = false;
        } else {
            redTurn = true;
        }
     //todo Finish this   
    }

    public static void saveSpaces(Piece[] redPieces, Piece[] blackPieces) {
        historyIndex++;
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 12; j++) {
                if (i == 0) {
                    locationHistory[historyIndex][i][j] = redPieces[j].getPosition();
                } else {
                    locationHistory[historyIndex][i][j] = blackPieces[j].getPosition();
                }
            }
        }
    }

    public static void openSpaces(ArrayList<int[]> futurePositions, ArrayList<Piece> futureSpots, EventHandler<ActionEvent> handler) {
        boolean open = true;
        for (int index = 0; index < futurePositions.size(); index++) {
            for (int i = 0; i < locationHistory[historyIndex].length; i++) {
                for (int j = 0; j < locationHistory[historyIndex][i].length; j++) {
                    if ((futurePositions.get(index))[0] == 8 || (futurePositions.get(index))[1] == 8 || ((futurePositions.get(index))[0] == locationHistory[historyIndex][i][j][0] && (futurePositions.get(index))[1] == locationHistory[historyIndex][i][j][1])) {
                        open = false;
                    } 
                }
            } 
            if (open) {
                Piece adjPiece = new Piece(handler);
                        adjPiece.setPosition(futurePositions.get(index));
                        futureSpots.add(adjPiece);
            } else {
                // int[] jumpPosition = new int[2];
                // switch (index) {
                //     case 0:
                //         jumpPosition[0] = (futurePositions.get(index)[0] - 1);
                //         jumpPosition[1] = (futurePositions.get(index)[1] + 1);
                //         futurePositions.add(jumpPosition.clone());
                //         break;
                //     case 1:
                //         jumpPosition[0] = (futurePositions.get(index)[0] + 1);
                //         jumpPosition[1] = (futurePositions.get(index)[1] + 1);
                //         futurePositions.add(jumpPosition.clone());
                //         break;
                //     case 2:
                //         jumpPosition[0] = (futurePositions.get(index)[0] - 1);
                //         jumpPosition[1] = (futurePositions.get(index)[1] - 1);
                //         futurePositions.add(jumpPosition.clone());
                //         break;
                //     case 3:
                //         jumpPosition[0] = (futurePositions.get(index)[0] + 1);
                //         jumpPosition[1] = (futurePositions.get(index)[1] - 1);
                //         futurePositions.add(jumpPosition.clone());
                //         break;
                // }
            }
            open = true;
        }
        
        
    }

    public static void potentialPositions(Piece selectedPiece, ArrayList<int[]> futurePositions) {
        int[] position = selectedPiece.getPosition();
        int[] checkPosition = new int[2];
        if (selectedPiece.getColor().equals("red") && CheckersMisc.redTurn) {
            checkPosition[0] = position[0] - 1;
            checkPosition[1] = position[1] + 1;
            futurePositions.add(0, checkPosition.clone());

            checkPosition[0] = position[0] + 1;
            checkPosition[1] = position[1] + 1;
            futurePositions.add(1, checkPosition.clone());

            if (selectedPiece.getKingship()) {
                
                checkPosition[0] = position[0] - 1;
                checkPosition[1] = position[1] - 1;
                futurePositions.add(2, checkPosition.clone());
                
                checkPosition[0] = position[0] + 1;
                checkPosition[1] = position[1] - 1;
                futurePositions.add(3, checkPosition.clone());
            }
        } else if (selectedPiece.getColor().equals("black") && !CheckersMisc.redTurn) {
            
            if (selectedPiece.getKingship()) {
                // issue with checkPosition being added to the ArrayList using a reference instead of a deep copy
                checkPosition[0] = position[0] - 1;
                checkPosition[1] = position[1] + 1;
                futurePositions.add(0, checkPosition.clone());

                checkPosition[0] = position[0] + 1;
                checkPosition[1] = position[1] + 1;
                futurePositions.add(1, checkPosition.clone());
            }
            futurePositions.add(CheckersMisc.DEATHSPACE);
            futurePositions.add(CheckersMisc.DEATHSPACE);
            checkPosition[0] = position[0] - 1;
            checkPosition[1] = position[1] - 1;
            futurePositions.add(2, checkPosition.clone());

            checkPosition[0] = position[0] + 1;
            checkPosition[1] = position[1] - 1;
            futurePositions.add(3, checkPosition.clone());
        }
    }

    public static int[][][] startPositions() {
        locationHistory = new int[100][2][12][2];
        int[][][] start = {                 
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
        locationHistory[historyIndex] = start;
        return start;
    }

    public static void pieceKilled(Piece piece) {
        piece.setPosition(DEATHSPACE);
        piece.setDisable(true);
        piece.setVisible(false);
    }
}
