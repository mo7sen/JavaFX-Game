package gameproject;

import javafx.animation.AnimationTimer;
import javafx.scene.Group;
import javafx.scene.image.Image;

public class Enemy extends ObjectImage
{
    AnimationTimer enemyMoving;
    int health = 2;
    int index;
    double speed = 1;
    boolean dead = false;
    
    public Enemy(Image image, double posX, double posY, Group root) 
    {
        super(image, posX, posY, root);
        index = GameProject.npcM.enemies.size();
        
        GameProject.npcM.enemies.add(this);
    }   
    
    public void animate()
    {
        enemyMoving = new AnimationTimer() 
        {
            @Override
            public void handle(long now) 
            {
                Enemy.this.changeX(-speed);
            }
        };
        GameProject.gc.animators.add(enemyMoving);
        enemyMoving.start();
    }
    
    public void damageTaken()
    {
        if(--health == 0)
            dead();
        else
        {
            EffectManager eM = new EffectManager(this);
            Thread t = new Thread(eM);
            t.start();
        }
    }
    public void dead()
    {
        dead = true;
        GameProject.npcM.enemies.remove(index);
        
        for(Enemy en: GameProject.npcM.enemies)
            if(en.index > index)
                en.index--;
        
        this.setImage(null);
        this.bound.destroy();
        enemyMoving.stop();
    }
}
