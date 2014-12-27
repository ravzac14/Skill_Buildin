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
    
    //  ####
    I(Color.AQUA),
    
    //  #
    //  ###
    J(Color.BLUE),
    
    //    #
    //  ###
    L(Color.ORANGE),
    
    //  ##
    //  ##
    O(Color.YELLOW),
    
    //   ##
    //  ##
    S(Color.GREEN),
    
    //   #
    //  ###
    T(Color.PURPLE),
    
    //  ##
    //   ##
    Z(Color.RED);

    private final Color color;  //default color of each block type
    private static final List<BlockType> VALUES = Collections.unmodifiableList(Arrays.asList(values()));
    private static final int SIZE = VALUES.size();
    private static final Random RANDOM = new Random();

    BlockType(Color color){ this.color = color; }

    public Color getColor(){ return this.color; }

    //Need to get a random block type every time we start a new game and kill another block
    public static BlockType randomBlockType(){
        return VALUES.get(RANDOM.nextInt(SIZE));
    }
}//BlockType
    
