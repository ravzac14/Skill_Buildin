/*Zack Raver; ravzac14
 * 4/5/14
 * 
 * CH.1 #7 from "Absolute Java" by Walter Savitch
 * Given a time in seconds output the time in Hours.Minutes.Seconds
 * (ie. 50391 seconds is 13 hours 59 minutes and 51 seconds)
 */

import java.util.concurrent.TimeUnit;
import java.util.Scanner;

public class SecondsConverter {

	public static void main(String[] args) {
		Scanner s1 = new Scanner(System.in);
		int x, days;
		long hours, minutes, seconds;
		
		System.out.println("Enter the number of seconds you want to convert!");
		x = s1.nextInt();
		
		days = (int)TimeUnit.SECONDS.toDays(x);        
		hours = TimeUnit.SECONDS.toHours(x) - (days * 24);
		minutes = TimeUnit.SECONDS.toMinutes(x) - (TimeUnit.SECONDS.toHours(x) * 60);
		seconds = TimeUnit.SECONDS.toSeconds(x) - (TimeUnit.SECONDS.toMinutes(x) * 60);
		
		System.out.printf("You gave me %d second(s)...that is equal to\n%d day(s), %d hour(s), %d minute(s) and %d second(s)", x, days, hours, minutes, seconds);
	}

}
