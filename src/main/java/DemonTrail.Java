import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class DemonTrail extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        VBox box = new VBox();
        box.setAlignment(Pos.CENTER);
        Scene scene = new Scene(box, 700, 600); 
        primaryStage.setScene(scene); 
        primaryStage.show();

        
        
    }
}