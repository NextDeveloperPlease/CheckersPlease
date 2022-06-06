import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;

public class OptionsPane extends VBox {
    public OptionsPane() {
        this.setStyle("-fx-background-color: black");
        Label text = new Label("Sorry, this isn't fully implemented yet");
        text.setTextAlignment(TextAlignment.CENTER);
        text.setTextFill(Color.WHITE);
        text.setWrapText(true);
        text.setFont(new Font(25));

        //Add button

        this.getChildren().add(text);
    }
}
