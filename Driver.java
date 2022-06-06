import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Driver extends Application {

    Stage primaryStage;
    LaunchScene launchScene;
    Scene creditsScene, optionsScene;
    BoardScene startScene;
    SideFeaturePane sideFeatures;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        launchScene = new LaunchScene(this::processButtonPress, 265, 180);

        CreditsPane creditsPane = new CreditsPane();
        creditsScene = new Scene(creditsPane, 450, 300);

        OptionsPane optionsPane = new OptionsPane();
        optionsScene = new Scene(optionsPane, 450, 300);

        startScene = new BoardScene();

        sideFeatures = startScene.getSideFeatures();
        sideFeatures.addButtonProcessing(this::processGameButtonPress);

        primaryStage = stage;

        stage.setTitle("Checkers");
        stage.setScene(launchScene);
        stage.centerOnScreen();
        stage.show();
    }

    private void processButtonPress(ActionEvent event) {
        if (event.getSource() == launchScene.getQuit()) {
            primaryStage.close();
        } else if (event.getSource() == launchScene.getCredits()) {
            primaryStage.setScene(creditsScene);
            primaryStage.centerOnScreen();
        } else if (event.getSource() == launchScene.getOptions()) {
            primaryStage.setScene(optionsScene);
            primaryStage.centerOnScreen();
        } else if (event.getSource() == launchScene.getStart()) {
            primaryStage.setScene(startScene);
            primaryStage.centerOnScreen();
        }
    }

    private void processGameButtonPress(ActionEvent event) {
        if (event.getSource() == sideFeatures.getstartOverButton()) {

        } else if (event.getSource() == sideFeatures.getQuitButton()) {
            primaryStage.close();
        } else {
            primaryStage.setScene(launchScene);
        }
    }
}