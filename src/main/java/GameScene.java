import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

/**
* Abstract class that all routes inherit. Contains style methods and input methods that are created for non-repetitive code.
*
* @author  Sophia & Jelena
*/
public class GameScene {
    // class worked on together - Sophia & Jelena

/**
 * Creates first scene using text and images. Uses methods from GameScene.java.
 * 
 * @return StackPane
 * @param StackPane being used in the
 */
    public StackPane basicPane(StackPane box) {
        box.setStyle("-fx-background: black;");
        box.setAlignment(Pos.TOP_CENTER);
        return box;
    }

    public Label styleText(Label text, int y) { // styles text and places pos
        text.setTextFill(javafx.scene.paint.Color.WHITESMOKE);
        text.getStylesheets().add(getClass().getResource("/style.css").toExternalForm());
        text.setTranslateY(y);

        return text;
    }

    public Label title(Label label) { // changes text to title sized font
        label.getStyleClass().add("label-title");
        return label;
    }

    public Label bigFont(Label label) { // changes text to bigger font
        label.getStyleClass().add("label-big");
        return label;

    }

    public Label smallFont(Label label) { // changes text to smaller font
        label.getStyleClass().add("label-small");
        return label;

    }

    public Label spaceText(int y) { // creates click space text for all scenes
        Label space = new Label();
        space.setText("Press Space Bar To Continue");
        space.setTranslateX(0); 
        space.setTranslateY(y);
        space.setTextFill(javafx.scene.paint.Color.WHITESMOKE);
        space.getStylesheets().add(getClass().getResource("/style.css").toExternalForm());
        bigFont(space);
        return space;
    }

    public ImageView image(String picture, int width, int height) { // image
        Image graphics = new Image(picture);
        ImageView imageArea = new ImageView();

        imageArea.setImage(graphics);

        imageArea.setSmooth(true);
        imageArea.setCache(true);
        imageArea.setFitWidth(width);
        imageArea.setFitHeight(height);

        return imageArea;
    }

    public TextField limitText(TextField field) {

        field.setAlignment(Pos.CENTER);
        field.setFont((Font.font("Helvetica", FontWeight.BOLD, 36)));
        field.setEditable(true);
        field.setStyle("-fx-background-color: black;");
        field.setMaxSize(100,10);
        field.setTranslateY(700);

        field.setOnKeyTyped(new EventHandler<KeyEvent>() {
            @Override
            public void handle(javafx.scene.input.KeyEvent event) {
                int max = 1;
                if (field.getText().length() > max) {
                    field.setText("");
                }

            }

        });

        field.textProperty().addListener((observable, oldValue, newValue) -> {

            if (!newValue.matches("\\d*")) {
                field.setText(newValue.replaceAll("[^\\d]", ""));
            }
        });

        return field;
    }

    public Button restart(Button button) { // Restart Button
        button.setTranslateY(700);
        button.setMaxSize(300, 75);
        button.setAlignment(Pos.CENTER);
        button.setText("Restart");
        button.getStylesheets().add(getClass().getResource("/style.css").toExternalForm());
      
        return button;
    }

 
}
