/* Zack Raver, ravzac14
 * this belongs to ch.8 #4 from "Absolute Java"
 * Ants: 	Move - Every time step, randomly up/down/left/right. If that cell is the end of the grid or is occupied ant doesn't move
 * 			Breed - If an ant survives for 3 time steps, then at the end of the 3rd time step (after moving) the ant will breed.
 * 						Creates a new ant in an adjacent unoccupied cell. If no-empty, no breed. Has to wait an additional 3 turns to breed regardless.
 */

public class PPAnt extends PPOrganism{

	//Move count dictates when to breed
	public PPAnt(){
		this.moveCount = 0;
		this.image = 'o';
		
		int[] ar1 = PPGrid.getRandomUnoccupied();
		this.xPos = ar1[0];
		this.yPos = ar1[1];
	}
	
	//Used exclusively for breeding
	public PPAnt(int[] coord){
		this.moveCount = 0;
		this.image = 'o';
		
		int[] ar2 = PPGrid.getAdjUnoccupied(coord);
		this.xPos = ar2[0];
		this.yPos = ar2[1];
	}
	
	//Needs to choose a random, unoccupied (unless its an ant), adjacent spot and move to it 
	public void move(int[] coord){
		xPos = coord[0];
		yPos = coord[1];
		moveCount++;
	}
	
	public void checkBreed(){
		if ((moveCount > 0) && (moveCount%3 == 0)){	//Checks to see that the ant isn't new and if it is due to breed
			breed();
		}
	}
	
	public void setTurnLastEaten(int n){
		System.out.println("This shouldnt happen!");
	}
	
	//This should include the logic for choosing a random, unoccupied, adjacent spot and putting the new spider there
	public PPAnt breed(){
		int[] tuple = new int[2];
		tuple[0] = getXPos();
		tuple[1] = getYPos();
		return new PPAnt(tuple); 
	}
	
}
