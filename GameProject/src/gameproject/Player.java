/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameproject;

import javafx.scene.Group;
import javafx.scene.image.Image;

/**
 *
 * @author Robear
 */
public class Player extends ObjectImage
{
    int health = 4;
    String actionGif;
    Group root;
    
    public Player(Image image, double posX, double posY, Group root) 
    {
        super(image, posX, posY, root);
        this.root = root;
    }
    
    public boolean isDead()
    {
        return (health == 0);
    }
    
    public void setActionImage(String action)
    {
        actionGif = action;
    }
    
    public void act()
    {
        this.setImage(new Image(actionGif));
        Projectiles fireball = new Projectiles(new Image("fireball.png"), xx, yy, 1, 0, 30, 15, 10, 0, root);
        fireball.setScaleX(2);
        fireball.setScaleY(2);
    }
    
}
