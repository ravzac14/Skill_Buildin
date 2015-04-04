//Zack Raver
//ravzac14
//
//Testing Lab4A.j's evenOrOdd method

import java.util.Random;

public class TestLab4A{
	public static void main(String[] args) {
		Random randomGen = new Random();
		int number = randomGen.nextInt(100);
		System.out.println(number);
		Lab4A lab = new Lab4A();
		System.out.println(lab.evenOrOdd(number));
	}
}
