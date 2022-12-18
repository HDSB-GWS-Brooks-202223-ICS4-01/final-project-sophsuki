import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;

public class RouteTwo extends GameScene {

    public int days = 5;
    public int kilometers = 51;
    public String date = "November 15th"; 
    private Group daysPass;

    GameScene game = new GameScene();

    public Scene storyTwoOne() {

        StackPane box1 = new StackPane();
        game.basicPane(box1);

        // labels
        Label stats = new Label();
        Label day = new Label();
        Label mile = new Label();
        Label date = new Label();

        // text
        stats.setText("Stats");
        day.setText(" days survived : 5");
        mile.setText("kilometers walked : 51");
        date.setText("November 15th");

        // styles text
        game.styleText(stats, 100);
        game.title(stats);
        game.styleText(day, 300);
        game.styleText(mile, 400);
        game.styleText(date, 500);

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

    public Scene storyTwoThree() {

        StackPane box3 = new StackPane();
        game.basicPane(box3);

        // label
        Label gasStation = new Label();

        // text + styles text
        gasStation.setText("you arrive at the gas station");
        game.styleText(gasStation, 390);

        ImageView border = game.image("\\images\\border.png", 615, 100);
        border.setTranslateY(370);

        box3.getChildren().addAll(game.image("\\images\\station.gif", 1000, 800), border);
        box3.getChildren().addAll(gasStation, game.spaceText(700));
        Scene sceneThree = new Scene(box3, 1000, 800);
        return sceneThree;
    }

    public Scene optionTwoOne() {

        StackPane box4 = new StackPane();
        game.basicPane(box4);

        // labels
        Label bag = new Label();
        Label choice = new Label();
        Label choiceOne = new Label();
        Label choiceTwo = new Label();
        Label choiceThree = new Label();

        // text
        bag.setText("You may carry one item :");
        choice.setText("What is your choice?");
        choiceOne.setText("1 : Gas");
        choiceTwo.setText("2 : Food and Water");
        choiceThree.setText("3 : Medical Supplies");

        // styles text
        game.styleText(bag, 150);
        game.styleText(choiceOne, 250);
        choiceOne.setTranslateX(-115);
        game.styleText(choiceTwo, 350);
        game.styleText(choiceThree, 450);
        game.styleText(choice, 600);

        // input textfield
        TextField textField = new TextField();
        TextField option = game.limitText(textField);
        option.setMaxSize(100, 10);
        option.setTranslateY(700);

        box4.getChildren().addAll(game.image("\\images\\border2.png", 800, 100), bag, choice);
        box4.getChildren().addAll(choiceOne, choiceTwo, choiceThree, option);
        Scene optionOneScene = new Scene(box4, 1000, 800);
        return optionOneScene;
    }

    public Scene endGas() { // gas ending for option 1

        StackPane box5 = new StackPane();
        game.basicPane(box5);

        // labels
        Label car = new Label();
        Label gasUse = new Label();
        Label start = new Label();
        Label explode = new Label();
        Label death = new Label();

        // text
        car.setText("You approach an abanndoned car");
        gasUse.setText("You pour gas into the car");
        start.setText("You find the keys and start the car");
        explode.setText("Something went wrong... the car explodes");
        death.setText("you have died");

        // styles text
        game.styleText(car, 100);
        game.styleText(gasUse, 200);
        game.styleText(start, 300);
        game.styleText(explode, 400);
        game.styleText(death, 500);

        //IMPORTANT ADD RESTART BUTTON WHEN POSSIBLE
        box5.getChildren().add(game.image("\\images\\cargas.gif", 1000, 800));
        box5.getChildren().addAll(car, gasUse, start, explode, death);

        Scene endGasScene = new Scene(box5, 1000, 800);
        return endGasScene;

    }

    public Scene endMedOne() { // medkit part 1 ending for option 1 
        StackPane box6 = new StackPane();
        game.basicPane(box6);

        //labels
        Label travel = new Label();
        Label noFood = new Label();

        //text
        travel.setText("You hike for days... nothing but mountains in sight");
        noFood.setText("You have used up all your food and water");

        //styles text
        game.styleText(travel, 400);
        game.styleText(noFood, 500);

        
        box6.getChildren().add(game.image("\\images\\mountain.png", 1000, 300));
        box6.getChildren().addAll(travel, noFood, game.spaceText(700));

        Scene medOneScene = new Scene(box6, 1000, 800);
        return medOneScene; 


    }

    public Scene endMedTwo(){ //medkit ending part 2 for option 1
        StackPane box7 = new StackPane();
        game.basicPane(box7);
    
        //labels
        Label faint = new Label();
        Label eaten = new Label();
        Label scream = new Label();
        Label hunger = new Label();
        Label consume = new Label();

        //text
        faint.setText("You pass out due to malnutrion");
        eaten.setText("A sharp pain wakes you up");
        scream.setText("Your sister broke of her ropes ");
        hunger.setText("she is eating you");
        consume.setText("You have been consumed");
        //styles text
        game.styleText(faint, 325);
        game.styleText(eaten, 400);
        game.styleText(scream, 475);
        game.styleText(hunger, 550);
        game.styleText(consume, 625);
        //add restart button on 700

        box7.getChildren().add(game.image("\\images\\grave.png", 200, 300)); 
        box7.getChildren().addAll(faint, eaten, scream, hunger, consume);

        Scene medTwoScene = new Scene(box7, 1000, 800);
        return medTwoScene;

    }

    public Scene foodOption (){ // correct option to continue game
        StackPane box8 = new StackPane();
        game.basicPane(box8);

        //labels
        Label traveling = new Label();
        Label tired = new Label();
        Label eat = new Label();
        //text
        traveling.setText("You continue walking at a gruelling pace");
        tired.setText("You are exhausted and stop to rest ");
        eat.setText("You eat your food and begin walking again");
        //styles text
        game.styleText(traveling, 400);
        game.styleText(tired, 500);
        game.styleText(eat, 600);

        box8.getChildren().add(game.image("\\images\\camp.png", 1000, 300));
        box8.getChildren().addAll(traveling, tired, eat, game.spaceText(700));

        Scene foodOptionScene = new Scene(box8, 1000, 800);
     
        return foodOptionScene;  
    }

    public Scene storyTwoFour(){
        StackPane box9 = new StackPane();
        game.basicPane(box9);

        //labels
        Label daysPass = new Label();
        Label arrive = new Label();
        Label problem = new Label();
        Label cross = new Label();
        //text
        daysPass.setText("Couple of days pass");
        arrive.setText("You arrive at a river");
        problem.setText("The rivers stretches for miles");
        cross.setText("You prepare to cross the river");
        //styles text
        game.styleText(daysPass, 350);
        game.styleText(arrive, 425);
        game.styleText(problem, 500);
        game.styleText(cross, 575);

        box9.getChildren().add(game.image("\\images\\river.jpg", 1000, 300));
        box9.getChildren().addAll(daysPass, arrive, problem, cross, game.spaceText(700));

        Scene sceneFour = new Scene(box9, 1000, 800);
        return sceneFour; 

    }

}


