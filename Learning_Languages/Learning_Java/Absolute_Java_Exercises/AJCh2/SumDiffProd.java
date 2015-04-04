/*Zack Raver; ravzac14
 * 4/6/15
 * 
 * Ch.2 #3 from "Absolute Java" by Walter Savitch
 * Given 2 #s as input, output their Sum, Difference and Product
 */
import java.util.Scanner;

public class SumDiffProd {

	public static void sum(int x, int y){
		int sum = 0;
		sum = x + y;
		System.out.printf("The sum of %d and %d is %d\n", x, y, sum);
	}
	
	public static void difference(int x, int y){
		int diff = 0;
		diff = x - y;
		System.out.printf("The difference of %d and %d is %d\n", x, y, diff);
	}
	
	public static void product(int x, int y){
		int prod = 0;
		prod = x * y;
		System.out.printf("The product of %d and %d is %d\n", x, y, prod);
	}
	
	public static void main(String[] args) {
		Scanner s1 = new Scanner(System.in);
		int x, y;
		
		System.out.println("Gimme to integers tough guy! Hit enter after inputting each number");
		x = s1.nextInt();
		y = s1.nextInt();
		SumDiffProd.sum(x, y);
		SumDiffProd.difference(x, y);
		SumDiffProd.product(x, y);
		
		s1.close();
	}
	

}
