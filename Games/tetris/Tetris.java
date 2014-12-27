/* Tetris main driving class
 *  - Has stuff
 *
 * @author  Zack Raver
 * @date    12/22/14
 * 
 * This is my first crack at a game..sorry about the mess (im assuming)
 * The main driver of the game
 */
 
package tetris;

import gameengine.GameWorld;
import javafx.application.Application;
import javafx.stage.Stage;
 
 public class Tetris extends Application {
    
    GameWorld gw = new TetrisWorld (60, "My-Tetris");

    public static void main(String[] args){
        launch(args);
    }

    @Override
    public void start(Stage primaryStage){
        //setup title, scene, stats, controls, and actors
        gw.initialize(primaryStage);

        //kick off the game loop
        gw.beginGameLoop();

        //display window
        primaryStage.show();
    }
}

