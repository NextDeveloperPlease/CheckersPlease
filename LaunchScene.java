import javafx.event.ActionEvent;
import javafx.scene.Group;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;

public class LaunchScene extends Scene {

    private SelectionButtons startButton, optionsButton, creditsButton, quitButton;

    public LaunchScene(EventHandler<ActionEvent>handler, int width, int height) {
        super(new Group(), width, height, Color.BLACK);

        SelectionButtons.setSize(width, height);

        startButton = new SelectionButtons("Start");
        startButton.setOnAction(handler);

        optionsButton = new SelectionButtons("Options");
        optionsButton.setLayoutY(40);
        optionsButton.setOnAction(handler);

        creditsButton = new SelectionButtons("Credits");
        creditsButton.setLayoutY(80);
        creditsButton.setOnAction(handler);

        quitButton = new SelectionButtons("Quit");
        quitButton.setLayoutY(120);
        quitButton.setOnAction(handler);

        ImageView view = new ImageView(new Image("buttonbackground2.png"));


        ((Group)this.getRoot()).getChildren().addAll(view, startButton, optionsButton, creditsButton, quitButton);
    }

    public SelectionButtons getStart() {
        return startButton;
    }

    public SelectionButtons getOptions() {
        return optionsButton;
    }

    public SelectionButtons getCredits() {
        return creditsButton;
    }

    public SelectionButtons getQuit() {
        return quitButton;
    }
}
