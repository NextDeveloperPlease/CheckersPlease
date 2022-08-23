import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.scene.layout.Pane;

public class Pieces extends Pane{
    private static Piece[] redPieces, blackPieces;
    private Piece selectedPiece;
    private boolean firstSelected;
    public ArrayList<Piece> futureSpots;
    


    public Pieces() {
        redPieces = new Piece[12];
        blackPieces = new Piece[12];
        firstSelected = true;

        for (int i = 0; i < redPieces.length; i++) {
            redPieces[i] = new Piece(this::firstPieceSelected);
            redPieces[i].chooseColor("red");
            redPieces[i].setPosition(CheckersMisc.startPositions()[0][i]);
            redPieces[i].setLayoutX(CheckersMisc.position(redPieces[i].getXPosition()));
            redPieces[i].setLayoutY(CheckersMisc.position(redPieces[i].getYPosition()));

            blackPieces[i] = new Piece(this::firstPieceSelected);
            blackPieces[i].chooseColor("black");
            blackPieces[i].setPosition(CheckersMisc.startPositions()[1][i]);
            blackPieces[i].setLayoutX(CheckersMisc.position(blackPieces[i].getXPosition()));
            blackPieces[i].setLayoutY(CheckersMisc.position(blackPieces[i].getYPosition()));

            this.getChildren().addAll(redPieces[i], blackPieces[i]);
        }

        update();

        
    }

    public static void update() {
        for (int i = 0; i < 12; i++) {
            redPieces[i].setLayoutX(CheckersMisc.position(redPieces[i].getXPosition()));
            redPieces[i].setLayoutY(CheckersMisc.position(redPieces[i].getYPosition()));

            blackPieces[i].setLayoutX(CheckersMisc.position(blackPieces[i].getXPosition()));
            blackPieces[i].setLayoutY(CheckersMisc.position(blackPieces[i].getYPosition()));
        }
    }

    public void firstPieceSelected(ActionEvent event) {
        selectedPiece = ((Piece)event.getSource());
        if (!firstSelected) {
            checkDoublePieceSelected();
        }
        futureSpots = new ArrayList<Piece>();
        firstSelected = false;
        int[] position = selectedPiece.getPosition();
        int[] checkPosition = new int[2];
        ArrayList<int[]> futurePositions = new ArrayList<>();
        if (selectedPiece.getColor().equals("red") && CheckersMisc.redTurn) {
            checkPosition[0] = position[0] - 1;
            checkPosition[1] = position[1] + 1;
            futurePositions.add(checkPosition.clone());

            checkPosition[0] = position[0] + 1;
            checkPosition[1] = position[1] + 1;
            futurePositions.add(checkPosition.clone());

            if (selectedPiece.getKingship()) {
                
                checkPosition[0] = position[0] - 1;
                checkPosition[1] = position[1] - 1;
                futurePositions.add(checkPosition.clone());
                
                checkPosition[0] = position[0] + 1;
                checkPosition[1] = position[1] - 1;
                futurePositions.add(checkPosition.clone());
            }
        } else if (selectedPiece.getColor().equals("black") && !CheckersMisc.redTurn) {
            
            if (selectedPiece.getKingship()) {
                // issue with checkPosition being added to the ArrayList using a reference instead of a deep copy
                checkPosition[0] = position[0] - 1;
                checkPosition[1] = position[1] + 1;
                futurePositions.add(checkPosition.clone());

                checkPosition[0] = position[0] + 1;
                checkPosition[1] = position[1] + 1;
                futurePositions.add(checkPosition.clone());
            }
            
            checkPosition[0] = position[0] - 1;
            checkPosition[1] = position[1] - 1;
            futurePositions.add(checkPosition.clone());

            checkPosition[0] = position[0] + 1;
            checkPosition[1] = position[1] - 1;
            futurePositions.add(checkPosition.clone());
        }
        
        // for (int[] spot : futurePositions) {
        //     if (CheckersMisc.checkOpen(spot)) {
        //         Piece adjPiece = new Piece(this:: movePiece);
        //         adjPiece.setPosition(spot);
        //         futureSpots.add(adjPiece);
        //         this.getChildren().add(adjPiece);
        //     }
        // }
        
        CheckersMisc.checkJump(futurePositions, futureSpots, this::movePiece);
        for (Piece piece : futureSpots) {
            this.getChildren().add(piece);
        }
        
    }

    public void checkDoublePieceSelected() {
        for (int i = 0; i < futureSpots.size(); i++) {
            this.getChildren().remove(futureSpots.get(i));
        }
    }

    public void movePiece(ActionEvent event) {
        for (Piece spot : futureSpots) {
            if (spot != null) {
                spot.setDisable(true);
                spot.setVisible(false);
            }
        }
        selectedPiece.setPosition(((Piece)event.getSource()).getPosition());
        CheckersMisc.saveSpaces(redPieces, blackPieces);
        CheckersMisc.switchPlayers();
        firstSelected = true;
    }

    public static void resetPieces() {
        for (int i = 0; i < redPieces.length; i++) {
            redPieces[i].setPosition(CheckersMisc.startPositions()[0][i]);
            redPieces[i].setLayoutX(CheckersMisc.position(redPieces[i].getXPosition()));
            redPieces[i].setLayoutY(CheckersMisc.position(redPieces[i].getYPosition()));

            blackPieces[i].setPosition(CheckersMisc.startPositions()[1][i]);
            blackPieces[i].setLayoutX(CheckersMisc.position(blackPieces[i].getXPosition()));
            blackPieces[i].setLayoutY(CheckersMisc.position(blackPieces[i].getYPosition()));
        }

        update();
    }

}
