import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;

public class CreditsPane extends VBox {
    public CreditsPane() {
        this.setStyle("-fx-background-color: black");
        
        Label text = new Label("Thanks for playing my game!\nMy name is Connor and this is one of my first games I've built. If you have any comments or recommendations, my github page is ");
        text.setTextAlignment(TextAlignment.CENTER);
        text.setTextFill(Color.WHITE);
        text.setWrapText(true);
        text.setFont(new Font(25));

        //Add button

        this.getChildren().add(text);
    }
}
