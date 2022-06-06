import javafx.event.ActionEvent;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;

public class BoardScene extends Scene {
    private SideFeaturePane side;

    public BoardScene() {
        super(new Group(), 1000, 695, Color.TEAL);
        Board board = new Board();
        Pieces pieces = new Pieces(this::processButtonPress);
        side = new SideFeaturePane();
        side.setLayoutX(720);
        side.setLayoutY(25);
        ((Group)this.getRoot()).getChildren().addAll(board, pieces, side);
    }

    public void processButtonPress(ActionEvent event) {
        String color = ((Piece)event.getSource()).getColor();
        ((Piece)event.getSource()).setVisible(false);

        if (color.equals("red")) {
            Pieces.setNumPieces(false);
        } else {
            Pieces.setNumPieces(true);
        }

        side.update();
        
    }

    public SideFeaturePane getSideFeatures() {
        return side;
    }


}
