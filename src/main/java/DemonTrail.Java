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
        
        title.setPrefHeight(120);
        title.setPrefWidth(300);
        GameScene l1 = new GameScene();
        
        Scene scene = new Scene(l1.basicLayout(title, box), 1000, 800); 
        primaryStage.setScene(scene); 
        primaryStage.show();
        
    }
}