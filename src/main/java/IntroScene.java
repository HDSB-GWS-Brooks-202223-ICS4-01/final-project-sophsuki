import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class IntroScene extends GameScene {

    GameScene game = new GameScene(); 
    // public Timer timer = new Timer(); 

    //initial scene
    public Scene introOne() {
        VBox v1 = new VBox(); 

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
        //monologue5.setText("");
        
        game.basic(v1);
        game.styleText(monologue1, 80);
        game.styleText(monologue2, 100);
        game.styleText(monologue3, 120);
        game.styleText(monologue4,140);
        game.smallFont(monologue1);
        game.smallFont(monologue2);
        game.smallFont(monologue3);
        game.smallFont(monologue4);

        v1.getChildren().add(game.image("\\images\\city.gif", 1000, 300));
        v1.getChildren().addAll(monologue1, monologue2, monologue3, monologue4);

        // v1.getChildren().add(monologue1);
        // v1.getChildren().add(monologue2);
        // v1.getChildren().add(monologue2);
        // v1.getChildren().add(monologue3);
        //v1.getChildren().add(monologue5);


        Scene scene1 = new Scene(v1, 1000, 800);

        return scene1;

    } 

    // public Scene introTwo() {
    //     VBox v2 = new VBox(); 

        

    //     Scene scene = new Scene(v2, 1000, 800);
    //     return scene; 

    //     game.styleText(introText, 0);

    //     introText.setText("It's Novemeber 10th, we've been in the apocalypse for 3 years now");

    //     v.getChildren().add(game.image("\\images\\city.gif", 1000, 300));
    //     v.getChildren().addAll(game.spaceText(400), introText);

    //     Scene scene = new Scene(v, 1000, 800);

    //     return scene;
    // } 
    
}
