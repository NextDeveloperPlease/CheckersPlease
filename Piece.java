import javafx.scene.control.Button;
import javafx.scene.shape.Circle;

public class Piece extends Button {
    Circle piece;
    String color;

    public Piece() {
        this.setStyle(
            "-fx-background-radius: 5em; " +
            "-fx-min-width: 80px; " +
            "-fx-min-height: 80px; " +
            "-fx-max-width: 80px; " +
            "-fx-max-height: 80px;"
        );


    }

    public void chooseColor(String color) {
        this.color = color;
        this.setStyle(
            "-fx-background-radius: 5em; " +
            "-fx-min-width: 80px; " +
            "-fx-min-height: 80px; " +
            "-fx-max-width: 80px; " +
            "-fx-max-height: 80px;" +
            "-fx-background-color: " + color);
    }

    public String getColor() {
        return color;
    }
}
