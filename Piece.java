import javafx.scene.control.Button;

public class Piece extends Button {
    private String color;
    private boolean isVisible, isSelected;
    private double xInit, yInit;

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

    public void initVisible(boolean isVisible) {
        this.isVisible = isVisible;
    }

    public boolean getVisibility() {
        return isVisible;
    }

    public void setInitPosition(double xInit, double yInit) {
        this.xInit = xInit;
        this.yInit = yInit;
    }

    public double[] getInitPosition() {
        double[] result = {xInit, yInit};
        return result;
    }

    public void isSelected(boolean isSelected) {
        this.isSelected = isSelected;
    }

    public boolean getSelected() {
        return isSelected;
    }
}
