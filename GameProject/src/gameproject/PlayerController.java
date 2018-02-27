package gameproject;

import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.AnimationTimer;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;

public class PlayerController 
{
    boolean firing1, firing2, playerOneExists, playerTwoExists;
    Player playerOne, playerTwo;
    Scene scene;
    
    public PlayerController(Scene scene)
    {
        this.scene = scene;
        
        AnimationTimer firing = new AnimationTimer() {
            
            @Override
            public void handle(long now) 
            {
                if(firing1)
                {
                    if(now > playerOne.lastFired + playerOne.fireDelay)
                    {
                        playerOne.act();
                        playerOne.lastFired = now;
                    }
                }
                if(firing2)
                {
                    if(now > playerTwo.lastFired + playerTwo.fireDelay)
                    {
                        playerTwo.act();
                        playerTwo.lastFired = now;
                    }
                }
                
            }
        };
        GameProject.gc.animators.add(firing);
    }

    public void setPlayerOne(Player playerOne)
    {
	this. playerOne = playerOne;
        Projectiles.playerOne = playerOne;
	playerOneExists = true;
    }
		
    public void setPlayerTwo(Player playerTwo)
    {
	this. playerTwo = playerTwo;
        Projectiles.playerTwo = playerTwo;
	playerTwoExists = true;
    }
               
    public void setControls() 
    {
        scene.setOnKeyPressed((event) -> 
            {
                if(playerOneExists) 
                {
                    if(event. getCode() == KeyCode. UP) 
                        playerOne.shiftUp();
                    if(event. getCode() == KeyCode. DOWN)
                        playerOne.shiftDown();
                    if(event. getCode() == KeyCode. P) 
                        firing1 = true;
                } 
               
                if(playerTwoExists) 
                {
                    if(event. getCode() == KeyCode. W) 
                        playerTwo. shiftUp();
                    if(event. getCode() == KeyCode. S)
                	playerTwo. shiftDown();
                    if(event. getCode() == KeyCode. G) 
                	firing2 = true;
                } 
                
                
                    if(event.getCode() == KeyCode.I)
                    {
                        GameProject.gc.pause();
                        System.out.println("paused");
                    }
                    
                    if(event.getCode() == KeyCode.O)
                    {
                        GameProject.gc.resume();
                        System.out.println("resumed");
                    }
                
                    
       
            });
            
        scene.setOnKeyReleased((event) -> 
        {
            if(event.getCode() == KeyCode.P)
                firing1 = false;
            if(event.getCode() == KeyCode.G)
                firing2 = false;
        });
    }
    
    public void destroy()
    {
        scene.setOnKeyPressed((event) -> 
        {
            if(event.getCode() == KeyCode.SPACE)
                new GameProject().reset();
        });
        scene.setOnKeyReleased(null);
        firing1 = false;
        firing2 = false;
    }
}
