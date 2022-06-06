import javafx.scene.control.Button;

public class BoardPiece extends Button {
    
    
    public BoardPiece(boolean isBlack) {
        this.setPrefSize(86, 86);
        if (isBlack) {
            this.setStyle("-fx-background-image: url('woodtextureblack.jpg'); " +
                      "-fx-background-repeat: no-repeat; " +
                      "-fx-background-size: 100 100; " +
                      "-fx-background-position: center center; "
                      );
        } else {
            this.setStyle("-fx-background-image: url('woodtexturered.jpg'); " +
                      "-fx-background-repeat: no-repeat; " +
                      "-fx-background-size: 100 100; " +
                      "-fx-background-position: center center; "
                      );
        }
        this.setDisable(true);
        this.setOpacity(1.0);
    }
}
