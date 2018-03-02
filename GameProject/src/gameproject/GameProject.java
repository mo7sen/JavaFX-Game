package gameproject;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class GameProject extends Application 
{
    double speed = 10;
    static double windowWidth = 1000,
            windowHeight = 600;
    
    static Stage stage;
    
    static GameController gc;
    static PlayerController pC;
    static Menu pauseMenu;
    static NPCManager npcM;
    static Scene scene;
    static Group root;
    
    @Override
    public void start(Stage primaryStage) 
    {
        stage = primaryStage;
        root = new Group();
        npcM = new NPCManager();
        gc = new GameController(root);
        scene = new Scene(root, windowWidth, windowHeight);
    	pC = new PlayerController(scene);
        new GameModePicker("singlePlayer");
        pC.setControls();
        
        pauseMenu = new Menu("PauseMenu", root,windowWidth, windowHeight);
        
        stage = primaryStage;
        
        GameProject.gc.resume();
        primaryStage.setTitle("Game - in progress");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) 
    {
        launch(args);
    }
    
    public void reset()
    {
        start(stage);
    }
}
