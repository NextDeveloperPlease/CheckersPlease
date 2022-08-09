import javafx.scene.control.Button;

public class Piece extends Button {
    private String color;
    private boolean isVisible, isSelected, isKing;
    private int x, y;

    public Piece() {
        this.setStyle(
            "-fx-background-radius: 5em; " +
            "-fx-min-width: 80px; " +
            "-fx-min-height: 80px; " +
            "-fx-max-width: 80px; " +
            "-fx-max-height: 80px;"
        );
        isKing = false;
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

    public void setKingship() {
        isKing = true;
    }

    public boolean getKingship() {
        return isKing;
    }

    public void setPosition(int[] position) {
        this.x = position[0];
        this.y = position[1];
    }

    public int getXPosition() {
        return x;
    }

    public int getYPosition() {
        return y;
    }

    public int[] getPosition() {
        int[] result = {x, y};
        return result;
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

    public void isSelected(boolean isSelected) {
        this.isSelected = isSelected;
    }

    public boolean getSelected() {
        return isSelected;
    }
}
