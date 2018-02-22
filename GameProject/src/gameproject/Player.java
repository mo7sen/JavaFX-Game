package gameproject;

import javafx.animation.AnimationTimer;
import javafx.geometry.BoundingBox;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Player extends ObjectImage
{
    //==========================================================================
    int health = 4,             // Health value
        direction;              // Direction the player is facing
    //==========================================================================
    Image staticImage,                                                        
          projectileImage;                                                    
    //==========================================================================
    String animatedImage;
    //==========================================================================
    double posChange = 100,     // (Distance between tiles / lanes)
           windowWidth,     
           windowHeight,
           shiftSpeed = 10,     // Speed at which the player chages lanes
           scale,               // Scale of the player and the projectile with respect to the original images
           fireRate = 0.25;     // delay in seconds
    //==========================================================================
    double[] supportedY = new double[5];                                      
    //==========================================================================
    long lastFired = 0,
         fireDelay = (long)(fireRate * 1000000000);     // converting the delay to nanoseconds
    //==========================================================================
    Group root;                 // root node
    //==========================================================================
    
    public Player(Image staticImage, String animatedImage, Image projectileImage, double posX, double posY, Group root, int direction, double scale, double windowWidth) 
    {
        super(staticImage, posX, posY, root);
        
        this.windowWidth = windowWidth;
        this.root = root;
        this.direction = direction;
        this.scale = scale;
        this.setScaleX(direction * scale) ;
        this.setScaleY(scale);
        this.staticImage = staticImage;
        this.animatedImage = animatedImage;
        this.projectileImage = projectileImage;
        
        for(int i = 0; i < supportedY.length; i++)
        {
            int j = i-2;
            supportedY[i] = posY + posChange * j;
        }
        
        bound = new BoundingBox(this.xx, this.yy, staticImage.getWidth(), staticImage.getHeight());
        
        new AnimationTimer() {
            @Override
            public void handle(long now) {
                bound = new BoundingBox(Player.this.xx, Player.this.yy, staticImage.getWidth(), staticImage.getHeight());
            }
        }.start();
    }
    
    public int getHealth()
    {
        return health;
    }
    
    public void damageTaken()
    {
        health--;
        this.hurt();
    }
    
    public void hurt()
    {
        
    }
    
    public boolean isDead()
    {
        return (health == 0);
    }
    
    public void act()
    {
        this.setImage(new Image(animatedImage));
        new Projectiles(projectileImage, xx, yy, direction, 0, 15, 0, 10, 0, root, windowWidth, scale);
    }
    
    public void shiftDown()
    {
        int i;
        for(i = 0; i < supportedY.length; i++)
        {
            if(supportedY[i] == yy && i < supportedY.length - 1)
            {
                double nextY = supportedY[i+1];
                new AnimationTimer() {
                    @Override
                    public void handle(long now) {
                        double y = yy;
                        if(y < nextY) 
                        {
                            Player.this.changeY(shiftSpeed);
                        }
                        else if(y == nextY) 
                        {
                        this.stop() ;
                       } 
                    }
                }.start();
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
                new AnimationTimer() {
                    @Override
                    public void handle(long now) {
                        double y = yy;
                        if(y > nextY) 
                        {
                            Player.this.changeY(-shiftSpeed);
                        }
                        else if(y == nextY) 
                        {
                            this. stop() ;
                        } 
                    }
                }.start();
                break;
            }          
        }
    } 
}
