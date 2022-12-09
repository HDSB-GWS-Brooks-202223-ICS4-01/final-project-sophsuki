import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

public class GameScene {

    public VBox basic(VBox box) {
        box.setStyle("-fx-background: black;");
        box.setAlignment(Pos.TOP_CENTER);

        return box;
    }

    public Label styleText(Label text, int x, int y) {
        text.setTextFill(javafx.scene.paint.Color.WHITESMOKE);
        text.getStylesheets().add(getClass().getResource("/style.css").toExternalForm());
        text.setTranslateX(x);
        text.setTranslateY(y);

        return text;
    }

    public ImageView image(String picture, int width, int height) {
        Image graphics = new Image(picture);
        ImageView imageArea = new ImageView();

        imageArea.setImage(graphics);
        imageArea.setPreserveRatio(true);
        imageArea.setSmooth(true);
        imageArea.setCache(true);
        imageArea.setFitWidth(width);
        imageArea.setFitHeight(height);

        return imageArea;

    }

   

}
