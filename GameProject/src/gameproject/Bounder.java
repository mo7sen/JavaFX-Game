package gameproject;

import java.util.ArrayList;

public class Bounder 
{
    double minX, minY, width, height, maxX, maxY;
    
    public Bounder(double minX, double minY, double width, double height)
    {
        this.minX = minX;
        this.minY = minY;
        this.width = width;
        this.height = height;
        
        maxX = minX + width;
        maxY = minY + height;
    }
    
    public void changeX(double changeAmount)
    {
        minX += changeAmount;
        maxX += changeAmount;
    }
    
    public void setX(double x)
    {
        minX = x;
        maxX = x + width;
    }
    
    public void setY(double y)
    {
        minY = y;
        maxY = y + height;
    }
    
    public void changeY(double changeAmount)
    {
        minY += changeAmount;
        maxY += changeAmount;
    }
    
    public void setWidth(double width)
    {
        this.width = width;
    }
    
    public void setHeight(double height)
    {
        this.height = height;
    }
    
    public boolean intersects(Bounder b)
    {
        return  ( b.minX <= this.maxX && b.minY >= this.maxY )
                ||
                ( b.maxX >= this.minX && b.maxY >= this.minY )
                ||
                ( b.minX <= this.maxX && b.maxY >= this.minY )
                ||
                ( b.maxX >= this.minX && b.minY <= this.maxY );
    }
 
    public boolean intersectsAny(ArrayList<Bounder> bounders)
    {
        for(int  i = 0; i < bounders.size(); i++)
        {
            if(this.intersects(bounders.get(i)) && this != bounders.get(i))
                return true;
        }
        return false;
    }
}