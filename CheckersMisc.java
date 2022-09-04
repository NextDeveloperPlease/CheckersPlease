import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class CheckersMisc {
    public static final int TOTALPIECES = 12;
    public static final int[] DEATHSPACE = {9,9};
    public static int numRed, numBlack, historyIndex;
    public static final double displacementVariable = 87.0;
    public static int[][][][] locationHistory;
    public static boolean redTurn;
    public static ArrayList<int[]> potentialJumpPositions;

    public static void initializer() {
        numRed = 12;
        numBlack = 12;
        historyIndex = 0;
        redTurn = true;
    }

    public static void findPieceUsingPosition(ArrayList<int[]> deleteSpaces, ArrayList<Piece> deletePieces, String color) {
        Piece[] redPieces = Pieces.getPieces()[0];
        Piece[] blackPieces = Pieces.getPieces()[1];
        if (deleteSpaces.size() > 0) {
            System.out.println(deleteSpaces.get(0)[1]);
        }
        if (deleteSpaces.size() != 0) {
            for (int i = 0; i < deleteSpaces.size(); i++) {
                if (color.equals("black")) {
                    for (int j = 0; j < 12; j++) {
                        if (deleteSpaces.get(i)[0] == redPieces[j].getXPosition() && deleteSpaces.get(i)[1] == redPieces[j].getYPosition()) {
                            deletePieces.add(redPieces[j]);
                            deleteSpaces.remove(i);
                        }
                    }   
                } else {
                    for (int j = 0; j < 12; j++) {
                        if (deleteSpaces.get(i)[0] == blackPieces[j].getXPosition() && deleteSpaces.get(i)[1] == blackPieces[j].getYPosition()) {
                            deletePieces.add(blackPieces[j]);
                            deleteSpaces.remove(i);
                            break;
                        }
                    }   
                }
            }
        }

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

    public static void resetPlayers() {
        redTurn = true;
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

    public static void openSpaces(ArrayList<int[]> futurePositions, ArrayList<Piece> futureSpots, EventHandler<ActionEvent> handler, String color, boolean first, ArrayList<int[]> deleteSpaces, ArrayList<Piece> deletePieces) {
        boolean open = true;
        int spotToPullColor = 0;
        int colorIndicator = 1;
        ArrayList<Integer> indexArrayList = new ArrayList<>();
        if (color.equals("red")) {
            colorIndicator = 0;
        }
        for (int index = 0; index < futurePositions.size(); index++) {
            for (int i = 0; i < locationHistory[historyIndex].length; i++) {
                for (int j = 0; j < locationHistory[historyIndex][i].length; j++) {
                    if (((futurePositions.get(index))[0] == locationHistory[historyIndex][i][j][0] && (futurePositions.get(index))[1] == locationHistory[historyIndex][i][j][1])) {
                        open = false;
                        spotToPullColor = i;
                    } else if ((futurePositions.get(index))[0] == 8 || (futurePositions.get(index))[1] == 8) {
                        open = false;
                    }
                }
            } 
            if (open && first) {
                Piece adjPiece = new Piece(handler);
                adjPiece.setColor(color);
                adjPiece.setPosition(futurePositions.get(index));
                futureSpots.add(adjPiece);
            } else if (((futurePositions.get(index))[0] < 8 && (futurePositions.get(index))[1] < 8) && colorIndicator != spotToPullColor) {
                indexArrayList.add(index);
            }
            open = true;
        }
        checkJump(indexArrayList, futurePositions, handler, futureSpots, color, deleteSpaces, deletePieces);
    }

    public static void checkJump(ArrayList<Integer> indexArrayList, ArrayList<int[]> futurePositions, EventHandler<ActionEvent> handler, ArrayList<Piece> futureSpots, String color, ArrayList<int[]> deleteSpaces, ArrayList<Piece> deletePieces) {
        
        potentialJumpPositions = new ArrayList<>();
        int[] jumpPosition = new int[2];
        boolean open = true;
        for (Integer index : indexArrayList) {
            switch (index) {
                case 0:
                    jumpPosition[0] = (futurePositions.get(index)[0] - 1);
                    jumpPosition[1] = (futurePositions.get(index)[1] + 1);
                    break;
                case 1:
                    jumpPosition[0] = (futurePositions.get(index)[0] + 1);
                    jumpPosition[1] = (futurePositions.get(index)[1] + 1);
                    break;
                case 2:
                    jumpPosition[0] = (futurePositions.get(index)[0] - 1);
                    jumpPosition[1] = (futurePositions.get(index)[1] - 1);
                    break;
                case 3:
                    jumpPosition[0] = (futurePositions.get(index)[0] + 1);
                    jumpPosition[1] = (futurePositions.get(index)[1] - 1);
                    break;
            }
            for (int i = 0; i < locationHistory[historyIndex].length; i++) {
                for (int j = 0; j < locationHistory[historyIndex][i].length; j++) {
                    if (jumpPosition[0] > 7 || jumpPosition[1] > 7 || jumpPosition[0] < 0 || jumpPosition[1] < 0 || (jumpPosition[0] == locationHistory[historyIndex][i][j][0] && jumpPosition[1] == locationHistory[historyIndex][i][j][1])) {
                        open = false;
                    } 
                }
            }
            if (open) {
                Piece selectedPiece = new Piece(handler);

                deleteSpaces.add(futurePositions.get(index).clone());

                selectedPiece.setColor(color);
                selectedPiece.setPosition(jumpPosition);
                futureSpots.add(selectedPiece);
                potentialPositions(selectedPiece, potentialJumpPositions, futureSpots, handler, false, deleteSpaces, deletePieces);
            } else {
                open = true;
            }
        }

        for (int i = 0; i < deleteSpaces.size(); i++) {
            for (int j = i+1; j < deleteSpaces.size(); j++) {
                if (deleteSpaces.get(i)[0] == deleteSpaces.get(j)[0] && deleteSpaces.get(i)[1] == deleteSpaces.get(j)[1]) {
                    deleteSpaces.remove(j);
                }
            }
        }

        findPieceUsingPosition(deleteSpaces, deletePieces, color);
    }

    public static void potentialPositions(Piece selectedPiece, ArrayList<int[]> futurePositions, ArrayList<Piece> futureSpots, EventHandler<ActionEvent> handler, boolean first, ArrayList<int[]> deleteSpaces, ArrayList<Piece> deletePieces) {
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
        openSpaces(futurePositions, futureSpots, handler, selectedPiece.getColor(), first, deleteSpaces, deletePieces);
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
