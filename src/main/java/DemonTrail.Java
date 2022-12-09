import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class DemonTrail extends Application {

    Stage window;
    @Override
    public void start(Stage primaryStage) throws Exception {

        window = primaryStage ;
    
        VBox box = new VBox();
        Label title = new Label();
        title.setText("Welcome to Demon Trail");
  
        GameScene l1 = new GameScene();
        l1.basic(box);
        l1.styleText(title, 0, 400);

        // IDea for input changing scenes. 
    //     Intro scene = new Intro();
    //     scene.scene1();
    //     scene.scene2();

    //     Scene [] arrayintro = {scene.scene1(), scene.scene2()}; 
    //      key pressed event if space bar clicked
    //     i++ 
    //      array[] = array[i];
    //     we are on route2
    //    if we are on route 2
    //maybe create boolean variable for routes, make it false when on scene that links to next route. 
        
        box.getChildren().addAll(title, l1.image("\\images\\graveyard1.png", 200, 200));

        Scene scene = new Scene(box, 1000, 800);
      
        RouteTwo story = new RouteTwo();
        Scene routeTwoOne = story.partTwoOne();
        //title.getStyleClass().add("label-title");

       window.setScene(routeTwoOne); 
       window.setResizable(false);
       window.show();

        
    }
}