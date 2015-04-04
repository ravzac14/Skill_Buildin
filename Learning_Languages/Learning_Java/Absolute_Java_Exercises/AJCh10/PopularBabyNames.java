/*Zack Raver, ravzac14
 * 5/22/14
 * from Ch.10 #1 in "Absolute Java" by Walter Savitch
 * Write a program that reads in girlnames.txt and boynames.txt (1000 most popular names of each gender in 2003)
 * Store the data (each line looks like: "Hanna" 120000) in an array and prompt for user input for a name, search both files and output either:
 * "NAME is ranked xxx in popularity among boys/girls w/ xxxxxxx namings"
 * or
 * "NAME is not ranked amount the top 1000 boys/girls names"
 * 
 * pathname: "C:/Users/Zack R/Desktop/AbsJava_Source_Code_4e/Source_Code_4e/ch10/girlnames.txt"
 */

import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;

public class PopularBabyNames {

	//These buddies will contain the data for each line per index (ie. Michelle and 32000 will be in the same index of the corresponding arrays)
	public static ArrayList<String> girlNames = new ArrayList<String>();
	public static ArrayList<String> boyNames = new ArrayList<String>();
	public static ArrayList<Integer> girlNumbers = new ArrayList<Integer>();
	public static ArrayList<Integer> boyNumbers = new ArrayList<Integer>();
	
	//This will use the two files to fill up the arrays
	public static void fillArrays(){
		Scanner boyIn = null;
		Scanner girlIn = null;
		String lineHolder = "";		//Holds the temporary .nextLine()
		//String[] lineSplit;			//Holds the pieces of the split line
		//String[] lineSpl2;
		
		try {
			boyIn = new Scanner(new FileInputStream("C:/Users/Zack R/Desktop/AbsJava_Source_Code_4e/Source_Code_4e/ch10/boynames.txt"));
			girlIn = new Scanner(new FileInputStream("C:/Users/Zack R/Desktop/AbsJava_Source_Code_4e/Source_Code_4e/ch10/girlnames.txt"));
		} catch (FileNotFoundException e){
			System.out.println("File not found or could not be opened");
			System.exit(0);
		}
		
		//runs all the way to the end of the file
		while (boyIn.hasNext()){
			//NextLine of the boy file
			lineHolder = boyIn.nextLine();
			String[] lineSplit = lineHolder.split(" ");
			PopularBabyNames.boyNames.add(lineSplit[0]);
			PopularBabyNames.boyNumbers.add(Integer.valueOf(lineSplit[1]));
			
			//NextLine of the girl file
			lineHolder = girlIn.nextLine();
			String[] lineSpl2 = lineHolder.split(" ");
			PopularBabyNames.girlNames.add(lineSpl2[0]);
			PopularBabyNames.girlNumbers.add(Integer.valueOf(lineSplit[1]));
		}
		System.out.println("Files read succuessful!");
		boyIn.close();
		girlIn.close();
	}
	
	//After a name is given, this will search the arrays for that name and output the relevant data
	public static void findValues(String name){
		boolean found = false;
		int counter = 0;
		
		//Boynames loop
		while (found == false){
			if(name.equalsIgnoreCase(PopularBabyNames.boyNames.get(counter))){
				found = true;
				System.out.printf("%s is ranked %d out of 1000 boy names of 2003, with %d namings\n", name, (counter + 1), PopularBabyNames.boyNumbers.get(counter));
			}
			if (counter >= PopularBabyNames.boyNames.size() - 1){
				found = true;
				System.out.printf("%s is not ranked among the top 1000 boy names of 2003\n", name);
				break;
			}
			counter++;
		}
		
		//Re-initialize found and counter for the girlLoop
		found = false;
		counter = 0;
		
		//GirlNames Loop
		while (found == false){
			if(name.equalsIgnoreCase(PopularBabyNames.girlNames.get(counter))){
				found = true;
				System.out.printf("%s is ranked %d out of 1000 girl names of 2003, with %d namings\n", name, (counter + 1), PopularBabyNames.girlNumbers.get(counter));
			}
			if (counter >= PopularBabyNames.girlNames.size() - 1){
				found = true;
				System.out.printf("%s is not ranked among the top 1000 girl names of 2003\n", name);
				break;
			}
			counter++;
		}
	}
	
	//The name input is done in Main
	public static void main(String[] args) {
		Scanner s1 = new Scanner(System.in);
		String name = "";
		System.out.println("This program will tell you how popular a name was in 2003");
		
		System.out.println("Enter a first name to be checked against our database:");
		name = s1.next();
		
		//Sort the files
		PopularBabyNames.fillArrays();
		PopularBabyNames.findValues(name);
	}

}
