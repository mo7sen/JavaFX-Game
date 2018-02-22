package gameproject;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class GameProject extends Application {
    double speed = 10;
    double windowWidth = 1000,
            windowHeight = 600;
    PlayerController pC;
    @Override
    public void start(Stage primaryStage) {
        Group root = new Group();
        Scene scene = new Scene(root, windowWidth, windowHeight);
    	pC = new PlayerController(scene);
        new CharacterPicker(root, windowWidth, windowHeight, "red", 1, pC);
        new CharacterPicker(root, windowWidth, windowHeight, "blue", -1, pC);
        pC.setControls();
        
        primaryStage.setTitle("Game - in progress");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }   
}
