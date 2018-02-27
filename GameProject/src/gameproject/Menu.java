
package gameproject;

import javafx.animation.AnimationTimer;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.StackPane;


public class Menu 
{
    double initialScale = 0.7, scale = initialScale;
    public Menu(String type, Group root, Scene scene)
    {
        ImageView pause = new ImageView(new Image("PauseMenu.png"));
        pause.setScaleX(scale);
        pause.setScaleY(scale);
        
        root.getChildren().add(pause);
        
        AnimationTimer collapse = new AnimationTimer() 
        {
            @Override
            public void handle(long now) 
            {
                if(scale>0)
                {
                    scale -= 0.07;
                    pause.setScaleY(scale);
                    pause.setScaleX(scale);
                }
                else
                    scale = 0;
            }
        };
        AnimationTimer expand = new AnimationTimer() 
        {
            @Override
            public void handle(long now) 
            {
                if(scale<0.7)
                {
                    scale += 0.05;
                    pause.setScaleY(scale);
                    pause.setScaleX(scale);
                }
                else
                    scale = initialScale;
            }
        };
        
        
        scene.setOnKeyPressed((event) -> {
            if(event.getCode() == KeyCode.E)
            {
                collapse.stop();
                expand.start();
            }
            if(event.getCode() == KeyCode.C)
            {
                expand.stop();
                collapse.start();
            }
        });
        
    }
}
