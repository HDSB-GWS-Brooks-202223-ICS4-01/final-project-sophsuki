import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class GameScene {
    
    public VBox basicLayout (Label text, VBox box){
        VBox basic = new VBox();

        basic.setStyle("-fx-background: black;");
        basic.setAlignment(Pos.CENTER_LEFT);
        
        text.setTextFill(javafx.scene.paint.Color.RED);
        text.setFont(new Font("Courier New", 30));

        basic.getChildren().addAll(text, box);
        
        return basic;
    }
}
