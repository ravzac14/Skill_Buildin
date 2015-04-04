/* Zack Raver, ravzac14
 * 4/17/14
 * 
 * Ch.7 #1 from "Absolute Java" by Walter Savitch
 * Create a class Payment that has an instance variable of type double that stores the payment value. Include getters and setters; with method PaymentDetails that prints the details
 * 	create PaymentCash that includes appropriate constructors and redefines PaymentDetails
 * 	create PaymentCreditCard that add name/card#/exp date; redefine PaymentDetails
 * 	create PaymentTest that creates several objects and tests PaymentDetails
 */
public class Payment {
	
	private double paymentValue;
	
	/* No-arg constructor and convenience constructor
	 */
	
	public Payment(){
		this.paymentValue = 0.0d;
	}
	
	public Payment(double paymentValue){
		this.paymentValue = paymentValue;
	}
	
	/* Mutator and accessor methods for the class Payment
	 * Works on instance variable: paymentValue
	 */
	public void setPaymentValue(double value){
		paymentValue = value;
	}
	
	public double getPaymentValue(){
		return paymentValue;
	}
	
	/* paymentDetails is essentially the toString for the
	 * Payment class. Does not return a string, just prints one.
	 */
	
	public void paymentDetails(Payment p1){
		System.out.println("The payment is valued at: " + p1.getPaymentValue());
	}
}
