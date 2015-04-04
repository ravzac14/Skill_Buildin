/*Zack Raver;ravzac14
 * 5/15/14
 * part of ch.9 # 6
 * Exception class for unknown operator in SimpleCalc
 */

public class UnknownOperatorException extends Exception{
	
	//This is the character that holds the exceptional operator
	private char oper;
	

	//Constructors for default exception constructors and to set bad operator
	public UnknownOperatorException(){
		super("UnknownOperatorException");
	}

	public UnknownOperatorException(String message){
		super(message);
	}

	public UnknownOperatorException(char badOp){
		this.oper = badOp;
	}

	//Accessor for the bad operator
	public char getOper(){
		return oper;
	}
}
