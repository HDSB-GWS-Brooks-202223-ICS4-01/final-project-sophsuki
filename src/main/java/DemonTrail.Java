import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class DemonTrail extends Application {
    public int i = 0;

    Stage window;
    GameScene game = new GameScene();
    
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

        // Route 2 scenes
        RouteTwo rTwo = new RouteTwo();
        Scene rTwoOne = rTwo.storyTwoOne();
        Scene rTwoTwo = rTwo.storyTwoTwo();
        Scene rTwoThree = rTwo.storyTwoThree();
        //choice scene + endings
        Scene rTwoChoiceOne = rTwo.optionTwoOne();
        Scene rTwoEndGas    = rTwo.endGas();
        Scene rTwoEndMed = rTwo.endMedOne();
        Scene rTwoEndMedTwo = rTwo.endMedTwo();
        Scene rTwoFoodOption = rTwo.foodOption(); 
        //Route 2 scenes continued from food option to ending
        Scene rTwoFour = rTwo.storyTwoFour();
        Scene rTwoChoiceTwo = rTwo.optionTwoTwo();
        Scene rTwoEndTravel = rTwo.endTravel();
        Scene rTwoEndRope  = rTwo.endRope();
        Scene rTwofinal = rTwo.swimOption();
        //Route 2 textfields
        TextField rTwoTextOne = rTwo.textFieldOne;
        TextField rTwoTextTwo = rTwo.textFieldTwo;
        TextField[] rTwoFields = {rTwo.textFieldOne,rTwo.textFieldTwo};
        //note maybe put all texfields into array and then have big array.keypressed ect. and then in function
        //manage each indivudal textfield and where it should show scene 

        // scene arrays
        Scene[] introScenes = {introOne};
        Scene[] rTwoScenes = {introOne, rTwoOne, rTwoTwo, rTwoThree, rTwoChoiceOne, rTwoEndGas};
        Scene[] allScenes = { introOne , rTwoOne, rTwoTwo, rTwoThree, rTwoChoiceOne,rTwoEndGas, rTwoEndMed, rTwoEndMedTwo, rTwoFoodOption, rTwoFour,rTwoEndTravel, rTwoEndRope, rTwofinal }; // keep but delete eventually
        
        
        //note for score board maybe can include how many times player died (increase death count each time on end screen)
        // deathcount back to 0 when back to start screen;
        //restart button takes back to scene 1 not start screen
        //if reached final good ending, play again button takes to start screen to reset "score" maybe

        
        
    
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
            // for input // many problems// fix later
            rTwoTextOne.setOnKeyPressed(new EventHandler<KeyEvent>(){

                        @Override
                        public void handle(javafx.scene.input.KeyEvent key) {
                            if (key.getCode().equals(KeyCode.ENTER)){
                               System.out.println( rTwoTextOne.getText());
                               if (rTwoTextOne.getText().equals("1")){
                                window.setScene(allScenes[i + 1]);
                               }
                                
                            }
                            
                        }});
        }

        window.setScene(introOne); // change to whatever to test out screens.
        window.setResizable(false);
        window.show();
    }

    public Button restart(){ // TESTING RESTART BUTTOn
        Button button = new Button();
        button.setTranslateY(700);
        button.setAlignment(Pos.CENTER);
        button.setText("Restart");
        button.setOnAction((event) -> {
            
           // window.setScene(MAKES NULL WHY?????????);
        });
       return button;
    }
}