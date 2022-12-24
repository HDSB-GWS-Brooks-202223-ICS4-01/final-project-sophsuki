import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class DemonTrail extends Application {
    private int m = 0; // route 2 var
    private int c = 0; // route 2 var
    private int n = 0; // intro var
    public int deaths = 0;

    Boolean choiceMedWaterEnd = false;

    Stage window;
    GameScene game = new GameScene();

    @Override
    public void start(Stage primaryStage) throws Exception {

        window = primaryStage;
        // Intro 
        IntroScene intro = new IntroScene();
        // Route 2 
        RouteTwo rTwo = new RouteTwo();
        //Ending storyline 
        End end = new End();
    

        // scene arrays
        Scene[] introScenes = { intro.introOne(), intro.introTwo(), intro.introThree(), intro.introFourChoice1(), intro.inChoice1MedWater(), intro.inChoice1Pass() };
        Scene[] waterEnd = { intro.inChoice1MedWater(), intro.inChoice1Death() };

        // rTwo Scenes with correct choices, begining to end...
        Scene[] rTwoScenes = {rTwo.storyTwoOne(), rTwo.storyTwoTwo(), rTwo.storyTwoThree(), rTwo.optionTwoOne(), rTwo.foodOption(), rTwo.storyTwoFour(), rTwo.optionTwoTwo(),
                rTwo.swimOption() };
        Scene[] rTwoMedScenes = { rTwo.endMedOne(), rTwo.endMedTwo() };

        // Button array
        Button[] restartButtons = { intro.restart, intro.restart2, rTwo.restartOne, rTwo.restartTwo,
                rTwo.restartThree, rTwo.restartFour };
        // text field array
        TextField[] inputFields = { IntroScene.t, rTwo.textFieldOne, rTwo.textFieldTwo }; 


        // note for score board maybe can include how many times player died (increase
        // death count each time on end screen)
        // deathcount back to 0 when back to start screen;
        // restart button takes back to scene 1 not start screen
        // if reached final good ending, play again button takes to start screen to
        // reset "score" maybe

        // When space pressed... changes to next scene in array

        for (int i = 0; i < introScenes.length; i++) {

            introScenes[i].setOnKeyPressed(new EventHandler<KeyEvent>() {

                @Override
                public void handle(KeyEvent key) {
                    if (key.getCode().equals(KeyCode.SPACE)) {
                        if (n < 5) {
                            n++;
                            window.setScene(introScenes[n]);
                        } else {
                            window.setScene(rTwoScenes[m]);
                            n = 0;
                        }
                    }

                }
            });

        }

        for (int i = 0; i < waterEnd.length - 1; i++) {
            waterEnd[i].setOnKeyPressed(new EventHandler<KeyEvent>() {

                @Override
                public void handle(KeyEvent key) {
                    if (key.getCode().equals(KeyCode.SPACE)) {
                        if (choiceMedWaterEnd) {
                            window.setScene(waterEnd[1]);
                        } else {
                            n++;
                            window.setScene(introScenes[n]);
                        }
                    }

                }

            });
        }

        for (int i = 0; i < rTwoScenes.length - 1; i++) {
            rTwoScenes[i].setOnKeyPressed(new EventHandler<KeyEvent>() {

                @Override
                public void handle(KeyEvent key) {
                    if (key.getCode().equals(KeyCode.SPACE)) {
                        m++;
                        window.setScene(rTwoScenes[m]);
                    }

                }
            });
        }
        // med ending scenes space bar pressed event
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
        for (int j = 0; j < restartButtons.length; j++) {
            restartButtons[j].setOnMousePressed(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    deaths++; // increase deaths by 1
                    c = 0; // resets screen # counter to 0
                    m = 0;
                    n = 0;
                    window.setScene(intro.introOne());

                }

            });
        }

        // input from textfields
        for (int j = 0; j < inputFields.length; j++) {
            inputFields[j].setOnKeyPressed(new EventHandler<KeyEvent>() {

                @Override
                public void handle(javafx.scene.input.KeyEvent key) { 
                    if (key.getCode().equals(KeyCode.ENTER)) { // if enter pressed

                        if (key.getSource() == IntroScene.t) {
                            if (IntroScene.t.getText().equals("1")) { // if option 1 selected(correct option)
                                n++;
                                window.setScene(intro.inChoice1MedWater());
                                choiceMedWaterEnd = false;
                            } else if (IntroScene.t.getText().equals("2")) {// if option 2 selected
                                window.setScene(intro.inChoice1Gas());
                            } else if (IntroScene.t.getText().equals("3")) {// if option 3 selected
                                window.setScene(intro.inChoice1MedWater());
                                choiceMedWaterEnd = true;
                            }
                        }

                        else if (key.getSource() == rTwo.textFieldOne) { // Route 2 first choice textfield
                            if (rTwo.textFieldOne.getText().equals("1")) { // if option 1 selected
                                window.setScene(rTwo.endGas());
                            } else if (rTwo.textFieldOne.getText().equals("2")) {// if option 2 selected(correct option)
                                m++;
                                window.setScene(rTwoScenes[m]);
                            } else if (rTwo.textFieldOne.getText().equals("3")) {// if option 3 selected
                                window.setScene(rTwo.endMedOne());
                            }
                        }

                        else if (key.getSource() == rTwo.textFieldTwo) { // Route 2 second choice textfield
                            if (rTwo.textFieldTwo.getText().equals("1")) {// if option 1 selected(correct choice)
                                m++;
                                window.setScene(rTwoScenes[m]);

                            } else if (rTwo.textFieldTwo.getText().equals("2")) { // if option 2 selected
                                window.setScene(rTwo.endTravel());

                            } else if (rTwo.textFieldTwo.getText().equals("3")) {// if option 3 selected
                                window.setScene(rTwo.endRope());
                            }

                        }
                    }

                }
            });
        }
        
        window.setScene(end.endOne()); // change to whatever to test out screens.
        window.setResizable(false);
        window.show();
    }
}
