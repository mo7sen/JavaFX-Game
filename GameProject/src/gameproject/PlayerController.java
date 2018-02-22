package gameproject;

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
        
        new AnimationTimer() {
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
        }.start();   
    }

    public void setPlayerOne(Player playerOne)
    {
	this. playerOne = playerOne;
	playerOneExists = true;
    }
		
    public void setPlayerTwo(Player playerTwo)
    {
	this. playerTwo = playerTwo;
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
       
            });
            
        scene.setOnKeyReleased((event) -> 
        {
            if(event.getCode() == KeyCode.P)
                firing1 = false;
            if(event.getCode() == KeyCode.G)
                firing2 = false;
        });
    }
}
