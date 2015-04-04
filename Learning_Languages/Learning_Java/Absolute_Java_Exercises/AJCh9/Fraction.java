/*Zack Raver; ravzac14
 * 5/15/14
 * from Ch.9 #4 in "Absolute Java" by Walter Savitch
 * This class should take as input two ints, and have a toString method that prints them as a ratio (5/9), as a percentage (15%), and as a float (0.15)
 * It should have mutator/accessor methods to change the num and denom (if denom is set to 0 throws DenominatorIsZeroException) 
 */

public class Fraction{
	
	//These hold the numerator and denomonator for the fraction
	private float numer;
	private float denom;
	
	//Default and convenience constructors for Fraction
	public Fraction(){
		this.numer = 1;
		this.denom = 1;
	}

	public Fraction(float a, float b) throws DenominatorIsZeroException{
		this.setNumer(a);
		this.setDenom(b);
	}

	//Accessor and mutator methods for numer and denom
	public void setNumer(float newNumer){
		numer = newNumer;
	}

	public void setDenom(float newDenom) throws DenominatorIsZeroException{
		if (newDenom == 0){
			throw new DenominatorIsZeroException("You divide by zero!");
		}
		denom = newDenom;
	}

	public float getNumer(){
		return numer;
	}

	public float getDenom(){
		return denom;
	}
	
	//This guy does all the work
	public String toString(){
		float percent = (this.getNumer()/this.getDenom()) * (float)100;
		float dec = (this.getNumer()/this.getDenom());
		String words = this.getNumer() + "/" + this.getDenom();
		return "Fraction: " + words + ", Percentage: " + percent + ", Ratio: " + dec;
	}

	//MAIN
	public static void main(String[] args){
		//Making some test numerators and denominators
		float num1 = 15.00F;
		float num2 = 0.0F;
		float num3 = 1.0F;
		float den1 = 20.0F;
		float den2 = 1.0F;
		float den3 = 0.0F;
		
		try {
			Fraction f1 = new Fraction(num1, den1);
			Fraction f2 = new Fraction(num2, den2);
			Fraction f3 = new Fraction(num3, den3);

			System.out.println(f1 + "\n" + f2 + "\n" + f3);
		}
		catch (DenominatorIsZeroException e) {
			System.out.println(e.getMessage());
		}
	}
}

