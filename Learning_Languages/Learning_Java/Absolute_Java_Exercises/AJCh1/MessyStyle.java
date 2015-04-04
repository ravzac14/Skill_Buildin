/*Zack Raver; ravzac14
 * 4/5/14
 * 
 * Ch.1 #8 from "Absolute Java" by Walter Savitch
 * Modify the code below to use better programming style
 * keep in mind spelling conventions, constant-naming convention, and formatting style
 */

public class MessyStyle {
	
	//Instance variables
	public static double time; 
	public static double pace;
	public static final double distance = 6.21;
	
	public static void main(String[] args) {
		System.out.println("This program calculates your pace  given a time and a distance traveled.");
		time = 35.5; //35 minutes and 30 seconds
		pace = time / distance;
		System.out.println("Your pace is " + pace + " miles per hour.");
	}
}
