import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;

public class End extends GameScene {
    public int finalDays = 20;
    public int finalKilometers = 199;
    public String finalDate = "November 30";



    public Scene endOne(){

        StackPane box1 = new StackPane();
        basicPane(box1);
        //labels + text
        Label time = new Label("Calm and full, you finally take a second to look at your sister");
        Label skin = new Label("Her skin has turned green and she has lost all her hair");
        Label notice = new Label("You realize shes running out of time and decide to pick up the pace");
        Label reach = new Label("You can see the city lights, but its still miles away");

        //styles text
        styleText(time, 350);
        styleText(skin, 450);
        styleText(notice, 550);
        styleText(reach, 650);
        smallFont(time);
        smallFont(skin);
        smallFont(notice);
        smallFont(reach);

        ImageView girl  = image("\\images\\shootgirl.gif", 100, 150);
        ImageView zomb = image("\\images\\zombrun.gif", 100, 150);

        girl.setTranslateY(200);
        zomb.setTranslateY(200);
        zomb.setTranslateX(-200);

        box1.getChildren().addAll(image("\\images\\citydist.png", 1000, 300), girl, zomb);
        box1.getChildren().addAll(time, skin, notice, reach, spaceText(700));
        Scene sceneOne = new Scene(box1, 1000, 800);
        return sceneOne;
    }

    public Scene endStats() { // move all the way to the end when reached the end

        StackPane box1 = new StackPane();
        basicPane(box1);
        // labels
        Label stats = new Label();
        Label day = new Label();
        Label mile = new Label();
        Label date = new Label();
        // text
        stats.setText("Stats");
        day.setText(" days survived : 20");
        mile.setText("kilometers walked : 199");
        date.setText("Date : November 30th");
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


}