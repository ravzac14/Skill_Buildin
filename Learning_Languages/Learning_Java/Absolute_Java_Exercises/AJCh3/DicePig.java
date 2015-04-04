/*Zack Raver, ravzac14
 * 4/8/14
 * 
 * Ch.3 #10 from "Absolute Java" by Walter Savitch
 * Simulate a game of pig with Player vs. AI (Also 1000 games just for probability) 
 * Rules: If the roller rolls 1, then they get no points and it is the opponents turn
 * 		  If the roller rolls 2 thru 6, They can either:
 * 			Roll again or
 * 			Hold at this point the sum of all rolls is added to the player's score and it becomes the opponents turn
 * Humans turn: Show the score of both players and the previous roll.
 * 				Allow the human to input "r" to roll and "h" to hold
 * AI turn: Keep rolling until it has accumulated 20 or more points, then hold. If the computer wins or rolls a "1" then the turn ends
 * int diceroll = (int) (Math.random() * 6) + 1;
 */
import java.util.Scanner;

public class DicePig {
	
	//Simulates a dice roll for 1-6
	
	public static int roll(){
		int diceroll =  (int)(Math.random() * 6) + 1;
		return diceroll;
	}
	
	//This method checks to see if the player wants to hold or roll
	//Will return true of hold, false if roll
	
	public static boolean hold() {
		String answer;
		Scanner s1 = new Scanner(System.in);
		System.out.println("Would you like to hold(enter \'h\') or roll again(enter \'r\')?");
		answer = s1.next();

		if (answer.equalsIgnoreCase("h")) {
			return true;
		}
		else {
			return false;
		}
	}
	
	//Deals with the rules of the player's turn
	
	public static int playerTurn() {
		boolean hold = false;
		int playerRoll;
		int tempScore = 0;
		
		playerRoll = DicePig.roll();
		System.out.println("You rolled a " + playerRoll + "!");
		if (playerRoll == 1 ) {
			System.out.println("Because you rolled a 1, you lost your turn!");
			return 0;
		} 
		else {
			tempScore += playerRoll;
			System.out.println("Your rolls have yielded you " + tempScore + " so far...");
			hold = DicePig.hold();
			if (hold) {
				return tempScore;
			}
			else {
				tempScore += DicePig.playerTurn();
			}
		}
		return tempScore;	//Should never get to this one...but if it does it will kick out whatever the score is then
	}
	
	//Deals with the rules of the AI's turn
	//AI turn: Keep rolling until it has accumulated 20 or more points, then hold. If the computer wins or rolls a "1" then the turn ends
	public static int aiTurn(){
		int aiRoll;
		int tempScore = 0;
		
		aiRoll = DicePig.roll();
		System.out.println("Pig rolled a " + aiRoll + "!");
		if (aiRoll == 1) {
			System.out.println("Aw pig rolled a 1 and lost his turn!");
			return tempScore;
		}
		else {
			tempScore += aiRoll;
			if (tempScore >= 20) {
				System.out.println("Pig's current roll scor is " + tempScore + " and pig will hold. Your turn!");
				return tempScore;
			}
			else {
				tempScore += DicePig.aiTurn();
				System.out.println("Pig's current roll score is " + tempScore + " and pig will roll again!");
			}
		}
		return tempScore;		//Should never get to this one...but if it does it will kick out whatever the score is then
	}
	
	public static void main(String[] args) {
		Scanner s2 = new Scanner(System.in);
		int playerScore = 0;
		int aiScore = 0;
		int playerRoll, aiRoll;
		
		System.out.println("Welcome to the game of Pig!\n\nPig is a dice rolling game where your rolls all add up...\nYou will be playing against Pig, the pig champion...First to 100 wins");
		System.out.println("Rules:\nOn your turn you will roll, if it is a 1 you will not add anything to your score and your turn will end.\nIf it is a 2-6 you can opt to either HOLD [\'h\'](adding the sum of your previous dice rolls to your overall score and ending your turn) \nor ROLL [\'r\'] (and try to get a higher roll score)!\n\n");
		System.out.print("We will start by rolling for you and pig, the higher roll will start first, Type start and hit enter to start the game!\n\n");
		String taco = s2.next(); //Just to halt the program 

		playerRoll = DicePig.roll();
		System.out.println("You rolled a " + playerRoll + "!");
		aiRoll = DicePig.roll();
		System.out.println("Pig rolled a " + aiRoll + "!");
		
		if (playerRoll >= aiRoll){
			System.out.println("Congratulations, you get first roll!");
			do {
				playerScore += DicePig.playerTurn();
				System.out.println("Your score is now: " + playerScore + "\n");
				aiScore += DicePig.aiTurn();
				System.out.println("Pig's score is now: " + aiScore + "\n");
			} while ((playerScore < 100) && (aiScore < 100));
		}
		else {
			System.out.println("You get second roll!");
			do {
				aiScore += DicePig.aiTurn();
				System.out.println("Pig's score is now: " + aiScore + "\n");
				playerScore += DicePig.playerTurn();
				System.out.println("Your score is now: " + playerScore + "\n");
			} while ((playerScore < 100) && (aiScore < 100));
		}
		if (playerScore >= 100){
			System.out.println("Congratulations you won! That will show who is top pig!");
		}
		else {
			System.out.println("You lost! Pig feels like a pig among guinea pigs! (\"I think we know whose in charge here\")");
		}
	}
}
