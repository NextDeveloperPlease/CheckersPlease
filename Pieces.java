import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.layout.Pane;

public class Pieces extends Pane{
    public static int numBlack, numRed;
    public static final int TOTALPIECES = 12;
    private static Piece[][] spots;
    
    public Pieces(EventHandler<ActionEvent>handler) {
        numBlack = 0;
        numRed = 0;
        spots = new Piece[8][8];
        for (int i = 0; i < spots.length; i++) {
            for (int j = 0; j < spots[i].length; j++) {
                Piece spot = new Piece(i, j);
                spots[i][j] = spot;
                spot.setLayoutX((87 * i) + 3);
                spot.setLayoutY((87 * j) + 3);
                spot.setOnAction(handler);
                if (j < 3) {
                    if ((j % 2) == 0) {
                        if ((i % 2) != 0) {
                            spot.chooseColor("red");
                            spot.initVisible(true);
                            numRed++;
                        } else {
                            spot.setVisible(false);
                            spot.initVisible(false);
                        }
                    } else {
                        if ((i % 2) == 0) {
                            spot.chooseColor("red");
                            spot.initVisible(true);
                            numRed++;
                        } else {
                            spot.setVisible(false);
                            spot.initVisible(false);
                        }
                    }
                } else if (j >= 5) {
                    if ((j % 2) != 0) {
                        if ((i % 2) == 0) {
                            spot.chooseColor("black");
                            spot.initVisible(true);
                            numBlack++;
                        } else {
                            spot.setVisible(false);
                            spot.initVisible(false);
                        }
                    } else {
                        if ((i % 2) != 0) {
                            spot.chooseColor("black");
                            spot.initVisible(true);
                            numBlack++;
                        } else {
                            spot.setVisible(false);
                            spot.initVisible(false);
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

    public void resetPieces() {
        for (int i = 0; i < spots.length; i++) {
            for (int j = 0; j < spots[i].length; j++) {
                spots[i][j].setVisible(spots[i][j].getVisibility());
            }
        }
        numBlack = TOTALPIECES;
        numRed = TOTALPIECES;
    }

    public Piece[][] getSpots() {
        return spots;
    }
}
