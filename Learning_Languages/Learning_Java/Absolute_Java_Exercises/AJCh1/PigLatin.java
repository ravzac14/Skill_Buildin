/*Zack Raver; ravzac14
 * 4/5/14
 * 
 * Ch.1 #3 From "Absolute Java" by Walter Savitch
 * Given your first and last name as lowercase strings
 * Output the name in Pig Latin, with the first letter cap'd
 * 
 * Pig Latin: Move the first letter to the end of the word and add "ay"
 */

import java.util.Scanner;
import java.util.StringTokenizer;

public class PigLatin {
	
	public static String firstName, lastName, wholeName;
	
	public static String toThePig(String name) {
		String temp1, temp2, temp3;
		
		StringTokenizer punch = new StringTokenizer(name);
		if(punch.countTokens() != 2){
			System.out.println("It looks like you included more or less than your first and last name, please re-run the program.");
			System.exit(0);
		}
		firstName = punch.nextToken().toLowerCase();
		lastName = punch.nextToken().toLowerCase();
		
		temp1 = firstName.substring(0, 1);
		temp2 = firstName.substring(1, 2);
		temp3 = firstName.substring(2);
		firstName = temp2.toUpperCase() + temp3 + temp1 + "ay";
		
		temp1 = lastName.substring(0, 1);
		temp2 = lastName.substring(1, 2);
		temp3 = lastName.substring(2);
		lastName = temp2.toUpperCase() + temp3 + temp1 + "ay";
		
		wholeName = firstName + " " + lastName;
		return wholeName;
	}
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		System.out.println("Input your first and last name!");
		wholeName = s.nextLine();
		System.out.println(PigLatin.toThePig(wholeName));
		s.close();
	}

}
