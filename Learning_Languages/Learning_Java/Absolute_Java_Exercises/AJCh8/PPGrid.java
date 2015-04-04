/* Zack Raver, ravzac14
 * this belongs to ch.8 #4 from "Absolute Java"
 * Each turn: spiders move first...20x20 grid...start with 5 spiders and 100 ants
 * 		Prompt to press enter to start each time step. Keep score maybe? Ants/Spiders dead, Ants.Spider born....
 * 
 * 
 * CHANGE THE MAP THEN ADJUST THE ARRAYS...
 * EX. 	step 0: grid is initialized with nulls, add 100 ants and 5 spiders to map
 * 		step 0.5: Adjust grid based on new map
 * 		step 1: spiders take turns, ants take turns (adjust the map as each turn happens
 * 		step 1.5: Adjust array based on new mappings
 *
 * Maybe name the neighbors of each cell(ie nwDiag = grid[n-1][n1]...north = grid[n-1][n]...etc
 */

import java.util.ArrayList;

public class PPGrid {

	//Use an ArrayList to store the spiders/ants/walls(get, remove, add(element), add(index, element), clear, set(index, element) == replaces an element with..., 
	public static ArrayList<PPOrganism> a1 = new ArrayList<PPOrganism>();
	
	public static void putRandom(){
		int spiders = 5;
		int ants = 100;
		
		//Adding the spiders first makes it easier for them to move first
		for (int s = 0; s < spiders; s++){
			a1.add(new PPSpider());
		}
		for (int a = 0; a < ants; a++){
			a1.add(new PPAnt());
		}
	}
	
	//This guy adds the walls to the ArrayList
	public static void putWalls(){
		int min = 0;
		int max = 21;
		
		for (int a = 0; a <= max; a++){
			a1.add(new PPWall(min,a));
			a1.add(new PPWall(a,min));
			a1.add(new PPWall(max,a));
			a1.add(new PPWall(a,max));
		}
	}
	
	//Makes the grid from the ArrayList
	public static char[][] makeGrid(ArrayList<PPOrganism> ard){
		char[][] grid = new char[22][22]; 	//Hard-coded 22x22 grid
		
		for (int i = 0; i < 22; i++){			//Got to change the grid size here 
			for (int k = 0; k < 22; k++){		//and here too
				
				grid[i][k] = '.';										//BLANK SPOTS ON GRID ARE A '.'
				for (int r = 0; r < ard.size(); r++){
					if ((ard.get(r).getXPos() == i) && (ard.get(r).getYPos() == k)){
						grid[i][k] = ard.get(r).image;
					}
				}
			}
		} 
		System.out.println("Made a new grid!");
		return grid;
	}
	
	//To test if that spot is available to move to(for an ant) or to create a new organism for the first grid
	public static boolean isUnoccupied(int x, int y){
		for (int t = 0; t < a1.size(); t++){
			if ((x == a1.get(t).getXPos()) && (y == a1.get(t).getYPos())){
				return false;
			}
		}
		return true;
	}

	
	public static int[] getRandomUnoccupied(){
		boolean flip = false;
		int[] tuple = new int[2];		//I'm using this small array as a tuple to carry the use-able coordinate
		
		while (flip == false){
			tuple[0] = (int)(Math.random() * 21);
			tuple[1] = (int)(Math.random() * 21);
			if (PPGrid.isUnoccupied(tuple[0], tuple[1])){
				flip = true;
			}
		}
		return tuple;
	}
	
	//Just a shortcut method (for extracting the PPOrganism with certain coordinates from the ArrayList) so I don't have to type so much...
	public static PPOrganism tupleToOrganism(int[] tuple){
		PPOrganism theOne = null;
		for (int y = 0; y < PPGrid.a1.size(); y++){				
			if ((PPGrid.a1.get(y).getXPos() == tuple[0]) && (PPGrid.a1.get(y).getYPos() == tuple[1])){
				theOne = PPGrid.a1.get(y);
				return theOne;
			}
		}
		return theOne;
	}
	
	public static int tupleToIndex(int[] tuple){
		int newIndex = 0;
		for (int y = 0; y < PPGrid.a1.size(); y++){				
			if ((PPGrid.a1.get(y).getXPos() == tuple[0]) && (PPGrid.a1.get(y).getYPos() == tuple[1])){
				newIndex = y;
				return newIndex;
			}
		}
		return newIndex;
	}
	
	//Checks for adjacent unoccupied but also if the spot is occupied by an eatable ant..sets turn last eaten to the current move (+1 because it hasn't been inc'd yet), and kills the ant
	public static int[] getAdjUnoccupied(int[] coords){
		boolean flip = false;
		int[] tuple = new int[2];
		
		while (flip == false){
			int rand = (int)(Math.random() * 7) + 1;
			switch (rand) {
			case 1:		tuple[0] = coords[0] - 1; 
						tuple[1] = coords[1] + 1;
						if ((PPGrid.tupleToOrganism(coords) instanceof PPSpider) && (PPGrid.tupleToOrganism(tuple) instanceof PPAnt)){
							a1.remove(PPGrid.tupleToIndex(tuple));
							PPGrid.tupleToOrganism(coords).setTurnLastEaten(PPGrid.tupleToOrganism(coords).moveCount + 1);			//Set to moveCount + 1 because moveCount hasn't been inc'd yet this turn
							flip = true;
						} else if (PPGrid.isUnoccupied((coords[0] - 1), (coords[1] + 1))){
							flip = true;																			//NW
						}
						break;
			
			case 2:		tuple[0] = coords[0]; 
						tuple[1] = coords[1] + 1;
						if ((PPGrid.tupleToOrganism(coords) instanceof PPSpider) && (PPGrid.tupleToOrganism(tuple) instanceof PPAnt)){
							a1.remove(PPGrid.tupleToIndex(tuple));
							PPGrid.tupleToOrganism(coords).setTurnLastEaten(PPGrid.tupleToOrganism(coords).moveCount + 1);			//Set to moveCount + 1 because moveCount hasn't been inc'd yet this turn
							flip = true;
						} else if (PPGrid.isUnoccupied(coords[0], (coords[1] + 1))){
							flip = true;																	//N
						}
						break;
			
			case 3:		tuple[0] = coords[0] + 1; 
						tuple[1] = coords[1] + 1;
						if ((PPGrid.tupleToOrganism(coords) instanceof PPSpider) && (PPGrid.tupleToOrganism(tuple) instanceof PPAnt)){
							a1.remove(PPGrid.tupleToIndex(tuple));
							PPGrid.tupleToOrganism(coords).setTurnLastEaten(PPGrid.tupleToOrganism(coords).moveCount + 1);			//Set to moveCount + 1 because moveCount hasn't been inc'd yet this turn
							flip = true;
						} else if (PPGrid.isUnoccupied((coords[0] + 1), (coords[1] + 1))){
							flip = true;																	//NE
						}
						break;
			
			case 4:		tuple[0] = coords[0] + 1; 
						tuple[1] = coords[1];
						if ((PPGrid.tupleToOrganism(coords) instanceof PPSpider) && (PPGrid.tupleToOrganism(tuple) instanceof PPAnt)){
							a1.remove(PPGrid.tupleToIndex(tuple));
							PPGrid.tupleToOrganism(coords).setTurnLastEaten(PPGrid.tupleToOrganism(coords).moveCount + 1);			//Set to moveCount + 1 because moveCount hasn't been inc'd yet this turn
							flip = true;
						} else if (PPGrid.isUnoccupied((coords[0] + 1), coords[1])){
							flip = true;																	//E
						}
						break;
			
			case 5:		tuple[0] = coords[0] + 1; 
						tuple[1] = coords[1] - 1;
						if ((PPGrid.tupleToOrganism(coords) instanceof PPSpider) && (PPGrid.tupleToOrganism(tuple) instanceof PPAnt)){
							a1.remove(PPGrid.tupleToIndex(tuple));
							PPGrid.tupleToOrganism(coords).setTurnLastEaten(PPGrid.tupleToOrganism(coords).moveCount + 1);			//Set to moveCount + 1 because moveCount hasn't been inc'd yet this turn
							flip = true;
						} else if (PPGrid.isUnoccupied((coords[0] + 1), (coords[1] - 1))){
							flip = true;																	//SE
						}
						break;
			
			case 6:		tuple[0] = coords[0]; 
						tuple[1] = coords[1] - 1;
						if ((PPGrid.tupleToOrganism(coords) instanceof PPSpider) && (PPGrid.tupleToOrganism(tuple) instanceof PPAnt)){
							a1.remove(PPGrid.tupleToIndex(tuple));
							PPGrid.tupleToOrganism(coords).setTurnLastEaten(PPGrid.tupleToOrganism(coords).moveCount + 1);			//Set to moveCount + 1 because moveCount hasn't been inc'd yet this turn
							flip = true;
						} else if (PPGrid.isUnoccupied(coords[0], (coords[1] - 1))){
							flip = true;																	//S
						}
						break;
			
			case 7:		tuple[0] = coords[0] - 1; 
						tuple[1] = coords[1] - 1;
						if ((PPGrid.tupleToOrganism(coords) instanceof PPSpider) && (PPGrid.tupleToOrganism(tuple) instanceof PPAnt)){
							a1.remove(PPGrid.tupleToIndex(tuple));
							PPGrid.tupleToOrganism(coords).setTurnLastEaten(PPGrid.tupleToOrganism(coords).moveCount + 1);			//Set to moveCount + 1 because moveCount hasn't been inc'd yet this turn
							flip = true;
						} else if (PPGrid.isUnoccupied((coords[0] - 1), (coords[1] - 1))){
							flip = true;																	//SW
						}
						break;
			
			case 8:		tuple[0] = coords[0] - 1; 
						tuple[1] = coords[1];
						if ((PPGrid.tupleToOrganism(coords) instanceof PPSpider) && (PPGrid.tupleToOrganism(tuple) instanceof PPAnt)){
							a1.remove(PPGrid.tupleToIndex(tuple));
							PPGrid.tupleToOrganism(coords).setTurnLastEaten(PPGrid.tupleToOrganism(coords).moveCount + 1);			//Set to moveCount + 1 because moveCount hasn't been inc'd yet this turn
							flip = true;
						} else if (PPGrid.isUnoccupied((coords[0] - 1), coords[1])){
							flip = true;																							//W
						}
						break;
			
			default:	System.out.println("Invalid spot.");
						break;
			}
			
			//Checking for NO unoccupied, adjacent spots			
			boolean trick = (PPGrid.isUnoccupied((coords[0] - 1), (coords[1] + 1)) == false && (PPGrid.isUnoccupied(coords[0], (coords[1] + 1)) == false) && 
							(PPGrid.isUnoccupied((coords[0] + 1), (coords[1] + 1)) == false) && (PPGrid.isUnoccupied((coords[0] + 1), coords[1]) == false) && 
							(PPGrid.isUnoccupied((coords[0] + 1), (coords[1] - 1)) == false) && (PPGrid.isUnoccupied(coords[0], (coords[1] - 1)) == false) && 
							(PPGrid.isUnoccupied((coords[0] - 1), (coords[1] - 1)) == false) && (PPGrid.isUnoccupied((coords[0] - 1), coords[1]) == false));
			
			//if none, returns the current spot (just to replace the current thing, with a similarly typed thing, I dont care if the # resets)
			if (trick){
				tuple[0] = coords[0];
				tuple[1] = coords[1];
				flip = true;
			}
		}
		return tuple;
	}

	
	//Just prints the grid
	public static void showGrid(char[][] grid){
		for (int i = 0; i < 22; i++){			//Got to change the grid size here 
			for (int k = 0; k < 22; k++){		//and here too
				System.out.print(grid[i][k]);
			}
			System.out.println();
		}
		System.out.println("Enter \'c\' to continue to the next cycle!\nEnter \'n\' to quit the program after the current cycle completes!");
	}
}
