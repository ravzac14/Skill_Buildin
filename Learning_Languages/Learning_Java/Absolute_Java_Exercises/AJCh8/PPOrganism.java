/* Zack Raver, ravzac14
 * 4/26/14
 * from Ch.8 #4 "Absolute Java" by Walter Savitch
 * Create a predator/prey simulation between ants and spiders. Organism is the super of class Ant/Spider and should include a move method.
 * Ants: 	Move - Every time step, randomly up/down/left/right. If that cell is the end of the grid or is occupied ant doesn't move
 * 			Breed - If an ant survives for 3 time steps, then at the end of the 3rd time step (after moving) the ant will breed.
 * 						Creates a new ant in an adjacent unoccupied cell. If no-empty, no breed. Has to wait an additional 3 turns to breed regardless.
 * Spiders:	Move - Every time step, if an adjacent cell has an ant it moves to that an eats it. Otherwise its random, cannot eat other spiders
 * 			Breed - If a spider survives for 8 steps then at the end it makes a new spider
 * 			Starve - If a spider has not eaten an ant within the last 3 steps(checked at the end of step 3) it will starve and die.
 * 
 * Each turn: spiders move first...20x20 grid...start with 5 spiders and 100 ants
 * 		Prompt to press enter to start each time step. Keep score maybe? Ants/Spiders dead, Ants.Spider born....
 */
public abstract class PPOrganism {

	public int moveCount;
	public char image;
	public int xPos;
	public int yPos;
	
	//Placeholder constructor
	public PPOrganism(){
		this.moveCount = 0;
		this.image = 'n';
		
		int[] ar1 = PPGrid.getRandomUnoccupied();
		this.xPos = ar1[0];
		this.yPos = ar1[1];
	}
	
	//The following methods will be defined differently for spiders and ants
	public abstract void move(int[] coord);
	
	public abstract PPOrganism breed();
	
	public abstract void checkBreed();
	
	public abstract void setTurnLastEaten(int n);
	
	//Getters and setters for moving!
	public int getXPos(){
		return xPos;
	}
	
	public int getYPos(){
		return yPos;
	}
	
	public void setXPos(int newX){
		xPos = newX;
	}
	
	public void setYPos(int newY){
		yPos = newY;
	}
}
