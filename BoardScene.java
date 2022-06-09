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
        pieces = new Pieces(this::processButtonPress, 700, 695);
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
        String color = ((Piece) event.getSource()).getColor();

        double i = ((Piece) event.getSource()).getInitPosition()[0];
        double j = ((Piece) event.getSource()).getInitPosition()[1];

        for (int k = 0; k < spots.length; k++) {
            for (int l = 0; l < spots[k].length; l++) {
                spots[k][l].setDisable(true);
                spots[k][l].setOpacity(1.0);
            }
        }
        // Rewrite to fix removed i and j
        // if (spots[i][j].getColor() == "red") {
        //     if (i != 0 && i != 7) {
        //         spots[i + 1][j + 1].setVisible(true);
        //         spots[i + 1][j + 1].setDisable(false);

        //         spots[i - 1][j + 1].setVisible(true);
        //         spots[i - 1][j + 1].setDisable(false);
        //     } else if (i == 0) {
        //         spots[i + 1][j + 1].setVisible(true);
        //         spots[i + 1][j + 1].setDisable(false);
        //     } else {
        //         spots[i - 1][j + 1].setVisible(true);
        //         spots[i - 1][j + 1].setDisable(false);
        //     }
        // } else if (spots[i][j].getColor() == "black") {
        //     if (i != 0 && i != 7) {
        //         spots[i + 1][j - 1].setVisible(true);
        //         spots[i + 1][j - 1].setDisable(false);

        //         spots[i - 1][j - 1].setVisible(true);
        //         spots[i - 1][j - 1].setDisable(false);
        //     } else if (i == 0) {
        //         spots[i + 1][j - 1].setVisible(true);
        //         spots[i + 1][j - 1].setDisable(false);
        //     } else {
        //         spots[i - 1][j - 1].setVisible(true);
        //         spots[i - 1][j - 1].setDisable(false);
        //     }
        // } else {
        //     spots[i][j].chooseColor(color);
        //     spots[i][j].setVisible(true);
        // }
        // spots[i][j].setDisable(false);
        // spots[i][j].setOpacity(.8);
        

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
