import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class SelectionButtons extends Button {

    public static int width, height;

    public SelectionButtons(String text) {
        ImageView view = new ImageView(new Image("buttonbackground2.png"));
        this.setStyle("-fx-background-color: black");
        this.setGraphic(view);
        this.setText(text);
        this.setTextFill(Color.WHITE);
        this.setFont(new Font("helvetica", 12));
        this.setContentDisplay(ContentDisplay.CENTER);
    }

    public static void setSize(int inputWidth, int inputHeight) {
        width = inputWidth;
        height = inputHeight;
    }
}
