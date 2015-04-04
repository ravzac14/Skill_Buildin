import java.util.Scanner;

public class AsciiArt {

	static void makeOwl(){
	
		System.out.println("   /|ooooo|\\");
		System.out.println("  / |OOOOO| \\");
		System.out.println(" |'''''''''''|");
		System.out.println(" (  .)OOO(. ):");
		System.out.println(" ::  \\  /  ::");
		System.out.println(" ::   \\/   ::");
		
		for( int i = 0; i < 3; i++){
			System.out.println("::          ::");
		}
		System.out.println(" :...:::...:");
		System.out.println("  ==    ==");
	}

	static void makeRocket(int height){

		String baseString = "";
		//Nose builder for-loop
 		for (int i = 1; i < height; i++){
		//Whitespace before
			for (int j = 1; j <= (height - i); j++){
				baseString += " ";
			}
		//Slants 1st
			for (int j = 1; j <= i; j++){
				baseString += "/";
			}
		//Stars always two
			for (int j = 0; j < 2; j++){
				baseString += "*";
			}
		//Slants 2nd
			for (int j = 1; j <= i; j++){
				baseString += "\\";
			}
		if (i < (height - 1)){baseString += "\n";
		}
		}
		System.out.println(baseString);	

		//Body builder for-loop
		for (int i = 1; i <= (height/3); i++){
			System.out.println("+=*=*=*=*=*=*+");
			System.out.println("|../\\..../\\..|");
			System.out.println("|./\\/\\../\\/\\.|");
			System.out.println("|/\\/\\/\\/\\/\\/\\|");
			System.out.println("|\\/\\/\\/\\/\\/\\/|");
			System.out.println("|.\\/\\/..\\/\\/.|");
			System.out.println("|..\\/....\\/..|");
		}	
		System.out.println("+=*=*=*=*=*=*+");
		System.out.println(baseString);

	}	
	
	public static void main(String[] args){
		System.out.println("Part A: ");
		AsciiArt.makeOwl();
		System.out.println("Enter the base height for the rocket ship");
		Scanner kBoard = new Scanner(System.in);
		int height = kBoard.nextInt();
		AsciiArt.makeRocket(height);
	}
}
