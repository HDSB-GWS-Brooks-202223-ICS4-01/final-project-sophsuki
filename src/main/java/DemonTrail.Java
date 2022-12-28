import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class DemonTrail extends Application {
    private int m = 0; // route 2 scene # var
    private int c = 0; // route 2 scene #var
    private int n = 0; // intro 2 scene #var
    private int d = 0; // end scene # var
    public int deaths = 0;

    Boolean choiceMedWaterEnd = false;
    // Start screen
    Button start = new Button();
    Button instruction = new Button();

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
        // textfield
        TextField introInput = IntroScene.t;

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
        TextField rTwoInputOne = rTwo.textFieldOne;
        TextField rTwoInputTwo = rTwo.textFieldTwo;

        // ending scenes
        End end = new End();
        Scene endOne = end.endOne();
        Scene endTwo = end.endTwo();
        Scene endThree = end.endThree();
        Scene endChoice = end.endChoice();
        Scene endBad = end.endBad();
        Scene endGood = end.endGood();
        Scene endStats = end.endStats();
        // textfield
        TextField endInput = end.finalChoice;

        // introscene arrays
        Scene[] introScenes = { introOne, introTwo, introThree, introFourChoice1, inChoice1MedWater, inChoice1Pass };
        Scene[] waterEnd = { inChoice1MedWater, inChoice1Death };

        // rTwo Scenes with correct choices, begining to end...
        Scene[] rTwoScenes = { rTwoOne, rTwoTwo, rTwoThree, rTwoChoiceOne, rTwoFoodOption, rTwoFour, rTwoChoiceTwo,
                rTwoFinal };
        Scene[] rTwoMedScenes = { rTwoEndMed, rTwoEndMedTwo };

        // endscene array
        Scene[] endScenes = { endOne, endTwo, endThree, endChoice, endGood };

        // restart button array
        Button[] restartButtons = { intro.restart, intro.restart2, rTwo.restartOne, rTwo.restartTwo,
                rTwo.restartThree, rTwo.restartFour };
        // play again button array
        Button[] playAgain = { end.playAgain, end.playAgainTwo };

        // text field array
        TextField[] inputFields = { endInput, introInput, rTwoInputOne, rTwoInputTwo };

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
                        if (m < 5) {
                            m++;
                            window.setScene(rTwoScenes[m]);
                        } else {
                            window.setScene(endScenes[d]); // change to route 3 eventually then creatse same sthing
                                                           // to move from route 3 to end route
                            m = 0;
                        }
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

        for (int i = 0; i < endScenes.length - 1; i++) {
            endScenes[i].setOnKeyPressed(new EventHandler<KeyEvent>() {

                @Override
                public void handle(KeyEvent key) {
                    if (key.getCode().equals(KeyCode.SPACE)) {
                        
                        d++;
                        window.setScene(endScenes[d]);
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
                    d = 0;
                    window.setScene(introOne);

                }

            });
        }
        // button event if play again button clicked
        for (int i = 0; i < playAgain.length; i++) {
            playAgain[i].setOnMousePressed(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    window.setScene(startScreen(introOne,rTwoOne)); // change rTwoOne to instruction screen when made
                }

            });
        }

        // input from textfields
        for (int j = 0; j < inputFields.length; j++) {
            inputFields[j].setOnKeyPressed(new EventHandler<KeyEvent>() {

                @Override
                public void handle(javafx.scene.input.KeyEvent key) {
                    if (key.getCode().equals(KeyCode.ENTER)) { // if enter pressed

                        if (key.getSource() == introInput) {
                            if (introInput.getText().equals("1")) { // if option 1 selected(correct option)
                                n++;
                                window.setScene(inChoice1MedWater);
                                choiceMedWaterEnd = false;
                            } else if (introInput.getText().equals("2")) {// if option 2 selected
                                window.setScene(inChoice1Gas);
                            } else if (introInput.getText().equals("3")) {// if option 3 selected
                                window.setScene(inChoice1MedWater);
                                choiceMedWaterEnd = true;
                            }
                        }

                        else if (key.getSource() == rTwoInputOne) { // Route 2 first choice textfield
                            if (rTwoInputOne.getText().equals("1")) { // if option 1 selected
                                window.setScene(rTwoEndGas);
                            } else if (rTwoInputOne.getText().equals("2")) {// if option 2 selected(correct option)
                                m++;
                                window.setScene(rTwoScenes[m]);
                            } else if (rTwoInputOne.getText().equals("3")) {// if option 3 selected
                                window.setScene(rTwoEndMed);
                            }
                        }

                        else if (key.getSource() == rTwoInputTwo) { // Route 2 second choice textfield
                            if (rTwoInputTwo.getText().equals("1")) {// if option 1 selected(correct choice)
                                m++;
                                window.setScene(rTwoScenes[m]);

                            } else if (rTwoInputTwo.getText().equals("2")) { // if option 2 selected
                                window.setScene(rTwoEndTravel);

                            } else if (rTwoInputTwo.getText().equals("3")) {// if option 3 selected
                                window.setScene(rTwoEndRope);
                            }

                        } else if (key.getSource() == endInput) {
                            if (endInput.getText().equals("1") || endInput.getText().equals("2")) {// if option 1/2 //
                                                                                                   // selected
                                window.setScene(endBad);
                            } else if (endInput.getText().equals("3")) {// if option 3 selected(correct choice)
                                d++;
                                window.setScene(endScenes[d]); // change to win scene
                                System.out.println(deaths);
                            }
                        }
                    }

                }
            });
        }

        window.setScene(startScreen(introOne,rTwoOne)); // change to whatever to test out screens. // when final screen change 
        //change rTwoOne with instructions screen
        window.setResizable(false);
        window.show();
    }

    private Scene startScreen(Scene intro, Scene instructions) {
        deaths = 0; // deaths set to 0
        c = 0; // resets screen # counter to 0
        m = 0;
        n = 0;
        d = 0;
        StackPane box = new StackPane();
        game.basicPane(box);
        // labels
        Label title = new Label();
        Label day = new Label();
        Label mile = new Label();
        Label date = new Label();
        // text
        title.setText("Demon Trail");
        day.setText(" days survived : 20");
        mile.setText("kilometers walked : 199");
        date.setText("Date : November 30th");
        // styles text
        game.styleText(title, 100);
        game.title(title);

        Button begin = game.restart(start);
        begin.setText("Start");
        begin.setTranslateY(400);

        Button howToPlay = game.restart(instruction);
        howToPlay.setText("How To Play");
        howToPlay.setTranslateY(600);

        box.getChildren().addAll(begin, howToPlay, title);
        Scene sceneOne = new Scene(box, 1000, 800);
        
        //if start button pressed...
        begin.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                window.setScene(intro); // sets screen to first scene of story
            }

        });
        // if how to play betton pressed...
        howToPlay.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                window.setScene(instructions); // sets screen instructions screen
            }

        });

        return sceneOne;

    }
}
