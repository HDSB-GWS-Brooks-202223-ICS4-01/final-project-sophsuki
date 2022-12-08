import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class DemonTrail extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
    
        VBox box = new VBox();
        Label title = new Label();
        title.setText("Welcome to Demon Trail");
  
        //title.getStyleClass().add("label-title"); for bigger font when making start screen ect.
        Image graphics = new Image("\\images\\graveyard1.png");
        ImageView imageArea = new ImageView();

        imageArea.setImage(graphics);
        //imageArea.setPreserveRatio(true);
        imageArea.setSmooth(true);
        imageArea.setCache(true);
        imageArea.setFitWidth(1000);
        imageArea.setFitHeight(300);
        GameScene l1 = new GameScene();
        l1.basic(box);
        l1.styleText(title, 0, -300);
        // l1.image("\\resources\\images\\graveyard1.png");
        box.getChildren().addAll(title, imageArea);
        

        Scene scene = new Scene(box, 1000, 800);
        
      
        primaryStage.setScene(scene); 
        primaryStage.setResizable(false);
        primaryStage.show();

        
        
    }
}