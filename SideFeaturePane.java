import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;

public class SideFeaturePane extends Pane {
    // This is all the features shown on the side
    // Do this in a Pane
    // Add progress and labels into group
    // Add buttons into a group

        int numBlack, numRed;
        ProgressBar winning;
        NumPieces pieces;
        NumWins wins;
        public Button startOverButton, quitButton, mainMenuButton;

    public SideFeaturePane() {
        numBlack = CheckersMisc.numBlack;
        numRed = CheckersMisc.numRed;

        Group scoreGroup, buttonGroup;

        Label player1 = new Label("Player 1");
        player1.setFont(new Font(20));

        Label player2 = new Label("Player 2");
        player2.setFont(new Font(20));
        player2.setLayoutX(180);

        winning = new ProgressBar((numRed * 1.0) / (numRed + numBlack));
        winning.setPrefSize(250, 25);
        winning.setStyle(
            "-fx-accent: red;" +
            " -fx-text-box-border: blue;" +
            " -fx-control-inner-background: black;"
        );
        winning.setLayoutY(30);

        pieces = new NumPieces();

        wins = new NumWins();

        scoreGroup = new Group(player1, player2, winning, pieces, wins);



        startOverButton = new Button("Start Over");
        startOverButton.setLayoutY(200);
        startOverButton.setPrefSize(100, 50);

        quitButton = new Button("Quit");
        quitButton.setLayoutX(150);
        quitButton.setLayoutY(200);
        quitButton.setPrefSize(100, 50);

        mainMenuButton = new Button("Exit To\nMain Menu");
        mainMenuButton.setWrapText(true);
        mainMenuButton.setTextAlignment(TextAlignment.CENTER);
        mainMenuButton.setLayoutX(75);
        mainMenuButton.setLayoutY(300);
        mainMenuButton.setPrefSize(100, 50);


        buttonGroup = new Group(startOverButton, quitButton, mainMenuButton);


        this.getChildren().addAll(scoreGroup, buttonGroup);
    }

    public void addButtonProcessing(EventHandler<ActionEvent>handler) {
        startOverButton.setOnAction(handler);
        quitButton.setOnAction(handler);
        mainMenuButton.setOnAction(handler);
    }

    public void update() {
        numBlack = CheckersMisc.numBlack;
        numRed = CheckersMisc.numRed;
        winning.setProgress((numRed * 1.0) / (numRed + numBlack));
        pieces.update();
    }

    public Button getstartOverButton() {
        return startOverButton;
    }

    public Button getQuitButton() {
        return quitButton;
    }

    public Button getMainMenuButton() {
        return mainMenuButton;
    }
}
