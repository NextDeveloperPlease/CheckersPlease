import javafx.scene.layout.Pane;

public class Board extends Pane {
    private BoardPiece[][] tiles;

    public Board() {
        this.setPrefSize(700, 700);
        tiles = new BoardPiece[8][8];
        boolean isBlack = false;

        for (int i = 0; i < tiles.length; i++) {
            for (int j = 0; j < tiles[i].length; j++) {
                BoardPiece tile = new BoardPiece(isBlack);
                tiles[i][j] = tile;
                tile.setLayoutX((87) * i);
                tile.setLayoutY((87) * j);
                this.getChildren().add(tile);
                if (isBlack) {
                    isBlack = false;
                } else {
                    isBlack = true;
                }
            }
            if (isBlack) {
                isBlack = false;
            } else {
                isBlack = true;
            }
        }

    }
}
