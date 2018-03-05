package gameproject;

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
        this.root = SceneMaker.groupGame;
        this.stage = GameProject.stageMain;
        this.windowWidth = SceneMaker.windowWidth;
        this.windowHeight = SceneMaker.windowHeight;

        if(gameMode.equals("singlePlayer"))
            singlePlayer();
        else if(gameMode.equals("localMultiplayer"))
            localMulti();
    }

    public void singlePlayer()
    {
        new CharacterPicker(root, windowWidth, windowHeight, "blue", 1, SceneMaker.pC);
        spawner = new AnimationTimer() {
            @Override
            public void handle(long now) {

                if(System.currentTimeMillis()>lastSpawn + spawnRate)
                {
                    lastSpawn = System.currentTimeMillis();
                    SceneMaker.npcM.spawn();
                }
            }
        };
        spawner.start();
        SceneMaker.gc.animators.add(spawner);


    }

    public void localMulti()
    {
        new CharacterPicker(root, windowWidth, windowHeight, "blue", 1, SceneMaker.pC);
        new CharacterPicker(root, windowWidth, windowHeight, "red", -1, SceneMaker.pC);
    }
}
