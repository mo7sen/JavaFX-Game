/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameproject;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/**
 *
 * @author Robear
 */
public class GameProject extends Application {
    double speed = 10;
    double windowWidth = 1000,
            windowHeight = 600;
    Rectangle rect;
    @Override
    public void start(Stage primaryStage) {
        Group root = new Group();
        Scene scene = new Scene(root, windowWidth, windowHeight);
        Image image = new Image("sorcerer.png");
        Player one = new Player(image,100,100, root, windowWidth, windowHeight);
        one.setScaleX(2);
        one.setScaleY(2);
        
        one.setActionImage("sorcererGIF.gif");
        PlayerController r = new PlayerController(one, 0, scene);
       
        root.getChildren().add(one.rect);
        one.toFront();
        
        primaryStage.setTitle("Game - in progress");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
