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
        pieces = new Pieces();
        side = new SideFeaturePane();
        side.setLayoutX(720);
        side.setLayoutY(25);
        new ProcessWin();
        ((Group)this.getRoot()).getChildren().addAll(board, pieces, side);
    }

    public SideFeaturePane getSideFeatures() {
        return side;
    }

    public void resetBoard() {
        Pieces.resetPieces();
        Pieces.resetPieces(pieces);
        ProcessWin.resetPieces();
        ProcessWin.resetWins();
        SideFeaturePane.update();
        CheckersMisc.redTurn = true;
    }


}
