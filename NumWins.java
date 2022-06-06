import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;

public class NumWins extends Pane {

    private static Label p1, p2;
    private static int p1Wins, p2Wins;

    public NumWins() {
        p1 = new Label("Wins: 0");
        p2 = new Label("Wins: 0");

        p1.setFont(new Font(20));
        p2.setFont(new Font(20));

        p1.setLayoutX(11);
        p1.setLayoutY(90);
        p2.setLayoutX(176);
        p2.setLayoutY(90);
        
        p1Wins = ProcessWin.getWins()[0];
        p2Wins = ProcessWin.getWins()[1];

        this.getChildren().addAll(p1, p2);
    }

    public static void update() {
        p1Wins = ProcessWin.getWins()[0];
        p2Wins = ProcessWin.getWins()[1];

        p1.setText("Wins: " + p1Wins);
        p2.setText("Wins: " + p2Wins);
    }
}
