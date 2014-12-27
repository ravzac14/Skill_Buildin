/* The world class, from gameworld
 * 
 *@author   Zack Raver
 *@date     12/22/14
 *
 * Has all the rules for the world
 */

package tetris;

import gameengine.GameWorld;
import gameengine.Sprite;
import javafx.animation.Timeline;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import static javafx.animation.Animation.Status.RUNNING;
import static javafx.animation.Animation.Status.STOPPED;

public class TetrisWorld extends GameWorld {
    
    //Game wide vars
    public static int gamespeed = 0;

    //Panels height and width
    private static final double HEIGHT = 600;
    private static final double WIDTH = 300;   //should fit 10 blocknodes wide and 20 high

    public TetrisWorld(int fps, String title){
        super(fps,title);
    }

    //initialize the game world by adding some sprite objects
    @Override
    public void initialize(final Stage primaryStage){
        //Set the window title
        primaryStage.setTitle(getTitle());

        //Create the scene
        setSceneNodes(new Group());
        setGameSurface(new Scene(getSceneNodes(), WIDTH, HEIGHT, Color.BLACK));
        primaryStage.setScene(getGameSurface());

        //Start a block
        generateBlock();
        
        //Making the label for gamespeed (aka game level)
        Label speed = new Label("Level: " + gamespeed);

        //making a button to do the pause
        Button pause = new Button("Pause");
        pause.setCancelButton(true);
        //LAMBDAS IN JAVA THO****************************************
        pause.setOnAction(e -> {
            switch (getGameLoop().getStatus()){
                case RUNNING:
                    getGameLoop().stop();
                    break;
                case STOPPED:
                    getGameLoop().play();
                    break;
            }
        });
        
        //making buttons to do left and right, down goes faster, up rotates


        //making a menu to hold the label for speed and the pause button
        VBox menu = new VBox(5); 
        //menu.setPrefWidth(10); //dunno if this is necessary
        menu.getChildren().addAll(pause, speed);
        
        //lay down the controls 
        getSceneNodes().getChildren().add(menu);
    }//initialize

    private void generateBlock(){
        Block block = new Block(BlockType.randomBlockType(), (double)WIDTH / 2, (double)0);
        getSpriteManager().addSprites(block);
        for (Rectangle pixel : block.getPixels()){
            getSceneNodes().getChildren().add(pixel); 
        }
    }

    //I think in this case all "updates" ie moving and rotating etc are handled in the sprites update()
    @Override
    protected void handleUpdate(Sprite spr){
        spr.update();
    }
    
    //Should only be colliding with the edge or a dead block..make another 4 sprites of dead blocks..that can't move (unless they pop a row)
    @Override
    protected boolean handleCollision(Sprite spr1, Sprite spr2){
        if (spr1.collides(spr2)){
            Block b = (Block)spr1;
            for (Rectangle pixel : b.getPixels()){
                getSpriteManager().addSprites(new DeadBlock(pixel));
            }
            getSpriteManager().addSpritesToBeRemoved(spr1);
            gamespeed++;                                        //Might want to not do this here
            generateBlock();
            return true;
        }
        return false;
    }

    @Override
    protected void cleanupSprites(){
        //remove from the scene and backend store
        super.cleanupSprites();
        //maybe need to do more here
    }

    public static double getWidth(){ return WIDTH; }

    public static double getHeight(){ return HEIGHT; }
}//TetrisWorld
