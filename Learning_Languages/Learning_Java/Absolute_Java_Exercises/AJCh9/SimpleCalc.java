/*Zack Raver; ravzac14
 * 5/15/14
 * from ch.9 #6 in "Absolute Java" by Walter Savitch
 * write a simple calculator class (and an exception class for UnknownOperatorException)
 * should output like this:
 * Calculator Is ON:
 * result = 0.0 //this is a double
 * +5
 * result +5 = 5.0
 * new result = 5.0
 * *2.2
 * result * 2.2 = 11.0
 * updated result = 11.0
 * %10
 * % is an unknown operation
 * Re-enter your last line:
 * *0.1 
 * result * 0.1 = 1.1
 * updated result = 1.1
 * r
 * final result = 1.1
 * Again? (y/n)
 * N
 * End of program
 */

import java.util.Scanner;

public class SimpleCalc{
	
	public static void doCalc() throws UnknownOperatorException{
		char[] OPERATORS = {'+', '-', '*', '/'};
		Scanner s1 = new Scanner(System.in);
		boolean done = false;
	 	double result = 0.0;
		int temp = 0;
		char oper = 'o';
		boolean tester = false;
		
		System.out.println("Result: " + result);
		while (done == false){
			
			try{
				temp = s1.nextInt();
				oper = s1.next().charAt(0);
				
				for (char x: OPERATORS){
					if (oper == x){
						tester = true;
					}
					if (tester == true){
						throw new UnknownOperatorException(oper);
					}
				}
				done = true;
				if (oper == '+'){
					result += temp;
				} else if (oper == '-'){
					result -= temp;
				} else if (oper == '*'){
					result *= temp;
				} else {
					result /= temp;
				}

			}catch (UnknownOperatorException e){
				e.getMessage();
			}
			System.out.println("Updated result: " + result);
			System.out.println("Continue (Y/N)? or Start Over (S)?");
			oper = s1.next().charAt(0);
			if (oper == 'Y'){
				done = false;
				continue;
			} else if (oper == 'N'){
				break;
			} else {
				doCalc();
			}
		}
	}
	
	public static void main(String[] args) throws UnknownOperatorException{
		System.out.println("Calculator is ON:");
		SimpleCalc.doCalc();

		System.out.println("End of program.");
	}
}
