import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
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

    //public textField
    public TextField textFieldOne = new TextField();
    public TextField textFieldTwo = new TextField();

    //public buttons
    public Button restartOne = new Button();
    public Button restartTwo = new Button();
    public Button restartThree = new Button();
    public Button restartFour = new Button();
   
    DemonTrail trail = new DemonTrail();
    public Scene storyTwoOne() {

        StackPane box1 = new StackPane();
        basicPane(box1);
        // labels
        Label stats = new Label();
        Label day = new Label();
        Label mile = new Label();
        Label date = new Label();
        // text
        stats.setText("Stats");
        day.setText(" days survived : 5");
        mile.setText("kilometers walked : 51");
        date.setText("Date : November 15th");
        // styles text
       styleText(stats, 100);
        title(stats);
        styleText(day, 300);
        styleText(mile, 400);
        styleText(date, 500);

        box1.getChildren().addAll(spaceText(700), stats, day, mile, date);
        Scene sceneOne = new Scene(box1, 1000, 800);
        return sceneOne;
    }

    public Scene storyTwoTwo() {

        StackPane box2 = new StackPane();
        basicPane(box2);
        // labels
        Label travel = new Label();
        Label food = new Label();
        Label gas = new Label();
        // text
        travel.setText("Couple of days pass");
        food.setText("70% of rations have been depleted");
        gas.setText("Luckily you see a gas station in the distance");
        // styles text
        styleText(travel, 350);
        styleText(food, 450);
        styleText(gas, 550);
        // load images
        ImageView sun = image("\\images\\day.gif", 1000, 300);
        ImageView moon = image("\\images\\night.gif", 1000, 300);
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

        box2.getChildren().addAll(daysPass, spaceText(700), travel, food, gas);
        Scene sceneTwo = new Scene(box2, 1000, 800);
        return sceneTwo;
    }

    public Scene storyTwoThree() {

        StackPane box3 = new StackPane();
        basicPane(box3);
        // label
        Label gasStation = new Label();
        // text + styles text
        gasStation.setText("you arrive at the gas station");
        styleText(gasStation, 390);
        // loading image and moving it
        ImageView border = image("\\images\\border.png", 615, 100);
        border.setTranslateY(370);

        box3.getChildren().add(image("\\images\\station.gif", 1000, 800));
        box3.getChildren().addAll(border, gasStation, spaceText(700));
        Scene sceneThree = new Scene(box3, 1000, 800);
        return sceneThree;
    }

    public Scene optionTwoOne() {

        StackPane box4 = new StackPane();
        basicPane(box4);
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
        styleText(bag, 150);
        styleText(choiceOne, 250);
        choiceOne.setTranslateX(-115);
        styleText(choiceTwo, 350);
        styleText(choiceThree, 450);
        styleText(choice, 600);
        // input textfield
        TextField optionOne = limitText(textFieldOne);
        

        box4.getChildren().add(image("\\images\\border2.png", 800, 100));
        box4.getChildren().addAll(bag, choice, choiceOne, choiceTwo, choiceThree, optionOne);
        Scene optionOneScene = new Scene(box4, 1000, 800);
        return optionOneScene;
    }

    public Scene endGas() { // gas ending for option 1

        StackPane box5 = new StackPane();
        basicPane(box5);
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
        styleText(car, 100);
        styleText(gasUse, 200);
        styleText(start, 300);
        styleText(explode, 400);
        styleText(death, 500);

        box5.getChildren().add(image("\\images\\cargas.gif", 1000, 800));
        box5.getChildren().addAll(car, gasUse, start, explode, death, restart(restartOne));

        Scene endGasScene = new Scene(box5, 1000, 800);
        return endGasScene;

    }

    public Scene endMedOne() { // medkit part 1 ending for option 1
        StackPane box6 = new StackPane();
        basicPane(box6);
        // labels
        Label travel = new Label();
        Label noFood = new Label();
        // text
        travel.setText("You hike for days... nothing but mountains in sight");
        noFood.setText("You have used up all your food and water");
        // styles text
        styleText(travel, 400);
        styleText(noFood, 500);

        box6.getChildren().add(image("\\images\\mountain.png", 1000, 300));
        box6.getChildren().addAll(travel, noFood, spaceText(700));

        Scene medOneScene = new Scene(box6, 1000, 800);
        return medOneScene;

    }

    public Scene endMedTwo() { // medkit ending part 2 for option 1

        StackPane box7 = new StackPane();
        basicPane(box7);
        // labels
        Label faint = new Label();
        Label eaten = new Label();
        Label scream = new Label();
        Label hunger = new Label();
        Label consume = new Label();
        // text
        faint.setText("You pass out due to malnutrion");
        eaten.setText("Suddenly a sharp pain wakes you up");
        scream.setText("Your sister broke free of her ropes ");
        hunger.setText("she is eating you");
        consume.setText("You have been consumed");
        // styles text
        styleText(faint, 325);
        styleText(eaten, 400);
        styleText(scream, 475);
        styleText(hunger, 550);
        styleText(consume, 625);

        box7.getChildren().add(image("\\images\\grave.png", 200, 300));
        box7.getChildren().addAll(faint, eaten, scream, hunger, consume, restart(restartTwo));

        Scene medTwoScene = new Scene(box7, 1000, 800);
        return medTwoScene;

    }

    public Scene foodOption() { // correct option to continue game

        StackPane box8 = new StackPane();
        basicPane(box8);
        // labels
        Label traveling = new Label();
        Label tired = new Label();
        Label eat = new Label();
        // text
        traveling.setText("You continue walking at a gruelling pace");
        tired.setText("You are exhausted and stop to rest ");
        eat.setText("You eat your food and begin walking again");
        // styles text
        styleText(traveling, 400);
        styleText(tired, 500);
        styleText(eat, 600);

        box8.getChildren().add(image("\\images\\camp.png", 1000, 300));
        box8.getChildren().addAll(traveling, tired, eat, spaceText(700));

        Scene foodOptionScene = new Scene(box8, 1000, 800);

        return foodOptionScene;
    }

    public Scene storyTwoFour() {

        StackPane box9 = new StackPane();
        basicPane(box9);
        // labels
        Label daysPass = new Label();
        Label arrive = new Label();
        Label problem = new Label();
        Label cross = new Label();
        // text
        daysPass.setText("Couple of days pass");
        arrive.setText("You arrive at a river");
        problem.setText("The river stretches for miles");
        cross.setText("You must cross the river quickly");
        // styles text
        styleText(daysPass, 350);
        styleText(arrive, 425);
        styleText(problem, 500);
        styleText(cross, 575);

        box9.getChildren().add(image("\\images\\river.jpg", 1000, 300));
        box9.getChildren().addAll(daysPass, arrive, problem, cross, spaceText(700));

        Scene sceneFour = new Scene(box9, 1000, 800);
        return sceneFour;

    }

    public Scene optionTwoTwo() {

        StackPane box10 = new StackPane();
        basicPane(box10);
        // labels
        Label swim = new Label();
        Label choice = new Label();
        Label choiceOne = new Label();
        Label choiceTwo = new Label();
        Label choiceThree = new Label();
        // text
        swim.setText("How will you cross?");
        choice.setText("What is your choice?");
        choiceOne.setText("1 : Swim across it");
        choiceTwo.setText("2 : Travel around it");
        choiceThree.setText("3 : Tightrope walk across");
        // styles text
        styleText(swim, 150);
        styleText(choiceOne, 250);
        choiceOne.setTranslateX(-70);
        styleText(choiceTwo, 350);
        choiceTwo.setTranslateX(-55);
        styleText(choiceThree, 450);
        styleText(choice, 600);
        choice.setTranslateX(-40);
        // input textfield
        TextField option = limitText(textFieldTwo);
        option.setMaxSize(100, 10);
        option.setTranslateY(700);

        box10.getChildren().add(image("\\images\\border2.png", 800, 100));
        box10.getChildren().addAll(swim, choice, choiceOne, choiceTwo, choiceThree, option);
        Scene optionTwoScene = new Scene(box10, 1000, 800);
        return optionTwoScene;
    }

    public Scene endTravel() {
        StackPane box11 = new StackPane();
        basicPane(box11);

        // labels
        Label traveling = new Label();
        Label risky = new Label();
        Label slip = new Label();
        Label head = new Label();
        Label dead = new Label();
        // text
        traveling.setText("You take a detour through the mountains");
        risky.setText("The path is dangerous and long");
        slip.setText("You are half way across when you slip on a rock");
        head.setText("you fall from 50 feet and hit your head");
        dead.setText("You have died");
        // styles text
        styleText(traveling, 350);
        styleText(risky, 425);
        styleText(slip, 500);
        styleText(head, 575);
        styleText(dead, 650);

        box11.getChildren().add(image("\\images\\bodyoutline.png", 1000, 300));
        box11.getChildren().addAll(traveling, risky, slip, head, dead, restart(restartThree));

        Scene travelOptionScene = new Scene(box11, 1000, 800);
        return travelOptionScene;
    }

    public Scene endRope() { // correct option to continue game

        StackPane box12 = new StackPane();
        basicPane(box12);
        // labels
        Label toss = new Label();
        Label tree = new Label();
        Label walk = new Label();
        Label fall = new Label();
        Label drown = new Label();
        Label zomb = new Label();
        // text
        toss.setText("You make a loop with the rope and throw it across on a tree");
        tree.setText("You check if it is secure and tie it to another tree");
        walk.setText("You begin walking the tight rope");
        fall.setText("You lose your balance and fall into the river");
        drown.setText("Your sister distraught from the water, scratches you");
        zomb.setText("You give up and drown as you will turn into a zombie soon");
        // styles text
        styleText(toss, 320);
        styleText(tree, 380);
        styleText(walk, 440);
        styleText(fall, 500);
        styleText(drown, 560);
        styleText(zomb, 620);
        smallFont(toss);
        smallFont(tree);
        smallFont(walk);
        smallFont(fall);
        smallFont(drown);
        smallFont(zomb);

        box12.getChildren().add(image("\\images\\drowning.jpg", 1000, 300));
        box12.getChildren().addAll(toss, tree, walk, fall, drown, zomb, restart(restartFour));

        Scene ropeOptionScene = new Scene(box12, 1000, 800);
        return ropeOptionScene;
    }

    public Scene swimOption() {
        StackPane box13 = new StackPane();
        basicPane(box13);
        // labels
        Label safety = new Label();
        Label tie = new Label();
        Label swim = new Label();
        Label river = new Label();
        // text
        safety.setText("You blindfold and cover your sisters mouth");
        tie.setText("You tie her body with yours and begin swimming");
        swim.setText("Progress is slow but steady");
        river.setText("You make it safely across the river");
        // styles text
        styleText(safety, 350);
        styleText(tie, 425);
        styleText(swim, 500);
        styleText(river, 575);

        box13.getChildren().add(image("\\images\\deepriver.jpg", 1000, 300));
        box13.getChildren().addAll(safety, tie, swim, river, spaceText(700));

        Scene swimOptionScene = new Scene(box13, 1000, 800);
        return swimOptionScene;
    }

}
