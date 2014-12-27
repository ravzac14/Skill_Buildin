/* This is a class for blocks that have hit the bottom..
 * they need to dissappear when a whole row of them have combined
 *
 * @author  Zack Raver
 * @date    12/24/14
 * 
 * Need to override update() to just check for a whole row of deads and kill them
 * I think...
 */

package tetris;

import gameengine.Sprite;
import javafx.scene.shape.Rectangle;

public class DeadBlock extends Sprite{

    public Rectangle pixel;

    public DeadBlock(Rectangle r) {
       pixel = r;
    }

    //Needs to grab the list of other deadblocks from the SM (which is just GAME_ACTORS minus the one live blocks) 
    //and check if there are 10 in a horizontal row 
    @Override
    public void update(){

    }

    public Rectangle getPixel(){ return pixel; }
}
