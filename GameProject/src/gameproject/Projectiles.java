package gameproject;

import java.util.ArrayList;
import javafx.animation.AnimationTimer;
import javafx.scene.Group;
import javafx.scene.image.Image;

public class Projectiles extends ObjectImage
{
    
    public static Player playerOne, playerTwo;
    public static ArrayList<Bounder> enemies = new ArrayList<>();
    double offsetX, offsetY, speedX, speedY, windowWidth;
    String identity;
    int directionX, directionY;
    
    public Projectiles(Image image, double posX, double posY, int directionX, int directionY, double offsetX, double offsetY, double speedX, double speedY, Group root, double windowWidth, double scale, String identity) 
    {
        super(image, posX + offsetX * directionX, posY + offsetY *directionY, root);
        this.directionX = directionX;
        this.directionY = directionY;
        this.speedX = speedX;
        this.speedY = speedY;
        this.windowWidth = windowWidth;
        this.identity = identity;
        
        Projectiles.this.setScaleY(scale);
        Projectiles.this.setScaleX(scale * directionX);
        
        this.animate();
    }
    
    private void animate()
    {
        AnimationTimer shot = new AnimationTimer() {
            @Override
            public void handle(long now) 
            {
                Projectiles.this.changeX(directionX * speedX);
                Projectiles.this.changeY(directionY * speedY);
                
                if(Projectiles.this.getX() > windowWidth || Projectiles.this.getX() < -50 )
                {
                    this.stop();
                }
                
                if(Projectiles.this.bound.collides(playerTwo.bound) && (playerTwo.identity != Projectiles.this.identity))
                {
                    playerTwo.damageTaken();
                    this.stop();
                    Projectiles.this.setImage(null);
                }
                
                if(Projectiles.this.bound.collides(playerOne.bound) && (playerOne.identity!=Projectiles.this.identity))
                {
                    playerOne.damageTaken();
                    this.stop();
                    Projectiles.this.setImage(null);
                }
            }
        };
        shot.start();
        GameProject.gc.animators.add(shot);
    }
}
