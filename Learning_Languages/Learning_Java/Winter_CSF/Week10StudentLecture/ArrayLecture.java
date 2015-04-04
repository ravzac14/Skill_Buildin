public class ArrayLecture{
	
	/*Possible Types of Arrays:
	 * byte[] anArrayofBytes
	 * short[] anArrayofShorts
	 * long[] anArrayofLongs
	 * float[] anArrayofFloats
	 * double[] anArrayofDoubles
	 * boolean[] anArrayofBooleans
	 * char[] anArrayofChars
	 * String[] anArrayofStrings
	 * String[][] anArrayofStringArrays!
	 * String[][][][][] anArrayofarraysofarraysofarraysofStringArrays
	 * Object[] anArrayofObjects
	 *
	 * Similarly:
	 * Puppy[] anArrayofPuppies!
	 * Integer[] anArrayofIntegers
	 */



	public static void main(String[] args){
		
	//Here we will initialize an array of ints called intsToTen
	
		int[] intsToTen = new int[11];		//It is important to initialize the type and length of an array when declaring it

		int[] intsToFive;
		intsToFive = new int[6]; 			//This is an alternative way to declare its length (Cant put values in before you state the length)

		

	//Ways to find length and type
		
		int arrayLen = intsToTen.length;	//Each array has a variable called length that can be accessed like this
		System.out.println("Array Length: " + arrayLen);
		String arrayType = intsToTen.getClass().getName();	//Through reflection we can find the type of an array like this
		System.out.println("Array Type: " + arrayType);


	//Setting values in a declaration

		intsToFive[0] = 5;
		intsToFive[1] = 25; //You can manually add and alter the values in each index
		intsToFive[1] = 10;

		String[] coolGuys = {"Zack", "Alexei", "Josh"};		//You can also initialize the values at the same time as declaring the array initially
															//In this case you don't have to explicitly state the length it is set to 3 (for 3 values)


	//Setting values by iterating through arrays
		
		for (int i=0; i<intsToTen.length; i++){
			intsToTen[i] = i;								//We set the values of intsToTen by iterating through using a for-loop to touch each index
		}	
		
		int j = 0;
		System.out.println("The following names belong to cool guys (any that aren't included are not cool):");
		
		while(j < coolGuys.length){
			System.out.println(coolGuys[j]);				//We use a while loop here to iterate through the array coolGuys and print their values
			j++;
		}


	//Common mistakes with arrays
		String[] strings = new String[5];

		//String[0] = 5; //You have to make sure the values inside of the arrays are of the correct type
						//if you initialize the array as a String, only strings can be added
		
		strings[0] = "Kyle really is a coolGuy"; //This is ok!
		System.out.println(strings[0]);
	}
}
