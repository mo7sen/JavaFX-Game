/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameproject;

import javafx.animation.AnimationTimer;
import javafx.geometry.BoundingBox;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 *
 * @author Robear
 */
public class Player extends ObjectImage
{
    AnimationTimer movingUp, movingDown;
    int health = 4;
    String actionGif;
    double initialY,
            initialX,
            posChange = 100,
            windowWidth,
            windowHeight,
            shiftSpeed = 10;
    double[] supportedY = new double[5];
    double fireRate = 0.33; // delay in seconds
    long lastFired = 0,
    fireDelay = (long)(fireRate * 1000000000); // converting the delay to nanoseconds
    Group root;
    
    public Player(Image image, double posX, double posY, Group root, double windowWidth, double windowHeight) 
    {
        super(image, posX, posY, root);
        
        this.windowWidth = windowWidth;
        this.windowHeight = windowHeight;
        this.root = root;
        
        initialY = windowHeight/2 - 30;
        initialX = 30;
        
        for(int i = 0; i < supportedY.length; i++)
        {
            int j = i-2;
            supportedY[i] = initialY + posChange * j;
        }
        
        xx = initialX;
        yy = initialY;
        
        this.setY(initialY);
        this.setX(initialX);
        
        bound = new BoundingBox(this.xx, this.yy, image.getWidth(), image.getHeight());
        
        new AnimationTimer() {
            @Override
            public void handle(long now) {
                bound = new BoundingBox(Player.this.xx, Player.this.yy, image.getWidth(), image.getHeight());
            }
        }.start();
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
    
    public void shiftDown()
    {
        int i;
        for(i = 0; i < supportedY.length; i++)
        {
            if(supportedY[i] == yy && i < supportedY.length - 1)
            {
                double nextY = supportedY[i+1];
                if(movingUp != null)
                    movingUp.stop();
                movingDown = new AnimationTimer() {
                    @Override
                    public void handle(long now) {
                        double y = yy;
                        if(y < nextY) 
                        {
                            Player.this.changeY(shiftSpeed);
                        }
                    }
                };
                movingDown.start();
                break;
            }         
        }
    }
    
    public void shiftUp()
    {
        
        for(int i = 0; i < supportedY.length; i++)
        {
            if(supportedY[i] == yy && i > 0)
            {
                double nextY = supportedY[i-1];
                if(movingDown != null)
                    movingDown.stop();
                movingUp = new AnimationTimer() {
                    @Override
                    public void handle(long now) {
                        double y = yy;
                        if(y > nextY) 
                        {
                            Player.this.changeY(-shiftSpeed);
                        }
                    }
                };
                movingUp.start();
                break;
            }          
        }
    } 
}
