/*Zack Raver, ravzac14
 * 4/8/14
 * 
 * Ch.3 #3 from "Absolute Java" by Walter Savitch
 * heightKid(for MaleKid) = ((heightMom * (13/12) + heightDad) /2)
 * heightKid(for FemaleKid) = ((heightMom * (12/13) + heightDad) /2)
 * Given genderKid, heightMom, heightDad as input in Feet and Inches output the computed child's height
 */
import java.util.Scanner;

public class ChildHeight {
	
	public static void main(String[] args) {
		Scanner s1 = new Scanner(System.in);
		String genderKid;
		int momFt, dadFt, momIn, dadIn;
		int kidIn = 0;
		int kidFt = 0;
		
		System.out.println("Enter the gender of you child (m or f), followed by the father's height (ie. 5 6 for 5 foot 6 inches), followed by the mother's height\n");
		genderKid = s1.next();
		dadFt = s1.nextInt();
		dadIn = s1.nextInt();
		momFt = s1.nextInt();
		momIn = s1.nextInt();
		
		dadIn += dadFt * 12;
		momIn += momFt * 12;
		
		if (genderKid.equals("m")){
			kidIn = (int)(((momIn * (13/12)) + dadIn) / 2);
			kidFt = (((kidIn) - (kidIn%12))/12);
			kidIn = kidIn%12;
		} 
		else {
			kidIn = (int)(((dadIn * (13/12)) + momIn) / 2);
			kidFt = (((kidIn) - (kidIn%12))/12);
			kidIn = kidIn%12;
		}
		System.out.println("\nYour child is expected to be " + kidFt + "\' " + kidIn + "\" tall! Congrats on a freak!");
		s1.close();
	}

}
