/*Zack Raver, ravzac14
 * 4/8/14
 * 
 * Ch.3 #8 from "Absolute Java" by Walter Savitch
 * Write a program that takes an assumed cryptarithmetic puzzle as input (SEND + MORE = MONEY)
 * output the answer (ie, S=9 R=8 O=0 M=1 Y=2 E=5 N=6 D=7) if no answer say that
 * Maybe nested loops for each unique letter that try every set of number possibilities and set that to the answer
 * 
 * int foo = Integer.parseInt("1234"); String to primitive int
 */

import java.util.Scanner;

public class CryptarithmeticPuzzle {
	
	public static void solve(String puzzle) {
		String[] broken = puzzle.split(" ");
		
	}
	
	public static void main(String[] args) {
		Scanner s1 = new Scanner(System.in);
		String puzzle;
		
		System.out.println("What is your message?!");
		puzzle = s1.nextLine();
		CryptarithmeticPuzzle.solve(puzzle);
		
		s1.close();
	}

}
