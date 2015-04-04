/*Zack Raver, ravzac14
 * 4/5/14
 * 
 * Ch.1 #6 from "Absolute Java" by Walter Savitch
 * Calculate the bike speed given gear size and pedal cadence
 * Formula: Speed(mph) = gearSize(inches) * PI * (1(ft) / 12(inches)) * (1(mile) / 5280(ft)) * cadence(rpm) * (60(minutes) / 1(hour))
 */
//import java.math.*;

import java.util.Scanner;

public class BikeSpeed {
	
	public static float findSpeed(int gearSize, int cadence) {
		float speed;
		
		speed = (float)gearSize * (float)Math.PI * (1/12) * (1/5280) * (float)cadence * 60;
		return speed;
	}
	
	public static void main(String[] args) {
		int gearSize, cadence;
		Scanner s = new Scanner(System.in);
		
		System.out.println("Enter your bike's gear size and the average cadence at which you pedal (in rpm's) and I will output your average speed!");
		System.out.println("Enter your bike's gear size (in inches):");
		gearSize = s.nextInt();
		System.out.println("Enter the average cadence at which you pedal (in rpm's):");
		cadence = s.nextInt();
		
		System.out.printf("Your average speed in mph is %5.5f", BikeSpeed.findSpeed(gearSize, cadence));
		s.close();
	}

}
