import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.util.Duration;

public class RouteTwo extends GameScene {

    public int days = 5;
    public int miles = 5;
    public String date = "December 1st"; // change date to match jelenas

    private Group daysPass;

    GameScene game = new GameScene();

    public Scene storyTwoOne() {
        VBox box1 = new VBox();
        Label stats = new Label();
        Label day = new Label();
        Label mile = new Label();

        stats.setText("Stats");
        day.setText(" days survived : 5");
        mile.setText("miles walked : 5");

        game.basic(box1);
        game.styleText(stats, 0);
        game.title(stats);
        game.styleText(day, 200);
        game.styleText(mile, 300);
        box1.getChildren().addAll(game.spaceText(700), stats, day, mile);

        Scene sceneOne = new Scene(box1, 1000, 800);
        return sceneOne;
    }

    public Scene storyTwoTwo() {

        VBox box2 = new VBox();
        game.basic(box2);

        // labels
        Label travel = new Label();
        Label food = new Label();
        Label gas = new Label();

        // text
        travel.setText("Couple days pass");
        food.setText("70% of rations have been depleted");
        gas.setText("You have come across a gas station");

        // styles text
        game.styleText(travel, -50);
        game.styleText(food, 50);
        game.styleText(gas, 100);

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
                Duration.millis(1400),
                (ActionEvent event) -> {
                    daysPass.getChildren().setAll(sun);
                }));

        t.play();

        box2.getChildren().addAll(daysPass, game.spaceText(400), travel, food, gas);
        Scene sceneTwo = new Scene(box2, 1000, 800);
        return sceneTwo;
    }

}
