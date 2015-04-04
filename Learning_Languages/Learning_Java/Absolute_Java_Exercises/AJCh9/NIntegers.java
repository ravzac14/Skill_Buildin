/*Zack Raver; ravzac14
 * 5/15/14
 *
 * From ch.9 #1 in "Absolute Java" by Walter Savitch
 * Find the average of N integers:
 * -prompt the user to enter the value of N (# of ints)
 * -then prompt to ent all the N numbers
 * 		-if non-pos N throw exception (and caught) with a message
 * 		-if there is an exception an error message and the user prompted to enter the #s again
 */

import java.util.Scanner;

public class NIntegers{
	

	public static int ogN = 0;

	public static void setN() throws Exception{
		
		Scanner s1 = new Scanner(System.in);
		System.out.println("How many integers would you like to find the average of? (N)");
		int theN = s1.nextInt();
		if (theN <= 0){
			throw new Exception("N cannot be a non-positive number!");
		}
		NIntegers.ogN = theN;
	}

	public static int[] getNums() throws Exception{

		Scanner s2 = new Scanner(System.in);
		int[] numbers = new int[NIntegers.ogN];
		
		System.out.println("Input each # (they must be positive integers) of your set and hit enter.");
		for (int i = 0; i < NIntegers.ogN; i++){
			numbers[i] = s2.nextInt();
			if (numbers[i] <= 0){
				throw new Exception("Exception: Non-positive number in set!");
			}
		}
		return numbers;

	}

	public static int calcAvg(int[] numbs) throws Exception{
		int sum = 0;
		int avg = 0;
		for (int x : numbs){
			sum += x;
		}
		avg = sum / numbs.length;
		return avg;
	}

	public static void main(String[] args){
		int toBe = 0;
		try{
			NIntegers.setN();
			toBe = NIntegers.calcAvg(NIntegers.getNums());
			System.out.println("The average is: " + toBe);
		}catch (Exception e){
			e.getMessage();
		}finally{
			System.out.println("LATER!");
		}
	}
}
