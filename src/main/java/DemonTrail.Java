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
    public int c = 0;

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

        // Route 2 textfields + button
        TextField rTwoTextOne = rTwo.textFieldOne;
        TextField rTwoTextTwo = rTwo.textFieldTwo;
        TextField[] rTwoFields = { rTwo.textFieldOne, rTwo.textFieldTwo };
        Button button = rTwo.restartButton;
        // note maybe put all texfields into array and then have big array.keypressed
        // ect. and then in function
        // manage each indivudal textfield and where it should show scene

        // scene arrays
        Scene[] introScenes = { introOne };

        // rTwo Scenes order if all correct choices chosen
        Scene[] rTwoScenes = { rTwoOne, rTwoTwo, rTwoThree, rTwoChoiceOne, rTwoFoodOption, rTwoFour, rTwoChoiceTwo,
                rTwoFinal };
        Scene[] rTwoMedScenes = { rTwoEndMed, rTwoEndMedTwo };

        Scene[] allScenes = { introOne, rTwoOne, rTwoTwo, rTwoThree, rTwoChoiceOne, rTwoEndGas, rTwoEndMed,
                rTwoEndMedTwo, rTwoFoodOption, rTwoFour, rTwoEndTravel, rTwoEndRope, rTwoFinal }; // keep but delete
                                                                                                  // eventually

        // note for score board maybe can include how many times player died (increase
        // death count each time on end screen)
        // deathcount back to 0 when back to start screen;
        // restart button takes back to scene 1 not start screen
        // if reached final good ending, play again button takes to start screen to
        // reset "score" maybe

        // testing for switching between screens.
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

        // button event... if restart button pressed
        button.setOnAction((event) -> { // small issue.... restarts game when space clicked
            i=0;//resets i to 0 to know we are back on scene[0]
            window.setScene(rTwoOne);
        });

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