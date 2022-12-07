import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import package.GameScene;


public class DemonTrail extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
    
        VBox box = new VBox();
        TextArea area = new TextArea();
        area.setText("Enter your address here");
        area.setPrefColumnCount(15);
        area.setPrefHeight(120);
        area.setPrefWidth(300);
        GameScene l1 = new GameScene();
        
        Scene scene = new Scene(l1.basicLayout(area, box), 1000, 800); 
        primaryStage.setScene(scene); 
        primaryStage.show();
        
    }
}