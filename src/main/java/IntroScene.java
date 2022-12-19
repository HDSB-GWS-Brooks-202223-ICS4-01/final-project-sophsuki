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

        Label inTwo1 = new Label();
        Label inTwo2 = new Label();
        Label inTwo3 = new Label();
        Label inTwo4 = new Label();

        inTwo1.setText("It's November 10th, we've been in the apocalypse for 3 years now.");
        inTwo2.setText("An evil scientists released the zombie plague which infected over half the city.");
        inTwo3.setText("My sister and I barely survived the first year before she started getting rebellious.");
        inTwo4.setText("One day she went out into the city on our own and got bit...");

        basicPane(sp1);
        styleText(inTwo1, 350);
        styleText(inTwo2, 390);
        styleText(inTwo3, 430);
        styleText(inTwo4, 470);
        smallFont(inTwo1);
        smallFont(inTwo2);
        smallFont(inTwo3);
        smallFont(inTwo4);

        sp1.getChildren().add(image("\\images\\city.gif", 1000, 300));
        sp1.getChildren().addAll(inTwo1, inTwo2, inTwo3, inTwo4);

        //      FOR TIMER 
        // sp1.getChildren().add(inTwo1);
        // sp1.getChildren().add(inTwo2);
        // sp1.getChildren().add(inTwo2);
        // sp1.getChildren().add(inTwo3);
        // sp1.getChildren().add(inTwo5);

        Scene scene1 = new Scene(sp1, 1000, 800);

        return scene1;

    }

    public Scene introTwo() {
        StackPane sp2 = new StackPane();
        Scene scene = new Scene(sp2, 1000, 800);

        basicPane(sp2);
        
        Label inTwo1 = new Label();
        Label inTwo2 = new Label();
        Label inTwo3 = new Label();
        Label inTwo4 = new Label();

        inTwo1.setText("I went out that night and spent the whole day looking for her.");
        inTwo2.setText("When it hit 12 in the morning, I began to make my way back home when suddenly...");
        inTwo3.setText("I found her!");
        //long pause
        inTwo4.setText("and she was a zombie...");

        basicPane(sp2);
        styleText(inTwo1, 350);
        styleText(inTwo2, 390);
        styleText(inTwo3, 430);
        styleText(inTwo4, 470);
        smallFont(inTwo1);
        smallFont(inTwo2);
        smallFont(inTwo3);
        smallFont(inTwo4);

        sp2.getChildren().add(image("\\images\\red city.gif", 1000, 300));
        sp2.getChildren().add(inTwo1);
        sp2.getChildren().add(inTwo2);
        sp2.getChildren().add(inTwo3);
        //LONG PAUSE
        sp2.getChildren().add(image("\\images\\zombie sister.png", 400, 300));
        sp2.getChildren().add(inTwo4);

        return scene;
    }

    public Scene introThree() {

        StackPane sp3 = new StackPane(); 
        Scene scene = new Scene(sp3, 1000, 800);

        Label inThree1 = new Label();
        Label inThree2 = new Label();
        Label inThree3 = new Label();
        Label inThree4 = new Label();
        Label inThree5 = new Label(); 

        inThree1.setText("Today, during my daily task of trying to fix the radio,");
        inThree2.setText("I finally managed to get a connection!");
        inThree3.setText("I heard static and then...");
        inThree4.setText("'...come to the safe haven...the stars will lead the way...'");
        inThree5.setText("So we started to pack our bags.");

        basicPane(sp3);
        styleText(inThree1, 350);
        styleText(inThree2, 390);
        styleText(inThree3, 430);
        styleText(inThree4, 470);
        styleText(inThree5, 510);
        smallFont(inThree1);
        smallFont(inThree2);
        smallFont(inThree3);
        smallFont(inThree4);
        smallFont(inThree5); 

        sp3.getChildren().add(image("\\images\\radio.jpg", 1000, 300));
        sp3.getChildren().addAll(inThree1, inThree2, inThree3, inThree4, inThree5);

        return scene;
    }

    public Scene introFourChoice1() {
        StackPane sp4 = new StackPane(); 
        Scene scene = new Scene(sp4, 1000, 800);

        Label title1 = new Label(); 
        Label title2 = new Label();
        Label c1 = new Label(); 
        Label c2 = new Label();
        Label c3 = new Label(); 

        title1.setText("You can only fit one");
        title2.setText("more item in you inventory:");
        c1.setText("1. Med kit");
        c2.setText("2. Gas");
        c3.setText("3. Extra Water");

        basicPane(sp4);
        styleText(title1, 100);
        styleText(title2, 150);
        styleText(c1, 300);
        styleText(c2, 400);
        styleText(c3, 500);
        bigFont(title1);
        bigFont(title2);
        bigFont(c1);
        bigFont(c2);
        bigFont(c3);

        sp4.getChildren().addAll(title1, title2, c1, c2, c3);

        return scene;
    }
}
