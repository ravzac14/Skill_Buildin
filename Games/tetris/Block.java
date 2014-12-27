/* The basic sprites of tetris, can have any configuration of 4 squares, dictated by the BlockType enum (also sets their color)
 * 
 * @author  Zack Raver
 * @date    12/23/14
 */

package tetris;

import gameengine.GameWorld;
import gameengine.Sprite;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.paint.Color;
import javafx.scene.paint.Stop;
import javafx.scene.Node;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;
import java.util.ArrayList;

public class Block extends Sprite {
    
    private final double W = 30;   //Width of each pixel (should be a 10th of the stage width and a 20th of the height)
    private final ArrayList<Rectangle> PIXELS = new ArrayList<Rectangle>(4);    //Each block are comprised of 4 squares in different configurations..        

    public Block(BlockType bt, double xPos, double yPos){
        PIXELS.add(new Rectangle(W,W));                                             //in this case shapes in index 0,1,2,3 of this array list
        PIXELS.add(new Rectangle(W,W));
        PIXELS.add(new Rectangle(W,W));
        PIXELS.add(new Rectangle(W,W));
        
        switch (bt){    //Logic for pixel configuration based on BlockType
            case I: for (int i = 1; i <= PIXELS.size(); i++){
                        PIXELS.get(i-1).setX(xPos + (i * W));
                        PIXELS.get(i-1).setY(yPos);
                    }
                    break;
            
            case J: PIXELS.get(0).setX(xPos); PIXELS.get(0).setY(yPos);                 //position x and y for pixel[0]
                    PIXELS.get(1).setX(xPos); PIXELS.get(1).setY(yPos + W);            //pixel[1]
                    PIXELS.get(2).setX(xPos + W); PIXELS.get(2).setY(yPos + W);         //pixel[2]
                    PIXELS.get(3).setX(xPos + (W*2)); PIXELS.get(3).setY(yPos + W);     //pixel[3]
                    break;

            case L: PIXELS.get(0).setX(xPos + (W*2)); PIXELS.get(0).setY(yPos);         //position x and y for pixel[0]
                    PIXELS.get(1).setX(xPos); PIXELS.get(1).setY(yPos + W);             //pixel[1]
                    PIXELS.get(2).setX(xPos + W); PIXELS.get(2).setY(yPos + W);         //pixel[2]
                    PIXELS.get(3).setX(xPos + (W*2)); PIXELS.get(3).setY(yPos + W);     //pixel[3]
                    break;

            case O: PIXELS.get(0).setX(xPos); PIXELS.get(0).setY(yPos);                 //position x and y for pixel[0]
                    PIXELS.get(1).setX(xPos + W); PIXELS.get(1).setY(yPos);             //pixel[1]
                    PIXELS.get(2).setX(xPos); PIXELS.get(2).setY(yPos + W);             //pixel[2]
                    PIXELS.get(3).setX(xPos + W); PIXELS.get(3).setY(yPos + W);         //pixel[3]
                    break;

            case S: PIXELS.get(0).setX(xPos + W); PIXELS.get(0).setY(yPos);             //position x and y for pixel[0]
                    PIXELS.get(1).setX(xPos + (W*2)); PIXELS.get(1).setY(yPos);         //pixel[1]
                    PIXELS.get(2).setX(xPos); PIXELS.get(2).setY(yPos + W);             //pixel[2]
                    PIXELS.get(3).setX(xPos + W); PIXELS.get(3).setY(yPos + W);         //pixel[3]
                    break;

            case T: PIXELS.get(0).setX(xPos + W); PIXELS.get(0).setY(yPos);             //position x and y for pixel[0]
                    PIXELS.get(1).setX(xPos); PIXELS.get(1).setY(yPos + W);             //pixel[1]
                    PIXELS.get(2).setX(xPos + W); PIXELS.get(2).setY(yPos + W);         //pixel[2]
                    PIXELS.get(3).setX(xPos + (W*2)); PIXELS.get(3).setY(yPos + W);     //pixel[3]
                    break;

            case Z: PIXELS.get(0).setX(xPos); PIXELS.get(0).setY(yPos);                 //position x and y for pixel[0]
                    PIXELS.get(1).setX(xPos + W); PIXELS.get(1).setY(yPos);             //pixel[1]
                    PIXELS.get(2).setX(xPos + W); PIXELS.get(2).setY(yPos + W);         //pixel[2]
                    PIXELS.get(3).setX(xPos + (W*2)); PIXELS.get(3).setY(yPos + W);     //pixel[3]
                    break;
        }//switch
        
        for (Rectangle pixel : PIXELS){ pixel.setFill(bt.getColor()); }  //settin the fill based on the blocktype

    }//BlockConstructor
    
    //return the arraylist of pixel nodes
    public ArrayList<Rectangle> getPixels(){ return this.PIXELS; }
    
    @Override
    public void update(){
        //MOVINNNN ONNNN
        for (int i = 3; i >= 0; i--){
            if (!(((PIXELS.get(i).getY() >= 0) && (PIXELS.get(i).getY()) <= (TetrisWorld.getHeight() - W)))){
 //               for (Rectangle pixel : PIXELS){ //we've hit the bottom..turn them into dead blocks
 //                   TetrisWorld.getSpriteManager().addSprites(new DeadBlock(pixel));
   //             }
//                TetrisWorld.getSpriteManager().addSpritesToBeRemoved(this);
                i = -100; //poor mans break..
            }else{
                PIXELS.get(i).setY(PIXELS.get(i).getY() + (TetrisWorld.gamespeed+1));
            }
        }                                           //Might be all we need to do
    }

    @Override
    public boolean collides(Sprite other){
        //other has to be a deadblock...no way you can run into another live block
        DeadBlock db = (DeadBlock)other;
        //check if any of this blocks pixels are in any other blocks pixels
        for (Rectangle pixel : PIXELS){                                                                         //#######$$$$$ POTENTIAL FOR ONE OFFS HERE ################
            if (((pixel.getX() > (db.getPixel().getX() - W)) && (pixel.getX() < (db.getPixel().getX() + W)))) {     //If its within W (blockwidth) of the other block
                if (pixel.getY() >= db.getPixel().getY()){                                                       //and is >= the same depth as the other block
                    return true;                                                                                //Collision indeed
                }
            }
        }
        return false; //otherwise no collision
    }

}//Block
