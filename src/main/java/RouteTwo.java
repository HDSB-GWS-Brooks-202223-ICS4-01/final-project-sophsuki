import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class RouteTwo extends GameScene  {

    public int days = 5;
    public int miles  = 5;
    public String date = "December 1st";

    GameScene game = new GameScene();

public Scene partTwoOne (){
    VBox box = new VBox();
    Label stats = new Label();
    Label day = new Label();
    Label mile = new Label();
        
    stats.setText("Stats");
    day.setText(" days survived : 5" );
    mile.setText("miles walked : 5");

    game.basic(box);
    game.styleText(stats, 0, 50);
    game.bigSize(stats);
    game.styleText(day, 0, 200);
    game.styleText(mile, 0, 300);
    box.getChildren().addAll(stats, day, mile);

    Scene sceneOne = new Scene(box, 1000, 800);
    return sceneOne;

}


}
