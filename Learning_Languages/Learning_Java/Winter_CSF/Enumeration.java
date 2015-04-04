/*Zack Raver; ravzac14
 * Ch.13 #3 from 'Absolute Java' by Walter Savitch
 * 
 * Complete the method getEnumeration() so that it returns an anonymous inner class that corresponds to the Enumeration interface.
 * Write a main method that creates a NamesCollection object with a sample array of stringsm retrieves the Enumeration and then iterates through the enumeration,
 * outputting ea. name using the getName() method.
 */

interface Enumeration {

	//Return true if another element in the collection exists next
	public boolean hasNext();
	
	//Returns the next element in the collection as an object
	public Object getnext();
	
}


/* Name collection implements a collection of names using a simple array */

class NameCollection {
	
	String[] names;
	
	//The String is initialized from outside and passed in as an array of strings
	NameCollection(String[] names){
		this.names = names;
	}
	
	//getEnumeration should return an instance of a class that implements the Enumeration interface where hasNext and getNext correspond to data stored within the names array
	
	Enumeration getEnumeration(){
		
	}
}
