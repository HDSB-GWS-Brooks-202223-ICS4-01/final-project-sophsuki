import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

public class IntroScene extends GameScene{

    GameScene game = new GameScene(); 



    //initial scene
    public Scene introOne() {
        VBox v = new VBox(); 

        Label monologue1 = new Label();
        Label monologue2 = new Label();
        Label monologue3 = new Label();
        Label monologue4 = new Label();
        Label monologue5 = new Label();
        Label monologue6 = new Label();

        

        monologue1.setText("It's Novemeber 10th, we've been in the apocalypse for 3 years now.");
        monologue2.setText("An evil scientists released the zombie plague which infected over half the city.");
        monologue3.setText("My sister and I barely survived the first year before she started getting rebellious.");
        

        game.basic(v);
        game.styleText(monologue1, 40);
        game.styleText(monologue2, 40);
        game.styleText(monologue3, 80);
        game.smallFont(monologue1);
        game.smallFont(monologue2);
        game.smallFont(monologue3);

        v.getChildren().add(game.image("\\images\\city.gif", 1000, 300));
        v.getChildren().addAll(monologue1, monologue2, monologue3);

        Scene scene = new Scene(v, 1000, 800);

        return scene;

    } 
    
}
