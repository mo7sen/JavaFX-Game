package gameproject;

import static gameproject.GameProject.root;
import javafx.animation.AnimationTimer;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class GameModePicker 
{
    Group root;
    Scene scene;
    Stage stage;
    double windowWidth, windowHeight;
    AnimationTimer spawner;
    long lastSpawn, spawnRate = 800;
    
    public GameModePicker(String gameMode)
    {
        this.scene = GameProject.scene;
        this.root = GameProject.root;
        this.stage = GameProject.stage;
        this.windowWidth = GameProject.windowWidth;
        this.windowHeight = GameProject.windowHeight;
        
        if(gameMode.equals("singlePlayer"))
            singlePlayer();
        else if(gameMode.equals("localMultiplayer"))
            localMulti();
    }
    
    public void singlePlayer()
    {
        new CharacterPicker(root, windowWidth, windowHeight, "blue", 1, GameProject.pC);
        spawner = new AnimationTimer() {
            @Override
            public void handle(long now) {
                
                if(System.currentTimeMillis()>lastSpawn + spawnRate)
                {
                    lastSpawn = System.currentTimeMillis();
                    GameProject.npcM.spawn();
                }
            }
        };
        spawner.start();
        GameProject.gc.animators.add(spawner);
        
        
    }
    
    public void localMulti()
    {
        new CharacterPicker(root, windowWidth, windowHeight, "blue", 1, GameProject.pC);
        new CharacterPicker(root, windowWidth, windowHeight, "red", -1, GameProject.pC);
    }
}
