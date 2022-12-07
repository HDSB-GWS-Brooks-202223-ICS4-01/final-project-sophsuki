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
  
        //title.getStyleClass().add("label-title"); for bigger font when making start screen ect.
        GameScene l1 = new GameScene();
        l1.basic(box);
        l1.styleText(title, 0, -300);
        box.getChildren().add(title);

        Scene scene = new Scene(box, 1000, 800);
        
      
        primaryStage.setScene(scene); 
        primaryStage.setResizable(false);
        primaryStage.show();
        
    }
}