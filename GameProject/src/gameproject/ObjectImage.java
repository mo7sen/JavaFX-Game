/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameproject;


import javafx.animation.AnimationTimer;
import javafx.geometry.BoundingBox;
import javafx.geometry.Bounds;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 *
 * @author Robear
 */
public class ObjectImage extends ImageView
{
    ImageView imageView;
    BoundingBox bound;
    Rectangle rect = new Rectangle();
    double xx, yy;
    public ObjectImage(Image image, double posX, double posY, Group root)
    {
       this.setImage(image);
       
       xx = posX;
       yy = posY;
       this.setX(posX);
       this.setY(posY);
       root.getChildren().add(this);
       
       
       
    }
    
    public void reset()
    {
        this.setTranslateX(0);
        this.setTranslateY(0);
    }
    
    public void changeX(double changeAmount)
    {
        xx += changeAmount;
        this.setX(xx);
    }
    
    public void changeY(double changeAmount)
    {
        yy += changeAmount;
        this.setY(yy);
    }
}
