/*Zack Raver; ravzac14
 * 4/6/15
 * 
 * Ch.2 #1 from "Absolute Java" by Walter Savitch
 * Implement the babylonian algorithm to compute the square root
 * 1. Make a guess at the square root of n
 * 2. Compute r = n / guess
 * 3. Set guess = (guess + r) / 2
 * 4. Go back to step 2 from as many iterations as necessary. The more you repeat the closer guess comes to sr.rt(n)
 */
import java.lang.Math;
import java.util.Scanner;

public class BabylonianAlgorithm {
	
	public static void main(String[] args) {
		Scanner s1 = new Scanner(System.in);
		int iterations = 0;
		double guess, actual;
		double r = 0;
		
		
		System.out.println("Make a guess for the square root of 42, I'll tell you how close you were while computing the Babylonian algorithm.\n(Hint: An easy guess is n/2)");
		guess = s1.nextDouble();
		if (guess <= 0){
			System.out.println("Not An Allowable Square Root!");
			System.exit(0);
		}
		
		actual = Math.sqrt(42);
		while ((guess <= (actual - .0001)) || (guess >= (actual + .0001))){
			r = 42 / guess;
			guess = (guess + r) / 2;
			iterations++;
		}
		System.out.println("The actual was " + actual);
		System.out.println("It took " + iterations + " of the Babylonian algorithm to get your guess to " + guess);
		s1.close();
	}

}
