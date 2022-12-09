import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class DemonTrail extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
    
        VBox box = new VBox();
        Label title = new Label();
        title.setText("Welcome to Demon Trail");
  
        GameScene l1 = new GameScene();
        l1.basic(box);
        l1.styleText(title, 0, -100);
        
        box.getChildren().addAll(title, l1.image("\\images\\graveyard1.png", 200, 200));

        Scene scene = new Scene(box, 1000, 800);
      
        primaryStage.setScene(scene); 
        primaryStage.setResizable(false);
        primaryStage.show();

        
    }
}