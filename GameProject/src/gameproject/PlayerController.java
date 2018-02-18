/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameproject;

import javafx.animation.AnimationTimer;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 *
 * @author Robear
 */
public class PlayerController 
{
    double speed;
    boolean moveUp, moveDown, moveRight, moveLeft;
    public PlayerController(Player player, int playerNum, Scene scene)
    {
        speed = 1;
        
        scene.setOnKeyPressed((event) -> {
            switch(event.getCode())
            {
                case UP:
                    moveUp = true;
                    break;
                case DOWN:
                    moveDown = true;
                    break;
                case LEFT:
                    moveLeft = true;
                    break;
                case RIGHT:
                    moveRight = true;
                    break;
                default:
            }
        });
        scene.setOnKeyReleased((event) -> {
            switch(event.getCode())
            {
                case UP:
                    moveUp = false;
                    break;
                case DOWN:
                    moveDown = false;
                    break;
                case LEFT:
                    moveLeft = false;
                    break;
                case RIGHT:
                    moveRight = false;
                    break;
                case SPACE:
                    player.act();
                    break;
                default:
            }
        });
        
        new AnimationTimer() {
            @Override
            public void handle(long now) {
                if(moveUp)
                    player.changeY(-speed);
                if(moveDown)
                    player.changeY(speed);
                if(moveRight)
                    player.changeX(speed);
                if(moveLeft)
                    player.changeX(-speed);
                
            }
        }.start();
        
    }
}
