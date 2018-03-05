package gameproject;

import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Font;

public class SceneMaker
{

  static double windowWidth = 1000,
                windowHeight = 600;
  static Group groupMain = new Group(), groupGame = new Group(), groupModeChooser = new Group(), groupOptions = new Group();
  public static Scene sceneMain = new Scene(groupMain, windowWidth, windowHeight),
  sceneGame = new Scene(groupGame, windowWidth, windowHeight),
  sceneModeChooser = new Scene(groupModeChooser, windowWidth, windowHeight),
  sceneOptions = new Scene(groupOptions, windowWidth, windowHeight);
  Font gameFont = Font.loadFont(getClass().getResourceAsStream("/Fonts/PressStart2P-Regular.ttf"), 24);
  static Stage stage = GameProject.stageMain;
  double speed = 10;
  static GameController gc;
  static PlayerController pC;
  static Menu pauseMenu;
  static NPCManager npcM = new NPCManager();



  static void setUpSceneMain()
  {

  }

  static void setUpSceneGame()
  {
    ImageView iV = new ImageView(new Image("background.png"));
    iV.setScaleX(2);
    iV.setScaleY(2);
    iV.setX(250);
    iV.setY(150);
    gc = new GameController(groupGame);
    groupGame.getChildren().add(iV);
  }

  static void setUpSceneModeChooser()
  {

  }

  static void setUpSceneOptions()
  {

  }

  static void enterSceneMain()
  {
    stage.setScene(sceneMain);
  }

  static void enterSceneGame()
  {
    pC = new PlayerController(sceneGame);
    new GameModePicker("localMultiplayer");
    pC.setControls();
    stage.setScene(sceneGame);
  }

  static void enterSceneModeChooser()
  {
    stage.setScene(sceneModeChooser);
  }

  static void enterSceneOptions()
  {
    stage.setScene(sceneOptions);
  }
}
