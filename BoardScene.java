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
        Board board = new Board();
        pieces = new Pieces(this::processButtonPress);
        spots = pieces.getSpots();
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
        int i = ((Piece) event.getSource()).getPosition()[0];
        int j = ((Piece) event.getSource()).getPosition()[1];
        if (spots[i][j].getColor() == "red") {
            if (i != 0 && i != 11) {
                spots[i + 1][j + 1].setVisible(true);
                spots[i - 1][j + 1].setVisible(true);
            } else if (i == 0) {
                spots[i + 1][j + 1].setVisible(true);
            } else {
                spots[i - 1][j + 1].setVisible(true);
            }
            spots[i][j].setDisable(true);
            spots[i][j].setOpacity(.8);
        } else {
            if (i != 0 && i != 11) {
                spots[i + 1][j - 1].setVisible(true);
                spots[i - 1][j - 1].setVisible(true);
            } else if (i == 0) {
                spots[i + 1][j - 1].setVisible(true);
            } else {
                spots[i - 1][j - 1].setVisible(true);
            }
            spots[i][j].setDisable(true);
            spots[i][j].setOpacity(.8);
        }
        

        // TODO: check the color of the piece selected
        // if a previous button "piece" has been selected, the next button press sets visibility
        // on the initial piece and the unselected piece to false
        // change color of visible piece to the color of the initial piece

    }

    // add a logic system to detect if a piece can be jumped
    // redo processPieceDestroyed to remove the piece only if jumped
    // use this logic to call processPieceDestroyed

    public SideFeaturePane getSideFeatures() {
        return side;
    }

    public void resetBoard() {
        pieces.resetPieces();
        ProcessWin.resetWins();
        side.update();
    }


}
