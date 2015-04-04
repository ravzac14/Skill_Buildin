/*Zack Raver; ravzac14
 * 4/4/14
 * 
 * Ch.1 Programming Problem #2 from "Absolute Java" by Walter Savitch
 * You have earned x amount of coupons at the local arcade. You can use them to get either candy bars (10 coupons) or gum balls (3 coupons).
 * Print out how many candy bars and gum balls you can get with x coupons
 */

import java.util.Scanner; //For input

public class ArcadeCoupons {
	//Value in coupons
	public static final int candyBar = 10;
	public static final int gumBall = 3;
	
	public static void main(String[] args) {
		Scanner s1 = new Scanner(System.in);
		int x;
		int numGum = 0;
		int numCandy = 0;
		
		System.out.println("Enter the number of coupons you earned!");
		x = s1.nextInt();
		
		while  ( x >= candyBar){
			x -= candyBar;
			numCandy++;
		}
		while (x >= gumBall){
			x -= gumBall;
			numGum++;
		}
		
		System.out.printf("Assuming you prefer Candy Bars to Gum Balls you could get: %d Candy Bar(s) and %d Gum Ball(s) and have %d Coupon(s) left over!", numCandy, numGum, x);
	}

}
