/*Zack Raver, ravzac14
 * 5/22/14
 * from Ch.10 #4 in "Absolute Java" by Walter Savitch
 * Read doubles from a text file (one double per line) and compute (and output) the average and the standard deviation
 * it may help to read the entire file, compute the avg, close the file, and reopen for the stan dev.
 * Standard deviation (for N1, n2, and n3): (n1 - avg)**2, (n2 - avg)**2, (n3 - avg)**2
 * 
 * Do the same, but make a binary file (and then search that)
 */
import java.io.*;
import java.util.Scanner;

public class AvgAndStanDev {

	public static final double[] tehNumbs = {15.45D, 12.36D, 1.27D, 450.24D, 23,67D, 12.00D, 32.53D};
	public static double average = 0.0D;
	public static double newAverage = 0.0D;
	
	//This method creates a human-readable text file with each of the doubles on a new line
	public static void makeText(double[] numbers){
		PrintWriter outStream = null;
		try {
			outStream = new PrintWriter(new FileOutputStream("textFile.txt"));
		} catch(FileNotFoundException e){
			System.out.println("Error opening the file");
			System.exit(0);
		}
		for (double x : AvgAndStanDev.tehNumbs){
			outStream.println(x);
		}
		System.out.println("Text File Created");
		outStream.close();		//Important to close so that we can re-open later
	}
	
	//These guys open up the text file (of double  #s)
	public static void computeAvgText(){
		Scanner textIn = null;
		double sum = 0;
		int totalNums = 0;
		
		try {
			textIn = new Scanner(new FileInputStream("textFile.txt"));
		} catch (FileNotFoundException e){
			System.out.println("Error finding or opening txt file");
			System.exit(0);
		}
		
		//Loop reads until the end of the file
		while (textIn.hasNext()){
			sum += (Double.parseDouble(textIn.nextLine()));
			totalNums++;
		}
		average = (sum / (double)totalNums);
		System.out.println("The average of the numbers in that file is: " + average);
		textIn.close();
	}
	
	//Standard deviation (for N1, n2, and n3): (n1 - avg)**2, (n2 - avg)**2, (n3 - avg)**2
	public static void standardDeviationText(){
		Scanner textIn2 = null;
		double temp = 0.0D;
		
		try {
			textIn2 = new Scanner(new FileInputStream("textFile.txt"));
		} catch (FileNotFoundException e){
			System.out.println("Error finding or opening txt file");
			System.exit(0);
		}
		
		//Loop reads until the end of the file
		while (textIn2.hasNext()){
			temp = Double.parseDouble((textIn2.nextLine()));
			System.out.printf("The standard deviation of %3.2f from the set is %f\n", temp, Math.pow((temp - average), 2.0D));
		}
		textIn2.close();
	}

	//This creates a binary file from the text file ("textFile.txt")
	public static void textToBinary(){
		Scanner textIn3 = null;
		ObjectOutputStream binOut = null;
		
		try {
			textIn3 = new Scanner(new FileInputStream("textFile.txt"));
			binOut = new ObjectOutputStream(new FileOutputStream("binFile.dat"));
		} catch (FileNotFoundException e){
			System.out.println("Error finding or opening txt file");
			System.exit(0);
		} catch (IOException f){
			System.out.println("Error making bin file");
			System.exit(0);
		}
		
		//Loop reads until the end of the file
		while (textIn3.hasNext()){
			try {
				binOut.writeDouble(Double.parseDouble(textIn3.nextLine()));
			} catch (IOException e) {
				System.out.println("Error closing bin file");
				System.exit(0);
			}
		}
		textIn3.close();
		try {
			binOut.close();
		} catch (IOException e) {
			System.out.println("Error closing bin file");
			System.exit(0);
		}
		System.out.println("Binary File Created from Text File");
	}
	
	
	public static void computeAvgBinary(){
		ObjectInputStream binIn = null;
		double newSum = 0.0D;
		int newCount = 0;
		
		try {
			binIn = new ObjectInputStream(new FileInputStream("binFile.dat"));
		} catch (IOException e){
			System.out.println("Error opening bin file");
			System.exit(0);
		}
		
		//EOFException reads until the end of the file
		try {
			while (true){		//Not infinite because EOFException thrown at the end of the file
				newSum += binIn.readDouble();
				newCount++;
			}
		} catch (EOFException f) { 
			newAverage = (newSum / (double)newCount);
			System.out.println("The average of the set from the binary file is: " + newAverage);
		} catch (IOException e) {
			System.out.println("Error closing bin file");
			System.exit(0);
		}

		try {
			binIn.close();
		} catch (IOException e) {
			System.out.println("Error closing bin file");
			System.exit(0);
		}
	}
	
	public static void standardDeviationBinary(){
		ObjectInputStream binIn2 = null;
		double temp = 0.0D;
		
		try {
			binIn2 = new ObjectInputStream(new FileInputStream("binFile.dat"));
		} catch (IOException e){
			System.out.println("Error opening bin file");
			System.exit(0);
		}
		
		//EOFException reads until the end of the file
		try {
			while (true){		//Not infinite because EOFException thrown at the end of the file
				temp = binIn2.readDouble();
				System.out.printf("The standard deviation of %3.2f from the bin set is %f\n", temp, Math.pow((temp - newAverage), 2.0D));
			}
		} catch (EOFException f) { 
			System.out.println("End program");
		} catch (IOException e) {
			System.out.println("Error closing bin file");
			System.exit(0);
		}

		try {
			binIn2.close();
		} catch (IOException e) {
			System.out.println("Error closing bin file");
			System.exit(0);
		}
	}
	
	public static void main(String[] args) {

		AvgAndStanDev.makeText(tehNumbs);
		AvgAndStanDev.computeAvgText();
		AvgAndStanDev.standardDeviationText();
		AvgAndStanDev.textToBinary();
		AvgAndStanDev.computeAvgBinary();
		AvgAndStanDev.standardDeviationBinary();
	}

}
