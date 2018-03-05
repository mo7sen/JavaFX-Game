package gameproject;

import java.util.ArrayList;
import javafx.animation.AnimationTimer;
import javafx.scene.Group;
import javafx.scene.effect.BlendMode;
import javafx.scene.image.Image;

public class Projectiles extends ObjectImage
{

    public static Player playerOne, playerTwo;
    public static ArrayList<Projectiles> shots = new ArrayList<Projectiles>();

    double offsetX, offsetY, speedX, speedY, windowWidth;
    String identity;
    int directionX, directionY;
    AnimationTimer shot;

    public Projectiles(Image image, double posX, double posY, int directionX, int directionY, double offsetX, double offsetY, double speedX, double speedY, Group root, double windowWidth, double scale, String identity)
    {
        super(image, posX + offsetX * directionX, posY + offsetY *directionY, root);
        this.directionX = directionX;
        this.directionY = directionY;
        this.speedX = speedX;
        this.speedY = speedY;
        this.windowWidth = windowWidth;
        this.identity = identity;

        Projectiles.this.setScaleY(scale);
        this.setBlendMode(null);
        Projectiles.this.setScaleX(scale * directionX);
        shots.add(this);
        this.animate();
    }

    private void animate()
    {
        shot = new AnimationTimer() {
            @Override
            public void handle(long now)
            {
                Projectiles.this.changeX(directionX * speedX);
                Projectiles.this.changeY(directionY * speedY);

                if(Projectiles.this.getX() > windowWidth || Projectiles.this.getX() < -50 )
                {
                    this.stop();
                    Projectiles.this.setImage(null);
                }

                if((playerTwo != null) && Projectiles.this.bound.collides(playerTwo.bound) && (playerTwo.identity != Projectiles.this.identity))
                {
                    this.stop();
                    playerTwo.damageTaken();
                    Projectiles.this.setImage(null);
                    Projectiles.this.bound.destroy();
                }
                else if((playerOne != null) && Projectiles.this.bound.collides(playerOne.bound) && (playerOne.identity!=Projectiles.this.identity))
                {
                    this.stop();
                    playerOne.damageTaken();
                    Projectiles.this.setImage(null);
                    Projectiles.this.bound.destroy();
                }
                else if(playerTwo == null)
                    for(Enemy ene: SceneMaker.npcM.enemies)
                        if(Projectiles.this.bound.collides(ene.bound))
                        {
                            this.stop();
                            ene.damageTaken();
                            Projectiles.this.setImage(null);
                            // Projectiles.this.bound.destroy();
                            break;
                        }
            }
        };

        shot.start();
        SceneMaker.gc.animators.add(shot);
    }
}
