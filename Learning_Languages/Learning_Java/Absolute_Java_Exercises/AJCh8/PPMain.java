/* Zack Raver, ravzac14
 * this belongs to ch.8 #4 from "Absolute Java"
 * This is the main class for the ant/spider package
 */
import java.util.Scanner;

public class PPMain {
	
	public static boolean getInput(){
		Scanner s1 = new Scanner(System.in);
		String inter = s1.next();
		if (inter.equalsIgnoreCase("c")){
			return true;
		} else if (inter.equalsIgnoreCase("n")){
			return false;
		} else {
			System.out.println("Unknown input...Assuming continue!");
			return true;
		}
	}
	
	public static void main(String[] args){
		boolean cont = true;
		int spiderTurn = 1;
		int antTurn = 1;
		int[] coords = new int[2];
		
		
		PPGrid.putWalls();
		PPGrid.putRandom();
		PPGrid.showGrid(PPGrid.makeGrid(PPGrid.a1));
		cont = PPMain.getInput();
		
		while (cont){
			//Does the moves for all the spider
			for (int t=0; t<PPGrid.a1.size(); t++){
				if (PPGrid.a1.get(t) instanceof PPSpider){
					coords[0] = PPGrid.a1.get(t).getXPos();
					coords[1] = PPGrid.a1.get(t).getYPos();
					PPGrid.a1.get(t).move(PPGrid.getAdjUnoccupied(coords));
					PPGrid.a1.get(t).checkBreed();
				} 
			}
			System.out.println("The spider's have taken their turn! (Spider Turn: " + spiderTurn + ")");
			PPGrid.showGrid(PPGrid.makeGrid(PPGrid.a1));
			spiderTurn++;
			cont = PPMain.getInput();
			
			//Does the moves for the ants
			for (int p=0; p<PPGrid.a1.size(); p++){
				if (PPGrid.a1.get(p) instanceof PPAnt){
					coords[0] = PPGrid.a1.get(p).getXPos();
					coords[1] = PPGrid.a1.get(p).getYPos();
					PPGrid.a1.get(p).move(PPGrid.getAdjUnoccupied(coords));
					PPGrid.a1.get(p).checkBreed();
				} 
			}
			System.out.println("The ant's have taken their turn! (Ant Turn: " + antTurn + ")");
			PPGrid.showGrid(PPGrid.makeGrid(PPGrid.a1));
			antTurn++;
			cont = PPMain.getInput();
		}
		 
		 
	}
}
