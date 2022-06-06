import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.layout.Pane;

public class Pieces extends Pane{
    // might be better to do this by creating a full grid of piece spots, then hiding the piece until it is moved there.
    public static int numBlack, numRed;
    
    public Pieces(EventHandler<ActionEvent>handler) {
        numBlack = 0;
        numRed = 0;
        Piece[][] spots = new Piece[8][8];
        for (int i = 0; i < spots.length; i++) {
            for (int j = 0; j < spots[i].length; j++) {
                Piece spot = new Piece();
                spots[i][j] = spot;
                spot.setLayoutX((87 * i) + 3);
                spot.setLayoutY((87 * j) + 3);
                spot.setOnAction(handler);
                if (j < 3) {
                    if ((j % 2) == 0) {
                        if ((i % 2) != 0) {
                            spot.chooseColor("red");
                            numRed++;
                        } else {
                            spot.setVisible(false);
                        }
                    } else {
                        if ((i % 2) == 0) {
                            spot.chooseColor("red");
                            numRed++;
                        } else {
                            spot.setVisible(false);
                        }
                    }
                } else if (j >= 5) {
                    if ((j % 2) != 0) {
                        if ((i % 2) == 0) {
                            spot.chooseColor("black");
                            numBlack++;
                        } else {
                            spot.setVisible(false);
                        }
                    } else {
                        if ((i % 2) != 0) {
                            spot.chooseColor("black");
                            numBlack++;
                        } else {
                            spot.setVisible(false);
                        }
                    }
                } else {
                    spot.setVisible(false);
                }
                this.getChildren().add(spot);
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
}
