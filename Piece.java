import javafx.scene.control.Button;

public class Piece extends Button {
    private String color;
    private boolean isVisible;
    int i, j;

    public Piece(int i, int j) {
        this.setStyle(
            "-fx-background-radius: 5em; " +
            "-fx-min-width: 80px; " +
            "-fx-min-height: 80px; " +
            "-fx-max-width: 80px; " +
            "-fx-max-height: 80px;"
        );
        this.i = i;
        this.j = j;

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

    public void initVisible(boolean isVisible) {
        this.isVisible = isVisible;
    }

    public boolean getVisibility() {
        return isVisible;
    }

    public int[] getPosition() {
        int[] result = {i, j};
        return result;
    }
}
