package gameproject;

import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Healthbar 
{
    ImageView healthBar = new ImageView();;
    double posY = 15;
    double posX, offsetX;
    String direction;
    Group root;
    public Healthbar(double posX, Group root, String direction)
    {
        this.root = root;
        this.direction = direction;
        this.posX = posX;
        healthBar.setScaleX(2);
        healthBar.setScaleY(2);
        if(direction.equals("left"))
            offsetX = 15;
        else
            offsetX = -45;
        healthBar.setX(posX + offsetX);
        healthBar.setY(posY);
        root.getChildren().add(healthBar);
    }
    public void updateHealth(int health)
    {
        if(health == 0)
            healthBar.setImage(new Image("Health/0.png"));
        else
            healthBar.setImage(new Image("Health/" + health + direction + ".png"));
        
    }
}
