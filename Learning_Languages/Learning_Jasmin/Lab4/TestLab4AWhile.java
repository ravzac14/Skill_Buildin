//Zack Raver
//ravzac14
//
//Testing Lab4B.j's evOddWhile method

import java.util.Random;

public class TestLab4AWhile{
	public static void main(String[] args) {
		Random randomGen = new Random();
		int number = randomGen.nextInt(100);
		System.out.println(number);
		Lab4AWhileLoop lab = new Lab4AWhileLoop();
		System.out.println(lab.evOddWhile(number));
	}
}
