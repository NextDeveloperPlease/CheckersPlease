import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;

public class NumPieces extends Pane {

    static int numRed, numBlack;
    static Label p1, p2;

    public NumPieces() {
        numRed = CheckersMisc.numRed;
        numBlack = CheckersMisc.numBlack;

        p1 = new Label("Pieces: " + numRed);
        p2 = new Label("Pieces: " + numBlack);

        p1.setFont(new Font(20));
        p2.setFont(new Font(20));

        p1.setLayoutY(60);
        p2.setLayoutX(165);
        p2.setLayoutY(60);

        this.getChildren().addAll(p1, p2);
    }

    public static void update() {
        numRed = ProcessWin.p1Pieces;
        numBlack = ProcessWin.p2Pieces;

        p1.setText("Pieces: " + numRed);
        p2.setText("Pieces: " + numBlack);

        ProcessWin.update();
        NumWins.update();
    }
}
