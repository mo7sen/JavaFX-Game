/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameproject;

import javafx.animation.AnimationTimer;
import javafx.scene.Group;
import javafx.scene.image.Image;

/**
 *
 * @author Robear
 */
public class Projectiles extends ObjectImage{
    double offsetX, offsetY, speedX, speedY;
    int directionX, directionY;
    public Projectiles(Image image, double posX, double posY, int directionX, int directionY, double offsetX, double offsetY, double speedX, double speedY, Group root) 
    {
        super(image, posX, posY, root);
        this.offsetX = offsetX;
        this.offsetY = offsetY;
        this.directionX = directionX;
        this.directionY = directionY;
        this.speedX = speedX;
        this.speedY = speedY;
        this.animate();
    }
    
    void animate()
    {
        new AnimationTimer() {
            @Override
            public void handle(long now) 
            {
                Projectiles.this.changeX(directionX * speedX);
                Projectiles.this.changeY(directionY * speedY);
            }
        }.start();
        
    }
}
