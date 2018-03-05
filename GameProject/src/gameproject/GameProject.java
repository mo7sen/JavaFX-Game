package gameproject;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class GameProject extends Application
{
  public static Stage stageMain;

    @Override
    public void start(Stage primaryStage)
    {
        stageMain = primaryStage;
      //  root = new Group();


      //  pauseMenu = new Menu("PauseMenu", root,windowWidth, windowHeight);
      SceneMaker.setUpSceneGame();
      SceneMaker.enterSceneGame();

        //
        // GameProject.gc.resume();
        primaryStage.setTitle("Game - in progress");
        primaryStage.show();
    }

    public static void main(String[] args)
    {
        launch(args);
    }

    
}
