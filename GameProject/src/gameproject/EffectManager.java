package gameproject;

import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.effect.BlendMode;

public class EffectManager implements Runnable
{
    ObjectImage p;
    
    public EffectManager(ObjectImage p)
    {
        this.p = p;
    }
    
    public void hurt()
    {
        try {
            p.setBlendMode(BlendMode.DIFFERENCE);
            Thread.sleep(100);
            p.setBlendMode(null);
            Thread.sleep(100);
            p.setBlendMode(BlendMode.DIFFERENCE);
            Thread.sleep(100);
            p.setBlendMode(null);
        } catch (InterruptedException ex) {
            Logger.getLogger(EffectManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void run() 
    {
        hurt();
    }
}
