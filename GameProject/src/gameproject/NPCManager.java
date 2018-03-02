package gameproject;

import java.util.ArrayList;
import javafx.scene.image.Image;

public class NPCManager 
{
    ArrayList<Enemy> enemies = new ArrayList<Enemy>();
    
    public void spawn()
    {
        double posY = Player.supportedY[(int) (Math.random()*4)];
        double posX = GameProject.windowWidth + 50;
        new Enemy(new Image("sorcerer.png"), posX, posY, GameProject.root).animate();
    }
}
