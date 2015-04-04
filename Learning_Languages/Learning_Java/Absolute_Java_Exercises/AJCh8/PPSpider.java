/* Zack Raver, ravzac14
 * this belongs to ch.8 #4 from "Absolute Java"
 * Spiders:	Move - Every time step, if an adjacent cell has an ant it moves to that an eats it. Otherwise its random, cannot eat other spiders
 * 			Breed - If a spider survives for 8 steps then at the end it makes a new spider
 * 			Starve - If a spider has not eaten an ant within the last 3 steps(checked at the end of step 3) it will starve and die.

 */
public class PPSpider extends PPOrganism{

	public int turnLastEaten;
	
	//Move count dictates when to breed and starve
	public PPSpider(){
		this.moveCount = 0;
		this.turnLastEaten = 0;
		this.image = 'X';
		
		int[] ar1 = PPGrid.getRandomUnoccupied();
		this.xPos = ar1[0];
		this.yPos = ar1[1];
	}
	
	//Used exclusively for breeding
	public PPSpider(int[] coord){
		this.moveCount = 0;
		this.turnLastEaten = 0;
		this.image = 'X';
		
		int[] ar2 = PPGrid.getAdjUnoccupied(coord);
		this.xPos = ar2[0];
		this.yPos = ar2[1];
	}
	
	public int getTurnLastEaten(){
		return turnLastEaten;
	}

	public void setTurnLastEaten(int newTurn){
		turnLastEaten = newTurn;
	}
	
	public void checkBreed(){							//And check for starve...in the spiders case
		if ((moveCount > 0) && (moveCount%8 == 0)){					//Checks to see that the spider isn't new and if it is due to breed
			breed();
		}
		if ((moveCount > 0) && ((moveCount - turnLastEaten) >= 3)){	//Checks to see that a spider isn't new and should starve
			for (int y = 0; y < PPGrid.a1.size(); y++){				//Has to find itself in the arrayList to remove itself (starve)
				if ((PPGrid.a1.get(y).getXPos() == xPos) && (PPGrid.a1.get(y).getYPos() == yPos)){
					PPGrid.a1.remove(y);
				}
			}
		}
	}
	
	//Needs to choose a random, unoccupied (unless its an ant), adjacent spot and move to it 
	public void move(int[] coord){
		xPos = coord[0];
		yPos = coord[1];
		moveCount++;
	}
	
	//This should include the logic for choosing a random, unoccupied, adjacent spot and putting the new spider there
	public PPSpider breed(){
		int[] tuple = new int[2];
		tuple[0] = getXPos();
		tuple[1] = getYPos();
		
		return new PPSpider(tuple); 
	}
	
}
