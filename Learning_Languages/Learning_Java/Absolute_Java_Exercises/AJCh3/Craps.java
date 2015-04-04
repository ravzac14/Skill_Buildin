/*Zack Raver, ravzac14
 * 4/8/14
 * 
 * Ch.3 #2 from "Absolute Java" by Walter Savitch
 * Simulate 10,000 games of craps. Output the probability of winning (winning/total games) The house always wins
 * How to Craps:
 * Roll two dice, if 7/11 auto-win; if 2,3,12 auto-lose; if 4,5,6,8,9,10 start rolling until either point comes up (win) or 7 comes up (lose)
 */
public class Craps {
	//PROBABILITY_ARRAY.length() = 36 {0...35] Computes the odds associated with rolling two dice
	public static final int[] PROBABILITY_ARRAY = {2,3,3,4,4,4,5,5,5,5,6,6,6,6,6,7,7,7,7,7,7,8,8,8,8,8,9,9,9,9,10,10,10,11,11,12};
	
	public static int roll(){
		int diceroll = 0;
		int a = 0;
		a = (int) (Math.random() * 35);
		diceroll = PROBABILITY_ARRAY[a];
		return diceroll;
	}
	
	public static boolean play(int point){
		int check = 0;
		boolean switcheroo = true;
		
		if ((point == 7) || (point == 11)){								//Winning on the first role
			return true;
		}
		else if ((point == 2) || (point == 3) || (point == 12)){		//Losing on the first role
			return false;
		}
		else {															//Any other first role
			while (switcheroo) {
				check = Craps.roll();
				if ((check == point) || (check == 7)){
					switcheroo = false;
				}
			}
			if (check == point){
				return true;
			}
			else {
				return false;
			}
		}
	}
	
	public static void main(String[] args) {
		int winCount = 0;
		int lossCount = 0;
		boolean winner = true;
		double winProbability = 0;
		
		for (int i = 0; i <= 9999; i++){
			winner = Craps.play(Craps.roll());		//Starts the game with the initial roll
			if (winner == true){
				winCount++;
			}
			else {
				lossCount++;
			}
			
		}
		
		System.out.println("Total wins out of 10,000: " + winCount);
		System.out.println("Total losses out of 10,000: " + lossCount);
		winProbability = (winCount / 10000F) * 100F;
		System.out.printf("Probability of winning: %3.2f percent", winProbability);
	}

}
