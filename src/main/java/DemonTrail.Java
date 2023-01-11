
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;

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
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

public class DemonTrail extends Application {
    Stage window;
    GameScene game = new GameScene();

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
    Boolean choiceMedWaterEnd = false;

    // Route 3 Scenes
    RouteThree r3 = new RouteThree();
    Scene r3Stats = r3.r3Stats();
    Scene r3One = r3.r3One();
    Scene r3Choice = r3.r3Choice();
    Scene r3Feed = r3.r3Feed();
    Scene r3Free = r3.r3Free();
    Scene r3Starve = r3.r3Starve();
    // route 3 text fields
    TextField r3Input = r3.textField;

    // ending scenes
    End end = new End();
    Scene endOne = end.endOne();
    Scene endTwo = end.endTwo();
    Scene endThree = end.endThree();
    Scene endChoice = end.endChoice();
    Scene endBad = end.endBad();
    Scene endGood = end.endGood();
    // end textfield
    TextField endInput = end.finalChoice;

    // introscene arrays
    Scene[] introScenes = { introOne, introTwo, introThree, introFourChoice1, inChoice1MedWater, inChoice1Pass };
    Scene[] waterEnd = { inChoice1MedWater, inChoice1Death };

    // rTwo Scenes with correct choices, begining to end...
    Scene[] rTwoScenes = { rTwoOne, rTwoTwo, rTwoThree, rTwoChoiceOne, rTwoFoodOption, rTwoFour, rTwoChoiceTwo,
            rTwoFinal };
    Scene[] rTwoMedScenes = { rTwoEndMed, rTwoEndMedTwo };

    // rThree scenes
    Scene[] rThreeScenes = { r3Stats, r3One, r3Choice, r3Feed, r3Free, r3Starve };

    // endscene array
    Scene[] endScenes = { endOne, endTwo, endThree, endChoice, endGood };

    // restart button array (died before final ending, play again from intro one)
    Button[] restartButtons = { intro.restart, intro.restart2, rTwo.restartOne, rTwo.restartTwo,
            rTwo.restartThree, rTwo.restartFour, r3.restart1, r3.restart2 };
    // play again button array (reached one of the final endings, play again from
    // start screen)
    Button[] playAgain = { end.playAgain, end.playAgainTwo };
    // input text field array
    TextField[] inputFields = { endInput, introInput, rTwoInputOne, rTwoInputTwo, r3Input };

    private int m = 0; // route 2 scene # var
    private int c = 0; // route 2 medscene #var
    private int n = 0; // intro scene # var
    private int k = 0; // route 3 scene # var
    private int d = 0; // end scene # var

    private int score = 1000;
    private int deaths = 0;

    // start screen
    boolean onStartScreen = false;

    @Override
    public void start(Stage primaryStage) throws Exception {

        window = primaryStage;

        introNextScene();
        routeTwoNextScene();
        routeThreeNextScene();
        endNextScene();

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
                    k = 0;
                    window.setScene(introOne);

                }

            });
        }
        // button event if play again button clicked
        for (int i = 0; i < playAgain.length; i++) {
            playAgain[i].setOnMousePressed(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    window.setScene(startScreen());
                    // @@@JELENA LOOK HERE
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
                        }
                        // ROUTE 3
                        else if (key.getSource() == r3Input) {
                            if (r3Input.getText().equals("1")) {// CORRECT OPTION
                                k++;
                                window.setScene(null); // TODO: ADD END SCENE, do i need to add different array for
                                                       // endings? //remindersop u dont need to, u can just add final
                                                       // scene like i attampted to feed her blah blah she enjoyed the
                                                       // meal
                                                       // and then my beginning scene for end route " is finally calm
                                                       // and full we decide to blah blah "so it will pick up from ur
                                                       // scene.
                            } else if (r3Input.getText().equals("2")) {
                                window.setScene(null);
                            } else if (r3Input.getText().equals("2")) {
                                window.setScene(null);

                            }
                        } else if (key.getSource() == endInput) {
                            if (endInput.getText().equals("1") || endInput.getText().equals("2")) {// if option 1/2
                                                                                                   // selected

                                window.setScene(endBad);
                            } else if (endInput.getText().equals("3")) {// if option 3 selected(correct choice)
                                d++;

                                window.setScene(endScenes[d]); // good ending
                            }
                            writeFile();
                            deaths = 0;
                        }
                    }

                }
            });
        }

        window.setScene(startScreen()); // change to whatever to test out screens.

        window.setResizable(false);
        window.show();
    }

    private void introNextScene() {
        for (int i = 0; i < introScenes.length; i++) {

            introScenes[i].setOnKeyPressed(new EventHandler<KeyEvent>() {

                @Override
                public void handle(KeyEvent key) {
                    if (key.getCode().equals(KeyCode.SPACE)) {
                        if (n < introScenes.length - 1) {
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
    }

    private void routeTwoNextScene() {
        for (int i = 0; i < rTwoScenes.length; i++) {
            rTwoScenes[i].setOnKeyPressed(new EventHandler<KeyEvent>() {

                @Override
                public void handle(KeyEvent key) {
                    if (key.getCode().equals(KeyCode.SPACE)) {
                        if (m < rTwoScenes.length - 1) {
                            m++;
                            window.setScene(rTwoScenes[m]);
                        } else {
                            window.setScene(endScenes[d]); // change to rthreescene[k] later
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
    }

    private void routeThreeNextScene() {
        // route 3 Scenes
        for (int i = 0; i < rThreeScenes.length; i++) {
            rThreeScenes[i].setOnKeyPressed(new EventHandler<KeyEvent>() {

                @Override
                public void handle(KeyEvent key) {
                    if (key.getCode().equals(KeyCode.SPACE)) {
                        if (k < rThreeScenes.length - 1) {
                            k++;
                            window.setScene(rThreeScenes[k]);
                        } else {
                            window.setScene(endScenes[d]);
                            k = 0;
                        }
                    }

                }
            });
        }
    }

    private void endNextScene() {
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
    }

    private void playMusic() {
        Media bgMusic = new Media(getClass().getResource("/music.mp3").toExternalForm());
        MediaPlayer mediaPlayer = new MediaPlayer(bgMusic);

        mediaPlayer.setVolume(0.10);
        mediaPlayer.play();
    }

    //  private void readFile(){
       // need to add and sort to highscore
    //  }

    private void writeFile() {
        try {
            FileWriter fw = new FileWriter("Score.txt", true);
            BufferedWriter br = new BufferedWriter(fw);

            if (score >= 0) {
                score = 1000 - (deaths * 100);
            } else {
                score = 0;
            }

            br.newLine();
            br.write(Integer.toString(score));
            br.close();

        } catch (IOException exc) {
            System.out.println("Cannot open file.");
            return;
        }

    }

    private Scene startScreen() {
        playMusic(); // starts music
        c = 0; // resets screen # counter to 0
        m = 0;
        n = 0;
        d = 0;
        k = 0;

        StackPane box = new StackPane();
        game.basicPane(box);
        // labels
        Label title = new Label();
        // text
        title.setText("Demon Trail");
        game.styleText(title, 100);
        game.title(title);

        // Start screen buttons
        Button begin = new Button();
        game.restart(begin);
        begin.setText("Start");
        begin.setTranslateY(400);

        Button howToPlay = new Button();
        game.restart(howToPlay);
        howToPlay.setText("How To Play");
        howToPlay.setTranslateY(600);

        box.getChildren().addAll(begin, howToPlay, title);
        Scene sceneOne = new Scene(box, 1000, 800);

        // if start button pressed...
        begin.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                window.setScene(introOne); // sets screen to first scene of story
            }

        });
        // if how to play button pressed...
        howToPlay.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                window.setScene(introOne); // change to instruction scene
            }
        });

        return sceneOne;

    }

}
