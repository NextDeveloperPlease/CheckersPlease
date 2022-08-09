import java.security.spec.InvalidKeySpecException;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.layout.Pane;

public class Pieces extends Pane{
    private static Piece[] redPieces, blackPieces;


    public Pieces(EventHandler<ActionEvent>handler) {
        redPieces = new Piece[12];
        blackPieces = new Piece[12];

        for (int i = 0; i < redPieces.length; i++) {
            redPieces[i] = new Piece();
            redPieces[i].chooseColor("red");
            redPieces[i].setPosition(CheckersMisc.startPositions()[0][i]);
            redPieces[i].setLayoutX(CheckersMisc.position(redPieces[i].getXPosition()));
            redPieces[i].setLayoutY(CheckersMisc.position(redPieces[i].getYPosition()));

            blackPieces[i] = new Piece();
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

    public static void movePiece(ActionEvent event) {
        Piece selectedPiece = ((Piece)event.getSource());
        int[] position = selectedPiece.getPosition();
        int[][] futurePositions = new int[4][2];
        if (selectedPiece.getColor().equals("red")) {
            futurePositions[0][0] = position[0] - 1;
            futurePositions[0][1] = position[1] + 1;
            futurePositions[1][0] = position[0] + 1;
            futurePositions[1][1] = position[1] + 1;
            if (selectedPiece.getKingship()) {
                futurePositions[2][0] = position[0] - 1;
                futurePositions[2][1] = position[1] - 1;
                futurePositions[0][0] = position[0] + 1;
                futurePositions[0][1] = position[1] - 1;
            }
        } else {
            futurePositions[0][0] = position[0] - 1;
            futurePositions[0][1] = position[1] - 1;
            futurePositions[1][0] = position[0] + 1;
            futurePositions[1][1] = position[1] - 1;
            if (selectedPiece.getKingship()) {
                futurePositions[2][0] = position[0] - 1;
                futurePositions[2][1] = position[1] + 1;
                futurePositions[0][0] = position[0] + 1;
                futurePositions[0][1] = position[1] + 1;
            }
        }
        for (int i = 0; i < 4; i++) {
            if (!futurePositions[i].equals(null)) {
                if (CheckersMisc.checkOpen(futurePositions[i])) {
                    
                }
            }
        }
        if (CheckersMisc.checkOpen(futurePositions[0])) {

        }
        
        
    }

    

    public static void resetPieces() {
        for (int i = 0; i < redPieces.length; i++) {
            redPieces[i] = new Piece();
            redPieces[i].chooseColor("red");
            redPieces[i].setPosition(CheckersMisc.startPositions()[0][i]);
            redPieces[i].setLayoutX(CheckersMisc.position(redPieces[i].getXPosition()));
            redPieces[i].setLayoutY(CheckersMisc.position(redPieces[i].getYPosition()));

            blackPieces[i] = new Piece();
            blackPieces[i].chooseColor("black");
            blackPieces[i].setPosition(CheckersMisc.startPositions()[1][i]);
            blackPieces[i].setLayoutX(CheckersMisc.position(blackPieces[i].getXPosition()));
            blackPieces[i].setLayoutY(CheckersMisc.position(blackPieces[i].getYPosition()));
        }

        update();
    }

}
