//Arch Lab 8
//Zack Raver
//ravzac14
//
//5. You could test it by checking for some sort of overflow?
//   if nanoTime is signifigantly larger than it should be recheck
//   to find solid, re-produceable overflow
//
//6. Adding (as in ArrayList.add()) > Writing(and reading) > Reading
//   ArrayList take slightly longer than Arrays of type Integer, which 
//   take signifigantly longer than Arrays of type int.

import java.util.*;

public class ALab8Timing{

public static void main (String[] args){
	
	//10 element for-loop

	System.out.println("0 thru 9 Loop cycles with a print statement in the loop.");
	long firTime = System.nanoTime();
	for (int i = 0; i <10; i++){
		int potatoe = 5;
		long secTime = System.nanoTime();
		System.out.println("Loop " + i + ": " + (secTime - firTime));
		firTime = secTime;
	}

	//Array with 10000 ints
	
	System.out.println("Thru array with 10000 ints!");
	int[] numb = new int[10000];
	firTime = System.nanoTime();
	for (int i = 0; i<10000; i++){
		numb[i] = 5;
	}
	System.out.println(System.nanoTime() - firTime);

	//Array with 10000 Integers
	
	System.out.println("Thru array with 10000 Integers!");
	Integer[] dumb = new Integer[10000];
	firTime = System.nanoTime();
	for (int j = 0; j < 10000; j++){
		dumb[j] = 5;
	}
	System.out.println(System.nanoTime() - firTime);

	//ArrayList with 10000 Integers (creating)
	
	System.out.println("Creating ArrayList with 10000!");
	ArrayList<Integer> lumber = new ArrayList<Integer>();
	firTime = System.nanoTime();
	for (int k = 0; k<10000; k++){
		lumber.add(5);
	}
	System.out.println(System.nanoTime() - firTime);

	//ArrayList with 10000 Integers (parsing)
	
	System.out.println("Thru ArrayList with 10000!");
	firTime = System.nanoTime();
	for (int b = 0; b <10000; b++){
		lumber.set(b, 5);
	}
	System.out.println(System.nanoTime() - firTime);	
}
}
