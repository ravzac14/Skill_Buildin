/* Holds configurations for various block types in tetris
 *
 * dunno if enum is the correct way to do this 
 * @author  Zack Raver
 * @date    12/23/14
 */

package tetris;

import javafx.scene.paint.*;
import java.util.*;

public enum BlockType {
    
    //  0:  ####    1:  #                   NEED: 0, 1
    //                  #
    //                  #
    //                  #
    I(Color.AQUA, 120, 30),
    
    //  0:  #   1:  ##  2:  ### 3:   #      NEED: 0, 1, 2, 3
    //      ###     #         #      #
    //              #               ##
    J(Color.BLUE, 90, 60),
    
    //  0:    # 1:  #   2:  ### 3:  ##      NEED: 0, 1, 2, 3
    //      ###     #       #        #
    //              ##               #
    L(Color.ORANGE, 90, 60),
    
    //  0:  ##                              NEED: 0
    //      ##
    O(Color.YELLOW, 60, 60),
    
    //  0:   ## 1:  #   2:   ## 3:  #       NEED: 0, 1
    //      ##      ##      ##      ##
    //               #               #
    S(Color.GREEN, 90, 60),
    
    //  0:   #  1:  #   2:  ### 3:   #      NEED: 0, 1, 2, 3
    //      ###     ##       #      ##
    //              #                #
    T(Color.PURPLE, 90, 60),
    
    // 0:   ##  r1:  #  r2: ##  r3:  #      NEED: 0, 1
    //       ##     ##       ##     ##
    //              #               #
    Z(Color.RED, 90, 60);

    /* BlockType's fields:
     * @var: double height is the max height of the block
     * @var: double width is the max width of the block
     * @var: Color color is the default color for each block type
     * @var: List<BlockType> VALUES is the iterable list of enum values
     * @var: int SIZE is the length of that ^ list
     * @var: Random RANDOM is the random value to help choose which blocktype to generate    
     * @var: int leftmost keeps track of which block is farthest left
     * @var: int rightmost keeps track of which block is farthest right*/
    private final double height;
    private final double width;
    private final Color color;
    private static final List<BlockType> VALUES = Collections.unmodifiableList(Arrays.asList(values()));
    private static final int SIZE = VALUES.size();
    private static final Random RANDOM = new Random();
    private int leftmost = -1;
    private int rightmost = -1;

    /* BlockType's constructor:
     * @param: Color color  */
    BlockType(Color color, double width, double height){ this.color = color; 
                                                         this.width = width;
                                                         this.height = height; }

    /* BlockType's getColor method:
     * @return: Color   */
    public Color getColor(){ return this.color; }

    /* BlockType's randomBlockType method:
     *      Need to get a random block type every time we start a new game and kill another block
     *      Pulls a random value outta the list of blocktypes
     * @return: BlockType   */
    public static BlockType randomBlockType(){
        return VALUES.get(RANDOM.nextInt(SIZE));
    }
    
    /* BlockType's height accessor method:
     *      needed for checking collisions
     * @return: double height   */
    public double getHeight(){ return this.height; }

    /* BlockType's width accessor method:
     *      needed for checking collisions
     * @return: double width   */
    public double getWidth(){ return this.width; }

    /* BlockType's returns getLeftmost():
     *      sometimes need the leftmost index of the pixel
     * @return int leftmost */
    public int getLeftmost(){
        if(leftmost < 0){
            switch(this){
                case I:
                    leftmost = 0;
                case J:
                    leftmost = 1;
                case L:
                    leftmost = 1;
                case O:
                    leftmost = 2;
                case S:
                    leftmost = 2;
                case T:
                    leftmost = 1;
                case Z:
                    leftmost = 0;
                default:
                    leftmost = 0;
            }
        }
        return leftmost;
    }
    
    /* BlockType's returns getRightmost():
     *      sometimes need the rightmost index of the pixel
     * @return int rightmost */
    public int getRightmost(){
        if (rightmost < 0){
            switch(this){
                case I:
                    rightmost = 3;
                case J:
                    rightmost = 3;
                case L:
                    rightmost = 3;
                case O: 
                    rightmost = 3;
                case S:
                    rightmost = 1;
                case T:
                    rightmost = 3;
                case Z:
                    rightmost = 3;
                default:
                    rightmost = 3;
            } 
        }
        return rightmost;
    }

    /* BlockType's rightmost accessor method:
     * @param: int newRightmost */
    public void setRightmost(int newRightmost){
        if (newRightmost > 3){}
        else { rightmost = newRightmost; }
    }

    /* BlockType's leftmost accessor method:
     * @param: int newLeftmost */
    public void setLeftmost(int newLeftmost){
        if (newLeftmost > 3){}
        else { leftmost = newLeftmost; }
    }


    /* BlockType's checkRotate method:
     *      -TODO(zack): Is there a smarter way to do this, rather than just cases?
     *      -resets the bounds
     * @param: int nextPosition, representing the position that you will be transitioning to*/
    public void checkRotate(int nextPosition){
        switch(this){
            case I: 
                break; //Is the same
            case J:
                if (nextPosition == 0){
                    leftmost = 0;
                    rightmost = 3;
                }
                if (nextPosition == 1){
                    leftmost = 1;
                    rightmost = 0;
                }
                if (nextPosition == 2){
                    leftmost = 3;
                    rightmost = 0;
                }
                if (nextPosition == 3){
                    leftmost = 0;
                    rightmost = 3;
                } 
            case L:
                if (nextPosition == 0){
                    leftmost = 1;
                    rightmost = 0;
                }
                if (nextPosition == 1){
                    leftmost = 1;
                    rightmost = 0;
                }
                if (nextPosition == 2){
                    leftmost = 0;
                    rightmost = 3;
                }
                if (nextPosition == 3){
                    leftmost = 0;
                    rightmost = 3;
                } 
            case O: 
                break; //Doesn't do any moving
            case S:
                if (nextPosition == 0){
                    leftmost = 2;
                    rightmost = 1;
                }
                if (nextPosition == 1){
                    leftmost = 0;
                    rightmost = 3;
                } 
            case T:
                if (nextPosition == 0){
                    leftmost = 1;
                    rightmost = 3;
                }
                if (nextPosition == 1){
                    leftmost = 1;
                    rightmost = 0;
                }
                if (nextPosition == 2){
                    leftmost = 3;
                    rightmost = 1;
                }
                if (nextPosition == 3){
                    leftmost = 0;
                    rightmost = 1;
                } 
            case Z:
                if (nextPosition == 0){
                    leftmost = 0;
                    rightmost = 3;
                }
                if (nextPosition == 1){
                    leftmost = 3;
                    rightmost = 3;
                }
                
            default:
                break; //do nothing
        } 
    }//rotatoe

}//BlockType
    
