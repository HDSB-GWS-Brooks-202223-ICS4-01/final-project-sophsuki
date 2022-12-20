import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class DemonTrail extends Application {
    private int i = 0;
    private int c = 0;
    public int deaths = 0;

    Stage window;
    GameScene game = new GameScene();

    @Override
    public void start(Stage primaryStage) throws Exception {

        window = primaryStage;

        // Intro scenes
        IntroScene intro = new IntroScene();
        Scene introOne = intro.introOne();

        // Route 2 scenes
        RouteTwo rTwo = new RouteTwo();
        Scene rTwoOne = rTwo.storyTwoOne();
        Scene rTwoTwo = rTwo.storyTwoTwo();
        Scene rTwoThree = rTwo.storyTwoThree();
        // choice 1 scene + endings
        Scene rTwoChoiceOne = rTwo.optionTwoOne();
        Scene rTwoEndGas = rTwo.endGas();
        Scene rTwoEndMed = rTwo.endMedOne();
        Scene rTwoEndMedTwo = rTwo.endMedTwo();
        Scene rTwoFoodOption = rTwo.foodOption();
        // Route 2 scenes continued from food option to ending
        Scene rTwoFour = rTwo.storyTwoFour();
        Scene rTwoChoiceTwo = rTwo.optionTwoTwo();
        Scene rTwoEndTravel = rTwo.endTravel();
        Scene rTwoEndRope = rTwo.endRope();
        Scene rTwoFinal = rTwo.swimOption();
        // Route 2 textfields 
        TextField rTwoTextOne = rTwo.textFieldOne;
        TextField rTwoTextTwo = rTwo.textFieldTwo;
        TextField[] rTwoFields = { rTwo.textFieldOne, rTwo.textFieldTwo }; // change to all textfields eventually
        

        // note maybe put all texfields into array and then have big array.keypressed
        // ect. and then in function
        // manage each indivudal textfield and where it should show scene

        // scene arrays
        Scene[] introScenes = { introOne };

        // rTwo Scenes with correct choices, begining to end...
        Scene[] rTwoScenes = { rTwoOne, rTwoTwo, rTwoThree, rTwoChoiceOne, rTwoFoodOption, rTwoFour, rTwoChoiceTwo,
                rTwoFinal };
        Scene[] rTwoMedScenes = { rTwoEndMed, rTwoEndMedTwo };

        Scene[] allScenes = { introOne, rTwoOne, rTwoTwo, rTwoThree, rTwoChoiceOne, rTwoEndGas, rTwoEndMed,
                rTwoEndMedTwo, rTwoFoodOption, rTwoFour, rTwoEndTravel, rTwoEndRope, rTwoFinal }; // keep but delete
                                                                                                  // eventually

        //Button array
        Button [] restartButtons = {rTwo.restartButton, rTwo.restartButtonTwo, rTwo.restartButtonThree, rTwo.restartButtonFour}; 
        // add all scenes restart button here

        // note for score board maybe can include how many times player died (increase
        // death count each time on end screen)
        // deathcount back to 0 when back to start screen;
        // restart button takes back to scene 1 not start screen
        // if reached final good ending, play again button takes to start screen to
        // reset "score" maybe

        // When space pressed... changes to next scene in array
        //route 2 scenes space bar pressed event
        for (int j = 0; j < rTwoScenes.length - 1; j++) {

            rTwoScenes[j].setOnKeyPressed(new EventHandler<KeyEvent>() {

                @Override
                public void handle(KeyEvent key) {
                    if (key.getCode().equals(KeyCode.SPACE)) {
                        i++;
                        window.setScene(rTwoScenes[i]);
                    }

                }
            });
        }
        //med scenes space bar pressed event
        for (int i = 0; i < rTwoMedScenes.length - 1; i++) {
            rTwoMedScenes[i].setOnKeyPressed(new EventHandler<KeyEvent>() {

                @Override
                public void handle(KeyEvent key) {
                    if (key.getCode().equals(KeyCode.SPACE)) {
                        c++;
                        window.setScene(rTwoMedScenes[c]);
                    }

                }

            });
        }

        // button event, if restart button clicked
        for (int j = 0; j < restartButtons.length; j ++){
        restartButtons[j].setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                deaths ++; // increase deaths by 1
                i = 0;
                window.setScene(rTwoOne);// change to 1 scene after start screen eventually

            }

        });
    }

        // input from textfields
        for (int n = 0; n < rTwoFields.length; n++) {
            rTwoFields[n].setOnKeyPressed(new EventHandler<KeyEvent>() {

                @Override
                public void handle(javafx.scene.input.KeyEvent key) {
                    if (key.getCode().equals(KeyCode.ENTER)) {

                        if (key.getSource() == rTwoTextOne) { // Route 2 first choice textfield
                            if (rTwoTextOne.getText().equals("1")) { // if option 1 selected
                                window.setScene(rTwoEndGas);
                            } else if (rTwoTextOne.getText().equals("2")) {// if option 2 selected(correct option)
                                i++;
                                window.setScene(rTwoScenes[i]);
                            } else if (rTwoTextOne.getText().equals("3")) {// if option 3 selected
                                for (int i = 0; i < rTwoMedScenes.length; i++) {
                                    window.setScene(rTwoEndMed);
                                }
                            }
                        }

                        else if (key.getSource() == rTwoTextTwo) { // Route 2 second choice textfield
                            if (rTwoTextTwo.getText().equals("1")) {// if option 1 selected(correct choice)
                                i++;
                                window.setScene(rTwoScenes[i]);

                            } else if (rTwoTextTwo.getText().equals("2")) { // if option 2 selected
                                window.setScene(rTwoEndTravel);

                            } else if (rTwoTextTwo.getText().equals("3")) {// if option 3 selected
                                window.setScene(rTwoEndRope);
                            }

                        }

                    }

                }
            });
        }

        window.setScene(rTwoOne); // change to whatever to test out screens.
        window.setResizable(false);
        window.show();
    }
}