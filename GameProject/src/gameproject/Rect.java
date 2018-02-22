package gameproject;

import javafx.scene.shape.Rectangle;

public class Rect extends Rectangle
{
    double xx, yy;
    public Rect(double x, double y, double width, double height)
    {
        super(x,y,width,height);
        xx = x;
        yy = y;
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
