/* @author  Zack Raver; ravzac14
 * @date    1/25/15
 *
 * This should hold the logic/display methods for a section of a tape
 * Which probably just holds tape sections as an arraylist
 */

import java.util.ArrayList;

public class Tape {
    
    /* @field members holds all the tapes */
    private ArrayList<TapeSection> sections = new ArrayList<TapeSection>();  //Maybe 20?
    private TapeSection current;
    private int currentIndex;

    /* Default just adds 20 tape sections (which can be added to further) */
    public Tape(){
        for (int i = 0; i < 20; i++){
            sections.add(new TapeSection(i));
        }
        current = getFirst();
        currentIndex = 0;
    }

    /* Initialize with a custom length of initial tape
     * @param int initialSize   */
    public Tape(int initialSize){
        for (int i = 0; i < initialSize; i++){
            sections.add(new TapeSection(i));
        } 
        current = getFirst();
        currentIndex = 0;
    }

    /* Maybe later it would be useful to initialize with a bunch of preset TapeSection(s)?
    public Tape(TapeSection t1, ... TapeSections tn){}
    */

    /* May need a display */
    public void display(){
        for (TapeSection t : sections){
            t.display();
        }
    }

    /* Grabs the first section of the tape  */
    public TapeSection getFirst(){
        return sections.get(0);
    }

    /* Move should be the main driver for the machine
     * @param char newValue, the value to replace in the current TapeSection
     * @param char direction (L or R), the direction to move the tape after the replacement happens */
    public void move(char newValue, char direction){
       current.setValue(newValue);
       if (!((direction == 'L') && (currentIndex == 0))){   //If not (wanting to move left and at the head)
            if ((direction == 'R') && ((currentIndex + 1) == sections.size())){  //If (wanting to move right and at the "end" of the tape right) make more tape
                sections.add(new TapeSection(currentIndex + 1));
                current = sections.get(currentIndex + 1);
            } else if (direction == 'R') {
                current = sections.get(currentIndex + 1);
            } else if (direction == 'L') {
                current = sections.get(currentIndex - 1);
            }
            currentIndex++;
        } else {    //If wanting to move left and youre at the head
            //TODO: Try to something else here?
            System.out.println("Attempting to move left from head");
        }
    }
}

class TapeSection {
    
    /* @field value, the value of the tapeSection
     * @field index, the index of the tapeSection (where the first section is has a 0 index) */
    private char value;
    private int index;

    /* No default constructor, because every section needs a unique index   */
    public TapeSection(int initIndex){
        this.index = initIndex;
        this.value = 'B';
    }

    //NOTE: dunno if we'll need this
    public TapeSection(int initIndex, char initValue){
        this.index = initIndex;
        this.value = initValue;
    }

    /* Might need a cool little display method  */
    public void display(){
    }

    public char getValue(){ return value; }

    public void setValue(char newValue){ this.value = newValue; }

    public int getIndex(){ return index; }
}
