package gameproject;

import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.AnimationTimer;
import javafx.scene.Group;
import javafx.scene.image.Image;

public class Player extends ObjectImage
{
    //==========================================================================
    int health = 4,             // Health value
        direction,              // Direction the player is facing
        playerNo;
    //==========================================================================
    Image staticImage,                                                        
          projectileImage;                                                    
    //==========================================================================
    String animatedImage, identity;
    //==========================================================================
    double posChange = 100,    //Distance between tiles / lanes  
           windowWidth,     
           windowHeight,
           shiftSpeed = 10,     // Speed at which the player chages lanes
           scale,               // Scale of the player and the projectile with respect to the original images
           fireRate = 0.45;     // delay in seconds
    //==========================================================================
    double[] supportedY = new double[5];                                      
    //==========================================================================
    boolean deadInside;
    //==========================================================================
    long lastFired = 0,
         fireDelay = (long)(fireRate * 1000000000);     // converting the delay to nanoseconds
    //==========================================================================
    Group root;                 // root node
    //==========================================================================
    
    public Player(Image staticImage, String animatedImage, Image projectileImage, double posX, double posY, Group root, int direction, double scale, double windowWidth, String identity, int playerNo) 
    {
        super(staticImage, posX, posY, root);
        
        this.windowWidth = windowWidth;
        this.playerNo = playerNo;
        this.root = root;
        this.direction = direction;
        this.scale = scale;
        this.setScaleX(direction * scale) ;
        this.setScaleY(scale);
        this.staticImage = staticImage;
        this.animatedImage = animatedImage;
        this.projectileImage = projectileImage;
        this.identity = identity;
        
        for(int i = 0; i < supportedY.length; i++)
        {
            int j = i-2;
            supportedY[i] = posY + posChange * j;
        }
    }
    
    public int getHealth()
    {
        return health;
    }
    
    public void damageTaken()
    {
        health--;
        if (health == 0)
        {
            deadInside = true;
            dead();
        }
        else
        {
                EffectManager eM = new EffectManager(this);
                Thread t = new Thread(eM);
                t.start();
        }
    }
    
    private void dead()
    {
        GameProject.gc.endGame(playerNo);
    }
    
    public boolean isDead()
    {
        return deadInside;
    }
    
    public void act()
    {
        this.setImage(new Image(animatedImage));
        new Projectiles(projectileImage, xx, yy, direction, 0, 15, 0, 10, 0, root, windowWidth, scale, identity);
    }
    
    public void shiftDown()
    {
        if(!GameController.paused)
            for(int i = 0; i < supportedY.length; i++)
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
        if(!GameController.paused)
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
