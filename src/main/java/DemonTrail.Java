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
    private int m = 0; // route 2 var
    private int c = 0; // route 2 var
    private int n = 0; // intro var
    private int b = 0; // intro var
    public int deaths = 0;

    Boolean choiceMedWaterEnd = false;

    Stage window;
    GameScene game = new GameScene();

    @Override
    public void start(Stage primaryStage) throws Exception {

        window = primaryStage;

        // Intro scenes

        IntroScene intro = new IntroScene();
        Scene introOne = intro.introOne();
        Scene introTwo = intro.introTwo(); 
        Scene introThree = intro.introThree(); 
        Scene introFourChoice1 = intro.introFourChoice1();
        Scene inChoice1Gas = intro.inChoice1Gas(); 
        Scene inChoice1MedWater = intro.inChoice1MedWater();
        Scene inChoice1Death = intro.inChoice1Death();
        Scene inChoice1Pass = intro.inChoice1Pass();
        //textfield
        TextField introText = IntroScene.t;

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
        
        

        // note maybe put all texfields into array and then have big array.keypressed
        // ect. and then in function
        // manage each indivudal textfield and where it should show scene

        // scene arrays
    
        Scene[] introScenes = { introOne , introTwo, introThree, introFourChoice1, inChoice1MedWater, inChoice1Pass}; 
        Scene[] waterEnd = {inChoice1MedWater, inChoice1Death};

        // rTwo Scenes with correct choices, begining to end...
        Scene[] rTwoScenes = { rTwoOne, rTwoTwo, rTwoThree, rTwoChoiceOne, rTwoFoodOption, rTwoFour, rTwoChoiceTwo,
                rTwoFinal };
        Scene[] rTwoMedScenes = { rTwoEndMed, rTwoEndMedTwo };

        Scene[] allScenes = { introOne, rTwoOne, rTwoTwo, rTwoThree, rTwoChoiceOne, rTwoEndGas, rTwoEndMed,
                rTwoEndMedTwo, rTwoFoodOption, rTwoFour, rTwoEndTravel, rTwoEndRope, rTwoFinal }; // keep but delete
                                                                                                  // eventually

        //Button array
        Button [] restartButtons = {intro.restart, intro.restart2, rTwo.restartButton, rTwo.restartButtonTwo, rTwo.restartButtonThree, rTwo.restartButtonFour}; 
        TextField[] inputFields = {introText, rTwo.textFieldOne, rTwo.textFieldTwo }; // add all textfields here
        // add all scenes restart button here

        // note for score board maybe can include how many times player died (increase
        // death count each time on end screen)
        // deathcount back to 0 when back to start screen;
        // restart button takes back to scene 1 not start screen
        // if reached final good ending, play again button takes to start screen to
        // reset "score" maybe

        

        // When space pressed... changes to next scene in array
        //route 2 scenes space bar pressed event

        for ( int i = 0; i < introScenes.length -1; i++){

            introScenes[i].setOnKeyPressed(new EventHandler<KeyEvent>() {

                @Override
                public void handle(KeyEvent key) {
                    if (key.getCode().equals(KeyCode.SPACE)) {
                        n++;
                        window.setScene(introScenes[n]);

                        // if(introScenes[n] > introScenes.length){
                        //     window.setScene(rTwoOne);
                        // }
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
                    }
                    else {
                        n++;
                        window.setScene(introScenes[n]);
                    }
                }

                }

            });
        }
    


        for (int j = 0; j < rTwoScenes.length - 1; j++) {

            rTwoScenes[j].setOnKeyPressed(new EventHandler<KeyEvent>() {

                @Override
                public void handle(KeyEvent key) {
                    if (key.getCode().equals(KeyCode.SPACE)) {
                        m++;
                        window.setScene(rTwoScenes[m]);
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
                m = 0;
                n = 0;
                window.setScene(introOne);// change to 1 scene after start screen eventually

            }

        });
    }

        // input from textfields
        for (int j = 0; j < inputFields.length; j++) {
            inputFields[j].setOnKeyPressed(new EventHandler<KeyEvent>() {

                @Override
                public void handle(javafx.scene.input.KeyEvent key) { // REMINDER FIX WHAT WINDOW IT CHANGES TO 
                    if (key.getCode().equals(KeyCode.ENTER)) {

                        if(key.getSource() == introText){
                            if (introText.getText().equals("1")) { // if option 1 selected
                                n++;
                                window.setScene(inChoice1MedWater);
                                choiceMedWaterEnd = false;
                            } else if (introText.getText().equals("2")) {// if option 2 selected
                                window.setScene(inChoice1Gas);
                            } else if (introText.getText().equals("3")) {// if option 3 selected
                                    window.setScene(inChoice1MedWater);
                                    choiceMedWaterEnd = true;
                            }
                        }

                        }

                        else if (key.getSource() == rTwoTextOne) { // Route 2 first choice textfield
                            if (rTwoTextOne.getText().equals("1")) { // if option 1 selected
                                window.setScene(rTwoEndGas);
                            } else if (rTwoTextOne.getText().equals("2")) {// if option 2 selected(correct option)
                                m++;
                                window.setScene(rTwoScenes[m]);
                            } else if (rTwoTextOne.getText().equals("3")) {// if option 3 selected
                                    window.setScene(rTwoEndMed);
                            }
                        }

                        else if (key.getSource() == rTwoTextTwo) { // Route 2 second choice textfield
                            if (rTwoTextTwo.getText().equals("1")) {// if option 1 selected(correct choice)
                                m++;
                                window.setScene(rTwoScenes[m]);

                            } else if (rTwoTextTwo.getText().equals("2")) { // if option 2 selected
                                window.setScene(rTwoEndTravel);

                            } else if (rTwoTextTwo.getText().equals("3")) {// if option 3 selected
                                window.setScene(rTwoEndRope);
                            }

                        }

                    }                
            });
        }

        window.setScene(introOne); // change to whatever to test out screens.
        window.setResizable(false);
        window.show();
    }
}
