import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.layout.Pane;

public class Pieces extends Pane{
    private static Piece[] redPieces, blackPieces;
    private double displacementVariable;

    public Pieces(EventHandler<ActionEvent>handler, int x, int y) {
        redPieces = new Piece[12];
        blackPieces = new Piece[12];
        this.displacementVariable = CheckersMisc.displacementVariable;
        
        for (int i = 0; i < redPieces.length; i++) {
            Piece piece = new Piece();
            piece.chooseColor("red");
            redPieces[i] = piece;

            if (i <= 3) {
                piece.setLayoutX(((displacementVariable * 2) * i) + 3);
                piece.setLayoutY(3);
            } else if (i > 3 & i <= 7) {
                piece.setLayoutX((displacementVariable * 2) * (i - 4) + (displacementVariable + 3));
                piece.setLayoutY(displacementVariable + 3);
            } else {
                piece.setLayoutX((displacementVariable * 2) * (i - 8) + 3);
                piece.setLayoutY((displacementVariable * 2) + 3);
            }
            piece.setInitPosition(piece.getLayoutX(), piece.getLayoutY());
            this.getChildren().add(piece);
        }
        for (int i = 0; i < redPieces.length; i++) {
            Piece piece = new Piece();
            piece.chooseColor("black");
            blackPieces[i] = piece;
            
            if (i <= 3) {
                piece.setLayoutX(((displacementVariable * 2) * i) + (displacementVariable + 3));
                piece.setLayoutY((displacementVariable * 5) + 3);
            } else if (i > 3 & i <= 7) {
                piece.setLayoutX((displacementVariable * 2) * (i - 4) + 3);
                piece.setLayoutY((displacementVariable * 6) + 3);
            } else {
                piece.setLayoutX((displacementVariable * 2) * (i - 8) + (displacementVariable + 3));
                piece.setLayoutY((displacementVariable * 7) + 3);
            }
            piece.setInitPosition(piece.getLayoutX(), piece.getLayoutY());
            this.getChildren().add(piece);
        }
    }

    public static void resetPieces() {
        for (int i = 0; i < redPieces.length; i++) {
            redPieces[i].setLayoutX(redPieces[i].getInitPosition()[0]);
            redPieces[i].setLayoutY(redPieces[i].getInitPosition()[1]);

            blackPieces[i].setLayoutX(blackPieces[i].getInitPosition()[0]);
            blackPieces[i].setLayoutY(blackPieces[i].getInitPosition()[1]);
        }
    }

}
