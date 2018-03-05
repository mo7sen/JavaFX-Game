package gameproject;

import java.util.ArrayList;
import javafx.animation.AnimationTimer;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;

public class GameController
{
    Group root;
    static boolean paused = false;
    ArrayList<AnimationTimer> animators = new ArrayList<AnimationTimer>();
    public GameController(Group root)
    {
        this.root = root;
        ImageView iV = new ImageView(new Image("background.png"));
        iV.setScaleX(2);
        iV.setScaleY(2);
        iV.setX(250);
        iV.setY(150);

        this.root.getChildren().add(iV);
    }

    public void endGame(int i)
    {
        pause();
        if( i == 1 )
        {
            playerOneWon();
           SceneMaker.pC.destroy();
        }
        else if( i == 2 )
        {
            playerTwoWon();
            SceneMaker.pC.destroy();
        }
    }

    public void pause()
    {
        animators.forEach((anim) -> {
            anim.stop();
        });
        paused = true;
    }

    public void resume()
    {
        animators.forEach((anim) -> {
            anim.start();
            System.out.println(anim);
        });
        paused = false;
    }

    public void playerOneWon()
    {

    }

    public void playerTwoWon()
    {

    }

    public void reset()
    {
        for(Enemy e:SceneMaker.npcM.enemies)
        {
          e.setImage(null);
          e.bound.destroy();
          e.enemyMoving.stop();
          e = null;
        }

        for(Projectiles p:Projectiles.shots)
        {
          p.setImage(null);
          p.bound.destroy();
          p.shot.stop();
          p = null;
        }

        SceneMaker.npcM.enemies.clear();
        Projectiles.shots.clear();
        resume();
        SceneMaker.pC.setControls();
        if(CharacterPicker.player1 != null)
          {
            CharacterPicker.player1.setY(Player.supportedY[1]);
            CharacterPicker.player1.yy = Player.supportedY[1];
            CharacterPicker.player1.health = 5;
            CharacterPicker.player1.damageTaken();
          }
        if(CharacterPicker.player2 != null)
        {
          CharacterPicker.player2.setY(Player.supportedY[1]);
          CharacterPicker.player2.yy = Player.supportedY[1];
          CharacterPicker.player2.health = 5;
          CharacterPicker.player2.damageTaken();
        }

    }
}
