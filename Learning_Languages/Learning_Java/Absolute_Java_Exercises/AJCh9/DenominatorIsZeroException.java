/* Zack Raver; ravzac14
 * 5/15/14
 *
 * from ch.9 #4 in "Absolute Java" by Walter Savitch
 * Using the class from ch.5 to display ratios (Fraction) 
 * modify the class to throw a DenominatorIs-ZeroException if denom is set() to zero
 * -derive the Exception class 
 * write a main method that tests the new Fractions and catches the DenominatorIs-ZeroException
 */

public class DenominatorIsZeroException extends Exception{

	//Just need the inherited constructors here so that getMessage works
	public DenominatorIsZeroException(){
		super("DenominatorIs-ZeroException");
	}

	public DenominatorIsZeroException(String message){
		super(message);
	}
}
