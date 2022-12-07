import javafx.geometry.Pos;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

public class GameScene {
    
    public VBox basicLayout (TextArea text, VBox box){
        box.setAlignment(Pos.CENTER_LEFT);
        text.setFont(new Font("CC Overbyte", 30));
        box.getChildren().addAll(text, box);
        return box;
    }
}
