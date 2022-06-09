import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;

public class NumPieces extends Pane {

    int numRed, numBlack;
    Label p1, p2;

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

    public void update() {
        numRed = CheckersMisc.numRed;
        numBlack = CheckersMisc.numBlack;

        p1.setText("Pieces: " + numRed);
        p2.setText("Pieces: " + numBlack);

        ProcessWin.update();
        NumWins.update();
    }
}
