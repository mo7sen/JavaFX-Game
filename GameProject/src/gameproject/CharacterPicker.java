package gameproject;

import javafx.scene.Group;
import javafx.scene.image.Image;

public class CharacterPicker {
    public static Player player1 = null;
    public static Player player2 = null;
    
    
    public CharacterPicker(Group root, double windowWidth, double windowHeight, String identity, int direction, PlayerController pC)
    {
        Image staticImage = (identity.equals("red"))?new Image("sorcererRed.png"):new Image("sorcerer.png");
        String animatedImage = (identity.equals("red"))? "sorcererRed.gif":"sorcererGIF.gif";
        Image projectileImage = (identity.equals("red"))? new Image("fireballRed.png"):new Image("fireball.png");
        
        double posY = windowHeight/2 - 30;
        double posX = (direction > 0)? 30: windowWidth - staticImage.getWidth() - 30;
        double scale = 2;
        
        if(direction == 1)
        {
            player1 = new Player(staticImage, animatedImage, projectileImage, posX, posY, root, direction, scale, windowWidth);
            pC.setPlayerOne(player1);
        }
        else
        {
            player2 = new Player(staticImage, animatedImage, projectileImage, posX, posY, root, direction, scale, windowWidth);
            pC.setPlayerTwo(player2);
        }
    }
}