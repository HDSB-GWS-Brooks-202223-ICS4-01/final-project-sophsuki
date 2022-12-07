import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class GameScene {

    // public VBox basicLayout (Label text, VBox box){
    // VBox basic = new VBox();

    // basic.setStyle("-fx-background: black;");
    // basic.setAlignment(Pos.CENTER_LEFT);

    // text.setTextFill(javafx.scene.paint.Color.WHITESMOKE);
    // text.getStylesheets().add(getClass().getResource("/style.css").toExternalForm());

    // basic.getChildren().addAll(text, box);

    // return basic;
    // }

    public VBox basic( VBox box) { // use this instead of function above explain to jelena tmrw in class.
        box.setStyle("-fx-background: black;");
        box.setAlignment(Pos.CENTER);
        return box;
    }

    public Label styleText (Label text, int x, int y){
        text.setTextFill(javafx.scene.paint.Color.WHITESMOKE);
        text.getStylesheets().add(getClass().getResource("/style.css").toExternalForm());
        text.setTranslateX(x);
        text.setTranslateY(y);

        return text;
    }
}
