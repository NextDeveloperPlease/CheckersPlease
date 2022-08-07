import javafx.event.ActionEvent;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;

public class BoardScene extends Scene {
    private SideFeaturePane side;
    Pieces pieces;
    Piece[][] spots;

    public BoardScene() {
        super(new Group(), 1000, 695, Color.TEAL);
        CheckersMisc.initializer();
        Board board = new Board();
        pieces = new Pieces(this::processButtonPress);
        // spots = pieces.getSpots();
        side = new SideFeaturePane();
        side.setLayoutX(720);
        side.setLayoutY(25);
        ((Group)this.getRoot()).getChildren().addAll(board, pieces, side);
    }

    // public void processPieceDestroyed(ActionEvent event) {
    //     String color = ((Piece)event.getSource()).getColor();
    //     ((Piece)event.getSource()).setVisible(false);

    //     if (color.equals("red")) {
    //         Pieces.setNumPieces(false);
    //     } else {
    //         Pieces.setNumPieces(true);
    //     }

    //     side.update();
    // }

    // Will have to adjust once king/queen pieces are implemented
    public void processButtonPress(ActionEvent event) {
        

    }

    // add a logic system to detect if a piece can be jumped
    // redo processPieceDestroyed to remove the piece only if jumped
    // use this logic to call processPieceDestroyed

    public SideFeaturePane getSideFeatures() {
        return side;
    }

    public void resetBoard() {
        Pieces.resetPieces();
        ProcessWin.resetWins();
        side.update();
    }


}
