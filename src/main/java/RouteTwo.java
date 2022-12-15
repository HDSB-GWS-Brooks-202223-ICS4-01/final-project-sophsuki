import java.util.Stack;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.util.Duration;

import javafx.scene.input.KeyEvent;

public class RouteTwo extends GameScene {

    public int days = 5;
    public int miles = 5;
    public String date = "December 1st"; // change date to match jelenas

    private Group daysPass;

    GameScene game = new GameScene();

    public Scene storyTwoOne() {

        StackPane box1 = new StackPane();
        game.basicPane(box1);

        //labels
        Label stats = new Label();
        Label day = new Label();
        Label mile = new Label();

        // text
        stats.setText("Stats");
        day.setText(" days survived : 5");
        mile.setText("miles walked : 5");

        // styles text
        game.styleText(stats, 100);
        game.title(stats);
        game.styleText(day, 300);
        game.styleText(mile, 400);

        box1.getChildren().addAll(game.spaceText(700), stats, day, mile);

        Scene sceneOne = new Scene(box1, 1000, 800);
        return sceneOne;
    }

    public Scene storyTwoTwo() {

        StackPane box2 = new StackPane();
        game.basicPane(box2);

        // labels
        Label travel = new Label();
        Label food = new Label();
        Label gas = new Label();

        // text
        travel.setText("Couple days pass");
        food.setText("70% of rations have been depleted");
        gas.setText("You see a gas station in the distance");

        // styles text
        game.styleText(travel, 350);
        game.styleText(food, 450);
        game.styleText(gas, 550);

        // load images
        ImageView sun = game.image("\\images\\day.gif", 1000, 300);
        ImageView moon = game.image("\\images\\night.gif", 1000, 300);

        // Animating night and day images
        daysPass = new Group(sun);

        Timeline t = new Timeline();
        t.setCycleCount(Timeline.INDEFINITE);

        t.getKeyFrames().add(new KeyFrame(
                Duration.millis(700),
                (ActionEvent event) -> {
                    daysPass.getChildren().setAll(moon);
                }));

        t.getKeyFrames().add(new KeyFrame(
                Duration.millis(1800),
                (ActionEvent event) -> {
                    daysPass.getChildren().setAll(sun);
                }));

        t.play();

        box2.getChildren().addAll(daysPass, game.spaceText(700), travel, food, gas);
        Scene sceneTwo = new Scene(box2, 1000, 800);
        return sceneTwo;
    }

    public Scene storyTwoThree(){
        
        StackPane box3 = new StackPane();
        game.basicPane(box3); 
       
        //label
        Label gasStation = new Label();

        //text + styles text
        gasStation.setText("you arrive at the gas station");
        game.styleText(gasStation, 390);
        

        ImageView border =  game.image("\\images\\border.png", 615, 100);
        border.setTranslateY(370);

        box3.getChildren().addAll(game.image("\\images\\station.gif", 1000, 800), border);
        box3.getChildren().addAll(gasStation, game.spaceText(700));
        
        Scene sceneThree = new Scene(box3, 1000, 800);
        return sceneThree;
    }

    public Scene optionTwoOne(){

        StackPane box4 = new StackPane();
        game.basicPane(box4);

        TextField textField = new TextField();
        
        //labels
        Label bag = new Label();
        Label choice = new Label();
        Label choiceOne = new Label();
        Label choiceTwo = new Label();
        Label choiceThree = new Label();
    
        //text
        bag.setText("You may carry one item :");
        choice.setText("What is your choice?");

        choiceOne.setText("1 : Gas");
        choiceTwo.setText("2 : food and water");
        choiceThree.setText("3 : medical supplies");

        //styles text
        game.styleText(bag, 150);
        game.styleText(choiceOne, 250);
        choiceOne.setTranslateX(-115);
        game.styleText(choiceTwo, 350);
        game.styleText(choiceThree, 450);
        game.styleText(choice, 600);
        TextField option = game.limitText(textField);

        option.setMaxSize(100, 10);
        option.setTranslateY(700);
        
    
 
        box4.getChildren().addAll(game.image("\\images\\border2.png", 800, 100),bag, choice);
        box4.getChildren().addAll(choiceOne, choiceTwo, choiceThree, option);

        
    
        Scene sceneFour = new Scene(box4, 1000, 800);
        return sceneFour;


    
    }

}


