/* Zack Raver, ravzac14
 * Belongs to the Ch.7 # 1 Project 
 */

public class PaymentCash extends Payment{
	
	/* New no-arg and convenience constructors for the subclass PaymentCash */
	
	public PaymentCash(){
		super();
	}
	
	public PaymentCash(double cashPaymentValue){
		super(cashPaymentValue);
	}
	
	/* Overriding the method paymentDetails to describe that it is also in cash */
	
	public void paymentDetails(Payment p1){
		System.out.println("The payment was recieved in cash, and is valued at: " + p1.getPaymentValue());
	}
}
