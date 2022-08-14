import javafx.event.ActionEvent;
import javafx.scene.layout.Pane;

public class Pieces extends Pane{
    private static Piece[] redPieces, blackPieces, futureSpots;
    private Piece selectedPiece;
    private boolean firstSelected;
    


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
        firstSelected = false;
        int[] position = selectedPiece.getPosition();
        int[][] futurePositions = new int[4][2];
        if (selectedPiece.getColor().equals("red") && CheckersMisc.redTurn) {
            futurePositions[0][0] = position[0] - 1;
            futurePositions[0][1] = position[1] + 1;
            futurePositions[1][0] = position[0] + 1;
            futurePositions[1][1] = position[1] + 1;
            futurePositions[2] = CheckersMisc.DEATHSPACE;
            futurePositions[3] = CheckersMisc.DEATHSPACE;
            if (selectedPiece.getKingship()) {
                futurePositions[2][0] = position[0] - 1;
                futurePositions[2][1] = position[1] - 1;
                futurePositions[3][0] = position[0] + 1;
                futurePositions[3][1] = position[1] - 1;
            }
        } else if (selectedPiece.getColor().equals("black") && !CheckersMisc.redTurn) {
            futurePositions[2][0] = position[0] - 1;
            futurePositions[2][1] = position[1] - 1;
            futurePositions[3][0] = position[0] + 1;
            futurePositions[3][1] = position[1] - 1;
            futurePositions[0] = CheckersMisc.DEATHSPACE;
            futurePositions[1] = CheckersMisc.DEATHSPACE;
            if (selectedPiece.getKingship()) {
                futurePositions[0][0] = position[0] - 1;
                futurePositions[0][1] = position[1] + 1;
                futurePositions[1][0] = position[0] + 1;
                futurePositions[1][1] = position[1] + 1;
            }
        }
        

        futureSpots = new Piece[4];
        int j = 0;
        for (int i = 0; i < 4; i++) {
            if (!futurePositions[i].equals(CheckersMisc.DEATHSPACE)) {
                if (CheckersMisc.checkOpen(futurePositions[i])) {
                    futureSpots[j] = new Piece(this::movePiece);
                    futureSpots[j].setPosition(futurePositions[i]);
                    this.getChildren().add(futureSpots[j]);
                    j++;
                }
            }
        }       
    }

    public void checkDoublePieceSelected() {
        for (int i = 0; i < 4; i++) {
            this.getChildren().remove(futureSpots[i]);
        }
    }

    public void movePiece(ActionEvent event) {
        for (int i = 0; i < 4; i++) {
            if (futureSpots[i] != null) {
                futureSpots[i].setDisable(true);
                futureSpots[i].setVisible(false);
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
