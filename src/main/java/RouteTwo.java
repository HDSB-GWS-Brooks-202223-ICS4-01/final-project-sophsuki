import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class RouteTwo extends GameScene {

    public int days = 5;
    public int miles = 5;
    public String date = "December 1st";

    GameScene game = new GameScene();

    public Scene storyTwoOne() {
        VBox box = new VBox();
        Label stats = new Label();
        Label day = new Label();
        Label mile = new Label();

        stats.setText("Stats");
        day.setText(" days survived : 5");
        mile.setText("miles walked : 5");

        game.basic(box);
        game.styleText(stats, 0, 0);
        game.title(stats);
        game.styleText(day, 0, 200);
        game.styleText(mile, 0, 300);
        box.getChildren().addAll(game.spaceText(700), stats, day, mile);

        Scene sceneOne = new Scene(box, 1000, 800);
        return sceneOne;
    }

    public Scene storyTwoTwo() {

        VBox box = new VBox();
        game.basic(box);

        Label travel = new Label();
        Label food = new Label();
        Label gas = new Label();

        travel.setText("Couple days pass");
        food.setText("70% of rations have been depleted");
        gas.setText("You have come across a gas station");

        game.styleText(travel, 0, -50);
        game.styleText(food, 0, 50);
        game.styleText(gas, 0, 100);

        box.getChildren().add(game.image("\\images\\day.gif", 1000, 300));
        box.getChildren().addAll(game.spaceText(400), travel, food, gas);
        Scene sceneTwo = new Scene(box, 1000, 800);
        return sceneTwo;
    }

}
