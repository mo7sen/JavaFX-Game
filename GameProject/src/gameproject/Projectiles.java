package gameproject;

import javafx.animation.AnimationTimer;
import javafx.scene.Group;
import javafx.scene.image.Image;

public class Projectiles extends ObjectImage{
    
    public static Bounder playerOne, playerTwo;
    double offsetX, offsetY, speedX, speedY, windowWidth;
    int directionX, directionY;
    
    public Projectiles(Image image, double posX, double posY, int directionX, int directionY, double offsetX, double offsetY, double speedX, double speedY, Group root, double windowWidth, double scale) 
    {
        super(image, posX + offsetX * directionX, posY + offsetY *directionY, root);
        this.directionX = directionX;
        this.directionY = directionY;
        this.speedX = speedX;
        this.speedY = speedY;
        this.windowWidth = windowWidth;
        
        Projectiles.this.setScaleY(scale);
        Projectiles.this.setScaleX(scale * directionX);
        
        this.animate();
    }
    
    private void animate()
    {
        new AnimationTimer() {
            @Override
            public void handle(long now) 
            {
                Projectiles.this.changeX(directionX * speedX);
                Projectiles.this.changeY(directionY * speedY);
                
                if(Projectiles.this.getX() > windowWidth )
                {
                    this.stop();
                }
                
                if(Projectiles.this.bound.intersects(playerTwo))
                {
                    //System.out.println("player two hit");
                }
                
                if(Projectiles.this.bound.intersects(playerOne))
                {
                    this.stop();
                }
            }
        }.start();
    }
}
