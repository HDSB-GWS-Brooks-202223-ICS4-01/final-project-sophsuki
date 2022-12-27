import java.util.Timer;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;

public class RouteThree extends GameScene{
    GameScene game = new GameScene();
    Timer timer = new Timer();

    public Button restart = new Button();
    public Button restart2 = new Button();

    public static TextField t = new TextField(); 

    public Scene r3One() {
        StackPane sp1 = new StackPane();
        Scene scene = new Scene(sp1, 1000, 800);

        

        return scene;
    }
    
}
