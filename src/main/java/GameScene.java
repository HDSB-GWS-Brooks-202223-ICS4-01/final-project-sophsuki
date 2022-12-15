import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class GameScene {
    //class worked on together - Sophia & Jelena
    public int i = 0;

    ActionEvent KeyEvent;

    public VBox basic(VBox box) { // creates vbox
        box.setStyle("-fx-background: black;");
        box.setAlignment(Pos.TOP_CENTER);

        return box;
    }

    public StackPane basicPane(StackPane box) {
        box.setStyle("-fx-background: black;");
        box.setAlignment(Pos.TOP_CENTER);
        return box;
    }

    // NOTE MAYBE TAKE OUT X if text is alwasy gonna be centered anyway
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

    public TextField limitText (TextField field) {
     
        field.setAlignment(Pos.CENTER);
        field.setFont((Font.font("Helvetica", FontWeight.BOLD, 36)));
        field.setEditable(true);
        field.setStyle("-fx-background-color: black;");

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


    // public int nextScene(Scene scene){
    // scene.setOnKeyPressed(new EventHandler<KeyEvent>() {

    // @Override
    // public void handle(KeyEvent key) {
    // if(key.getCode().equals(KeyCode.SPACE)){
    // i++;

    // }

    // }

    // });
    // return i;
    // }

    // add animation method maybe

}
