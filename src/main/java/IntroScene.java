import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class IntroScene extends GameScene{

    GameScene game = new GameScene(); 



    //initial scene
    public Scene introOne() {
        VBox v = new VBox(); 
        game.basic(v);
        

        Label introText = new Label();

        game.styleText(introText, 0, 300);

        introText.setText("It's Novemeber 10th, we've been in the apocalypse for 3 years now");

        v.getChildren().add(game.image("\\images\\city.gif", 1000, 300));
        v.getChildren().addAll(game.spaceText(100), introText);

        Scene scene = new Scene(v, 1000, 800);

        return scene;
    } 
    
}
