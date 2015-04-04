/*Zack Raver; ravzac14
 * 4/6/15
 * 
 * Ch.2 #4 from "Absolute Java" by Walter Savitch
 * Given distance of commute, fuel consumption rate(mpg), and price of gas per gallon
 * Output cost of commute
 */
public class CommuteCost {
	
	public static void computeCost(int distance, float mpg, float gasPrice){
		float commuteCost = 0;
		commuteCost = (distance / mpg) * gasPrice;
		System.out.printf("Your commute cost given %d miles, %4.2f average mpg and %2.2f dollars per gallon of gas is %5.2f earth dollars\n", distance, mpg, gasPrice, commuteCost);
		System.out.println("For an additional 500 miles, double that but add LOVE!");
	}
	
	public static void main(String[] args) {
		int distance = 500;
		float mpg = 20.5F;
		float gasPrice = 4.99F;
		
		CommuteCost.computeCost(distance, mpg, gasPrice);
	}

}
