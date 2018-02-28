
package gameproject;

import javafx.animation.AnimationTimer;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


public class Menu 
{
    ImageView pause;
    AnimationTimer collapse, expand;
    double maxScale = 0.7,initialScale = 0, scale = initialScale, windowWidth, windowHeight;
    public Menu(String type, Group root, double windowWidth, double windowHeight)
    {
        this.windowWidth = windowWidth;
        this.windowHeight = windowHeight;
        
        Image pauseImage = new Image("PauseMenu.png");
        pause = new ImageView(pauseImage);
        
        pause.setLayoutX(windowWidth/2 - pauseImage.getWidth()/2);
        pause.setLayoutY(windowHeight/2 - pauseImage.getHeight()/2);
        
        pause.setScaleX(initialScale);
        pause.setScaleY(initialScale);
        
        root.getChildren().add(pause);
        
        collapse = new AnimationTimer() 
        {
            @Override
            public void handle(long now) 
            {
                if(scale>initialScale)
                {
                    scale -= 0.07;
                    pause.setScaleY(scale);
                    pause.setScaleX(scale);
                }
                else
                {
                    scale = initialScale;
                    this.stop();
                }
            }
        };
        expand = new AnimationTimer() 
        {
            @Override
            public void handle(long now) 
            {
                if(scale<maxScale)
                {
                    scale += 0.07;
                    pause.setScaleY(scale);
                    pause.setScaleX(scale);
                }
                else
                {
                    scale = maxScale;
                    this.stop();
                }
            }
        };
        
        
    }
        public void collapse()
        {            
           collapse.start();
        }
        
        public void expand()
        {
            expand.start();
        }
}
