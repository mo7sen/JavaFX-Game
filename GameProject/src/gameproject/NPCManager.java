package gameproject;

import java.util.ArrayList;
import javafx.scene.image.Image;

public class NPCManager 
{
    ArrayList<Enemy> enemies = new ArrayList<Enemy>();
    double offsetY = 15;
    public void spawn()
    {
        double posY = Player.supportedY[(int) (Math.random()*4)] + offsetY;
        double posX = GameProject.windowWidth + 50;
        new Enemy(new Image("blob.png"), posX, posY, GameProject.root,2).animate();
    }
}
