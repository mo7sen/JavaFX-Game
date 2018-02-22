package gameproject;

import javafx.geometry.BoundingBox;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;

public class ObjectImage extends ImageView
{
    ImageView imageView;
    BoundingBox bound;
    Rectangle rect;
    double xx, yy;
    
    public ObjectImage(Image image, double posX, double posY, Group root)
    {
        this.setSmooth(true);
        this.setImage(image);

        xx = posX;
        yy = posY;
        this.setX(posX);
        this.setY(posY);
        root.getChildren().add(this);
        rect = new Rectangle(posX, posY, image.getWidth(), image.getHeight());
        
        root.getChildren().add(rect);
    }
    
    public void reset()
    {
        this.setTranslateX(0);
        this.setTranslateY(0);
    }
    
    public void changeX(double changeAmount)
    {
        xx += changeAmount;
        rect.setX(xx);
        this.setX(xx);
    }
    
    public void changeY(double changeAmount)
    {
        yy += changeAmount;
        rect.setY(yy);
        this.setY(yy);
    }
}
