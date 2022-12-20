import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class DemonTrail extends Application {
    public int i = 0;

    Stage window;

    @Override
    public void start(Stage primaryStage) throws Exception {

        window = primaryStage;
        // IDea for input changing scenes.
        // Intro scene = new Intro();
        // scene.scene1();
        // scene.scene2();

        // Scene [] arrayintro = {scene.scene1(), scene.scene2()};
        // key pressed event if space bar clicked
        // i++
        // array[] = array[i];
        // we are on route2
        // if we are on route 2
        // maybe create boolean variable for routes, make it false when on scene that
        // links to next route.
        
        // Intro scenes
        IntroScene intro = new IntroScene();
        Scene introOne = intro.introOne();
        Scene introTwo = intro.introTwo(); 
        Scene introThree = intro.introThree(); 
        Scene introFourChoice1 = intro.introFourChoice1();
        Scene inChoice1Gas = intro.inChoice1Gas(); 

        // Route 2 scenes
        RouteTwo rTwo = new RouteTwo();
        Scene rTwoOne = rTwo.storyTwoOne();
        Scene rTwoTwo = rTwo.storyTwoTwo();
        Scene rTwoThree = rTwo.storyTwoThree();
        Scene rTwoChoiceOne = rTwo.optionTwoOne();

        // scene arrays
        Scene[] introScenes = {introOne, introTwo, introThree, introFourChoice1};
        Scene[] rTwoScenes = {rTwoOne, rTwoTwo, rTwoThree, rTwoChoiceOne};
        Scene[] allScenes = { introOne , introTwo, introThree, inChoice1Gas, introFourChoice1, rTwoOne, rTwoTwo, rTwoThree, rTwoChoiceOne }; // keep but delete eventually
        



        // testing for switching between screens.
        for (int j = 0; j < allScenes.length - 1; j++) {
            allScenes[j].setOnKeyPressed(new EventHandler<KeyEvent>() {

                @Override
                public void handle(KeyEvent key) {
                    if (key.getCode().equals(KeyCode.SPACE)) {
                        i++;
                        window.setScene(allScenes[i]);
                    }
                }
            });
        }

        window.setScene(introOne); // change to whatever to test out screens.
        window.setResizable(false);
        window.show();
    }

    
}