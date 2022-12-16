import java.util.Timer;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;

public class IntroScene extends GameScene {

    GameScene game = new GameScene();
    Timer timer = new Timer();

    // initial scene
    public Scene introOne() {
        StackPane sp1 = new StackPane();

        Label monologue1 = new Label();
        Label monologue2 = new Label();
        Label monologue3 = new Label();
        Label monologue4 = new Label();
        // Label monologue5 = new Label();
        // Label monologue6 = new Label();

        monologue1.setText("It's November 10th, we've been in the apocalypse for 3 years now.");
        monologue2.setText("An evil scientists released the zombie plague which infected over half the city.");
        monologue3.setText("My sister and I barely survived the first year before she started getting rebellious.");
        monologue4.setText("One day she went out into the city on our own and got bit...");
        // monologue5.setText("");

        game.basicPane(sp1);
        game.styleText(monologue1, 350);
        game.styleText(monologue2, 390);
        game.styleText(monologue3, 430);
        game.styleText(monologue4, 470);
        game.smallFont(monologue1);
        game.smallFont(monologue2);
        game.smallFont(monologue3);
        game.smallFont(monologue4);

        sp1.getChildren().add(game.image("\\images\\city.gif", 1000, 300));
        sp1.getChildren().addAll(monologue1, monologue2, monologue3, monologue4);

        // sp1.getChildren().add(monologue1);
        // sp1.getChildren().add(monologue2);
        // sp1.getChildren().add(monologue2);
        // sp1.getChildren().add(monologue3);
        // sp1.getChildren().add(monologue5);

        Scene scene1 = new Scene(sp1, 1000, 800);

        return scene1;

    }

    public Scene introTwo() {
        StackPane sp2 = new StackPane();

        game.basicPane(sp2);

        sp2.getChildren().add(game.image("\\images\\red city.gif", 1000, 300));

        Scene scene = new Scene(sp2, 1000, 800);
        return scene;

    }
}
