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
    StackPane stackPane = new StackPane();
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
            GameProject.pC.destroy();
        }
        else if( i == 2 )
        {
            playerTwoWon();
            GameProject.pC.destroy();
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
        stackPane.getChildren().add(new ImageView(new Image("fireballRed.png")));
    }
    
    public void playerTwoWon()
    {
        stackPane.getChildren().add(new ImageView(new Image("fireball.png")));
    }
}
